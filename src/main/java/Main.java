import java.util.*;

public class Main {
    public static void main(String... args) {
        ChessBoardContext context = new ChessBoardContext();
        context.setPiece(new Knight());

        ChessNode from = new ChessNode(0, 0);
        ChessNode to = new ChessNode(1, 2);

        Set<List<ChessNode>> paths = context.findAllPaths(from, to);
    }
}
