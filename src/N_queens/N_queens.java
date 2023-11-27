package N_queens;

import java.util.Arrays;
import java.util.Scanner;

public class N_queens {

    public static void main(String args[]){

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the input: ");
        int input = sc.nextInt();

        System.out.println("Total no. of boards arrangement possible: "+ totalQueens(input));
    }

    static int totalQueens(int n){

        backtrack(n, new int[n], 0, new char[n][n]);
        return ans;
    }
    static int ans = 0;

    static void backtrack(int n, int[] posTrack, int colIndex, char[][] board){

        if(colIndex == n){

            for(char[] row: board){
                System.out.println(Arrays.toString(row));
            }
            System.out.println();
            ans++;
            return;
        }

        for(int row = 0; row < n; row++){

            if(colIndex == 0){
                posTrack[colIndex] = row;
                board[row][colIndex] = 'Q';
                backtrack(n, posTrack, colIndex+1, board);
                board[row][colIndex] = '\0';
            }
            else {

                boolean valid = true;
                for(int col=0; col < colIndex; col++){
                    if(row == posTrack[col] || Math.abs(colIndex - col) == Math.abs(posTrack[col] - row)){
                        valid  = false;
                        break;
                    }
                }

                if(valid){
                    posTrack[colIndex] = row;
                    board[row][colIndex] = 'Q';
                    backtrack(n, posTrack, colIndex+1, board);
                    board[row][colIndex] = '\0';
                }

            }
        }
    }
}