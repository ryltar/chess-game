import entities.chess.ChessBoard;
import entities.chess.GameManager;
import entities.pieces.Pawn;
import entities.pieces.Pieces;

public class Main {

    public static void main(String[] args)
    {
        /**
        ChessBoard board = new ChessBoard();
        board.printChessBoard();
        Pieces pi = board.getChessBoard()[6][0];
        Pieces test = board.getChessBoard()[7][0];
        Pieces test2 = board.getChessBoard()[6][1];
        Pieces test3 = board.getChessBoard()[7][2];
        Pieces test4 = board.getChessBoard()[7][4];
        Pieces test5 = board.getChessBoard()[7][1];
        pi.move("A", "3", board);
        board.printChessBoard();
        pi.move("A", "4", board);
        pi.move("A", "5", board);
        pi.move("A", "6", board);
        pi.move("B", "7", board);
        pi.move("B", "8", board);
        pi.move("C", "8", board);
        test.move("A", "6", board);
        test2.move("B", "4", board);
        test3.move("A", "3", board);
        test4.move("D", "1", board);
        test5.move("C", "3", board);
        board.printChessBoard();
         */

        GameManager game = new GameManager();
        game.main();

    }
}
