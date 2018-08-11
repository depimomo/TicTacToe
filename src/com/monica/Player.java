package com.monica;

import java.util.stream.IntStream;

/*
* This is class for player (X and O)
* The class contain symbol (X or O), count, and position in 0 and 1
*
* Example:
* X - O
* O O X
* - X X
*
* Class 1:
* symbol = x
* position = 1, 0, 0, 0, 0, 1, 0, 1, 1
* count = 4
*
* Class 2:
* symbol = y
* position = 0, 0, 1, 1, 1, 0, 0, 0, 0
* count = 3
* */

public class Player {
    char symbol;
    int count;
    int[] position;

    public Player(char symbol, int[] position){
        this.symbol = symbol;
        this.position = position;
        this.count = IntStream.of(position).sum();
    }

    public boolean CheckWin(){
        boolean status = false;

        //Check horizontal win
        for(int i = 0; i < 9; i++){
            if(this.position[i] + this.position[++i] + this.position[++i] == 3){
                status = true;
            }
        }

        //Check vertical win
        for(int j = 0; j < 3; j++){
            if(this.position[j] + this.position[j+3] + this.position[j+6] == 3){
                status = true;
            }
        }

        //Check diagonal win
        if(this.position[4] == 1 && (this.position[0] + this.position[8] == 2 || this.position[2] + this.position[6] == 2)){
            status = true;
        }

        return status;

    }
}
