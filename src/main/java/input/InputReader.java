package input;

import model.ChessNode;

public interface InputReader {
    ChessNode readStartNode();

    ChessNode readFinishNode();
}
