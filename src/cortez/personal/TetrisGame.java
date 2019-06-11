package cortez.personal;

import java.util.ArrayList;
import java.util.Arrays;

class TetrisGame {

    private final String FULL_ROW = "[X, X, X, X, X, X, X, X, X, X]";
    private ArrayList<String[]> gameBoard;

    TetrisGame() {
    }

    int playNewGame(String gameSequence){
        this.gameBoard = new ArrayList<>();

        if(gameSequence.length() > 2) {
            int shapesToInsert = gameSequence.length() / 2;

            for(int i = 0; i <= shapesToInsert; i++){
                String type = Character.toString(gameSequence.charAt(i));
                int start = Character.getNumericValue(gameSequence.charAt(i+1));

                insertNewShape(type, start);
                i++;
            }
        }
        else {
            String type = Character.toString(gameSequence.charAt(0));
            int start = Character.getNumericValue(gameSequence.charAt(1));

            insertNewShape(type, start);
        }


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
        }

        if(row == 0 && gameBoard.size() >= 2){
            String[] gameRow = gameBoard.get(gameBoard.size()-1);
            if (isCollisionDetected(coordinate, start, gameRow))
                return false;
        }

        String[] gameRow = gameBoard.get(row);
        if (isCollisionDetected(coordinate, start, gameRow))
            return false;

        for (int column : coordinate) {
            gameBoard.get(row)[column + start] = "X";
        }
        return true;
    }

    private boolean isCollisionDetected(int[] coordinate, int start, String[] gameRow) {
        for(int i = 0; i < coordinate.length; i++){
            if(gameRow[i+start] != null && gameRow[i+start].equals("X"))
                return true;
        }
        return false;
    }
}
