import csv
import logging
import random
import threading
import time
from multiprocessing import Queue

# FIFO thread-safe queue
q = Queue()

class PresentProducer(threading.Thread):
    """
    Author: Jungreithmeir Jakob, 5BHIT
    Version: 1.0, 06-12-2016

    Producer which takes the stdin input and pushes it into the queue,
    """

    def __init__(self, group=None, target=None, name=None,
                 args=(), kwargs=None, verbose=None):
        super(PresentProducer, self).__init__()
        self.target = target
        self.name = name

    def run(self):
        print("Willkommen bei der Geschenkfabrik. Bitte gib deine"
            " Wünsche hier ein. Wenn dir nichts mehr einfällt einfach"
            " 'Nichts' eingeben.")
        while True:
            if not q.full():
                item = input("PROGRAMM: Was wünscht du dir?\nBENUTZER: ")
                q.put(item)
                if item.lower() == 'nichts':
                    return
        return

class PresentConsumer(threading.Thread):
    """
    Author: Jungreithmeir Jakob, 5BHIT
    Version: 1.0, 06-12-2016

    Consumer which reads from the queue and parses the input. If the program
    is to be closed it writes the previously supplied input to a csv file.
    """

    def __init__(self, group=None, target=None, name=None,
                 args=(), kwargs=None, verbose=None):
        super(PresentConsumer, self).__init__()
        self.target = target
        self.name = name
        return

    def run(self):
        presents = []
        while True:
            if not q.empty():
                item = q.get()
                if item.lower() == 'nichts':
                    with open('wunschliste.csv', 'w') as csvfile:
                            wr = csv.writer(csvfile, quoting=csv.QUOTE_MINIMAL)
                            wr.writerow(presents)
                    return
                presents.append(item)
        return

if __name__ == '__main__':

    p = PresentProducer(name='producer')
    c = PresentConsumer(name='consumer')

    p.start()
    c.start()
