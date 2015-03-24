package com.mycompany.hangman;

/**
 *
 * @author Jacob
 */
public class GameGui {

    boolean stillPlaying = true;
    String answer = "flot";
    int attempts = 0;
    int remainingAttempts = 7;

    public void startGame() {
        System.out.println("Welcome to Hangman");
        System.out.println("You have " + remainingAttempts + " attempts to solve the word.");
    }

    public void testForWinner(String guess) {
        if (guess.equals(answer)) {
            stillPlaying = false;
            gameWon();
        }
        if (attempts == 7) {
            stillPlaying = false;
            newGame();
        }
    }

    public void gameWon() {
        System.out.println("Congratulations");
        System.out.println("You guessed it!");
        System.out.println("Using " + attempts + "attempts.");
    }

    private void newGame() {
        System.out.println("Want to play a new game?");
        System.out.println("type 'y'");
        //read char her
        String s = "reader her!";
        if (s == "y") {
            startGame();
        } else {
            System.out.println("Thank you for playing");
        }
    }

}
