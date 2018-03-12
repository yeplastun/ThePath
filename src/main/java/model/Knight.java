package model;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.LinkedList;
import java.util.List;

public class Knight implements ChessPiece {

    private static final Logger log = LogManager.getLogger(Knight.class);

    @Override
    public List<ChessNode> getNodesToVisit(ChessNode from) {
        int[] relativeRankDiffs = {2, 2, -2, -2, 1, 1, -1, -1};
        int[] relativeFileDiffs = {-1, 1, 1, -1, 2, -2, 2, -2};
        List<ChessNode> possibleNodes = new LinkedList<>();

        for (int i = 0; i < 8; i++) {
            ChessNode node;
            try {
                node = new ChessNode(from.getRank() + relativeRankDiffs[i], from.getFile() + relativeFileDiffs[i], from.getDepth() + 1);
                log.debug("{} can be visited from {}", node, from);
                possibleNodes.add(node);
            } catch (IllegalArgumentException e) {
                log.debug(e.getMessage() + " Excluded.");
            }
        }

        return possibleNodes;
    }
}
