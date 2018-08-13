package com.monica;

import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

class MainTest {

    @AfterEach
    void tearDown() {
        System.setIn(System.in);
    }

    @Test
    void checkInputTest() {

        //Create valid and invalid testcase
        HashMap<String, Boolean> TestCase = new HashMap<String, Boolean>();
        TestCase.put("XOXXOOXXO", true);
        TestCase.put("XOOXOXOXO", true);
        TestCase.put("XO-XO-O-O", true);
        TestCase.put("XOOOXO", false);
        TestCase.put("XOOXOXOXXXO", false);
        TestCase.put("XOOXOXOYYYXO", false);
        TestCase.put("XOYZXOXO", false);

        for(String sample : TestCase.keySet()){
            Main game = new Main();
            Boolean result = game.checkInput(sample);

            Assert.assertEquals(result, TestCase.get(sample));
        }
    }

    @Test
    void setStatusTest() {
        String XWIN = "X wins!";
        String OWIN = "O wins!";
        String DRAW = "It's a draw!";
        String INVALID = "Invalid game board";
        String PROGRESS = "Game still in progress!";

        //Create valid and invalid testcase
        HashMap<String, String> TestCase = new HashMap<String, String>();
        TestCase.put("XOXXOOXXO", XWIN);
        TestCase.put("XOOXOXOXO", OWIN);
        TestCase.put("OXOXOXXOX", DRAW);
        TestCase.put("XOXX--O--", PROGRESS);
        TestCase.put("XXXOOOXXO", INVALID);
        TestCase.put("---------", PROGRESS);
        TestCase.put("XXXXXXXXX", INVALID);
        TestCase.put("OOOOOOOOO", INVALID);

        for(String sample : TestCase.keySet()){
            Main game = new Main();
            String result = game.setStatus(sample);

            Assert.assertEquals(result, TestCase.get(sample));
        }
    }
}