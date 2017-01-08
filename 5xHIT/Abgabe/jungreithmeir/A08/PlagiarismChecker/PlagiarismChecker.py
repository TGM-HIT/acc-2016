import os
import string
import itertools
from enum import Enum
import sys

import nltk
from sklearn.feature_extraction.text import TfidfVectorizer

# Normally this data needs to be downloaded during the first execution but I moved it to the working directory and
# included it to save the reviewer some time.
nltk.data.path = [os.getcwd() + "/../nltk_data"]
# nltk.download('punkt')


class Language(Enum):
    """
    List of supported languages.
    """
    CZECH = 'czech'
    DANISH = 'danish'
    DUTCH = 'dutch'
    ENGLISH = 'english'
    ESTONIAN = 'estonian'
    FINNISH = 'finnish'
    FRENCH = 'french'
    GERMAN = 'german'
    GREEK = 'greek'
    ITALIAN = 'italian'
    NORWEGIAN = 'norwegian'
    POLISH = 'polish'
    PORTUGUESE = 'portuguese'
    SLOVENE = 'slovene'
    SPANISH = 'spanish'
    SWEDISH = 'swedish'
    TURKISH = 'turkish'


class PlagiarismChecker(object):
    """
    This program is heavily based/influenced by an answer given on StackOverflow(http://stackoverflow.com/a/24129170).
    Because I have to use a library for the natural language processing (NLP) in this case the Natural Language Toolkit
    3.0 called NLTK I will explain a bit of the background of this whole process.

    Before text can be analyzed it needs to be modified in order to simplify the quite complex comparing process.
    Here are a few steps which need to happen before the processing can begin:
    1. Everything is turned into lowercase.
    2. Then all the punctuations are removed.
    3. Now the words are stripped of their 'extensions' and reduced to their basic word stem.

    Now we get to the complicated part that I will only explain briefly.
    4. The parts of the text are turned into numeric values and written down in two or more vectors.
    5. Afterwards the cosine similarity is calculated, this means the angle between the two "word" vectors defines
    the similarity.

    :author: Jakob Jungreithmeir
    :version: 1.0 16-12-2016
    """

    def __init__(self, language=Language.ENGLISH):
        """
        The stemmer is a kind of generator which is applied to every word in a given text to reduce it to it's word
        stem (deutsch Wortstamm). This helps with further identifying similarities between texts.

        :param language: text language
        """
        self.language = language.value
        self.stemmer = nltk.stem.porter.PorterStemmer()
        self.remove_punctuation_map = dict((ord(char), None) for char in string.punctuation)

    def __stem_tokens__(self, tokens):
        """
        Reduces a list of words to their stems.

        :param tokens: List of words to be reduced to their stem
        :return: list of word stems
        """
        return [self.stemmer.stem(item) for item in tokens]

    def __normalize__(self, text):
        """
        Calls word stem removal, casts text to lower case and removes all the punctuation marks.

        :param text: raw text
        :return: distilled text
        """
        return self.__stem_tokens__(nltk.word_tokenize(text.lower().translate(self.remove_punctuation_map)))

    @staticmethod
    def get_list_combinations(input_list, elements_per_result=2):
        """
        Returns a combination (see definition in https://en.wikipedia.org/wiki/Combination or in our mathematics
        school exercises.

        :param input_list:
        :param elements_per_result:
        :return: list of combinations as tuples
        """
        return itertools.combinations(input_list, elements_per_result)

    def check(self, texts):
        """
        Checks whether a list of texts is similar. Calls `__check__` for this operation.

        :param texts:
        :return: percentage values
        """
        if len(texts) < 2:
            raise ValueError("At least two texts must be given!")

        combinations = self.get_list_combinations(texts)
        results = []
        for index, combination in enumerate(combinations):
                results.append(self.__check__(combination[0], combination[1]))
        return results

    def __check__(self, text1, text2):
        """
        Checks whether two text strings share any similarity.

        :param text1:
        :param text2:
        :return: A list of the similarities. All of the values are based on the first element of the parameter list.
        This means by calling check(a, b, c) the result is [a~a, b~a, c~a]. As a result the first element of the return
        list is obviously always 1.
        """
        vectorizer = TfidfVectorizer(tokenizer=self.__normalize__, stop_words=self.language)
        tfidf = vectorizer.fit_transform([text1, text2])

        return (tfidf * tfidf.T).A[0][1]

    def check_files(self, files):
        """
        Does the same as the check function, but here you specify multiple files instead of direct strings/texts.

        :param files: file names
        :return: percentages with file names and the average similarity
        """
        if len(files) < 2:
            raise ValueError("At least two files must be given!")

        texts = []
        for file in files:
            with open(file, 'r') as f:
                texts.append(f.read().replace('\n', ' '))

        similarities = self.check(texts)

        specifiers = list(self.get_list_combinations(files))
        results = []
        avg = 0

        for index, percent in enumerate(similarities):
            avg += percent
            results.append(specifiers[index][0] + " to " + specifiers[index][1] + ": " +
                           repr(round(percent * 100)) + "%")

        avg = (avg * 100)/len(similarities)
        results.append("Average similarity: " + repr(round(avg)) + "%")
        return results


if __name__ == '__main__':
    """
    Example texts which have been used:
    https://www.princeton.edu/pr/pub/integrity/pages/plagiarism/
    """
    arguments = sys.argv[1:]
    if len(arguments) < 2:
        print("You have to specify at least two files when starting the program")
        sys.exit(1)
    c = PlagiarismChecker()
    report = c.check_files(arguments)
    print("\n".join(report))
