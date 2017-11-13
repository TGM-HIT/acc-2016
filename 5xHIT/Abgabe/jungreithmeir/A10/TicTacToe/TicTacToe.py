import pickle
import pygame
import sys
from pathlib import Path


class TicTacToe:
    """
    Simple TicTacToe game realised with Pygame. Just press the field you which to place your symbol on in turns and play
    until you have enough. All the stats and the current progress is saved and can be resumed.
    If you want to reset the game just press 'r'.

    :author: Jakob Jungreithmeir
    :version: 1.0 19-12-2016
    """

    WHITE = (255, 255, 255)
    BLACK = (0, 0, 0)
    GREY = (224, 244, 244)

    def __init__(self, side):
        """
        Initializes PyGame and a lot of basic attributes. Also loads or creates the save game file, whether or not a
        game has been player on this machine.
        As a little site note if files are opened and the mode is 'rb' or 'wb' this means read/write binary. This needs
        to be used to correctly read/write the serialized objects/variables through pickle.

        :param side: Length of the PyGame window.
        """
        pygame.init()
        self.side = side
        self.screen = pygame.display.set_mode((self.side, self.side))
        self.screen.fill(self.WHITE)
        self.font = pygame.font.Font(None, 150)
        self.status = ""
        self.save_file = "save.txt"

        pygame.display.set_caption("TicTacToe by Jakob Jungreithmeir")

        save_file = Path(self.save_file)
        if save_file.is_file():
            data = pickle.load(open(self.save_file, "rb"))
            self.X = data[0][0]
            self.O = data[0][1]
            self.draw = data[0][2]
            self.game = data[1]
        else:
            self.X = 0
            self.O = 0
            self.draw = 0
            self.reset()
            self.persist()

        self.buttons = [[None, None, None], [None, None, None], [None, None, None]]
        self.last_pick = 'X'

    def __draw_playground__(self):
        """
        Draws the board, the tiles and the labels. Is called by the update method and therefore is as private as Python
        methods can be.
        """
        side = self.side * 0.8
        offset = self.side/10
        square = side/3

        for i, row in enumerate(self.game):
            for j, element in enumerate(row):
                color = self.WHITE
                # This is quite cool. The following if condition simply sets every 2nd tile grey.
                if (i+j) % 2 == 0:
                    color = self.GREY
                self.buttons[i][j] = pygame.draw.rect(self.screen, color,
                                                      (square * i + offset, square * j + offset, square, square))
                text_position = (self.buttons[i][j].centerx - self.side/16, self.buttons[i][j].centery - self.side/16)
                self.screen.blit(self.font.render(element, 1, self.BLACK), text_position)

    def reset(self):
        """
        Resets the board.
        """
        self.game = [[' ', ' ', ' '],
                     [' ', ' ', ' '],
                     [' ', ' ', ' ']]

    def check_mouse_press(self, pos):
        """
        Checks if the position of the mouse is currently colliding with any of the hitboxes of the TicTacToe rectangles.
        If this is the case the new symbol is added to the board.

        :param pos: mouse position tuple
        """
        for i, row in enumerate(self.buttons):
            for j, button in enumerate(row):
                if button.collidepoint(pos):
                    if self.game[i][j] != 'X' and self.game[i][j] != 'O':
                        if self.last_pick == 'X':
                            self.last_pick = 'O'
                        else:
                            self.last_pick = 'X'
                        self.game[i][j] = self.last_pick

    def check_if_finished(self):
        """
        Checks all possible combinations which would result in the victory of one player.

        :return: the symbol of the winner or None if the game has not ended yet or it has resulted in a draw. The return
        value is not really needed, but somehow I need to leave the method at a certain point and for future uses the
        winning symbol sounded like a good idea.
        """
        for x, row in enumerate(self.game):
            for y, element in enumerate(row):
                if self.game[x][0] == self.game[x][1] == self.game[x][2] and self.game[x][0] != ' ':
                    winner = self.game[x][0]
                    self.add_score(winner)
                    return winner
                elif self.game[0][y] == self.game[1][y] == self.game[2][y] and self.game[0][y] != ' ':
                    winner = self.game[0][y]
                    self.add_score(winner)
                    return winner
                elif self.game[0][0] == self.game[1][1] == self.game[2][2] and self.game[0][0] != ' ':
                    winner = self.game[0][0]
                    self.add_score(winner)
                    return winner
                elif self.game[2][0] == self.game[1][1] == self.game[0][2] and self.game[2][0] != ' ':
                    winner = self.game[2][0]
                    self.add_score(winner)
                    return winner

        if self.board_is_full():
            self.add_score('draw')
        else:
            self.status = ''
        return None

    def board_is_full(self):
        """
        Checks if the board is full. Important for draw verification.

        :return: True = all fields are not ' ' any longer, False = otherwise
        """
        for x, row in enumerate(self.game):
            for y, element in enumerate(row):
                if self.game[x][y] == ' ':
                    return False
        return True

    def add_score(self, result):
        """
        Takes the result and responds appropriately.

        :param result: 'X' or 'O' or something else entirely for a draw.
        """
        if result == 'X':
            self.X += 1
            self.status = "X won."
        elif result == 'O':
            self.O += 1
            self.status = "O won."
        else:
            self.draw += 1
            self.status = "Nobody won."
        self.reset()

    def __display_status__(self):
        """
        Displays the statistics and the victory message.
        """
        small_font = pygame.font.Font(None, 30)
        status = "Draws: " + str(self.draw) + " " * 6 + \
                 "X: " + str(self.X) + " " * 6 + \
                 "O: " + str(self.O) + " " * 6 + \
                 self.status
        self.screen.blit(small_font.render(status, 1, self.BLACK), (5, self.side * 0.95))

    def persist(self):
        """
        Saves the current game data to the save game file.
        """
        pickle.dump([[self.X, self.O, self.draw], self.game], open(self.save_file, "wb"))

    def update(self):
        """
        Redraws everything.
        """
        pygame.draw.rect(self.screen, self.WHITE, (0, 0, self.side, self.side))
        self.__draw_playground__()
        self.__display_status__()
        self.persist()
        pygame.display.update()


class MainWindow:
    def __init__(self):
        self.game = TicTacToe(600)

    def render(self):
        while 1:
            for event in pygame.event.get():
                if event.type == pygame.QUIT:
                    sys.exit()
                elif event.type == pygame.KEYDOWN:
                    if event.key == pygame.K_ESCAPE:
                        pygame.quit()
                        sys.exit()
                    elif event.key == pygame.K_r:
                        self.game.reset()
                elif event.type == pygame.MOUSEBUTTONUP:
                    pos = pygame.mouse.get_pos()
                    self.game.check_mouse_press(pos)
                    self.game.check_if_finished()

            self.game.update()

if __name__ == "__main__":
    MainWindow = MainWindow()
    MainWindow.render()
