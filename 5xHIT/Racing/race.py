import random
from queue import Queue
from threading import Thread


class Racer(Thread):
    def __init__(self, q):
        super().__init__()
        self.q = q
        self.score = 0
        self.closing = False

    def run(self):
        while not self.closing:
            if not self.q.empty():
                self.score += self.q.get()


class Feeder(Thread):
    def __init__(self, q):
        super().__init__()
        self.q = q
        self.closing = False

    def run(self):
        while not self.closing:
            self.q.put(random.randint(0, 100))


if __name__ == "__main__":
    racers = []
    __q = Queue()

    feeder = Feeder(__q)

    for i in range(10):
        racer = Racer(__q)
        racer.start()
        racers.append(racer)

    feeder.start()
    input("Stop?")

    for r in racers:
        print(r.score)
        r.closing = True
        r.join()

    feeder.closing = True
    feeder.join()
