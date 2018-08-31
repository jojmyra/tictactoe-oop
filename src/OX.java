public class OX {
    // constant for plyaer value
    public static final int EMPTY = 0;
    public static final int CROSS = 1;
    public static final int NOUGHT = 2;

    // board setting
    public static final int ROWS = 3, COLS = 3;
    public static int[][] board = new int[ROWS][COLS];

    // constant for win check
    public static int CROSS_WIN = 0;
    public static int NOUGHT_WIN = 0;
    public static int DRAW_COUNT = 0;


    // constant game value
    public static final int PLAYING = 0;
    public static final int DRAW = 1;
    public static final int CROSS_WON = 2;
    public static final int NOUGHT_WON = 3;

    // constant for player
    public static int player = CROSS;
    public static int currentState = PLAYING;

    public OX() {
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {
                board[i][j] = EMPTY;
            }
        }
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

    public static String printCell(int content) {
        String result="";
        switch (content) {
            case EMPTY:  result = " -"; break;
            case NOUGHT: result = " O"; break;
            case CROSS:  result = " X"; break;
        }
        return result;
    }

   public void move(int col, int row){

        boolean validate = false;

        do {

            if (row >= 0 && row < ROWS && col >= 0 && col < COLS && board[row][col] == EMPTY) {
                board[row][col] = player;  // อัพเดทข้อมูลในอาเรย์
                validate = true;  // ถ้าข้อมูลถูก ออกจากลูป
            } else {
                System.out.println("Wrong move" + (row + 1) + "," + (col + 1)
                        + "). Try again...");
            }

        } while (!validate);

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

}
