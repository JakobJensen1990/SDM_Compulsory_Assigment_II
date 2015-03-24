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
    
}
