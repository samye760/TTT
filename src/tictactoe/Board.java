package tictactoe;

import java.util.Scanner;

public class Board {

    private char[][] board;
    private char turn;
    private final Scanner sc;

    public Board() {

        this.board = new char[3][3];
        turn = 'X';
        sc = new Scanner(System.in);

        /*
         System.out.print("Enter cells: ");
         String cells = sc.nextLine();
         int size = cells.length();
         double rows = Math.sqrt(size);
         if (rows != Math.round(rows)) {
             System.out.println("Board must have equal dimensions");
             System.exit(-1);
         }
         int dims = (int) rows;
         this.board = new char[dims][dims];
         int idx = 0;
         */

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                this.board[i][j] = '_';
                // idx++;
            }
        }
    }

    public void printBoard() {
        System.out.println("---------");
        for (int i = 0; i < 3; i++) {
            System.out.print("| ");
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println("|");
        }
        System.out.println("---------");
    }

    public void move() {

        String[] coords;

        while (true) {
            System.out.print("Enter the coordinates: ");
            coords = sc.nextLine().split(" ");

            try {
                int y = Integer.parseInt(coords[0]) - 1;
                int x = Integer.parseInt(coords[1]) - 1;
                if (this.board[y][x] == '_') {
                    this.board[y][x] = this.turn;
                    break;
                }
                System.out.println("This cell is occupied! Choose another one!");
            } catch (NumberFormatException e) {
                System.out.println("You should enter numbers!");
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.printf("Coordinates should be from 1 to %d!\n", this.board.length);
            }
        }
        turn = turn == 'X' ? 'O' : 'X';
    }

    public boolean checkBoard() {
        int emptyCount = 0;
        int xCount = 0;
        int oCount = 0;

        for (char[] row : this.board) {
            for (char col : row) {
                if (col == 'X') {
                    xCount++;
                } else if (col == 'O') {
                    oCount++;
                } else if (col == '_') {
                    emptyCount++;
                }
            }
        }

        boolean x = false;
        boolean o = false;
        boolean draw = false;
        boolean impossible = false;
        boolean notFinished = false;

        if (this.board[0][0] == 'X' && this.board[0][1] == 'X' && this.board[0][2] == 'X' || this.board[1][0] == 'X' && this.board[1][1] == 'X' && this.board[1][2] == 'X' || this.board[2][0] == 'X' && this.board[2][1] == 'X' && this.board[2][2] == 'X' || this.board[0][0] == 'X' && this.board[1][1] == 'X' && this.board[2][2] == 'X' || this.board[0][2] == 'X' && this.board[1][1] == 'X' && this.board[2][0] == 'X' || this.board[0][0] == 'X' && this.board[1][0] == 'X' && this.board[2][0] == 'X' || this.board[0][1] == 'X' && this.board[1][1] == 'X' && this.board[2][1] == 'X' || this.board[0][2] == 'X' && this.board[1][2] == 'X' && this.board[2][2] == 'X') {
            x = true;
        }
        if (this.board[0][0] == 'O' && this.board[0][1] == 'O' && this.board[0][2] == 'O' || this.board[1][0] == 'O' && this.board[1][1] == 'O' && this.board[1][2] == 'O' || this.board[2][0] == 'O' && this.board[2][1] == 'O' && this.board[2][2] == 'O' || this.board[0][0] == 'O' && this.board[1][1] == 'O' && this.board[2][2] == 'O' || this.board[0][2] == 'O' && this.board[1][1] == 'O' && this.board[2][0] == 'O' || this.board[0][0] == 'O' && this.board[1][0] == 'O' && this.board[2][0] == 'O' || this.board[0][1] == 'O' && this.board[1][1] == 'O' && this.board[2][1] == 'O' || this.board[0][2] == 'O' && this.board[1][2] == 'O' && this.board[2][2] == 'O') {
            o = true;
        }

        if (x && o || Math.abs(xCount - oCount) >= 2) {
            impossible = true;
        }
        if (!x && !o && emptyCount >= 1) {
            notFinished = true;
        }
        if (!x && !o && emptyCount <= 0) {
            draw = true;
        }

        // System.out.print(impossible ? "Impossible" : draw ? "Draw" : notFinished ? "Game not finished" : o ? "O wins" : "X wins");

        if (x) {
            System.out.println("X wins");
        } else if (o) {
            System.out.println("O wins");
        } else if (draw) {
            System.out.println("Draw");
        }

        return notFinished;
    }
}