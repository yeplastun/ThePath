package model;

public class ChessNode {
    private final static String FILES_CHARS = "ABCDEFGH";
    private final static int CHESSNODE_MAX_INDEX = 7;

    private int rank;
    private int file;
    private int depth;

    private ChessNode previous;

    public ChessNode(int rank, char file) {
        this(rank - 1, FILES_CHARS.indexOf(file), 0);
    }

    public ChessNode(int rank, int file, int depth) {
        if (rank < 0 || file < 0 || depth < 0) {
            throw new IllegalArgumentException(String.format("%d:%d[%d] is an invalid node. " +
                    "Expected non-negative values.", rank, file, depth));
        } else if (rank > CHESSNODE_MAX_INDEX || file > CHESSNODE_MAX_INDEX) {
            throw new IllegalArgumentException(String.format("%d:%d[%d] is an invalid node. " +
                    "Out of the board.", rank, file, depth));
        }
        this.rank = rank;
        this.file = file;
        this.depth = depth;
    }

    public ChessNode(int rank, int file) {
        this(rank, file, 0);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) return false;
        if (obj == this) return true;
        if (!(obj instanceof ChessNode)) return false;
        ChessNode input = (ChessNode) obj;
        return this.rank == input.rank && this.file == input.file;
    }

    @Override
    public int hashCode() {
        return rank * 10 + file + 1;
    }

    int getRank() {
        return rank;
    }

    int getFile() {
        return file;
    }

    public int getDepth() {
        return depth;
    }

    public ChessNode getPrevious() {
        return previous;
    }

    public void setPrevious(ChessNode previous) {
        this.previous = previous;
    }

    @Override
    public String toString() {
        return String.format(("%c:%d[%d]"), FILES_CHARS.charAt(file), rank + 1, depth);
    }
}