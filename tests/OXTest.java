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
}