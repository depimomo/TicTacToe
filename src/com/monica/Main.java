package com.monica;

import java.util.Scanner;

/*
* TicTacToe purpose is
* to find states of given input board
*
* Input:
* X-OOOX-XX
*
* Which translated as:
* X - O
* O O X
* - X X
*
* Output:
* Game still in progress!
*
* There are 5 status:
* X wins!
* O wins!
* It's a draw!
* Game still in progress!
* Invalid game board
*
* Winning condition: same symbol in one row
* (horizontal, vertical, diagonal)
* */

public class Main {

    //Create scanner
    private static Scanner scanner;

    //Constant to define game status
    private static final String XWIN = "X wins!";
    private static final String OWIN = "O wins!";
    private static final String DRAW = "It's a draw!";
    private static final String INVALID = "Invalid game board";
    private static final String PROGRESS = "Game still in progress!";

    //Store game status
    public static String STATUS = PROGRESS;


    public static void main(String[] args) {

        scanner = new Scanner(System.in);

        //Create some variable
        String game;
        boolean Xwin, Owin;
        int[] x = new int[9];
        int[] o = new int[9];

        //Scan input
        game = scanner.nextLine().toUpperCase();

        //Discard invalid board
        if((game.length() != 9) || (!game.matches("[X|O|-]*"))){
            STATUS = INVALID;
        } else {
            //Find X and O location
            for (int i = 0; i < game.length(); i++){
                switch (game.charAt(i)){
                    case 'X':
                        x[i] = 1;
                        break;
                    case 'O':
                        o[i] = 1;
                        break;
                    default:
                        break;
                }
            }

            //Create array of object to store player
            Player[] myPlayer = new Player[2];

            //Initialize each object
            myPlayer[0] = new Player('X', x);
            myPlayer[1] = new Player('O', o);

            //Check win
            Xwin = myPlayer[0].CheckWin();
            Owin = myPlayer[1].CheckWin();

            //Setting status

            if(Xwin && Owin){
               STATUS = INVALID; //Both win, invalid
            } else if (Math.abs(myPlayer[0].count - myPlayer[1].count) > 1){
                STATUS = INVALID; //Difference > 1, not taking turn
            } else if (Xwin) {
                STATUS = XWIN; //X win
            } else if (Owin) {
                STATUS = OWIN; //O win
            } else if (myPlayer[0].count + myPlayer[1].count == 9){
                STATUS = DRAW; //Board filled, no winner
            }
        }

        System.out.println(STATUS);
    }
}
