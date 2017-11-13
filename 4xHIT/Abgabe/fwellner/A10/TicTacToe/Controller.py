from View import View


class Controller:
    def __init__(self):
        self.view = View()

        self.turn = 0

        self.row1 = []
        self.row2 = []
        self.row3 = []

        self.buttons = [self.view.boardview.pushButton_1, self.view.boardview.pushButton_2, self.view.boardview.pushButton_3,
                        self.view.boardview.pushButton_4, self.view.boardview.pushButton_5, self.view.boardview.pushButton_6,
                        self.view.boardview.pushButton_7, self.view.boardview.pushButton_8, self.view.boardview.pushButton_9]

        self.place = {
            1: "",
            2: "",
            3: "",
            4: "",
            5: "",
            6: "",
            7: "",
            8: "",
            9: "",
        }

        for i in range(len(self.buttons)):
            self.place[i+1] = str(self.buttons[i].objectName())

        self.buttonHandle()

        self.xo = {
            0: "O",
            1: "X"
        }

        #ICH KÖNNTE ALLES HARDCODEN, ABER DAS IST HÄSSLICH

    def nextTurn(self, button):
        win_cond = [[1, 2, 3], [4, 5, 6], [7, 8, 9], [1, 4, 7], [2, 5, 8], [3, 6, 9], [1, 5, 9], [3, 5, 7]]

        if not button.text():
            if self.turn == 0:
                # Funktioniert nicht ganz, aber es ist ein Anfang
                # for i in range(1, 4):
                #     if button.objectName() == self.place[i]:
                #         self.row1 += [i]
                # for i in range(4, 7):
                #     if button.objectName() == self.place[i]:
                #         self.row2 += [i]
                # for i in range(7, 10):
                #     if button.objectName() == self.place[i]:
                #         self.row3 += [i]

                # Funktioniert nur, wenn man in den ersten 3 Zügen gewinnt
                # row = self.row1 + self.row2 + self.row3
                # if sorted(row) in win_cond:
                #     print("UltraNICE")
                self.turn = 1

            else:
                if self.turn == 1:
                    self.turn = 0

            button.setText(self.xo[self.turn])
            self.view.repaint()

    def buttonHandle(self):
        self.view.boardview.pushButton_1.clicked.connect(lambda: self.nextTurn(self.buttons[0]))
        self.view.boardview.pushButton_2.clicked.connect(lambda: self.nextTurn(self.buttons[1]))
        self.view.boardview.pushButton_3.clicked.connect(lambda: self.nextTurn(self.buttons[2]))
        self.view.boardview.pushButton_4.clicked.connect(lambda: self.nextTurn(self.buttons[3]))
        self.view.boardview.pushButton_5.clicked.connect(lambda: self.nextTurn(self.buttons[4]))
        self.view.boardview.pushButton_6.clicked.connect(lambda: self.nextTurn(self.buttons[5]))
        self.view.boardview.pushButton_7.clicked.connect(lambda: self.nextTurn(self.buttons[6]))
        self.view.boardview.pushButton_8.clicked.connect(lambda: self.nextTurn(self.buttons[7]))
        self.view.boardview.pushButton_9.clicked.connect(lambda: self.nextTurn(self.buttons[8]))
