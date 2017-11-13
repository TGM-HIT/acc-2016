from server import Server


class Tag(object):
    def __init__(self, md, tag, closing=True):
        self.md = md
        self.open = "<%s>" % tag
        self.close = ""

        if closing:
            self.close = "</%s>" % tag


class MDHTMLConverter:
    TAGS = [
        Tag("####", "h4"),
        Tag("###", "h3"),
        Tag("##", "h2"),
        Tag("#", "h1"),
        Tag("* ", "li", False),
        Tag("- ", "li", False),
        Tag("*", "b")
    ]

    @staticmethod
    def convert(source, filetype="html"):
        markdown = []
        with open(source, "r") as f:
            for line in f:
                markdown.append(line)

        print(markdown)

        for i in range(len(markdown)):
            for tag in MDHTMLConverter.TAGS:
                if tag.md in markdown[i]:
                    markdown[i] = markdown[i].replace(tag.md, tag.open)
                    markdown[i] += tag.close

        print(markdown)

        title = source[:source.rfind(".")]
        destination = title + "." + filetype

        with open("template.html", "r") as f:
            html = f.read()

        html = html.replace("{{title}}", title)
        html = html.replace("{{body}}", "".join(markdown).replace("\n\n", "<br>"))

        with open(destination, "w") as f:
            f.write(html)


if __name__ == "__main__":
    server = Server()
    MDHTMLConverter.convert("test.md")

    server.start()
