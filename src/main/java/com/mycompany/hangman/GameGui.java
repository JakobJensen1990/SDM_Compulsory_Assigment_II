package com.mycompany.hangman;

import com.mycompany.hangman.DAL.DALWord;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author André Thy
 */
public class GameGui {

    DALWord dalWord;
    boolean stillPlaying;
    String answer = "";
    String secret = "";
    int attempts;
    int remainingAttempts;
    final int LOSINGCONDITION = 0;
    ArrayList<Character> usedLetters;

    public GameGui() {
        dalWord = new DALWord();
    }

    public void startGame() {
        stillPlaying = true;
        usedLetters = new ArrayList<Character>();
        dalWord.populateWords();
        answer = dalWord.getRandomWord().toLowerCase();
        secret = dalWord.getSecretWord();
        attempts = 0;
        remainingAttempts = 15;
        System.out.println("Welcome to Hangman\n");
        System.out.println("The secret word is: " + secret);
        System.out.println(answer);
        System.out.println("You have " + remainingAttempts + " attempts to solve the word.");
        System.out.println("Type a char to start");

        while (stillPlaying) {
            char c = charScanner();
            usedLetters.add(c);
            System.out.println("Used letters: " + usedLetters);
            checkSecretWord(c);

            System.out.println(secret);
            System.out.println("Attempts left: " + remainingAttempts);
        }
    }

    private void checkForWinner(String guess) {
        if (guess.equals(answer)) {
            stillPlaying = false;
            gameWon();
        }
        if (remainingAttempts == LOSINGCONDITION) {
            stillPlaying = false;
            System.out.println("You have used all available attempts!");
            System.out.println("Please try again.");
            newGame();
        }
    }

    private void gameWon() {
        System.out.println("Congratulations");
        System.out.println("You guessed it!");
        System.out.println("Using " + attempts + " attempts.");
        newGame();
    }

    private void newGame() {
        System.out.println("Want to play a new game?");
        System.out.println("type 'y'");
        char c = charScanner();
        if (c == 'y') {
            startGame();
        } else {
            System.out.println("Thank you for playing");
            System.exit(0);
        }
    }

    private char charScanner() {
        Scanner s = new Scanner(System.in);
        return s.next().charAt(0);
    }

    private void checkSecretWord(char c) {
        int counter = 0;
        for (int i = 0; i < answer.length(); i++) {
            if (answer.charAt(i) == c) {
                String theWord = secret.substring(0, i) + c + secret.substring(i + 1);
                secret = theWord;
                
            }
            else{
                counter++;
            }
        }
        if (counter == answer.length()){
             remainingAttempts -= 1;
        }
        attempts += 1;

        checkForWinner(secret);
    }
}
