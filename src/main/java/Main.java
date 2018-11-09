import entities.chess.ChessBoard;
import entities.pieces.Pawn;
import entities.pieces.Pieces;

public class Main {

    public static void main(String[] args)
    {
        ChessBoard board = new ChessBoard();
        board.printChessBoard();
        Pieces pi = board.getChessBoard()[6][0];
        pi.move("A", "3", board);
        board.printChessBoard();
        pi.move("A", "4", board);
        pi.move("A", "5", board);
        pi.move("A", "6", board);
        pi.move("B", "7", board);
        pi.move("B", "8", board);
        pi.move("C", "8", board);
        board.printChessBoard();
    }
}
