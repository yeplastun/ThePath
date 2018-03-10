import java.util.List;

public interface ChessPiece {
    List<ChessNode> getNodesToVisit(ChessNode from);

    default boolean isValid(ChessNode node) {
        return !(node.getFile() < 0 || node.getRank() < 0 || node.getFile() >= 8 || node.getRank() >= 8);
    }
}
