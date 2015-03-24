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
    
    String[] randomWords = {"Etagehus","Benzin","McDonalds","Statue",
        "Pizzabil","Generalforsamlingsvedtægtsændringsforslagsstillerne",
        "Rustbunke","Sommerfestival","Baghoved","Bageri","Baconsandwich"};
    
    public String getRandomWord() {
        return randomWords[new Random().nextInt(randomWords.length-1)];
    }
    
}
