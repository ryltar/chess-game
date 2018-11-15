package entities.chess;

import entities.pieces.Pieces;
import entities.players.Player;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Scanner;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class GameManager {
    boolean finished = false;
    ChessBoard chessBoard = new ChessBoard();
    Player playerBlack = new Player( chessBoard.getBlackPieces(), false);
    Player playerWhite = new Player(chessBoard.getWhitePieces(), true);

    void gameLoop(){
        while (!finished){
            Scanner sc = new Scanner(System.in);
            System.out.print("The first player: enter a move");
            int x = sc.nextInt();
            int y = sc.nextInt();
            Pieces pieces = this.chessBoard.getChessBoard()[x][y];
        }
    }

    void main(){

        System.out.print("");
    }
}
