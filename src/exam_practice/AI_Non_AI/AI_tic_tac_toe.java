package exam_practice.AI_Non_AI;

import java.util.Scanner;

public class AI_tic_tac_toe {

    int[] board;
    boolean currentPlayer = false;

    public AI_tic_tac_toe(){
        board = new int[9];
    }
    public AI_tic_tac_toe(int[] board){
        for(int i = 0; i < 9; i++){
            this.board[i] = board[i];
        }
    }

    private void gamePlay(){

        Scanner sc = new Scanner(System.in);

        int emptyPos = 9;

        int ai_move = -1;



        System.out.println("\nFollowing is the position map: \n");

        System.out.println(" 1  2  3");
        System.out.println(" 4  5  6");
        System.out.println(" 7  8  9");


        while(emptyPos>0){

            printBoard();

            int winner = checkWinner();

            if(winner != 2){

                if(winner == 0){
                    System.out.println("The game is a Tie!");
                    return;
                }

                String winnerName = winner == 1? "CPU" : "Player";

                System.out.println(winnerName+" has won the game!");
                return;
            }


            if(!currentPlayer){
                System.out.println("Player's chance!");
                System.out.println("Enter the position: ");


                boolean repeat;
                do {
                    int move = sc.nextInt();
                    repeat = false;
                    if (move < 0 || move > 9)
                        System.out.println("Invalid Input! Please enter the value between 1 to 9.");
                    else if (this.board[move-1] == 0) {
                        this.board[move-1] = -1;
                    } else {
                        repeat = true;
                        System.out.println("This is positon is already filled try again!");
                    }
                } while(repeat);
                currentPlayer = true;
            }else {
                System.out.println("CPU's chance!");
                ai_move = bestMove();

            }


            emptyPos--;

        }

        if(emptyPos == 0){
            System.out.println("The game is a Tie!");
        }

    }

    private void printBoard(){

        StringBuilder board1 = new StringBuilder("+ - + - + - +");
        StringBuilder board2 = new StringBuilder("|   |   |   |");
        StringBuilder board3 = new StringBuilder("+ - + - + - +");
        StringBuilder board4 = new StringBuilder("|   |   |   |");
        StringBuilder board5 = new StringBuilder("+ - + - + - +");
        StringBuilder board6 = new StringBuilder("|   |   |   |");
        StringBuilder board7 = new StringBuilder("+ - + - + - +");

        for(int i = 0; i < this.board.length; i++){
            char let = valToChar(this.board[i]);

            switch (i){
                case 0:
                    board2.replace(2,  3, let+"");
                    break;

                case 1:
                    board2.replace(6, 7, let+"");
                    break;

                case 2:
                    board2.replace(10, 11, let+"");
                    break;

                case 3:
                    board4.replace(2,  3, let+"");
                    break;

                case 4:
                    board4.replace(6, 7, let+"");
                    break;

                case 5:
                    board4.replace(10, 11,let+"");
                    break;

                case 6:
                    board6.replace(2,  3, let+"");
                    break;

                case 7:
                    board6.replace(6, 7, let+"");
                    break;

                case 8:
                    board6.replace(10, 11,let+"");
                    break;

                default:
                    break;
            }

        }

        System.out.println(board1);
        System.out.println(board2);
        System.out.println(board3);
        System.out.println(board4);
        System.out.println(board5);
        System.out.println(board6);
        System.out.println(board7);
    }

    private char valToChar(int val){
        if(val == 1) return 'X';
        if(val == -1) return 'O';

        return '\0';
    }

    private int bestMove(){
        int bestScore = Integer.MIN_VALUE;
        int move=-1, score;
        for(int i = 0; i < 9; i++){

            if(board[i] == 0){
                board[i] = 1;
                score = miniMax(board, false);
                board[i] = 0;

                if(score > bestScore){
                    bestScore = score;
                    move = i;
                }
            }

        }

        board[move] = 1;
        currentPlayer = false;

        return move;
    }

    private int miniMax(int[] board, boolean isMax) {

        int result = checkWinner();
        if(result != 2)  return result;

        if(isMax) {
            int bestScore = Integer.MIN_VALUE;
            for (int i = 0; i < 9; i++) {
                if (this.board[i] == 0) {
                    this.board[i] = 1;
                    int score = miniMax(board, false);
                    this.board[i] = 0;

                    bestScore = Math.max(score, bestScore);
                }
            }
            return  bestScore;
        } else {
            int bestScore = Integer.MAX_VALUE;
            for (int i = 0; i < 9; i++) {
                if (this.board[i] == 0) {
                    this.board[i] = -1;
                    int score = miniMax(board, true);
                    this.board[i] = 0;

                    bestScore = Math.min(score, bestScore);
                }
            }
            return  bestScore;
        }
    }

    private int checkWinner(){

        int winner = 2;

        //All the rows
        if(board[0] != 0 && board[0] == board[1] && board[1] == board[2])
            winner =  board[0];
        else if(board[3] != 0 && board[3] == board[4] && board[4] == board[5])
            winner =  board[3];
        else if(board[6]!=0 && board[6]== board[7] && board[7]==board[8])
            winner =  board[6];

        //All the columns
        else if(board[0]!=0 && board[0] == board[3] && board[3] == board[6])
            winner =  board[0];
        else if(board[1]!=0 && board[1] == board[4] && board[4] == board[7])
            winner =  board[1];
        else if(board[2]!=0 && board[2] == board[5] && board[5] == board[8])
            winner =  board[2];

        //Both diagonals
        else if(board[0]!=0 && board[0] == board[4] && board[4] == board[8])
            winner =  board[0];
        else if(board[2]!=0 && board[2] == board[4] && board[4] == board[6])
            winner =  board[2];

        int openShots = 0;
        for(int i = 0; i < 9; i++){
            if(this.board[i] == 0) openShots++;
        }

        if(winner == 2 && openShots == 0 ) return 0;

        return winner;
    }



    public static void main(String args[]){

        AI_tic_tac_toe obj = new AI_tic_tac_toe();

        obj.gamePlay();
    }

}
