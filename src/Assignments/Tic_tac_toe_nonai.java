package Assignments;

import java.util.Scanner;

public class Tic_tac_toe_nonai {

    public static void main(String[] args) {

        int[][] board = new int[3][3];

        System.out.println("Block positions:");
        int posCount = 1;
        for (int i = 0; i < 3; i++) {
            System.out.print("[ ");
            for (int j = 0; j < 3; j++) {
                System.out.print(posCount+" ");
                posCount++;
            }
            System.out.print("]");
            System.out.println("");
        }
        game();

    }

    static void game() {
        int[][] mat1 = new int[3][3];
        int[][] mat2 = new int[3][3];

        char[][] xox = new char[3][3];

        int input;
        boolean[] posTrack = new boolean[9];

        Scanner sc = new Scanner(System.in);

        for(int i =0; i < 9; i++){
            System.out.println("Player 1 enter the position");
            do{
                input = sc.nextInt();
                if(posTrack[input-1]){
                    System.out.println("This position is already filled!");
                }
            }while(posTrack[input-1]);
            posTrack[input-1] = true;

            int[] fetchPos1 = getPos(input);
            mat1[fetchPos1[0]][fetchPos1[1]] = 1;
            xox[fetchPos1[0]][fetchPos1[1]] = 'X';
            if(checkMat(mat1)){
                System.out.println("Player 1 is WINNER!!!");
                break;
            }
            printMat(xox);
            System.out.println("Player 2 enter the position");
            do{
                input = sc.nextInt();
                if(posTrack[input-1]){
                    System.out.println("This position is already filled!");
                }
            }while(posTrack[input-1]);
            posTrack[input-1] = true;

            int[] fetchPos2 = getPos(input);
            mat2[fetchPos2[0]][fetchPos2[1]] = 1;
            xox[fetchPos2[0]][fetchPos2[1]] = 'O';
            if(checkMat(mat2)){
                System.out.println("Player 2 is WINNER!!!");
                break;
            }
            printMat(xox);
        }

    }

    static int[] getPos(int n){

        int[] pos = new int[2];
        switch (n){
            case 1:
                pos[0] = 0;
                pos[1] = 0;
                break;

            case 2:
                pos[0] = 0;
                pos[1] = 1;
                break;

            case 3:
                pos[0] = 0;
                pos[1] = 2;
                break;

            case 4:
                pos[0] = 1;
                pos[1] = 0;
                break;

            case 5:
                pos[0] = 1;
                pos[1] = 1;
                break;

            case 6:
                pos[0] = 1;
                pos[1] = 2;
                break;

            case 7:
                pos[0] = 2;
                pos[1] = 0;
                break;

            case 8:
                pos[0] = 2;
                pos[1] = 1;
                break;

            case 9:
                pos[0] = 2;
                pos[1] = 2;
                break;

            default:
                System.out.println("Invalid input!");
        }

        return pos;
    }

    static boolean checkMat(int[][] mat){
        int row1 = 0, row2 = 0, row3 = 0, col1 = 0, col2 = 0, col3 = 0, diag1 = 0, diag2 = 0;

        for (int i = 0; i < 3; i++) {
            row1 += mat[0][i];
        }

        for (int i = 0; i < 3; i++) {
            row2 += mat[1][i];
        }

        for (int i = 0; i < 3; i++) {
            row3 += mat[2][i];
        }

        for (int i = 0; i < 3; i++) {
            col1 += mat[i][0];
        }

        for (int i = 0; i < 3; i++) {
            col2 += mat[i][1];
        }

        for(int i = 0; i < 3; i++){
            col3 += mat[i][2];
        }

        for(int i = 0; i < 3; i++){
            diag1 += mat[i][i];
        }

        for(int i = 0; i < 3; i++){
            diag2 += mat[i][2-i];
        }

        return row1 == 3 || row2 == 3 || row3 == 3 || col1 == 3 || col2 == 3 || col3 == 3 || diag1 == 3 || diag2 == 3;
    }

    static void printMat(char[][] xox){
        for(int i = 0; i < xox.length; i++){
            for(int j = 0; j < xox[i].length; j++){

                System.out.print(xox[i][j]+" ");
            }
            System.out.println("");
        }
    }
}
