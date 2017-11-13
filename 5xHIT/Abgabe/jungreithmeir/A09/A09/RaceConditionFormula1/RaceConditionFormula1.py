import curses
import curses.textpad
import random
import threading
import time
import operator

import sys

values = []
running = True


class Racer(threading.Thread):
    """
    Small threaded class which simply takes numbers from the global values list and adds it to it's score.
    This happens every second.

    :author: Jakob Jungreithmeir
    :version: 1.0 17-12-2016
    """

    def __init__(self, name):
        """
        :param name: Name of the thread
        """
        threading.Thread.__init__(self)
        self.name = name
        self.score = 0

    def run(self):
        """
        Pops values from the global list.
        """
        while True:
            self.score += values.pop(random.randrange(len(values)))
            time.sleep(1)


class ScoreboardWatchdog(threading.Thread):
    """
    This class monitors the score of all racer threads and outputs it via the python curses library.

    :author: Jakob Jungreithmeir
    :version: 1.0 17-12-2016
    """

    def __init__(self, additional_threads, drivers):
        """
        Initializes curses.

        :param additional_threads: All non racer threads
        :param drivers: racer threads
        """
        threading.Thread.__init__(self)
        self.additional_threads = additional_threads
        self.drivers = drivers
        self.stdscr = curses.initscr()
        curses.echo()
        self.stdscr.keypad(1)
        curses.curs_set(0)

    def calculate_winner(self):
        """
        Determines the winner of the game.

        :return: Sorted dictionary {'driver name': points}
        """
        scoreboard = {}
        for driver in self.drivers:
            scoreboard[driver.name] = driver.score

        # sort by value
        scoreboard = sorted(scoreboard.items(), key=operator.itemgetter(1), reverse=True)
        return scoreboard

    def run(self):
        """
        Redraws the curses interface and manages the user input, which is sadly a little bit buggy, because of the
        rather strange architecture of curses.
        """
        # +2 for top and bottom row
        height = len(self.drivers) + 2
        top = 5

        scoreboard = curses.newwin(height, 70, top, 5)
        scoreboard.box()
        # immedok sets automatic refresh
        scoreboard.immedok(True)

        height2 = 3
        value_board = curses.newwin(height2, 70, top + height, 5)
        value_board.box()
        value_board.immedok(True)

        input_field = curses.newwin(4, 70, top + height + height2, 7)
        input_field.immedok(True)
        input_field.timeout(1000)
        input_field.leaveok(1)

        while True:

            for index, driver in enumerate(self.drivers):
                scoreboard.addstr(index + 1, 2, (driver.name + ": " + str(driver.score)), curses.A_BOLD)

            text = "Remaining values: " + str(values)
            text += " " * (67 - len(text))
            value_board.addstr(1, 2, text)

            command = input_field.getstr(0, 0, 15).decode("utf-8").strip()
            if command == 'quit' or command == 'Quit':
                scores = self.calculate_winner()
                for index, key in enumerate(scores):
                    if index == 0:
                        scoreboard.addstr(index + 1, 2, str(key[0]) + ": " + str(key[1]) + " "*15, curses.A_BOLD)
                    else:
                        scoreboard.addstr(index + 1, 2, str(key[0]) + ": " + str(key[1]) + " "*15)

                for x in reversed(range(1, 6)):
                    input_field.addstr(0, 0, "Leaving in " + str(x) + " seconds...")
                    time.sleep(1)

                curses.endwin()
                # global keyword is needed to modify outer scope variable
                global running
                running = False
                return

            elif command.isdigit():
                values.append(int(command))
                input_field.addstr(0, 0, " " * 60)

            input_field.addstr(2, 0, "Enter 'quit' to leave.")
            input_field.addstr(3, 0, "Enter a number and hit enter to add it to the race.")

            time.sleep(1)


class ListFiller(threading.Thread):
    """
    This threaded instance is going to fill the list with values.

    :author: Jakob Jungreithmeir
    :version: 1.0 19-12-2016

    """

    def __init__(self, threads, highest_number=100):
        """
        :param threads: list of all racer threads. Needed to ensure the creation of a list big enough to serve all
         racers.
        :param highest_number: highest number of the random generated values
        """
        threading.Thread.__init__(self)
        self.threads = threads
        self.highest_number = highest_number
        for i in range(len(threads)):
            self.add_rand_num()

    def run(self):
        """
        Adds random values to the global list, with 1 seconds sleeps in between.
        """
        while True:
            for _ in self.threads:
                self.add_rand_num()
            time.sleep(1)

    def add_rand_num(self):
        values.append(random.randint(1, self.highest_number))


class Formula1(threading.Thread):
    """
    This game uses one consequence of badly implemented parallel computation, namely the race condition effect.
    The definition of this problem is, that the outcome of the program is defined by the order in which the parallel
    instances have started. This makes the program behaviour non deterministic, which is (almost) always not desired.

    The program uses the nix-curses library which was pretty much the most used graphical terminal library for
    applications of any sort. If you install Debian, as an example, the installation process is implemented via curses.
    Sadly the structure of the library causes some pretty odd behaviour, it also does not allow multi-threaded access
    to one curses instance. The outcome of this is, that my program is a little bit buggy, but I still think it is a
    nice showcase of this rather interesting library.

    :author: Jakob Jungreithmeir
    :version: 1.0 19-12-2016
    """

    def __init__(self, drivers, highest_number):
        """
        :param drivers: Number of racers
        :param highest_number: highest desired random value
        """
        threading.Thread.__init__(self)
        self.drivers = drivers
        self.highest_number = highest_number

    def run(self):
        """
        Creates all necessary objects and idles until the program is ended by the user input.
        """
        drivers = []
        for index in range(1, self.drivers + 1):
            drivers.append(Racer("Driver " + str(index)))

        list_filler = ListFiller(drivers, highest_number=self.highest_number)
        # All of the threads are started as daemons, because daemons are terminated if nothing else is running.
        # This makes it possible to end the application with sys.exit(...). If normal threads would be used, these would
        # still be running after the main thread termination.
        list_filler.daemon = True

        scoreboard_wd = ScoreboardWatchdog([list_filler], drivers)
        scoreboard_wd.daemon = True

        list_filler.start()

        for driver in drivers:
            driver.daemon = True
            driver.start()
        scoreboard_wd.start()

        while running:
            pass


if __name__ == '__main__':
    arguments = sys.argv[1:]
    if len(arguments) != 2 or not arguments[0].isdigit() or not arguments[1].isdigit():
        print("Please enter the number of drivers and the highest possible number.")
        sys.exit(1)

    f1 = Formula1(int(arguments[0]), int(arguments[1]))
    f1.start()
    f1.join()
