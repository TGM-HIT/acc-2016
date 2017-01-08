"""
Author: TEKIN Abdurrahim Burak
Version: 22.12.2016
"""

import sys
from PySide import QtGui
from tictactoe_controller import TTTController

if __name__ == "__main__":
    app = QtGui.QApplication(sys.argv)
    controller = TTTController()
    sys.exit(app.exec_())