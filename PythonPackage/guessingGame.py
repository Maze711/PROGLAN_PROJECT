import sys
import random
import warnings
from PyQt5 import uic
from PyQt5.QtWidgets import QApplication, QMainWindow

warnings.filterwarnings("ignore", category=DeprecationWarning)
class StartWindow(QMainWindow):
    def __init__(self, game):
        super().__init__()
        self.game = game
        uic.loadUi("mainWindow.ui", self)
        self.startButton.clicked.connect(self.start_game)

    def start_game(self):
        self.game.open_guess_window()

class GuessWindow(QMainWindow):
    def __init__(self, game):
        super().__init__()
        self.game = game
        uic.loadUi("guessWindow.ui", self)
        self.submitButton.clicked.connect(self.check_guess)

    def check_guess(self):
        try:
            guess = int(self.numInput.text())
            if self.game.check_guess(guess):
                self.game.open_congrats_window()
            else:
                self.game.open_wrong_window()
        except ValueError:
            self.game.open_wrong_window()

class CongratsWindow(QMainWindow):
    def __init__(self):
        super().__init__()
        uic.loadUi("congratsWindow.ui", self)

class WrongWindow(QMainWindow):
    def __init__(self):
        super().__init__()
        uic.loadUi("wrongWindow.ui", self)

class Game:
    def __init__(self):
        self.target_number = random.randint(1, 10)
        self.app = QApplication(sys.argv)
        self.start_window = StartWindow(self)
        self.guess_window = GuessWindow(self)
        self.congrats_window = CongratsWindow()
        self.wrong_window = WrongWindow()

    def open_guess_window(self):
        self.start_window.hide()
        self.guess_window.show()

    def open_congrats_window(self):
        self.guess_window.hide()
        self.congrats_window.show()

    def open_wrong_window(self):
        self.guess_window.hide()
        self.wrong_window.show()

    def check_guess(self, guess):
        return guess == self.target_number

    def run(self):
        self.start_window.show()
        sys.exit(self.app.exec_())

if __name__ == "__main__":
    game = Game()
    game.run()
