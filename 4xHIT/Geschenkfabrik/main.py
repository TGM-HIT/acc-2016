"""
Author: Markus Reichl
Version: 27.11.2016
"""

import queue
import threading


# START SOLVED
class PresentProducer(threading.Thread):
    def __init__(self, q, e):
        super().__init__()
        self.q = q
        self.e = e

    def run(self):
        while True:
            wish = input("What do you wish for?")
            if wish.upper() == "NOTHING":
                self.e.set()
                return
            else:
                self.q.put(wish)


class PresentConsumer(threading.Thread):
    def __init__(self, q, e, f):
        super().__init__()
        self.q = q
        self.e = e
        self.f = f

    def run(self):
        while True:
            if not self.q.empty():
                self.f.write(self.q.get() + ",")
            elif self.e.is_set():
                return


# END SOLVED


# DO NOT MODIFY
class PresentFactory:
    def __init__(self):
        self.q = queue.Queue()
        self.e = threading.Event()
        self.pp = None
        self.pc = None

    def make_presents(self):
        f = open("wishlist.csv", "w+")

        self.pp = PresentProducer(self.q, self.e)
        self.pc = PresentConsumer(self.q, self.e, f)

        self.pp.start()
        self.pc.start()

        self.pp.join()
        self.pc.join()

        self.e.clear()

        f.close()


if __name__ == '__main__':
    pf = PresentFactory()
    pf.make_presents()
