package output;

import model.ChessNode;

import java.util.List;

public class ConsoleWriter implements OutputWriter {
    @Override
    public void write(List<ChessNode> nodes) {
        if (nodes == null) {
            System.out.println("Sorry! There is no solution!");
        } else {
            System.out.println(nodes);
        }
    }
}
