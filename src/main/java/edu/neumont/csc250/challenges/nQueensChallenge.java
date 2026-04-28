package edu.neumont.csc250.challenges;

import java.util.ArrayList;

public class nQueensChallenge {

    public static ArrayList<int[]> solvenQueens(int n){
        ArrayList<int[]> solutions = new ArrayList<>();
        nQueens(n, 0, new int[n], solutions);
        return  solutions;
    }
    /*
   row by row
   recursively move to the next row
   not safe, iterate until it is safe
   next row, iterate if not found, backtrack to the previous and continue on

solution [2],[0],[3],[1] -- indexes are implied
   --
   row == n ? save solution/return;
   place queen
   validate position
   safe -> Recurse (next row)
   not safe || return from recursion -> iterate
   if no more room -> return;

   ArrayList<Integer[]> solutions = new ArrayList<>();

    */
    public static void nQueens(int n, int row, int[] queens, ArrayList<int[]> solutions){
        if (row == n){
            //save solution
            int[] copy = new int[n];
            for (int i = 0; i < queens.length; i++) { // O(n)
                copy[i] = queens[i];
            }
            solutions.add(copy);
            return;
        }

        for (int col = 0; col < n; col++){
            queens[row] = col;
            if (validate(queens, row)){
                nQueens(n, row + 1, queens, solutions);
            }
        }

    }

    public static boolean validate(int[] queens, int row){ // O(n)
        if (row == 0){
            return true;
        }
        for (int i = 0; i < row; i++) {
            if (queens[row] == queens[i]){
                // if columns match up return false
                return false;
            }

            if ((queens[row] + row) == (queens[i] + i)){
                return false;
            }

            if((Math.abs(queens[row] - queens[i])) == (Math.abs(row - i))){ //distance between x and y are equal
                return false;
            }
        }

        return true;
    }
}
