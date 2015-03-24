package com.mycompany.hangman;

import com.mycompany.hangman.DAL.DALWord;
import java.util.Scanner;

/**
 *
 * @author Jacob
 */
public class GameGui {

    DALWord dalWord;
    boolean stillPlaying = true;
    String answer = "";
    String secret = "";
    int attempts = 0;
    int remainingAttempts = 7;

    public GameGui() {
        dalWord = new DALWord();
    }

    public void startGame() {
        answer = dalWord.getRandomWord();
        System.out.println("Welcome to Hangman");
        System.out.println("You have " + remainingAttempts + " attempts to solve the word.");

        while (stillPlaying) {

        }
    }

    public void checkForWinner(String guess) {
        if (guess.equals(answer)) {
            stillPlaying = false;
            gameWon();
        }
        if (attempts == 7) {
            stillPlaying = false;
            System.out.println("You have used all available attempts!");
            System.out.println("Please try again.");
            newGame();
        }
    }

    public void gameWon() {
        System.out.println("Congratulations");
        System.out.println("You guessed it!");
        System.out.println("Using " + attempts + "attempts.");
    }

    public void newGame() {
        System.out.println("Want to play a new game?");
        System.out.println("type 'y'");
        String s = stringScanner();
        if (s == "y") {
            startGame();
        } else {
            System.out.println("Thank you for playing");
            System.exit(0);
        }
    }

    public String stringScanner() {
        Scanner s = new Scanner(System.in);
        return s.nextLine();
    }

}
