package tictactoe;

public class Main {
    public static void main(String[] args) {

        Board board = new Board();
        board.printBoard();

        while (board.checkBoard()) {
            board.move();
            board.printBoard();
        }
    }
}
