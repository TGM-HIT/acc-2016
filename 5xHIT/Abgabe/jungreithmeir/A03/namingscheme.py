"""
Princeton University "About WordNet." WordNet. Princeton University. 2010. <http://wordnet.princeton.edu>
"""

import random
import sys


class NamingScheme(object):
    """
    Author: Jungreithmeir Jakob, 5BHIT
    Version: 1.0, 08-12-2016

    Small class which reads two given files and uses them as source for name
    generation. Because this exercise seems to focus on creativity rather than
    implementation I decided to use a 'creative' approach by not simply using
    a small handwritten word list, but by using pre generated word lists from
    the Princeton University (~100.000 lines).
    """

    def __init__(self, noun_file_name, adj_file_name):
        """
        Saves the contents of the two files in order to process them later.

        :param noun_file_name: file name of noun file
        :param adj_file_name: file name of adjective file
        """
        self.nouns = open(noun_file_name).read()
        self.adjectives = open(adj_file_name).read()

    def get_name(self, input):
        """
        Takes the input and returns a new name. This name consists of two words
        if the input is shorter than 9 characters. The first letter is used
        for an adjective, the last for a noun. If the word is longer than 8
        characters the middle letter is user for another bridge noun.

        :param input: std in input like 'Jakob'
        :return: new name
        """
        name = ''
        # title() turns the first letter into upper case
        name += self.__get_word_starting_with(self.adjectives, input[0]).title()
        if len(input) > 8:
            name += ' '
            name += self.__get_word_starting_with(self.nouns,
                                                  input[len(input)//2]).title()
        name += ' '
        name += self.__get_word_starting_with(self.nouns, input[-1]).title()
        return name

    def __get_word_starting_with(self, words, letter):
        """
        Retrieves random words from the given word list until one matches
        the specified beginning letter.

        :param words: giant word string
        :param letter: desired first letter
        :return: randomly choosen word
        """
        while True:
            word = self.__read_random_line(words)
            if word[0] == letter:
                return word

    def __read_random_line(self, words):
        """
        Reads a random line from a giant string

        :param words: giant word string
        :return: randomly choosen word
        """
        lines = words.splitlines()
        myline = random.choice(lines)
        return myline

if __name__ == '__main__':
    print("Welcome to Jakob's name generator.")
    print("In order to leave just enter 'exit'.")

    name_gen = NamingScheme('conv.data.noun', 'conv.data.adj')

    while True:
        name = input("Please enter your name: ")
        if name.lower() == 'exit':
            sys.exit(0)
        else:
            print(name_gen.get_name(name))
