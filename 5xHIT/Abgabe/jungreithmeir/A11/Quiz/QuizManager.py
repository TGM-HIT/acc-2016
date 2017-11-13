import random
from pathlib import Path

import pickle


class QuizManager:
    """
    Small manager class which handles the persistence of the question/answer sets and tracks the current state of a
    gaming session. It returns the questions in a random order, the four answers each are also shuffled. In a given
    round no question is returned twice.

    :author: Jakob Jungreithmeir
    :version: 1.0 21-12-2016
    """
    def __init__(self):
        """
        Writes the initial questions to the save file, if it does not exist yet. Otherwise the save file is loaded.
        """
        self.save_file = 'quiz.data'
        self.questions = []

        save_file = Path(self.save_file)
        if save_file.is_file():
            self.__load__()
        else:
            self.questions = [
                ['How many persons did the fellowship of the ring consist of?',
                 ['9', '3', '11', '7']],
                ['Which of these spells is an unforgivable curse?',
                 ['Imperio', 'Accio', 'Wingardium Leviosa', 'Expecto Patronum']],
                ['What is the name of the protagonist in the movie Matrix?',
                 ['Neo', 'Trinity', 'Morpheus', 'Cypher']],
                ['Which family name is given to bastard children from the north?',
                 ['Snow', 'Ice', 'Frost', 'Wolf']],
                ['Which test is used in order to determine whether a being is a replicant or not?',
                 ['Voight Kampff Test', 'Kobayashi Maru', 'Jedi Trials', 'Turing Test']],
                ['What is the answer to the Ultimate Question of Life, the Universe, and Everything?',
                 ['42', '1337', '0', '0118 999 881 999 119 725 3']]
            ]
            self.__save__()

        self.already_used = []
        self.right = 0
        self.wrong = 0

    def get_question(self):
        """
        Returns a random question with shuffled answers.

        :return: [question, [answer 1, answer 2, answer 3, answer 4]
        """
        question = random.choice(self.questions)
        while question in self.already_used:
            question = random.choice(self.questions)

        self.already_used.append(question)
        answers = question[1]
        # Copying the list, so that I do not shuffle the original list
        rand_answers = list(answers)
        random.shuffle(rand_answers)
        return [question[0], rand_answers]

    def check_if_finished(self):
        """
        Checks whether there are any unanswered/unchecked questions left.

        :return:
        """
        if len(self.questions) == len(self.already_used):
            return True
        else:
            return False

    def add_question(self, question, answers):
        """
        Adds a question and immediately saves it to the data file.

        :param question:
        :param answers: list of answers, the first one is the right one
        """
        if len(answers) == 4:
            self.questions.append([question, answers])
            self.__save__()
            self.__load__()

    def check_answer(self, question, answer):
        """
        Checks whether a given answer is the right one for the passed question. Also processes the internal game stats.

        :param question: Needs to be in the list of questions
        :param answer: hopefully the right answer
        :return: True if right, False if wrong
        """
        for q in self.questions:
            if q[0] == question:
                if q[1][0] == answer:
                    self.right += 1
                    return True
                else:
                    self.wrong += 1
                    return False

    def get_summary(self):
        """
        Returns a summary, useful for status displays of any kind.

        :return:
        """
        question = 'questions'
        if self.right == 1:
            question = 'question'
        return 'You have successfully answered ' + str(self.right) + ' ' + question + ' out of ' + \
               str(self.right + self.wrong) + ' in total.'

    def get_remaining(self):
        """
        :return: number of unanswered questions
        """
        return len(self.questions) - len(self.already_used)

    def get_total(self):
        """
        :return: number of questions
        """
        return len(self.questions)

    def __load__(self):
        """
        Loads the persisted question/answer data from the save file.
        """
        self.questions = pickle.load(open(self.save_file, 'rb'))

    def __save__(self):
        """
        Writes the serialized question/answer data to a save file.
        """
        pickle.dump(self.questions, open(self.save_file, 'wb'))
