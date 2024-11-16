import java.util.Scanner;

public class Chess {
    Scanner s = new Scanner(System.in);
    int[][] chessTable = new int[10][10];
    boolean started = false;
    int player = 1;

    public void gameStart() {
        printTable();
        started = true;
        switchPlayer();
    }

    public void printTable() {
        // print default table
        for (int i = 0; i < 10; i++) {
            // first col
            System.out.print(i + "  " + "|" + "  ");

            // table
            for (int j = 0; j < 10; j++) {
                if (!started) {
                    chessTable[i][j] = 0;
                    System.out.print(chessTable[i][j] + "  ");
                } else {
                    System.out.print(chessTable[i][j] + "  ");
                }
            }
            System.out.println();
        }

        // last two row
        System.out.println("   " + "+------------------------------");
        System.out.print("      ");
        for (int i = 0; i < 10; i++) {
            System.out.print(i + "  ");
        }
        System.out.println();
    }

    public void switchPlayer() {

        while (started) {
                    System.out.println("Player " + player + "'s turn");
                    System.out.println("Enter row and column (e.g., 0 1): ");
                    int row = s.nextInt();
                    int col = s.nextInt();

                    // check out of range & repetition
                    if (row < 0 || col < 0 || row > 9 || col > 9) {
                        System.out.println("out of range! Try again.");
                    
                    } else if (chessTable[row][col] != 0){
                        System.out.println("invalid move");

                    } else {
                        chessTable[row][col] = player;
                        printTable();
                        draw();
                        win();
                        player = (player == 1) ? 2 : 1;
                    }
                }
        
        
    }

    public void draw() {
        // check no zero left
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if (chessTable[i][j] == 0) {
                    return; 
                }
            }
        }
        System.out.println("Draw, no one wins");
        started = false;
        return;
    }

    public void win() {
        for (int row = 0; row < 10; row++) {
                for (int col = 0; col < 10; col++) {
                    
                    // horizontal
                    if (row <= 6 &&
                        chessTable[row][col] != 0 &&
                        chessTable[row][col] == chessTable[row+1][col] && 
                        chessTable[row][col] == chessTable[row+2][col] && 
                        chessTable[row][col] == chessTable[row+3][col]) {
                        System.out.println("player " + chessTable[row][col] + " wins!");
                        started = false;
                        return;
                    }


                    // vertical
                    if (col <= 6 &&
                        chessTable[row][col] != 0 &&
                        chessTable[row][col] == chessTable[row][col+1] && 
                        chessTable[row][col] == chessTable[row][col+2] && 
                        chessTable[row][col] == chessTable[row][col+3]) {
                        System.out.println("player " + chessTable[row][col] + " wins!");
                        started = false;
                        return;
                    }

                    // diagonal
                    if (row <= 6 && 
                        col <= 6 &&
                        chessTable[row][col] != 0 &&
                        chessTable[row][col] == chessTable[row+1][col+1] && 
                        chessTable[row][col] == chessTable[row+2][col+2] && 
                        chessTable[row][col] == chessTable[row+3][col+3]) {
                        System.out.println("player " + chessTable[row][col] + " wins!");
                        started = false;
                        return;
                    }

                    if (row >= 3 && 
                        col <= 6 &&
                        chessTable[row][col] != 0 &&
                        chessTable[row][col] == chessTable[row-1][col+1] && 
                        chessTable[row][col] == chessTable[row-2][col+2] && 
                        chessTable[row][col] == chessTable[row-3][col+3]) {
                        System.out.println("player " + chessTable[row][col] + " wins!");
                        started = false;
                        return;
                    }
                    
                }

            

        }
    }

    public static void main(String[] args) {
        Chess chess = new Chess();
        chess.gameStart();
    }

}