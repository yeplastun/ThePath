import java.util.*;

public class Main {
    public static void main(String... args) {
        calculateThePath(new ChessNode(0, 0, 0), new ChessNode(2, 1, 0));
    }

    private static List<ChessNode> getNodesToVisit(ChessNode from) {
        int[] row = {2, 2, -2, -2, 1, 1, -1, -1};
        int[] column = {-1, 1, 1, -1, 2, -2, 2, -2};
        ArrayList<ChessNode> possibleSquares = new ArrayList<>();

        //for the knight
        for (int k = 0; k < 8; k++) {
            ChessNode node = new ChessNode(from.rank + row[k], from.file + column[k], from.depth + 1);
            if (isValid(node)) possibleSquares.add(node);
        }

        return possibleSquares;
    }

    private static boolean isValid(ChessNode node) {
        return !(node.file < 0 || node.rank < 0 || node.file >= 8 || node.rank >= 8);
    }

    private static class ChessNode {

        //number
        int rank;
        //letter
        int file;

        int depth;

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

    }

    private static void calculateThePath(ChessNode from, ChessNode destination) {

        LinkedList<ChessNode> queue = new LinkedList<>();
        queue.add(from);

        while (!queue.isEmpty()) {
            ChessNode current = queue.remove();

            if (current.equals(destination) && current.depth == 3) {
                printThePathTo(current);
                continue;
            }

            if (current.depth > 3) continue;

            System.out.println(String.format(("Visited: %d:%d - %d"), current.rank, current.file, current.depth));

            List<ChessNode> nodesToVisit = getNodesToVisit(current);

            for (ChessNode node : nodesToVisit) {
                node.previous = current;
                queue.add(node);
            }

        }
    }

    private static void printThePathTo(ChessNode node) {
        StringBuilder thePathStringBuilder = new StringBuilder();
        thePathStringBuilder.append(String.format((" -> %d:%d[%d]"), node.rank, node.file, node.depth));

        ChessNode current = node.previous;
        while (current != null) {
            thePathStringBuilder.insert(0, String.format((" -> %d:%d[%d]"), current.rank, current.file, current.depth));
            current = current.previous;
        }
        System.out.println(thePathStringBuilder.toString());
    }

}
