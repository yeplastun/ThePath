import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;
import java.util.Set;

public class ChessBoardTest {

    private ChessBoardContext context;

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
}
