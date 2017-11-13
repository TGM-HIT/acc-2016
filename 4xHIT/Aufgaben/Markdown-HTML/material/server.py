"""
author: Markus Reichl
version: 07.12.2016
"""

import http.server
import threading


class Server(threading.Thread):
    def __init__(self):
        super().__init__()
        self.HOST = "localhost"
        self.PORT = 8000
        self.handler = http.server.SimpleHTTPRequestHandler
        self.httpd = None

    def run(self):
        print("Serving at port", self.PORT)
        self.httpd = http.server.HTTPServer((self.HOST, self.PORT), self.handler)
        self.httpd.serve_forever()

    def join(self, timeout=None):
        if self.httpd:
            self.httpd.server_close()
        super().join()
