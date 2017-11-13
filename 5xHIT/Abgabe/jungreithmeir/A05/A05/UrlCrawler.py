import urllib.request
import re
import _thread
import threading


class UrlCrawler(object):
    """
    author: Jakob Jungreithmeir
    version: 09-12-2016

    Small web crawler which takes an initial url and follows all other http(s) hyperlinks on the website until the
    specified depth has been reached. Based on the urllib library.
    """

    def __init__(self, root, depth=5, file_name='urls.txt'):
        """
        Specifies the initial crawling url.

        :param root: url
        :param depth: how often should the found links be followed
        :param file_name: name of the result set file
        """
        self.root = root
        self.depth = depth
        # Using a set to avoid duplicates
        self.urls = set()
        self.file_name = file_name

    def start(self):
        """
        Calls the first crawl cycle and writes the collected urls to a file.
        """
        print('Collecting links...')
        self.__crawl()
        self.__write()
        print('Finished')

    def __crawl(self, url=None, level=0):
        """
        Takes a given url and searches it's http response for more urls. If a hyperlink is found, this method
        recursively calls itself in a new thread to handle multiple crawling requests in a minimal amount of time.
        This is done until the level reaches the depth which has been set at the object initialization.

        :param url: url to be analyzed
        :param level: Do not manually modify this, it is only used for the recursive exit mechanism.
        """
        if url is None:
            url = self.root

        with urllib.request.urlopen(url) as response:
            if level is self.depth:
                return

            html = response.read()
            links = re.findall('"((http|ftp)s?://.+?)"', html.decode("utf-8"))

            # Removing second match from tuple result set as it only contains 'http'
            links = [x[0] for x in links]

            for link in links:
                self.__add_url(link)
                # Starting a new thread one level 'deeper'
                _thread.start_new_thread(self.__crawl, (link, level+1))

    def __add_url(self, url):
        """
        Thread safe set add mechanism.

        :param url: text/url to be added
        """
        with threading.Lock():
            self.urls.add(url)

    def __write(self):
        """
        Writes every line of the url set to a file.
        """
        with open(self.file_name, 'w') as f:
            for url in self.urls:
                f.write(url + '\n')


if __name__ == '__main__':

    crawler = UrlCrawler('https://www.tgm.ac.at/')
    crawler.start()
