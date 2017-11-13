from server import Server


class MDHTMLConverter:
    @staticmethod
    def convert(source, filetype="html"):
        pass


if __name__ == "__main__":
    server = Server()
    MDHTMLConverter.convert("test.md")

    server.start()
