package entities.Pieces;

import entities.chess.ChessBoard;
import entities.chess.GameManager;
import entities.pieces.Pieces;
import entities.players.Player;
import org.junit.Assert;
import org.junit.Test;

public class PiecesTest {

    private ChessBoard chessBoard = new ChessBoard();

    @Test
    public void MovePawnTest(){
        Pieces pi = chessBoard.getChessBoard()[6][0];
        Pieces test = chessBoard.getChessBoard()[7][0];
        Pieces test2 = chessBoard.getChessBoard()[6][1];
        Pieces test3 = chessBoard.getChessBoard()[7][2];
        Pieces test5 = chessBoard.getChessBoard()[7][1];
        Pieces test6 = chessBoard.getChessBoard()[7][3];
        Pieces test7 = chessBoard.getChessBoard()[7][4];
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
        test6.move("B", "1", chessBoard);
        test7.move("D", "1", chessBoard);
        chessBoard.printChessBoard();
        Assert.assertEquals(pi.getCoordinates().getX(), 2);
        Assert.assertEquals(pi.getCoordinates().getY(), 0);
        Assert.assertEquals(test.getCoordinates().getX(), 7);
        Assert.assertEquals(test.getCoordinates().getY(), 0);
        Assert.assertEquals(test2.getCoordinates().getX(), 4);
        Assert.assertEquals(test2.getCoordinates().getY(), 1);
        Assert.assertEquals(test3.getCoordinates().getX(), 5);
        Assert.assertEquals(test3.getCoordinates().getY(), 0);
        Assert.assertEquals(test5.getCoordinates().getX(), 5);
        Assert.assertEquals(test5.getCoordinates().getY(), 2);
        Assert.assertEquals(test6.getCoordinates().getX(), 7);
        Assert.assertEquals(test6.getCoordinates().getY(), 1);
        Assert.assertEquals(test7.getCoordinates().getX(), 7);
        Assert.assertEquals(test7.getCoordinates().getY(), 3);
    }

    @Test
    public void gameManagerTest(){
        Player playerWhite = new Player(chessBoard.getWhitePieces(), true);
        GameManager game = new GameManager();
        String[] input = new String[]{"WP1", "A3"};
        game.playerPlay(playerWhite, input);
        Assert.assertNotEquals(game.getChessBoard().getChessBoard()[5][0], null);
    }

}
