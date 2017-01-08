import csv
import threading
import time
import sys

class Translator:
    words = []

    def user_input(self):
        """
        Check the user input

        :return: the user input
        """
        return input("EINGABE: ")

    def get_word(self, word):
        """
        Searches a word and prints the translation or returns False if not found

        :param word: the word to translate
        :return: index of translation or False if not found
        """
        for index, item in enumerate(self.words):
            if item[0] == word:
                print("AUSGABE: " + self.words[index][1])
                return index

        return False

    def read_data(self):
        """
        Reads the data from the file into a list
        """
        prog_bar = threading.Thread(target=self.loading)
        prog_bar.start()

        try:
            with open('words_db.csv', newline='', encoding='utf-8') as csvfile:
                db = csv.reader(csvfile, delimiter=',')
                self.words = list(db)

            prog_bar.do_run = False
            prog_bar.join()

        except FileNotFoundError:
            prog_bar.do_run = False
            prog_bar.join()
            print("Translator file not found. Creating a new one...")

    def loading(self):
        """
        Creates a loading bar
        """
        t = threading.current_thread()
        i = 1
        while getattr(t, "do_run", True):
            sys.stdout.write("\rLoading" + "." * (i % 4))
            sys.stdout.flush()
            time.sleep(1)
            i += 1
        sys.stdout.write("\r")
        sys.stdout.flush()

    def write_data(self, word):
        """
        Writes a new translation to the file

        :param word: new word
        """
        print("AUSGABE: Unbekannt! Hinzufügen? (y/n)")
        if self.user_input() == "y":
            print('AUSGABE: Neues Wort für "' + word + '"')
            translation = self.user_input()

            with open('words_db.csv', 'a', newline='', encoding='utf-8') as csvfile:
                db = csv.writer(csvfile, delimiter=',', quoting=csv.QUOTE_MINIMAL)
                db.writerow([word, translation])

            self.words.append((word, translation))
            print('AUSGABE: "' + word + '" now means: "' + translation + '"')


if __name__ == '__main__':
    translator = Translator()
    translator.read_data()

    print("AUSGABE: Word to translate?")
    search = translator.user_input()
    search_resp = translator.get_word(search)
    if search_resp is False:
        translator.write_data(search)
