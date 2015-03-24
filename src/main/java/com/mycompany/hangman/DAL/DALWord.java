/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.hangman.DAL;

import java.util.Random;

/**
 *
 * @author Jacob
 */
public class DALWord {
    String theWord = "";
    String secretWord = "";
    
    String[] randomWords = {"Etagehus","Benzin","McDonalds","Statue",
        "Pizzabil","Generalforsamlingsvedtægtsændringsforslagsstillerne",
        "Rustbunke","Sommerfestival","Baghoved","Bageri","Baconsandwich"};
    
    public String getRandomWord() {
        return theWord;
    }
    
    private void populateTheWord() {
        if (theWord.isEmpty()) 
            theWord = randomWords[new Random().nextInt(randomWords.length-1)];
    }
    
    private void populateSecretWord() {
        StringBuilder sb = new StringBuilder(theWord.length());
        for(char c: theWord.toCharArray()) {
            sb.append("*");
        }
        secretWord = sb.toString();
    }
    public void populateWords() {
        populateTheWord();
        populateSecretWord();
    }
    
    public String getSecretWord() {
        return secretWord;
    }
    
    public String testGetSecretWord(String localWord) {
        if (localWord.isEmpty()) 
            getRandomWord();
        StringBuilder sb = new StringBuilder(localWord.length());
        for(char c : localWord.toCharArray()) {
            sb.append("*");
        }
        return sb.toString();
    }
}
