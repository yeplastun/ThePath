import java.util.Dictionary;
import java.util.HashMap;

/**
 * Created by imbananko on 10.03.2018.
 */
public class ChessNode {

    private String files = "ABCDEFGH";
    //number
    private int rank;
    //letter
    private int file;

    private int depth;

    ChessNode previous;

    ChessNode(int rank, int file, int depth) {
        this.rank = rank;
        this.file = file;
        this.depth = depth;
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

    public int getRank() {
        return rank;
    }

    public int getFile() {
        return file;
    }

    public int getDepth() {
        return depth;
    }

    @Override
    public String toString() {
        return String.format(("%c:%d[%d]"), files.charAt(file), rank + 1, depth);
    }


}