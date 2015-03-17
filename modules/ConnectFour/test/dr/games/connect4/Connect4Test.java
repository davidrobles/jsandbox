package dr.games.connect4;

import org.junit.Before;
import org.junit.Test;
import dr.games.core.GameTest;
import static dr.games.connect4.Connect4.Cell;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class Connect4Test extends GameTest<Connect4>
{
    @Before
    public void init() {
        this.game = new Connect4();
    }

    @Test
    public void testNumberOfPlayers() throws Exception {
        assertEquals(2, game.getNumPlayers());
    }

    @Test
    public void testInitialBoard() {
        Cell[] expectedBoard = new Cell[6 * 7];
        for (int i = 0; i < expectedBoard.length; i++)
            expectedBoard[i] = Cell.EMPTY;
        assertArrayEquals(expectedBoard, new Connect4().getBoard());
    }
}
