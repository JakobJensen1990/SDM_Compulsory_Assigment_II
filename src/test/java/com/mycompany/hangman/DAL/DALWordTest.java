/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.hangman.DAL;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Kevin
 */
public class DALWordTest {
    
    public DALWordTest() {
    }
    
    /**
     * Test of getRandomWord method, of class DALWord.
     */
    @Test
    public void testGetRandomWord() {
        System.out.println("getRandomWord");
        DALWord instance = new DALWord();
        String expResult = "";
        String result = instance.getRandomWord();
        assertNotEquals(expResult, result);
    }
    
    /**
     * Test of getSecretWord method, of class DALWord.
     * Test for string is not empty
     */
    @Test
    public void testGetSecretWordForNotEmpty() {
        System.out.println("getSecretWord");
        DALWord instance = new DALWord();
        String expResult = "";
        String result = instance.getSecretWord();
        assertNotEquals(expResult, result);
    }
    
    /**
     * Test of getSecretWord method, of class DALWord.
     * Test for string length is correct
     */
    @Test
    public void testGetSecretWordLengthIsZero() {
        System.out.println("getSecretWord");
        DALWord instance = new DALWord();
        int result = instance.testGetSecretWord("").length();
        int expResult = 0;
        assertEquals(expResult, result);
    }
    
    /**
     * Test of getSecretWord method, of class DALWord.
     * Test for string length is correct
     */
    @Test
    public void testGetSecretWordLength() {
        System.out.println("getSecretWord");
        DALWord instance = new DALWord();
        int result = instance.testGetSecretWord("Lastbil").length();
        int expResult = 7;
        assertEquals(expResult, result);
    }
}
