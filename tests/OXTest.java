import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OXTest {
    OX ox = new OX();
    @Test
    public void getBoard(){
        ox.getBoard();
        assertEquals("   0 1 2\n" +
                " 0 - - -\n" +
                " 1 - - -\n" +
                " 2 - - -\n",ox.getBoard());
    }

    @Test
    public void move(){
        ox.move(0,0);
        assertEquals("   0 1 2\n" +
                " 0 X - -\n" +
                " 1 - - -\n" +
                " 2 - - -\n",ox.getBoard());
    }

    @Test
    public void switchPlayer(){
        ox.switchPlayer();
        ox.move(0,0);
        assertEquals("   0 1 2\n" +
                " 0 O - -\n" +
                " 1 - - -\n" +
                " 2 - - -\n",ox.getBoard());
    }

    @Test
    void get() {
        ox.move(0,0);
        assertEquals(" X",ox.get(0,0));
    }

    @Test
    void printCell() {
        assertEquals(" -", ox.get(0,0));
    }

    @Test
    void getCROSS_WIN() {
        assertEquals(0,ox.getCROSS_WIN());
    }

    @Test
    void getNOUGHT_WIN() {
        assertEquals(0,ox.getNOUGHT_WIN());
    }

    @Test
    void getDRAW_COUNT() {
        assertEquals(0,ox.getDRAW_COUNT());
    }

    @Test
    void getTURN_COUNT() {
        ox.move(0,0);
        assertEquals(1,ox.getTURN_COUNT());
    }

    @Test
    void getPlayer() {
        assertEquals(1,ox.getPlayer());
    }


    @Test
    void isDraw() {
        

        assertEquals(0,ox.getDRAW_COUNT());
        ox.move(0,0);
        ox.move(0,1);
        ox.move(0,2);
        assertFalse(ox.isDraw());

        ox.move(1,0);
        ox.move(1,1);
        ox.move(1,2);
        assertFalse(ox.isDraw());

        ox.move(2,0);
        ox.move(2,1);
        ox.move(2,2);
        assertTrue(ox.isDraw());
        assertEquals(1,ox.getDRAW_COUNT());

    }


    @Test
    void getAt0_0() {
        OX ox = new OX();
        ox.move(0,0);
        assertEquals("   0 1 2\n" +
                " 0 X - -\n" +
                " 1 - - -\n" +
                " 2 - - -\n", ox.getBoard());
        assertEquals(" X",ox.get(0,0));
    }

    @Test
    void getOver() {
        OX ox = new OX();
        assertNull(ox.get(0, -1));
        assertNull(ox.get(0, 3));
        assertNull(ox.get(3, -1));
        assertNull(ox.get(-1, 3));
    }

    @Test
    void checkWinCol0() {
        OX ox = new OX();
        ox.move(0,0);
        ox.move(0,1);
        ox.move(0,2);
        assertTrue(ox.checkWin(0,0));
        assertTrue(ox.checkWin(0,1));
        assertTrue(ox.checkWin(0,2));
        assertFalse(ox.checkWin(1,0));
        assertFalse(ox.checkWin(1,1));
        assertFalse(ox.checkWin(1,2));
    }

    @Test
    void checkWinCol2() {
        OX ox = new OX();
        ox.move(2,0);
        ox.move(2,1);
        ox.move(2,2);
        assertTrue(ox.checkWin(2,0));
        assertTrue(ox.checkWin(2,1));
        assertTrue(ox.checkWin(2,2));
        assertFalse(ox.checkWin(1,0));
        assertFalse(ox.checkWin(1,1));
        assertFalse(ox.checkWin(1,2));
    }

    @Test
    void checkWinRo2() {
        OX ox = new OX();
        ox.move(0,2);
        ox.move(1,2);
        ox.move(2,2);
        assertTrue(ox.checkWin(0,2));
        assertTrue(ox.checkWin(1,2));
        assertTrue(ox.checkWin(2,2));
        assertFalse(ox.checkWin(1,0));
        assertFalse(ox.checkWin(1,1));
        assertFalse(ox.checkWin(2,1));
    }

    @Test
    void checkWinES() {
        OX ox = new OX();
        ox.move(0,0);
        ox.move(1,1);
        ox.move(2,2);
        assertTrue(ox.checkWin(0,0));
        assertTrue(ox.checkWin(1,1));
        assertTrue(ox.checkWin(2,2));
    }

    @Test
    void checkWinSS() {
        OX ox = new OX();
        ox.move(2,0);
        ox.move(1,1);
        ox.move(0,2);
        assertTrue(ox.checkWin(2,0));
        assertTrue(ox.checkWin(1,1));
        assertTrue(ox.checkWin(0,2));
    }

    @Test
    void reset() {
    }
}
