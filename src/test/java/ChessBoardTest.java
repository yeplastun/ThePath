import main.ChessBoardContext;
import model.ChessNode;
import model.Knight;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;
import java.util.Set;

public class ChessBoardTest {

    private ChessBoardContext context;

    private final static int CHESSNODE_MAX_INDEX = 7;

    @Before
    public void setUp() {
        context = new ChessBoardContext();
    }

    @Test
    public void shouldFindNoPathWhenNeighbourNodesSet() {
        context.setPiece(new Knight());
        ChessNode from = new ChessNode(0, 0);
        ChessNode to = new ChessNode(1, 1);

        Set<List<ChessNode>> actual = context.findAllPaths(from, to);

        Assert.assertTrue(actual.isEmpty());
    }

    @Test
    public void shouldFindOnlyTwoPathsWhenFinishNodeOnBorder() {
        context.setPiece(new Knight());
        ChessNode from = new ChessNode(0, 0);
        ChessNode to = new ChessNode(0, 5);

        Set<List<ChessNode>> actual = context.findAllPaths(from, to);

        Assert.assertEquals(2, actual.size());
    }

    @Test
    public void shouldReturnTrueWhenComparingEqualNodes() {
        ChessNode first = new ChessNode(5, 5, 1);
        ChessNode second = new ChessNode(5, 5, 2);
        ChessNode third = new ChessNode(5, 5, 3);

        Assert.assertTrue(first.equals(first));
        Assert.assertEquals(first.equals(second), second.equals(first));
        Assert.assertNotEquals(true, first.equals(null));
        Assert.assertTrue(first.equals(second) && second.equals(third) && third.equals(first));
        Assert.assertEquals(first.hashCode(), second.hashCode());
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowExceptionWhenInvalidArgs() {
        new ChessNode(-1, -1);
        new ChessNode(CHESSNODE_MAX_INDEX + 1, CHESSNODE_MAX_INDEX + 2);
    }

    @Test
    public void shouldReturnOneNodeWhenStartEqualsFinish() {
        context.setPiece(new Knight());
        ChessNode from = new ChessNode(0, 0);
        ChessNode to = new ChessNode(0, 0);

        List<ChessNode> actual = context.findTheShortestPath(from, to);

        Assert.assertTrue(actual.size() == 1);
        Assert.assertEquals(from, actual.get(0));
        Assert.assertEquals(to, actual.get(0));
    }

    @Test
    public void shouldFindNoPathWhenCornersSet() {
        context.setPiece(new Knight());
        ChessNode from = new ChessNode(0, 0);
        ChessNode to = new ChessNode(7, 7);

        List<ChessNode> actual = context.findTheShortestPath(from, to);

        Assert.assertNull(actual);
    }
}
