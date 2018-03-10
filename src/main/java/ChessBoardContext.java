import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.*;

class ChessBoardContext {

    private static final Logger log = LogManager.getLogger(ChessBoardContext.class);

    private static final int LIMIT_DEPTH = 3;

    private ChessPiece piece = null;

    void setPiece(ChessPiece piece) {
        this.piece = piece;
    }

    Set<List<ChessNode>> findAllPaths(ChessNode from, ChessNode to) {

        Set<List<ChessNode>> paths = new HashSet<>();

        Queue<ChessNode> queue = new LinkedList<>();
        queue.add(from);

        while (!queue.isEmpty()) {
            ChessNode current = queue.remove();

            if (current.equals(to) && current.getDepth() == LIMIT_DEPTH) {
                printThePathTo(current);
                paths.add(getPath(current));
                continue;
            }

            if (current.getDepth() > LIMIT_DEPTH) continue;

            log.info("Staying at: " + current);

            List<ChessNode> nodesToVisit = piece.getNodesToVisit(current);

            for (ChessNode node : nodesToVisit) {
                node.previous = current;
                queue.add(node);
            }

        }
        return paths;
    }

    private void printThePathTo(ChessNode finishNode) {
        StringBuilder thePathStringBuilder = new StringBuilder();
        thePathStringBuilder.append(" -> ").append(finishNode.toString());

        ChessNode current = finishNode.previous;
        while (current != null) {
            thePathStringBuilder.insert(0, " -> " + current.toString());
            current = current.previous;
        }
        System.out.println(thePathStringBuilder.toString());
    }

    private List<ChessNode> getPath(ChessNode to) {
        List<ChessNode> thePath = new LinkedList<>();
        ChessNode current = to;
        while (current != null) {
            thePath.add(0, current);
            current = current.previous;
        }
        return thePath;
    }
}
