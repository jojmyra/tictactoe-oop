public class OX {
    // constant for plyaer value
    private static final int EMPTY = 0;
    private static final int CROSS = 1;
    private static final int NOUGHT = 2;

    // board setting
    private static final int ROWS = 3, COLS = 3;
    private static int[][] board = new int[ROWS][COLS];

    // constant for win check
    private int CROSS_WIN;
    private int NOUGHT_WIN;
    private int DRAW_COUNT;
    private int TURN_COUNT;


    // constant for player
    private int player = CROSS;

    public OX() {
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {
                board[i][j] = EMPTY;
            }
        }
        CROSS_WIN = 0;
        NOUGHT_WIN = 0;
        DRAW_COUNT = 0;
        TURN_COUNT = 0;
    }

    public String getBoard(){
        String result = "";
        for (int i = 0; i < ROWS+1; i++) {

            for (int j = 0; j < COLS+1; j++) {
                /*
                Check if for print index of array
                 */

                if( i == 0 ) {
                    if( j != 0)
                        result+= " " + (j-1);
                    else result+="  ";
                }
                if( j == 0 && i != 0 ) {
                    if( i != 0)
                        result+= " " + (i-1);
                    else result+="  ";
                }

                // print value in array
                if( i != 0 && j != 0) {
                    result+= printCell(board[i-1][j-1]);
                }
            }

            result+="\n";

        }

        return result;
    }

    public String printCell(int content) {
        String result="";
        switch (content) {
            case EMPTY:  result = " -"; break;
            case NOUGHT: result = " O"; break;
            case CROSS:  result = " X"; break;
        }
        return result;
    }

   public boolean move(int col, int row){

        boolean validate = false;

        do {

            if (row >= 0 && row < ROWS && col >= 0 && col < COLS && board[row][col] == EMPTY) {
                board[row][col] = player;
                validate = true;

            } else {
                System.out.println("Wrong move" + (row + 1) + "," + (col + 1)
                        + "). Try again...");
            }

        } while (!validate);

       TURN_COUNT++;
       if(checkWin(col,row)) {
           if(player == CROSS) {
               CROSS_WIN++;
           } else if(player == NOUGHT) {
               NOUGHT_WIN++;
           }
       }

       if(isDraw()) {
           DRAW_COUNT++;
       }

       return true;
   }

   public void switchPlayer(){
        if(player == CROSS){
            player = NOUGHT;
        } else if(player == NOUGHT){
            player = CROSS;
        }
   }

   public String get(int col, int row){

        if(col > COLS-1 || col < 0 || row > ROWS-1 || row < 0){
            return null;
        }

        return printCell(board[row][col]);
   }

    public int getCROSS_WIN() {
        return CROSS_WIN;
    }

    public int getNOUGHT_WIN() {
        return NOUGHT_WIN;
    }

    public int getDRAW_COUNT() {
        return DRAW_COUNT;
    }

    public int getTURN_COUNT() {
        return TURN_COUNT;
    }

    public int getPlayer() {
        return player;
    }

    public boolean checkWin(int col, int row) {
        /* checkColWin */
        boolean colWin=true;
        for(int i = 0; i < 3; i++) {
            if(board[i][col] != player) {
                colWin=false;
            }
        }
        if(colWin) {
            return true;
        }
        /* checkRowWin */
        boolean rowWin=true;
        for(int i = 0; i < 3; i++) {
            if(board[row][i] != player) {
                rowWin=false;
            }
        }
        if(rowWin) {
            return true;
        }

        /* checkEsWin */
        boolean esWin = true;
        for(int i = 0; i < 3; i++) {
            if(board[i][i] != player) {
                esWin=false;
            }
        }
        if(esWin) {
            return true;
        }


        /* checkEsWin */
        boolean ssWin = true;
        for(int i = 0; i < 3; i++) {
            /* col,row -> 2,0, 1,1, 0,2 */
            /* row,col -> 1,3, 2,2, 3,1 */
            /* row,col -> i:0 ,i+1,3-i, i:1 2,2, 3,1 */
            if(board[i][2-i] != player) {
                ssWin=false;
            }
        }
        if(ssWin) {
            return true;
        }
        return false;
    }

    public boolean isDraw() {
        if( TURN_COUNT < 9 ) {
            return false;
        }
        return true;
    }

    public  void reset() {
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {
                board[i][j] = EMPTY;
            }
        }
        TURN_COUNT = 0;
    }

}
