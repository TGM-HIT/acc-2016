import sys

from PySide.QtGui import QApplication
from PySide.QtGui import QDialog
from PySide.QtGui import QWidget

from Dialog import Ui_Dialog as Dialog
import QuizView
from QuizManager import QuizManager


class QuizController(QWidget):
    """
    Basic game which resembles 'Who Wants to Be a Millionaire?'. Users have to answer questions, which each have one
    right answer. It is also possible to add questions yourself. These are saved to a file, which can be exported and
    used with other instances of this application.
    This program is designed in a basic Controller-View structure. The MVC architecture was not implemented, as PyQT
    works much better with this simplified version.

    :author: Jakob Jungreithmeir
    :version: 1.0 21-12-2016
    """

    def __init__(self, parent=None):
        """
        Initializes the GUI by creating an instance of the generated Python Code. (generated with QT Designer).

        :param parent:
        """
        super().__init__(parent)
        self.form = QuizView.Ui_Form()
        self.form.setupUi(self)

        self.quiz_manager = QuizManager()
        self.next()
        self.__update_status__()

        self.form.bNext.clicked.connect(self.next)
        self.form.bNew.clicked.connect(self.new)
        self.form.bFinish.clicked.connect(self.end)

    def next(self):
        """
        If the next button is pressed, the given answer is checked, as well as the state of the game.
        """
        if not self.quiz_manager.check_if_finished():
            answer = self.__get_selected_answer__()
            self.quiz_manager.check_answer(self.form.lOutput.text(), answer)
            self.__uncheck_all__()

            initial_question = self.quiz_manager.get_question()
            self.form.lOutput.setText(initial_question[0])
            self.form.rA.setText(initial_question[1][0])
            self.form.rB.setText(initial_question[1][1])
            self.form.rC.setText(initial_question[1][2])
            self.form.rD.setText(initial_question[1][3])
            self.__update_status__()
        else:
            self.end()

    def new(self):
        """
        Opens up a small dialog window, which blocks the main window. Here a new question can be entered.
        """
        dialog = QDialog()
        dialog.ui = Dialog.Ui_Dialog()
        dialog.ui.setupUi(dialog)
        result = dialog.exec_()

        if result == QDialog.Accepted:
            self.quiz_manager.add_question(dialog.ui.eQuestion.toPlainText(),
                                           [dialog.ui.eAnswer1.toPlainText(), dialog.ui.eAnswer2.toPlainText(),
                                            dialog.ui.eAnswer3.toPlainText(), dialog.ui.eAnswer4.toPlainText()])

    def end(self):
        """
        (Visually) removes all important GUI elements and outputs a goodbye/status message.
        """
        self.form.lRemaining.setText('')
        self.form.rA.setVisible(False)
        self.form.rB.setVisible(False)
        self.form.rC.setVisible(False)
        self.form.rD.setVisible(False)
        self.form.bFinish.setVisible(False)
        self.form.bNew.setVisible(False)
        self.form.bNext.setVisible(False)
        self.form.lOutput.setText(self.quiz_manager.get_summary())

    def __get_selected_answer__(self):
        """
        Returns the label of the selected radiobutton.
        :return: "" if nothing is selected
        """
        if self.form.rA.isChecked():
            return self.form.rA.text()
        elif self.form.rB.isChecked():
            return self.form.rB.text()
        elif self.form.rC.isChecked():
            return self.form.rC.text()
        elif self.form.rD.isChecked():
            return self.form.rD.text()
        else:
            return ""

    def __uncheck_all__(self):
        """
        Unchecks all radio buttons. Can be used between questions, as normally this would not happen automatically.
        """
        self.form.rA.setAutoExclusive(False)
        self.form.rA.setChecked(False)
        self.form.rA.setAutoExclusive(True)

        self.form.rB.setAutoExclusive(False)
        self.form.rB.setChecked(False)
        self.form.rB.setAutoExclusive(True)

        self.form.rC.setAutoExclusive(False)
        self.form.rC.setChecked(False)
        self.form.rC.setAutoExclusive(True)

        self.form.rD.setAutoExclusive(False)
        self.form.rD.setChecked(False)
        self.form.rD.setAutoExclusive(True)

    def __update_status__(self):
        """
        Updates a label, which functions as a basic status bar.
        """
        self.form.lRemaining.setText(str(self.quiz_manager.get_remaining()) + ' left.')


if __name__ == "__main__":
    app = QApplication(sys.argv)
    c = QuizController()
    c.show()
    sys.exit(app.exec_())
