"""
Author: TEKIN Abdurrahim Burak
Version: 22.12.2016
"""

from PySide.QtGui import *
from PySide.QtCore import *

class TTTView(QWidget):

    long = 600
    width = 500

    def __init__(self):
        super(TTTView, self).__init__()

        self.long = TTTView.long
        self.width = TTTView.width

        self.setWindowTitle("TicTacToe")
        self.setObjectName("Widget")

        self.button1 = QPushButton(" ", self)
        self.button2 = QPushButton(" ", self)
        self.button3 = QPushButton(" ", self)
        self.button4 = QPushButton(" ", self)
        self.button5 = QPushButton(" ", self)
        self.button6 = QPushButton(" ", self)
        self.button7 = QPushButton(" ", self)
        self.button8 = QPushButton(" ", self)
        self.button9 = QPushButton(" ", self)

        self.button10 = QPushButton("Restart", self)
        self.button11 = QPushButton("Close", self)

        self.button1.setStyleSheet('QPushButton {font: 100px; background-color: #fdedec}')
        self.button2.setStyleSheet('QPushButton {font: 100px; background-color: #fadbd8}')
        self.button3.setStyleSheet('QPushButton {font: 100px; background-color: #fdedec}')
        self.button4.setStyleSheet('QPushButton {font: 100px; background-color: #fadbd8}')
        self.button5.setStyleSheet('QPushButton {font: 100px; background-color: #fdedec}')
        self.button6.setStyleSheet('QPushButton {font: 100px; background-color: #fadbd8}')
        self.button7.setStyleSheet('QPushButton {font: 100px; background-color: #fdedec}')
        self.button8.setStyleSheet('QPushButton {font: 100px; background-color: #fadbd8}')
        self.button9.setStyleSheet('QPushButton {font: 100px; background-color: #fdedec}')

        self.button10.setStyleSheet('QPushButton {font: 20px; background-color: #fadbd8}')
        self.button11.setStyleSheet('QPushButton {font: 20px; background-color: #fadbd8}')

        self.button1.resize(166, 166)
        self.button2.resize(166, 166)
        self.button3.resize(166, 166)
        self.button4.resize(166, 166)
        self.button5.resize(166, 166)
        self.button6.resize(166, 166)
        self.button7.resize(166, 166)
        self.button8.resize(166, 166)
        self.button9.resize(166, 166)

        self.button10.resize(200, 90)
        self.button11.resize(200, 90)

        self.button1.move(1, 0)
        self.button2.move(167, 0)
        self.button3.move(333, 0)
        self.button4.move(1, 167)
        self.button5.move(167, 167)
        self.button6.move(333, 167)
        self.button7.move(1, 333)
        self.button8.move(167, 333)
        self.button9.move(333, 333)

        self.button10.move(49, 503)
        self.button11.move(251, 503)

        self.button1.show()
        self.button2.show()
        self.button3.show()
        self.button4.show()
        self.button5.show()
        self.button6.show()
        self.button7.show()
        self.button8.show()
        self.button9.show()

        self.button10.show()
        self.button11.show()

        self.setStyleSheet('QWidget {background-color: rgb(249, 235, 234)}')

        self.setFixedSize(self.width, self.long)
        self.show()

class WinScreenX(QMessageBox):

    x = 200
    y = 100

    def __init__(self):
        super(WinScreenX, self).__init__()

        self.x = WinScreenX.x
        self.y = WinScreenX.y

        self.setWindowTitle("We have a winner!")
        self.setObjectName("QMessageBox")

        self.setInformativeText("Player X won!")
        self.setStyleSheet('QMessageBox {background-color: rgb(255, 204, 204); font: 20px}')
        self.setFixedSize(self.x, self.y)

class WinScreenO(QMessageBox):

    x = 200
    y = 100

    def __init__(self):
        super(WinScreenO, self).__init__()

        self.x = WinScreenO.x
        self.y = WinScreenO.y

        self.setWindowTitle("We have a winner!")
        self.setObjectName("QMessageBox")

        self.setInformativeText("Player O won!")
        self.setStyleSheet('QMessageBox {background-color: rgb(255, 204, 204); font: 20px}')
        self.setFixedSize(self.x, self.y)