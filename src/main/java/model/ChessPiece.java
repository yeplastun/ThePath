package model;

import java.util.List;

public interface ChessPiece {
    List<ChessNode> getNodesToVisit(ChessNode from);
}
