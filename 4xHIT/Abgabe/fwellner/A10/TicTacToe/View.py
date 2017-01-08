from PySide.QtGui import *
from board import Ui_Form


class View(QWidget):
    def __init__(self):
        super().__init__()

        self.boardview = Ui_Form()
        self.boardview.setupUi(self)
        self.show()
    #
    # def paintEvent(self, event):
    #     painter = QPainter()
    #
    #     board = QRect(self.myWidth/3 - 100, self.myHeight/3 - 50, 100, 100)
    #     liste = []
    #     liste.append(board)
    #
    #     mypen = QPen()
    #     mypen.setWidth(3)
    #     mypen.setColor(Qt.black)
    #
    #     painter.begin(self)
    #
    #     self.update()
    #     painter.drawRect(self.test)
    #
    #     painter.end()
    #
    # def mousePressEvent(self, QMouseEvent):
    #     print(QMouseEvent.pos())
    #
    #     if QMouseEvent.x() > 90 and QMouseEvent.x() < 120:
    #         self.test = QRect(95, 80, 50, 50)
