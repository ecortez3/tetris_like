package cortez.personal;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {
        String inputFile = "C:\\Users\\Farside\\IdeaProjects\\JavaTetris\\src\\cortez\\personal\\input.txt";
        List<String> gameList;

        BufferedReader bufferReader = null;
        try {
            // newBufferedReader opens a file for reading
            bufferReader = Files.newBufferedReader(Paths.get(inputFile));

        } catch (IOException e) {
            e.printStackTrace();
        }

        // Current assumption is that file will not be empty thus avoiding NPE
        gameList = bufferReader.lines().collect(Collectors.toList());

        // full file is coming in as one single line
        String[] gameSequences = gameList.get(0).split(",");

        TetrisGame game = new TetrisGame();

        for(String sequence : gameSequences){
            System.out.println("Playing sequence: " + sequence);
            int height = game.playNewGame(sequence);
            System.out.println("This is " + height + " rows high");
        }
    }
}
