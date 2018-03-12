package output;

import model.ChessNode;

import java.util.List;

public interface OutputWriter {
    void write(List<ChessNode> nodes);
}
