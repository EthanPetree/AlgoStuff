package edu.neumont.csc250.challenges;

public class ShipOfTheseus {
    /**
     check first to make sure each row is the same length
     have a counter for changes made per interation based on the current row, and the next row
     if the counter is not equal to 1, return false
     if we get to the last line in the matrix, return true
     */
    public static boolean shipOfTheseus(String[][] ship) {
        for (int i = 0; i < ship.length; i++){
            int changeCounter = 0;
            for (int j = 0; j < ship[i].length; j++){
                if (ship[i].length != ship[i+1].length){
                    return false;
                }

                if(ship[i][j] != ship[i + 1][j]){
                    changeCounter++;
                }
            }
            if(changeCounter != 1){
                return false;
            }
        }
        return true;
    }
}
