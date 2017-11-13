"""
Author: TEKIN Abdurrahim Burak
Version: 22.12.2016
"""

from tictactoe_view import *
import sys

class TTTController():

    runde = True

    def __init__(self):
        super().__init__()

        self.view = TTTView()
        self.winx = WinScreenX()
        self.wino = WinScreenO()
        self.view.show()

        self.view.button1.clicked.connect(self.button1check)
        self.view.button2.clicked.connect(self.button2check)
        self.view.button3.clicked.connect(self.button3check)
        self.view.button4.clicked.connect(self.button4check)
        self.view.button5.clicked.connect(self.button5check)
        self.view.button6.clicked.connect(self.button6check)
        self.view.button7.clicked.connect(self.button7check)
        self.view.button8.clicked.connect(self.button8check)
        self.view.button9.clicked.connect(self.button9check)

        self.view.button10.clicked.connect(self.restart)
        self.view.button11.clicked.connect(self.close)

    def close(self):
        sys.exit()

    def restart(self):
        self.runde = True
        self.view.button1.setEnabled(True)
        self.view.button2.setEnabled(True)
        self.view.button3.setEnabled(True)
        self.view.button4.setEnabled(True)
        self.view.button5.setEnabled(True)
        self.view.button6.setEnabled(True)
        self.view.button7.setEnabled(True)
        self.view.button8.setEnabled(True)
        self.view.button9.setEnabled(True)

        self.view.button1.setText(" ")
        self.view.button2.setText(" ")
        self.view.button3.setText(" ")
        self.view.button4.setText(" ")
        self.view.button5.setText(" ")
        self.view.button6.setText(" ")
        self.view.button7.setText(" ")
        self.view.button8.setText(" ")
        self.view.button9.setText(" ")

    def button1check(self):
        if self.view.button1.text() == " " and self.runde == True:
            self.view.button1.setText("X")
            self.runde = False
            self.view.button1.setEnabled(False)
            self.update()

            if (self.view.button1.text() == "X" and self.view.button2.text() == "X" and self.view.button3.text() == "X") or (
                self.view.button4.text() == "X" and self.view.button5.text() == "X" and self.view.button6.text() == "X") or (
                self.view.button7.text() == "X" and self.view.button8.text() == "X" and self.view.button9.text() == "X") or (
                self.view.button1.text() == "X" and self.view.button4.text() == "X" and self.view.button7.text() == "X") or (
                self.view.button2.text() == "X" and self.view.button5.text() == "X" and self.view.button8.text() == "X") or (
                self.view.button3.text() == "X" and self.view.button6.text() == "X" and self.view.button9.text() == "X") or (
                self.view.button1.text() == "X" and self.view.button5.text() == "X" and self.view.button9.text() == "X") or (
                self.view.button3.text() == "X" and self.view.button5.text() == "X" and self.view.button7.text() == "X"):
                self.winx.show()
                self.update()
                self.view.button2.setEnabled(False)
                self.view.button3.setEnabled(False)
                self.view.button4.setEnabled(False)
                self.view.button5.setEnabled(False)
                self.view.button6.setEnabled(False)
                self.view.button7.setEnabled(False)
                self.view.button8.setEnabled(False)
                self.view.button9.setEnabled(False)

        elif self.view.button1.text() == " " and self.runde == False:
            self.view.button1.setText("O")
            self.runde = True
            self.view.button1.setEnabled(False)
            self.update()

            if (self.view.button1.text() == "O" and self.view.button2.text() == "O" and self.view.button3.text() == "O") or (
                self.view.button4.text() == "O" and self.view.button5.text() == "O" and self.view.button6.text() == "O") or (
                self.view.button7.text() == "O" and self.view.button8.text() == "O" and self.view.button9.text() == "O") or (
                self.view.button1.text() == "O" and self.view.button4.text() == "O" and self.view.button7.text() == "O") or (
                self.view.button2.text() == "O" and self.view.button5.text() == "O" and self.view.button8.text() == "O") or (
                self.view.button3.text() == "O" and self.view.button6.text() == "O" and self.view.button9.text() == "O") or (
                self.view.button1.text() == "O" and self.view.button5.text() == "O" and self.view.button9.text() == "O") or (
                self.view.button3.text() == "O" and self.view.button5.text() == "O" and self.view.button7.text() == "O"):
                self.wino.show()
                self.update()

                self.view.button2.setEnabled(False)
                self.view.button3.setEnabled(False)
                self.view.button4.setEnabled(False)
                self.view.button5.setEnabled(False)
                self.view.button6.setEnabled(False)
                self.view.button7.setEnabled(False)
                self.view.button8.setEnabled(False)
                self.view.button9.setEnabled(False)


    def button2check(self):
        if self.view.button2.text() == " " and self.runde == True:
            self.view.button2.setText("X")
            self.runde = False
            self.view.button2.setEnabled(False)
            self.update()

            if (self.view.button1.text() == "X" and self.view.button2.text() == "X" and self.view.button3.text() == "X") or (
                self.view.button4.text() == "X" and self.view.button5.text() == "X" and self.view.button6.text() == "X") or (
                self.view.button7.text() == "X" and self.view.button8.text() == "X" and self.view.button9.text() == "X") or (
                self.view.button1.text() == "X" and self.view.button4.text() == "X" and self.view.button7.text() == "X") or (
                self.view.button2.text() == "X" and self.view.button5.text() == "X" and self.view.button8.text() == "X") or (
                self.view.button3.text() == "X" and self.view.button6.text() == "X" and self.view.button9.text() == "X") or (
                self.view.button1.text() == "X" and self.view.button5.text() == "X" and self.view.button9.text() == "X") or (
                self.view.button3.text() == "X" and self.view.button5.text() == "X" and self.view.button7.text() == "X"):
                self.winx.show()
                self.update()

                self.view.button1.setEnabled(False)
                self.view.button3.setEnabled(False)
                self.view.button4.setEnabled(False)
                self.view.button5.setEnabled(False)
                self.view.button6.setEnabled(False)
                self.view.button7.setEnabled(False)
                self.view.button8.setEnabled(False)
                self.view.button9.setEnabled(False)

        elif self.view.button2.text() == " " and self.runde == False:
            self.view.button2.setText("O")
            self.runde = True
            self.view.button2.setEnabled(False)
            self.update()

            if (self.view.button1.text() == "O" and self.view.button2.text() == "O" and self.view.button3.text() == "O") or (
                self.view.button4.text() == "O" and self.view.button5.text() == "O" and self.view.button6.text() == "O") or (
                self.view.button7.text() == "O" and self.view.button8.text() == "O" and self.view.button9.text() == "O") or (
                self.view.button1.text() == "O" and self.view.button4.text() == "O" and self.view.button7.text() == "O") or (
                self.view.button2.text() == "O" and self.view.button5.text() == "O" and self.view.button8.text() == "O") or (
                self.view.button3.text() == "O" and self.view.button6.text() == "O" and self.view.button9.text() == "O") or (
                self.view.button1.text() == "O" and self.view.button5.text() == "O" and self.view.button9.text() == "O") or (
                self.view.button3.text() == "O" and self.view.button5.text() == "O" and self.view.button7.text() == "O"):
                self.wino.show()
                self.update()

                self.view.button1.setEnabled(False)
                self.view.button3.setEnabled(False)
                self.view.button4.setEnabled(False)
                self.view.button5.setEnabled(False)
                self.view.button6.setEnabled(False)
                self.view.button7.setEnabled(False)
                self.view.button8.setEnabled(False)
                self.view.button9.setEnabled(False)

    def button3check(self):
        if self.view.button3.text() == " " and self.runde == True:
            self.view.button3.setText("X")
            self.runde = False
            self.view.button3.setEnabled(False)
            self.update()

            if (self.view.button1.text() == "X" and self.view.button2.text() == "X" and self.view.button3.text() == "X") or (
                self.view.button4.text() == "X" and self.view.button5.text() == "X" and self.view.button6.text() == "X") or (
                self.view.button7.text() == "X" and self.view.button8.text() == "X" and self.view.button9.text() == "X") or (
                self.view.button1.text() == "X" and self.view.button4.text() == "X" and self.view.button7.text() == "X") or (
                self.view.button2.text() == "X" and self.view.button5.text() == "X" and self.view.button8.text() == "X") or (
                self.view.button3.text() == "X" and self.view.button6.text() == "X" and self.view.button9.text() == "X") or (
                self.view.button1.text() == "X" and self.view.button5.text() == "X" and self.view.button9.text() == "X") or (
                self.view.button3.text() == "X" and self.view.button5.text() == "X" and self.view.button7.text() == "X"):
                self.winx.show()
                self.update()

                self.view.button2.setEnabled(False)
                self.view.button1.setEnabled(False)
                self.view.button4.setEnabled(False)
                self.view.button5.setEnabled(False)
                self.view.button6.setEnabled(False)
                self.view.button7.setEnabled(False)
                self.view.button8.setEnabled(False)
                self.view.button9.setEnabled(False)

        elif self.view.button3.text() == " " and self.runde == False:
            self.view.button3.setText("O")
            self.runde = True
            self.view.button3.setEnabled(False)
            self.update()

            if (self.view.button1.text() == "O" and self.view.button2.text() == "O" and self.view.button3.text() == "O") or (
                self.view.button4.text() == "O" and self.view.button5.text() == "O" and self.view.button6.text() == "O") or (
                self.view.button7.text() == "O" and self.view.button8.text() == "O" and self.view.button9.text() == "O") or (
                self.view.button1.text() == "O" and self.view.button4.text() == "O" and self.view.button7.text() == "O") or (
                self.view.button2.text() == "O" and self.view.button5.text() == "O" and self.view.button8.text() == "O") or (
                self.view.button3.text() == "O" and self.view.button6.text() == "O" and self.view.button9.text() == "O") or (
                self.view.button1.text() == "O" and self.view.button5.text() == "O" and self.view.button9.text() == "O") or (
                self.view.button3.text() == "O" and self.view.button5.text() == "O" and self.view.button7.text() == "O"):
                self.wino.show()
                self.update()

                self.view.button2.setEnabled(False)
                self.view.button1.setEnabled(False)
                self.view.button4.setEnabled(False)
                self.view.button5.setEnabled(False)
                self.view.button6.setEnabled(False)
                self.view.button7.setEnabled(False)
                self.view.button8.setEnabled(False)
                self.view.button9.setEnabled(False)

    def button4check(self):
        if self.view.button4.text() == " " and self.runde == True:
            self.view.button4.setText("X")
            self.runde = False
            self.view.button4.setEnabled(False)
            self.update()

            if (self.view.button1.text() == "X" and self.view.button2.text() == "X" and self.view.button3.text() == "X") or (
                self.view.button4.text() == "X" and self.view.button5.text() == "X" and self.view.button6.text() == "X") or (
                self.view.button7.text() == "X" and self.view.button8.text() == "X" and self.view.button9.text() == "X") or (
                self.view.button1.text() == "X" and self.view.button4.text() == "X" and self.view.button7.text() == "X") or (
                self.view.button2.text() == "X" and self.view.button5.text() == "X" and self.view.button8.text() == "X") or (
                self.view.button3.text() == "X" and self.view.button6.text() == "X" and self.view.button9.text() == "X") or (
                self.view.button1.text() == "X" and self.view.button5.text() == "X" and self.view.button9.text() == "X") or (
                self.view.button3.text() == "X" and self.view.button5.text() == "X" and self.view.button7.text() == "X"):
                self.winx.show()
                self.update()

                self.view.button2.setEnabled(False)
                self.view.button3.setEnabled(False)
                self.view.button1.setEnabled(False)
                self.view.button5.setEnabled(False)
                self.view.button6.setEnabled(False)
                self.view.button7.setEnabled(False)
                self.view.button8.setEnabled(False)
                self.view.button9.setEnabled(False)

        elif self.view.button4.text() == " " and self.runde == False:
            self.view.button4.setText("O")
            self.runde = True
            self.view.button4.setEnabled(False)
            self.update()

            if (self.view.button1.text() == "O" and self.view.button2.text() == "O" and self.view.button3.text() == "O") or (
                self.view.button4.text() == "O" and self.view.button5.text() == "O" and self.view.button6.text() == "O") or (
                self.view.button7.text() == "O" and self.view.button8.text() == "O" and self.view.button9.text() == "O") or (
                self.view.button1.text() == "O" and self.view.button4.text() == "O" and self.view.button7.text() == "O") or (
                self.view.button2.text() == "O" and self.view.button5.text() == "O" and self.view.button8.text() == "O") or (
                self.view.button3.text() == "O" and self.view.button6.text() == "O" and self.view.button9.text() == "O") or (
                self.view.button1.text() == "O" and self.view.button5.text() == "O" and self.view.button9.text() == "O") or (
                self.view.button3.text() == "O" and self.view.button5.text() == "O" and self.view.button7.text() == "O"):
                self.wino.show()
                self.update()

                self.view.button2.setEnabled(False)
                self.view.button3.setEnabled(False)
                self.view.button1.setEnabled(False)
                self.view.button5.setEnabled(False)
                self.view.button6.setEnabled(False)
                self.view.button7.setEnabled(False)
                self.view.button8.setEnabled(False)
                self.view.button9.setEnabled(False)

    def button5check(self):
        if self.view.button5.text() == " " and self.runde == True:
            self.view.button5.setText("X")
            self.runde = False
            self.view.button5.setEnabled(False)
            self.update()

            if (self.view.button1.text() == "X" and self.view.button2.text() == "X" and self.view.button3.text() == "X") or (
                self.view.button4.text() == "X" and self.view.button5.text() == "X" and self.view.button6.text() == "X") or (
                self.view.button7.text() == "X" and self.view.button8.text() == "X" and self.view.button9.text() == "X") or (
                self.view.button1.text() == "X" and self.view.button4.text() == "X" and self.view.button7.text() == "X") or (
                self.view.button2.text() == "X" and self.view.button5.text() == "X" and self.view.button8.text() == "X") or (
                self.view.button3.text() == "X" and self.view.button6.text() == "X" and self.view.button9.text() == "X") or (
                self.view.button1.text() == "X" and self.view.button5.text() == "X" and self.view.button9.text() == "X") or (
                self.view.button3.text() == "X" and self.view.button5.text() == "X" and self.view.button7.text() == "X"):
                self.winx.show()
                self.update()

                self.view.button2.setEnabled(False)
                self.view.button3.setEnabled(False)
                self.view.button4.setEnabled(False)
                self.view.button1.setEnabled(False)
                self.view.button6.setEnabled(False)
                self.view.button7.setEnabled(False)
                self.view.button8.setEnabled(False)
                self.view.button9.setEnabled(False)

        elif self.view.button5.text() == " " and self.runde == False:
            self.view.button5.setText("O")
            self.runde = True
            self.view.button5.setEnabled(False)
            self.update()

            if (self.view.button1.text() == "O" and self.view.button2.text() == "O" and self.view.button3.text() == "O") or (
                self.view.button4.text() == "O" and self.view.button5.text() == "O" and self.view.button6.text() == "O") or (
                self.view.button7.text() == "O" and self.view.button8.text() == "O" and self.view.button9.text() == "O") or (
                self.view.button1.text() == "O" and self.view.button4.text() == "O" and self.view.button7.text() == "O") or (
                self.view.button2.text() == "O" and self.view.button5.text() == "O" and self.view.button8.text() == "O") or (
                self.view.button3.text() == "O" and self.view.button6.text() == "O" and self.view.button9.text() == "O") or (
                self.view.button1.text() == "O" and self.view.button5.text() == "O" and self.view.button9.text() == "O") or (
                self.view.button3.text() == "O" and self.view.button5.text() == "O" and self.view.button7.text() == "O"):
                self.wino.show()
                self.update()

                self.view.button2.setEnabled(False)
                self.view.button3.setEnabled(False)
                self.view.button4.setEnabled(False)
                self.view.button1.setEnabled(False)
                self.view.button6.setEnabled(False)
                self.view.button7.setEnabled(False)
                self.view.button8.setEnabled(False)
                self.view.button9.setEnabled(False)

    def button6check(self):
        if self.view.button6.text() == " " and self.runde == True:
            self.view.button6.setText("X")
            self.runde = False
            self.view.button6.setEnabled(False)
            self.update()

            if (self.view.button1.text() == "X" and self.view.button2.text() == "X" and self.view.button3.text() == "X") or (
                self.view.button4.text() == "X" and self.view.button5.text() == "X" and self.view.button6.text() == "X") or (
                self.view.button7.text() == "X" and self.view.button8.text() == "X" and self.view.button9.text() == "X") or (
                self.view.button1.text() == "X" and self.view.button4.text() == "X" and self.view.button7.text() == "X") or (
                self.view.button2.text() == "X" and self.view.button5.text() == "X" and self.view.button8.text() == "X") or (
                self.view.button3.text() == "X" and self.view.button6.text() == "X" and self.view.button9.text() == "X") or (
                self.view.button1.text() == "X" and self.view.button5.text() == "X" and self.view.button9.text() == "X") or (
                self.view.button3.text() == "X" and self.view.button5.text() == "X" and self.view.button7.text() == "X"):
                self.winx.show()
                self.update()

                self.view.button2.setEnabled(False)
                self.view.button3.setEnabled(False)
                self.view.button4.setEnabled(False)
                self.view.button5.setEnabled(False)
                self.view.button1.setEnabled(False)
                self.view.button7.setEnabled(False)
                self.view.button8.setEnabled(False)
                self.view.button9.setEnabled(False)

        elif self.view.button6.text() == " " and self.runde == False:
            self.view.button6.setText("O")
            self.runde = True
            self.view.button6.setEnabled(False)
            self.update()

            if (self.view.button1.text() == "O" and self.view.button2.text() == "O" and self.view.button3.text() == "O") or (
                self.view.button4.text() == "O" and self.view.button5.text() == "O" and self.view.button6.text() == "O") or (
                self.view.button7.text() == "O" and self.view.button8.text() == "O" and self.view.button9.text() == "O") or (
                self.view.button1.text() == "O" and self.view.button4.text() == "O" and self.view.button7.text() == "O") or (
                self.view.button2.text() == "O" and self.view.button5.text() == "O" and self.view.button8.text() == "O") or (
                self.view.button3.text() == "O" and self.view.button6.text() == "O" and self.view.button9.text() == "O") or (
                self.view.button1.text() == "O" and self.view.button5.text() == "O" and self.view.button9.text() == "O") or (
                self.view.button3.text() == "O" and self.view.button5.text() == "O" and self.view.button7.text() == "O"):
                self.wino.show()
                self.update()

                self.view.button2.setEnabled(False)
                self.view.button3.setEnabled(False)
                self.view.button4.setEnabled(False)
                self.view.button5.setEnabled(False)
                self.view.button1.setEnabled(False)
                self.view.button7.setEnabled(False)
                self.view.button8.setEnabled(False)
                self.view.button9.setEnabled(False)

    def button7check(self):
        if self.view.button7.text() == " " and self.runde == True:
            self.view.button7.setText("X")
            self.runde = False
            self.view.button7.setEnabled(False)
            self.update()

            if (self.view.button1.text() == "X" and self.view.button2.text() == "X" and self.view.button3.text() == "X") or (
                self.view.button4.text() == "X" and self.view.button5.text() == "X" and self.view.button6.text() == "X") or (
                self.view.button7.text() == "X" and self.view.button8.text() == "X" and self.view.button9.text() == "X") or (
                self.view.button1.text() == "X" and self.view.button4.text() == "X" and self.view.button7.text() == "X") or (
                self.view.button2.text() == "X" and self.view.button5.text() == "X" and self.view.button8.text() == "X") or (
                self.view.button3.text() == "X" and self.view.button6.text() == "X" and self.view.button9.text() == "X") or (
                self.view.button1.text() == "X" and self.view.button5.text() == "X" and self.view.button9.text() == "X") or (
                self.view.button3.text() == "X" and self.view.button5.text() == "X" and self.view.button7.text() == "X"):
                self.winx.show()
                self.update()

                self.view.button2.setEnabled(False)
                self.view.button3.setEnabled(False)
                self.view.button4.setEnabled(False)
                self.view.button5.setEnabled(False)
                self.view.button6.setEnabled(False)
                self.view.button1.setEnabled(False)
                self.view.button8.setEnabled(False)
                self.view.button9.setEnabled(False)

        elif self.view.button7.text() == " " and self.runde == False:
            self.view.button7.setText("O")
            self.runde = True
            self.view.button7.setEnabled(False)
            self.update()

            if (self.view.button1.text() == "O" and self.view.button2.text() == "O" and self.view.button3.text() == "O") or (
                self.view.button4.text() == "O" and self.view.button5.text() == "O" and self.view.button6.text() == "O") or (
                self.view.button7.text() == "O" and self.view.button8.text() == "O" and self.view.button9.text() == "O") or (
                self.view.button1.text() == "O" and self.view.button4.text() == "O" and self.view.button7.text() == "O") or (
                self.view.button2.text() == "O" and self.view.button5.text() == "O" and self.view.button8.text() == "O") or (
                self.view.button3.text() == "O" and self.view.button6.text() == "O" and self.view.button9.text() == "O") or (
                self.view.button1.text() == "O" and self.view.button5.text() == "O" and self.view.button9.text() == "O") or (
                self.view.button3.text() == "O" and self.view.button5.text() == "O" and self.view.button7.text() == "O"):
                self.wino.show()
                self.update()

                self.view.button2.setEnabled(False)
                self.view.button3.setEnabled(False)
                self.view.button4.setEnabled(False)
                self.view.button5.setEnabled(False)
                self.view.button6.setEnabled(False)
                self.view.button1.setEnabled(False)
                self.view.button8.setEnabled(False)
                self.view.button9.setEnabled(False)

    def button8check(self):
        if self.view.button8.text() == " " and self.runde == True:
            self.view.button8.setText("X")
            self.runde = False
            self.view.button8.setEnabled(False)
            self.update()

            if (self.view.button1.text() == "X" and self.view.button2.text() == "X" and self.view.button3.text() == "X") or (
                self.view.button4.text() == "X" and self.view.button5.text() == "X" and self.view.button6.text() == "X") or (
                self.view.button7.text() == "X" and self.view.button8.text() == "X" and self.view.button9.text() == "X") or (
                self.view.button1.text() == "X" and self.view.button4.text() == "X" and self.view.button7.text() == "X") or (
                self.view.button2.text() == "X" and self.view.button5.text() == "X" and self.view.button8.text() == "X") or (
                self.view.button3.text() == "X" and self.view.button6.text() == "X" and self.view.button9.text() == "X") or (
                self.view.button1.text() == "X" and self.view.button5.text() == "X" and self.view.button9.text() == "X") or (
                self.view.button3.text() == "X" and self.view.button5.text() == "X" and self.view.button7.text() == "X"):
                self.winx.show()
                self.update()

                self.view.button2.setEnabled(False)
                self.view.button3.setEnabled(False)
                self.view.button4.setEnabled(False)
                self.view.button5.setEnabled(False)
                self.view.button6.setEnabled(False)
                self.view.button7.setEnabled(False)
                self.view.button1.setEnabled(False)
                self.view.button9.setEnabled(False)

        elif self.view.button8.text() == " " and self.runde == False:
            self.view.button8.setText("O")
            self.runde = True
            self.view.button8.setEnabled(False)
            self.update()

            if (self.view.button1.text() == "O" and self.view.button2.text() == "O" and self.view.button3.text() == "O") or (
                self.view.button4.text() == "O" and self.view.button5.text() == "O" and self.view.button6.text() == "O") or (
                self.view.button7.text() == "O" and self.view.button8.text() == "O" and self.view.button9.text() == "O") or (
                self.view.button1.text() == "O" and self.view.button4.text() == "O" and self.view.button7.text() == "O") or (
                self.view.button2.text() == "O" and self.view.button5.text() == "O" and self.view.button8.text() == "O") or (
                self.view.button3.text() == "O" and self.view.button6.text() == "O" and self.view.button9.text() == "O") or (
                self.view.button1.text() == "O" and self.view.button5.text() == "O" and self.view.button9.text() == "O") or (
                self.view.button3.text() == "O" and self.view.button5.text() == "O" and self.view.button7.text() == "O"):
                self.wino.show()
                self.update()

                self.view.button2.setEnabled(False)
                self.view.button3.setEnabled(False)
                self.view.button4.setEnabled(False)
                self.view.button5.setEnabled(False)
                self.view.button6.setEnabled(False)
                self.view.button7.setEnabled(False)
                self.view.button1.setEnabled(False)
                self.view.button9.setEnabled(False)

    def button9check(self):
        if self.view.button9.text() == " " and self.runde == True:
            self.view.button9.setText("X")
            self.runde = False
            self.view.button9.setEnabled(False)
            self.update()

            if (self.view.button1.text() == "X" and self.view.button2.text() == "X" and self.view.button3.text() == "X") or (
                self.view.button4.text() == "X" and self.view.button5.text() == "X" and self.view.button6.text() == "X") or (
                self.view.button7.text() == "X" and self.view.button8.text() == "X" and self.view.button9.text() == "X") or (
                self.view.button1.text() == "X" and self.view.button4.text() == "X" and self.view.button7.text() == "X") or (
                self.view.button2.text() == "X" and self.view.button5.text() == "X" and self.view.button8.text() == "X") or (
                self.view.button3.text() == "X" and self.view.button6.text() == "X" and self.view.button9.text() == "X") or (
                self.view.button1.text() == "X" and self.view.button5.text() == "X" and self.view.button9.text() == "X") or (
                self.view.button3.text() == "X" and self.view.button5.text() == "X" and self.view.button7.text() == "X"):
                self.winx.show()
                self.update()

                self.view.button2.setEnabled(False)
                self.view.button3.setEnabled(False)
                self.view.button4.setEnabled(False)
                self.view.button5.setEnabled(False)
                self.view.button6.setEnabled(False)
                self.view.button7.setEnabled(False)
                self.view.button8.setEnabled(False)
                self.view.button1.setEnabled(False)

        elif self.view.button9.text() == " " and self.runde == False:
            self.view.button9.setText("O")
            self.runde = True
            self.view.button9.setEnabled(False)
            self.update()

            if (self.view.button1.text() == "O" and self.view.button2.text() == "O" and self.view.button3.text() == "O") or (
                self.view.button4.text() == "O" and self.view.button5.text() == "O" and self.view.button6.text() == "O") or (
                self.view.button7.text() == "O" and self.view.button8.text() == "O" and self.view.button9.text() == "O") or (
                self.view.button1.text() == "O" and self.view.button4.text() == "O" and self.view.button7.text() == "O") or (
                self.view.button2.text() == "O" and self.view.button5.text() == "O" and self.view.button8.text() == "O") or (
                self.view.button3.text() == "O" and self.view.button6.text() == "O" and self.view.button9.text() == "O") or (
                self.view.button1.text() == "O" and self.view.button5.text() == "O" and self.view.button9.text() == "O") or (
                self.view.button3.text() == "O" and self.view.button5.text() == "O" and self.view.button7.text() == "O"):
                self.wino.show()
                self.update()

                self.view.button2.setEnabled(False)
                self.view.button3.setEnabled(False)
                self.view.button4.setEnabled(False)
                self.view.button5.setEnabled(False)
                self.view.button6.setEnabled(False)
                self.view.button7.setEnabled(False)
                self.view.button8.setEnabled(False)
                self.view.button1.setEnabled(False)

    def update(self):
        self.view.repaint()