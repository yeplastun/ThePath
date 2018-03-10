import com.sun.javaws.exceptions.InvalidArgumentException;

public class ChessNode {
    private final static String FILES_CHARS = "ABCDEFGH";
    private int rank;
    private int file;
    private int depth;

    ChessNode previous;

    ChessNode(int rank, int file, int depth) {
        this.rank = rank;
        this.file = file;
        this.depth = depth;
    }

    ChessNode(int rank, int file) {
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
        return rank * 10 + file;
    }

    int getRank() {
        return rank;
    }

    int getFile() {
        return file;
    }

    int getDepth() {
        return depth;
    }

    @Override
    public String toString() {
        return String.format(("%c:%d[%d]"), FILES_CHARS.charAt(file), rank + 1, depth);
    }
}