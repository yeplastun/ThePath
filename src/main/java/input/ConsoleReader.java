package input;

import model.ChessNode;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ConsoleReader implements InputReader {
    private static final Logger log = LogManager.getLogger(ConsoleReader.class);

    @Override
    public ChessNode readStartNode() {
        ChessNode node = null;
        while (node == null) {
            System.out.println("Enter the start position in format letter:number");
            node = readNode();
        }
        return node;
    }

    @Override
    public ChessNode readFinishNode() {
        ChessNode node = null;
        while (node == null) {
            System.out.println("Enter the finish position in format letter:number");
            node = readNode();
        }
        return node;
    }

    private ChessNode readNode() {
        BufferedReader bufferedReader = null;
        try {
            bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            char file = ' ';
            int rank;
            String unformattedInput = bufferedReader.readLine();
            unformattedInput = unformattedInput.trim().replaceAll("\\s+", "").toUpperCase();
            String[] trimmedInput = unformattedInput.split(":");
            if (trimmedInput.length == 2) {
                if (trimmedInput[0].length() == 1) {
                    file = trimmedInput[0].charAt(0);
                }
                rank = Integer.parseInt(trimmedInput[1]);
                return new ChessNode(rank, file);
            }
            System.out.println("Invalid input");
        } catch (IllegalArgumentException | IOException e) {
            log.error(e.getMessage());
            System.out.println(e.getMessage());
        }
        return null;
    }
}
