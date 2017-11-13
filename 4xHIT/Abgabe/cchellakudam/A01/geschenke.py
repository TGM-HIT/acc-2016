import queue
import sys
import threading


class PresentProducer(threading.Thread):
    def __init__(self, queue):
        threading.Thread.__init__(self)
        self.queue = queue

    def run(self):
        while True:
            self.var1 = input("Programm: Was wünschst du dir?")
            self.queue.put(self.var1)
            if self.var1 == "Nichts":
                sys.exit()
            self.queue.join()


class PresentConsumer(threading.Thread):

    def __init__(self, queue):
            threading.Thread.__init__(self)
            self.queue = queue

    def run(self):

            list=[]
            while True:
                self.var2 = self.queue.get()
                print("Benutzer: "+str(self.var2))
                if self.var2 == "Nichts":
                    print("Programm: Na gut")
                    sys.exit()
                else:
                    list.append(self.var2)
                    file = open("wunschliste.csv", "w+")
                    file.write(str(list) + "\n")

                self.queue.task_done()


if __name__ == '__main__':

    queue = queue.Queue()
    ca = PresentProducer(queue)
    cb = PresentConsumer(queue)

    ca.start()
    cb.start()
    ca.join()
    cb.join()
