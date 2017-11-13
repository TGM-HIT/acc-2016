class PresentProducer:
    """
    Asks the user for presents and sends them to the consumer
    """
    def __init__(self, consumer):
        while True:
            txt = input("WEIHNACHTSMANN: Was wünscht du dir?\nKIND: ")

            if txt.lower() == "nichts":
                print("WEIHNACHTSMANN: Na gut")
                break
            else:
                consumer.write(txt)


class PresentConsumer:
    """
    Receives presents from the producer and writes them into a file
    """
    def write(self, present):
        with open('wunschliste.csv', 'a') as file:
            file.write(present + ", ")


if __name__ == '__main__':
    PresentProducer(PresentConsumer())
