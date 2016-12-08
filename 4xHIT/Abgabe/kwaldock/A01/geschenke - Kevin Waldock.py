"""
Author: Kevin Waldock
Version: 06.12.2016
"""

import io
import queue
import threading


class PresentProducer(threading.Thread):
    """
    Produces presents by the user input
    """
    def __init__(self, shared_queue):
        """
        Creates a new PresentProducer

        :param shared_queue: The used thread-safe Queue shared with the consumer
        """
        super().__init__()
        self.shared_queue = shared_queue  # type: queue.Queue

    def run(self):
        """
        Runs the producer. Asks the user for presents until he writes 'nichts'.
        """
        while True:
            next_input = input("PROGRAMM: Was wünscht du dir?\nBENUTZER: ")
            self.shared_queue.put(next_input)
            if next_input.lower() == "nichts":
                print("Na gut")
                break


class PresentConsumer(threading.Thread):
    """
    Consumes the presents from the producer (by the shared thread-safe Queue)
    """
    def __init__(self, shared_queue):
        """
        Creates a new PresentConsumer

        :param shared_queue: The used thread-safe Queue shared with the producer
        """
        super().__init__()
        self.shared_queue = shared_queue  # type: queue.Queue

    def run(self):
        """
        Runs the consumer. Writes the result into wunschliste.csv until it gets the text 'nichts'.
        """
        first_write = True
        with open("wunschliste.csv", "w") as out_file:
            while True:
                next_input = self.shared_queue.get()
                if next_input.lower() == "nichts":
                    break

                if first_write:
                    out_file.write(next_input)
                    first_write = False
                else:
                    out_file.write(", " + next_input)
                out_file.flush()


class PresentFactory:
    def __init__(self):
        pass

    def make_presents(self):
        """
        Creates a producer and consumer which shares a thread-safe Queue for communication.
        """
        shared_queue = queue.Queue()
        producer = PresentProducer(shared_queue)
        consumer = PresentConsumer(shared_queue)

        producer.start()
        consumer.start()

        producer.join()
        consumer.join()


if __name__ == '__main__':
    pf = PresentFactory()
    pf.make_presents()
