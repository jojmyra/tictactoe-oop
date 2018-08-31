import java.util.Scanner;

public class Game {
    private static OX ox;
    private static Scanner sc = new Scanner(System.in);
    private static int col;
    private static int row;

    public static void main(String[] args) {
        ox = new OX();
        while (true) {
            printBoard();
            input();
            if(ox.checkWin(col,row)) {
                printBoard();
                printWin();
                printScore();
                ox.reset();
                continue;
            }
            if(ox.isDraw()) {
                printBoard();
                printDraw();
                printScore();
                ox.reset();
                continue;
            }
            ox.switchPlayer();
        }
    }

    private static void input() {
        boolean canPut = true;
        do {
            System.out.print(ox.printCell(ox.getPlayer()) + " Col :");
            col = sc.nextInt();
            System.out.print(ox.printCell(ox.getPlayer()) + " Row :");
            row = sc.nextInt();
            canPut = ox.move(col, row);
            if (!canPut) {
                System.out.println("Please input number between 0-2");
            }
        } while(!canPut);
    }

    private static void printBoard() {
        System.out.println(ox.getBoard());
    }

    private static void printScore() {
        System.out.println("X win: " + ox.getCROSS_WIN());
        System.out.println("O win: " + ox.getNOUGHT_WIN());
        System.out.println("Draw: " + ox.getDRAW_COUNT());
    }

    private static void printWin() {
        System.out.println(ox.printCell(ox.getPlayer()) + " " + "Win");
    }

    private static void printDraw() {
        System.out.println("Draw");
    }
}
