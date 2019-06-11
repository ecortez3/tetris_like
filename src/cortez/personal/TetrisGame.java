package cortez.personal;

import cortez.personal.shapes.Shapes;

import java.util.ArrayList;
import java.util.Arrays;

class TetrisGame {

    private final String FULL_ROW = "[X, X, X, X, X, X, X, X, X, X]";
    private ArrayList<String[]> gameBoard;

    TetrisGame() {
    }

    int playNewGame(String gameSequence){
        this.gameBoard = new ArrayList<>();

        String type = Character.toString(gameSequence.charAt(0));
        int start = Character.getNumericValue(gameSequence.charAt(1));

        insertNewShape(type, start);


        return this.gameBoard.size();
    }

    private void insertNewShape(String type, int start) {
        int[][] coordinates = Shapes.getShapeCoordinates(type);
        int row = 0;
        for(int i = coordinates.length - 1; i >= 0; i--){
            boolean insertSuccessful = false;
            while(!insertSuccessful){
                insertSuccessful = insertNewRow(coordinates[i], row, start);
                row++;
            }
//            row++;

        }

        removeFullRows();
    }

    private void removeFullRows() {
        for(int i = gameBoard.size() -1; i >= 0 ; i--) {
            if (Arrays.toString(gameBoard.get(i)).contentEquals(FULL_ROW))
                gameBoard.remove(i);
        }
    }

    private boolean insertNewRow(int[] coordinate, int row, int start) {
        if(gameBoard.isEmpty() || gameBoard.size() <= row){
            gameBoard.add(new String[10]);
//            this.gameBoard.get(row)[0] = "X";
//            this.gameBoard.get(row)[1] = "X";
//            this.gameBoard.get(row)[2] = "X";
//            this.gameBoard.get(row)[3] = "X";
//            this.gameBoard.get(row)[4] = "X";
//            this.gameBoard.get(row)[5] = "X";
//            this.gameBoard.get(row)[6] = "X";
//            this.gameBoard.get(row)[7] = "X";
//            this.gameBoard.get(row)[8] = "X";
//            this.gameBoard.get(row)[9] = "X";
            String[] gameRow = gameBoard.get(row);
            for(int i = 0; i < coordinate.length; i++){
                if(gameRow[i+start] != null && gameRow[i+start].equals("X"))
                    return false;
            }
        }
        else {
            String[] gameRow = gameBoard.get(row);
            for(int i = 0; i < coordinate.length; i++){
                if(gameRow[i+start].equals("X"))
                    return false;
            }
        }

        for(int column : coordinate){
            gameBoard.get(row)[column+start] = "X";
        }
        return true;
    }
}
