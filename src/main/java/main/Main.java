package main;

import input.ConsoleReader;
import input.InputReader;
import model.ChessNode;
import model.Knight;
import output.ConsoleWriter;
import output.OutputWriter;

import java.util.List;

public class Main {
    public static void main(String... args) {
        ChessBoardContext context = new ChessBoardContext();
        context.setPiece(new Knight());

        InputReader consoleReader = new ConsoleReader();
        ChessNode from = consoleReader.readStartNode();
        ChessNode to = consoleReader.readFinishNode();

        List<ChessNode> path = context.findTheShortestPath(from, to);

        OutputWriter consoleWriter = new ConsoleWriter();
        consoleWriter.write(path);
    }
}
