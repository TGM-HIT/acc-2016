from PySide import QtGui
from Controller import Controller
import sys

if __name__ == "__main__":
    app = QtGui.QApplication(sys.argv)
    c = Controller()
    sys.exit(app.exec_())
