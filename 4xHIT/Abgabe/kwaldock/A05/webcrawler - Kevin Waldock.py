import io
import queue
import re
import threading
import urllib.request


class AsyncFileProcessor(threading.Thread):
    """
    A async file processor, which only accepts unique items. Duplicates will not be written into
    """
    def __init__(self, input_queue, filename):
        super().__init__()
        self.filename = filename
        self.input_queue = input_queue  # type: queue.Queue
        self.filter_set = set()

    def run(self):
        with io.open(self.filename, "w") as output_file:
            while True:
                next_input = self.input_queue.get()
                if next_input == -1:
                    break

                next_input_str = str(next_input)
                if next_input_str not in self.filter_set:
                    output_file.write(next_input_str + "\n")
                    self.filter_set.add(next_input_str)


class AsyncLinkCrawler(threading.Thread):
    """
    Thread-Safe async link crawler. Looks for href="..."
    """
    def __init__(self, output_queue, link_to_process, depth):
        """
        Creates a new AsyncLinkCrawler

        :param output_queue: The queue for putting the link into
        :param link_to_process: The link to process
        :type link_to_process: str
        :param depth: How deep it should crawl for links. 0 = no further crawling
        """

        super().__init__()
        self.depth = depth
        self.link_to_process = link_to_process
        if not self.link_to_process.endswith("/"):
            self.link_to_process += "/"
        if not self.link_to_process.startswith("http://") and not self.link_to_process.startswith("https://"):
            self.link_to_process = "http://" + self.link_to_process
        self.output_queue = output_queue

    def run(self):
        """
        Looks for href-links
        """
        try:
            with urllib.request.urlopen(self.link_to_process) as response:
                html = response.read()  # type: str
                sub_crawlers = []  # type: list[threading.Thread]

                for match in re.finditer(b'href=[\'|"](.*?)[\'"]', html):
                    match_text = match.group().decode("utf-8")  # type: str
                    match_text = match_text[6:len(match_text) - 1]  # Remove href wrapper
                    if match_text == "/":  # Self-Links should be skipped
                        continue
                    if match_text.startswith("//"):  # Links with omitted "http" should add it back
                        match_text = "http:" + match_text
                    elif match_text.startswith("/"):  # Absolute links but with ommited main domain --> add it back
                        cur_index = -1
                        for i in range(0, 3): # Find third slash --> http://google.com/test --> http://google.com/
                            cur_index = self.link_to_process.find("/", cur_index + 1)

                        match_text = self.link_to_process[0:cur_index] + match_text
                    elif not match_text.startswith("http") and not match_text.startswith("https"):  # All non-absolute links
                        match_text = self.link_to_process + match_text

                    self.output_queue.put(match_text)  # Put link into queue for further processing
                    if self.depth > 0:  # Crawl the links itself too, if depth is bigger than 0
                        sub_crawler = AsyncLinkCrawler(self.output_queue, match_text, self.depth - 1)
                        sub_crawler.start()
                        sub_crawlers.append(sub_crawler)

                for sub_crawler in sub_crawlers:
                    sub_crawler.join()
        except Exception as err:
            print("Skipping url, due to error (probably invalid URL):", err)


if __name__ == '__main__':
    # Settings:
    output_file = "links.txt"
    link_to_crawl = "http://example.org/"
    depth_to_use = 2  # Depth: 0 = only link collecting, no further recursion

    # Async File Processor
    data_queue = queue.Queue()  # Shared thread-safe-queue
    file_processor_thread = AsyncFileProcessor(data_queue, output_file)
    file_processor_thread.start()

    # Async Crawler:
    top_level_crawler = AsyncLinkCrawler(data_queue, link_to_crawl, depth_to_use)
    top_level_crawler.start()
    top_level_crawler.join()

    # Stop the file processor
    data_queue.put(-1)
    file_processor_thread.join()
