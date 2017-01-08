from threading import Thread
import random
import time


class Race:
    """
    Thread Race
    """
    liste = []
    scores = {}
    thread_nr = 0

    def __init__(self):
        """
        Init
        """
        self.start_time = time.time()

    def create_read_thread(self):
        """
        Creates a new thread that reads values from list
        """
        self.thread_nr += 1
        self.scores[self.thread_nr] = 0

        t = Thread(target=self.read, args=(self.thread_nr,))
        t.setDaemon(True)
        t.start()

    def fill_random(self, maximum):
        """
        Inserts random values into list

        :param maximum: maximum random value
        """
        while True:
            self.liste.append(random.randint(1, maximum))
            try:
                """
                Faster input if more threads
                """
                time.sleep(1 / self.thread_nr)
            except ZeroDivisionError:
                time.sleep(1)

    def fill_own(self, number):
        """
        Insert user value into list

        :param number: the user input value to insert
        """
        self.liste.append(number)

    def read(self, nr):
        """
        Read value from lits

        :param nr: thread number
        """
        while True:
            try:
                self.scores[nr] += self.liste.pop(1)
            except IndexError:
                print("Thread %i: No element in List" % nr)

            time.sleep(1)

    def show_stat(self):
        """
        Prints a statistic about the current thread score
        """
        while True:
            print("+-- Status after %is" % (time.time() - self.start_time))
            for key, value in self.scores.items():
                print("|\tThread #" + str(key) + " : " + str(value) + "\t\t|")
            print("+------------------------")
            print("| List length: %i" % len(self.liste))
            print("| Input value or 'stop'")
            print("+------------------------\n")
            time.sleep(5)

    def print_score(self):
        """
        Prints final score
        """
        final_score = sorted(self.scores.items(), key=lambda x: x[1], reverse=True)

        print("+-- SCORE after %is:" % (time.time() - self.start_time))

        for key, value in final_score:
            print("|\tThread #" + str(key) + " : " + str(value) + "\t\t|")

        print("+-----------------------+")


if __name__ == '__main__':
    """
    Main
    """

    max_random = 10
    reader_number = 3

    while True:
        """
        Start Values
        """
        reader_number = input("Number of Processes? ")
        max_random = input("Max. random number? ")

        if reader_number.isdigit() and max_random.isdigit():
            reader_number = int(reader_number)
            max_random = int(max_random)
            break
        else:
            print("Incorrect input!")

    r = Race()
    """
    Value filler
    """
    random_fill = Thread(target=r.fill_random, args=(max_random,))
    random_fill.setDaemon(True)
    random_fill.start()

    """
    Reader threads
    """
    for i in range(0, reader_number):
        r.create_read_thread()

    """
    Print statistic
    """
    stat = Thread(target=r.show_stat)
    stat.setDaemon(True)
    stat.start()

    while True:
        """
        User input
        """
        user_input = input()
        if user_input.isdigit():
            r.fill_own(int(user_input))
        elif user_input == "stop":
            r.print_score()
            break
