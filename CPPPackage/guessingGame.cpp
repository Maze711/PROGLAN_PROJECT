#include <iostream>
#include <cstdlib>
#include <ctime>
#include <limits>

using namespace std;

class Game {
public:
    Game() {
        srand(time(0));
        target_number = rand() % 10 + 1;
    }

    void start_game() {
        int guess = 0;
        bool correct = false;

        cout << "Welcome to the Guessing Game!" << endl;
        cout << "Try to guess the number between 1 and 10." << endl;

        while (!correct) {
            cout << "Enter your guess: ";
            cin >> guess;

            if (cin.fail()) {
                cin.clear(); 
                cin.ignore(numeric_limits<streamsize>::max(), '\n');
                cout << "Invalid input, please enter a number." << endl;
                continue;
            }

            correct = check_guess(guess);

            if (correct) {
                cout << "Congratulations! You guessed the correct number!" << endl;
            } else {
                cout << "Wrong guess! Try again." << endl;
            }
        }
    }

private:
    int target_number;

    bool check_guess(int guess) {
        return guess == target_number;
    }
};

int main() {
    Game game;
    game.start_game();
    return 0;
}
