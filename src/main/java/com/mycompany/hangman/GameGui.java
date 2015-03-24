package com.mycompany.hangman;

import com.mycompany.hangman.DAL.DALWord;
import java.util.ArrayList;
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
    ArrayList<Character> usedLetters;

    public GameGui() {
        dalWord = new DALWord();
    }

    public void startGame() {
        usedLetters = new ArrayList<Character>();
        answer = dalWord.getRandomWord();
        secret = dalWord.getSecretWord();
        System.out.println("Welcome to Hangman");
        System.out.println("You have " + remainingAttempts + " attempts to solve the word.");
        System.out.println("Type a char to start");
        System.out.println("theWord is: " + answer);

        while (stillPlaying) {
            char c = charScanner();
            usedLetters.add(c);
            System.out.println("Used letters: " + usedLetters);
            checkSecretWord(c);
            attempts += 1;
            remainingAttempts -= 1;
            System.out.println(secret);
            System.out.println("Attempts left: " + remainingAttempts);
        }
    }

    private void checkForWinner(String guess) {
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

    private void gameWon() {
        System.out.println("Congratulations");
        System.out.println("You guessed it!");
        System.out.println("Using " + attempts + "attempts.");
    }

    private void newGame() {
        System.out.println("Want to play a new game?");
        System.out.println("type 'y'");
        char c = charScanner();
        if ("y".equals(c)) {
            startGame();
        } else {
            System.out.println("Thank you for playing");
            System.exit(0);
        }
    }

    private char charScanner() {
        Scanner s = new Scanner(System.in);
        return s.next(".").charAt(0);
    }

    private void checkSecretWord(char c) {
//FIX THIS!
        for (int i = 0; i < answer.length(); i++) {
            if (answer.charAt(i) == c) {
                char x = secret.substring(i, i + 1).charAt(0);
                String guess = secret.replace(x, c);
                secret = guess;
            }
        }
        checkForWinner(secret);
    }

}
