package exam_practice.AI_Non_AI;

import java.util.Arrays;

public class Non_AI_TicTacToe {

    int[] board = new int[9];
    int turn;

    public Non_AI_TicTacToe(int turn){
        Arrays.fill(board, 2);
        this.turn = turn;
    }

    private int make2(){
        if(this.board[4] == 2) return 5;

        int choice = (int)Math.random()*4;
        int[] choices = {1, 3, 5, 7};

        return choices[choice];
    }

    private int posswin(int p){



        return 0;
    }

    private void go(int n){
        if(this.turn%2==0){
            this.board[n] = 5;
        }else{
            this.board[n] = 3;
        }
    }


    public static void main(String args[]){


    }
}
