package main;

import model.ChessNode;
import model.ChessPiece;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.*;

public class ChessBoardContext {

    private static final Logger log = LogManager.getLogger(ChessBoardContext.class);

    private static final int LIMIT_DEPTH = 3;

    private ChessPiece piece = null;

    public void setPiece(ChessPiece piece) {
        this.piece = piece;
    }

    public Set<List<ChessNode>> findAllPaths(ChessNode from, ChessNode to) {
        Set<List<ChessNode>> paths = new HashSet<>();

        Queue<ChessNode> queue = new LinkedList<>();
        queue.add(from);

        while (!queue.isEmpty()) {
            ChessNode current = queue.remove();

            if (current.equals(to) && current.getDepth() == LIMIT_DEPTH) {
                paths.add(getPath(current));
                continue;
            }

            if (current.getDepth() > LIMIT_DEPTH) continue;

            log.info("Staying at: " + current);

            List<ChessNode> nodesToVisit = piece.getNodesToVisit(current);

            for (ChessNode node : nodesToVisit) {
                node.setPrevious(current);
                queue.add(node);
            }

        }
        return paths;
    }

    public List<ChessNode> findTheShortestPath(ChessNode from, ChessNode to) {

        HashSet<ChessNode> visited = new HashSet<>();

        Queue<ChessNode> queue = new LinkedList<>();
        queue.add(from);

        while (!queue.isEmpty()) {
            ChessNode current = queue.remove();

            if (current.equals(to) && current.getDepth() <= LIMIT_DEPTH) {
                return getPath(current);
            }

            if (current.getDepth() > LIMIT_DEPTH) continue;

            log.info("Staying at: " + current);

            List<ChessNode> nodesToVisit = piece.getNodesToVisit(current);

            for (ChessNode node : nodesToVisit) {
                if (!visited.contains(node)) {
                    node.setPrevious(current);
                    visited.add(node);
                    queue.add(node);
                }
            }

        }
        return null;
    }

    private List<ChessNode> getPath(ChessNode to) {
        List<ChessNode> thePath = new LinkedList<>();
        ChessNode current = to;
        while (current != null) {
            thePath.add(0, current);
            current = current.getPrevious();
        }
        return thePath;
    }
}
