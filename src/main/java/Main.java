import java.util.*;

public class Main {
    public static void main(String... args) {
        ChessNode from = new ChessNode(0, 0, 0);
        ChessNode to = new ChessNode(2, 1, 0);
        calculateThePath(from, to);
    }

    private static List<ChessNode> getNodesToVisit(ChessNode from) {
        int[] row = {2, 2, -2, -2, 1, 1, -1, -1};
        int[] column = {-1, 1, 1, -1, 2, -2, 2, -2};
        ArrayList<ChessNode> possibleSquares = new ArrayList<>();

        //for the knight
        for (int i = 0; i < 8; i++) {
            ChessNode node = new ChessNode(from.getRank() + row[i], from.getFile() + column[i], from.getDepth() + 1);
            if (isValid(node)) {
                possibleSquares.add(node);
            }
        }

        return possibleSquares;
    }

    private static boolean isValid(ChessNode node) {
        return !(node.getFile() < 0 || node.getRank() < 0 || node.getFile() >= 8 || node.getRank() >= 8);
    }

    private static void calculateThePath(ChessNode from, ChessNode destination) {

        LinkedList<ChessNode> queue = new LinkedList<>();
        queue.add(from);

        while (!queue.isEmpty()) {
            ChessNode current = queue.remove();

            if (current.equals(destination) && current.getDepth() == 3) {
                printThePathTo(current);
                continue;
            }

            if (current.getDepth() > 3) continue;

            System.out.println("Visited: " + current.toString());

            List<ChessNode> nodesToVisit = getNodesToVisit(current);

            for (ChessNode node : nodesToVisit) {
                node.previous = current;
                queue.add(node);
            }

        }
    }

    private static void printThePathTo(ChessNode node) {
        StringBuilder thePathStringBuilder = new StringBuilder();
        thePathStringBuilder.append(" -> " + node.toString());

        ChessNode current = node.previous;
        while (current != null) {
            thePathStringBuilder.insert(0, " -> " + current.toString());
            current = current.previous;
        }
        System.out.println(thePathStringBuilder.toString());
    }

}
