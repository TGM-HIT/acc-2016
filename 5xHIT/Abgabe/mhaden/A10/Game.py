from PySide.QtCore import *
from PySide.QtGui import *
import gui
import sys


class Game(QWidget):
    """
    Tick-Tac-Toe game
    """

    def __init__(self):
        """
        Initialize game
        """
        super().__init__()
        self.gui = gui.Ui_TicTacToe()
        self.gui.setupUi(self)

        self.board = [[0, 0, 0], [0, 0, 0], [0, 0, 0]]
        self.player_move = 1

        self.neu()

        self.restore_game()

    def save_game(self):
        """
        Backup the game
        """
        game_save = {"board": self.board, "move": self.player_move, "status": self.gui.status.text()}

        with open(".game_save.save", mode="w") as file:
            file.write(str(game_save))

    def restore_game(self):
        """
        Restore the game from backup file
        """
        buttons = [[self.gui.b_0_0, self.gui.b_0_1, self.gui.b_0_2], [self.gui.b_1_0, self.gui.b_1_1, self.gui.b_1_2],
                   [self.gui.b_2_0, self.gui.b_2_1, self.gui.b_2_2]]

        try:
            with open(".game_save.save") as file:
                game_save = file.read()
                self.board = eval(game_save)["board"]
                self.player_move = eval(game_save)["move"]
                self.gui.status.setText(eval(game_save)["status"])

            for key_x, button_x in enumerate(self.board):
                for key_y, button_y in enumerate(button_x):
                    if button_y == "X":
                        buttons[key_x][key_y].setEnabled(False)
                        buttons[key_x][key_y].setText("X")
                    elif button_y == "O":
                        buttons[key_x][key_y].setEnabled(False)
                        buttons[key_x][key_y].setText("O")

        except FileNotFoundError:
            pass

    def neu(self):
        """
        Create new game, resets game board
        """
        buttons = [self.gui.b_0_0, self.gui.b_1_0, self.gui.b_2_0, self.gui.b_0_1, self.gui.b_1_1, self.gui.b_2_1,
                   self.gui.b_0_2, self.gui.b_1_2, self.gui.b_2_2]

        for button in buttons:
            button.setEnabled(True)
            button.setText("")

        self.board = [[0, 0, 0], [0, 0, 0], [0, 0, 0]]
        self.player_move = 1
        self.status_update("Player X's turn")

    def update_game_field(self, sender):
        """
        Update text on game field

        :param sender: button that was pressed
        """
        if self.player_move == 1:
            sender.setText("X")
        elif self.player_move == 2:
            sender.setText("O")

    def gameClick(self):
        """
        Called if a game button is clicked
        """
        sender_button = self.sender()
        sender_button.setEnabled(False)
        self.update_game_field(sender_button)

        button_x, button_y = self.sender().objectName()[2], self.sender().objectName()[4]
        button_x = int(button_x)
        button_y = int(button_y)
        if self.player_move == 1:
            self.board[button_x][button_y] = "X"
        elif self.player_move == 2:
            self.board[button_x][button_y] = "O"

        check = self.check_draw(self.board, button_x, button_y)

        if check == "full":
            self.status_update("No more fields to choose from!")
        elif check:
            self.status_update("Player %s has won!" % ("X" if self.player_move == 1 else "O"))
            self.win()
        else:
            self.player_move = (self.player_move % 2) + 1  # Switch between player 1 and 2
            self.status_update("Player %s's turn" % ("X" if self.player_move == 1 else "O"))

        self.save_game()

    def status_update(self, state):
        """
        Update the status bar

        :param state: state to update
        """
        self.gui.status.setText(state)

    def win(self):
        """
        Called if a player has won
        Disable all buttons
        """
        buttons = [self.gui.b_0_0, self.gui.b_1_0, self.gui.b_2_0, self.gui.b_0_1, self.gui.b_1_1, self.gui.b_2_1,
                   self.gui.b_0_2, self.gui.b_1_2, self.gui.b_2_2]

        for button in buttons:
            button.setEnabled(False)

    def check_draw(self, board, x, y):
        """
        Check if a player has won or no more fields are free

        :param board: the game board
        :param x: last move button x
        :param y: last move button y
        :return: status, True if won, full if game is full
        """

        # check if win on vertical line
        if board[0][y] == board[1][y] == board[2][y]:
            return True

        # check if win on horizontal line
        if board[x][0] == board[x][1] == board[x][2]:
            return True

        # check if win on diagonal
        if x == y and board[0][0] == board[1][1] == board[2][2]:
            return True

        # check if win on diagonal 2
        if x + y == 2 and board[0][2] == board[1][1] == board[2][0]:
            return True

        for field_x in board:
            for field_y in field_x:
                if field_y == 0:
                    return False

        return "full"


if __name__ == '__main__':
    """
    Main
    """
    app = QApplication(sys.argv)
    g = Game()
    g.show()
    sys.exit(app.exec_())
