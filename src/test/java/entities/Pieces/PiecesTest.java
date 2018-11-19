package entities.Pieces;

import entities.chess.ChessBoard;
import entities.pieces.Pieces;
import org.junit.Assert;
import org.junit.Test;

public class PiecesTest {

    private ChessBoard chessBoard = new ChessBoard();

    @Test
    public void MovePawn(){
        Pieces pi = chessBoard.getChessBoard()[6][0];
        Pieces test = chessBoard.getChessBoard()[7][0];
        Pieces test2 = chessBoard.getChessBoard()[6][1];
        Pieces test3 = chessBoard.getChessBoard()[7][2];
        Pieces test5 = chessBoard.getChessBoard()[7][1];
        pi.move("A", "3", chessBoard);
        pi.move("A", "4", chessBoard);
        pi.move("A", "5", chessBoard);
        pi.move("A", "6", chessBoard);
        pi.move("B", "7", chessBoard);
        pi.move("B", "8", chessBoard);
        pi.move("C", "8", chessBoard);
        test.move("A", "6", chessBoard);
        test2.move("B", "4", chessBoard);
        test3.move("A", "3", chessBoard);
        test5.move("C", "3", chessBoard);
        chessBoard.printChessBoard();
        Assert.assertEquals(pi.getCoordinates().getX(), 2);
        Assert.assertEquals(test.getCoordinates().getX(), 7);
        Assert.assertEquals(test2.getCoordinates().getX(), 4);
        Assert.assertEquals(test3.getCoordinates().getX(), 5);
        Assert.assertEquals(test5.getCoordinates().getX(), 5);


    }
}
