package entities.chess;

import entities.pieces.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ChessBoard {
    private Pieces[][] chessBoard = {
            {new Rook(false, 0, 0), new Knight(false,0,1), new Bishop(false, 0,2), new Queen(false,0,3), new King(false,0,4),
                    new Bishop(false,0,5), new Knight(false,0,6), new Rook(false,0,7)},
            {new Pawn(false,1,0), new Pawn(false,1,1), new Pawn(false,1,2), new Pawn(false,1,3), new Pawn(false,1,4),
                    new Pawn(false,1,5), new Pawn(false,1,6), new Pawn(false,1,7)},
            {null, null, null, null, null, null, null, null },
            {null, null, null, null, null, null, null, null },
            {null, null, null, null, null, null, null, null },
            {null, null, null, null, null, null, null, null },
            {new Pawn(true,6,0), new Pawn(true,6,1), new Pawn(true,6,2), new Pawn(true,6,3), new Pawn(true,6,4),
                    new Pawn(true,6,5), new Pawn(true,6,6), new Pawn(true,6,7)},
            {new Rook(true,7,0), new Knight(true,7,1), new Bishop(true,7,2), new Queen(true,7,3), new King(true,7,4),
                    new Bishop(true,7,5), new Knight(true,7,6), new Rook(true,7,7)}
    };

    public void printChessBoard(){
        System.out.println(" ---------------------------------");
        for(int i = 0 ; i < this.chessBoard.length ; i++) {
            System.out.print(8-i+"|");
            for(int j = 0 ; j < this.chessBoard[i].length ; j++) {
                if(this.chessBoard[i][j] == null) {
                    System.out.print("   ");
                } else {
                    System.out.print(" " +this.chessBoard[i][j]+ " ");
                }
                System.out.print("|");
            }
            System.out.println("\n ---------------------------------");
        }
        System.out.println("   A   B   C   D   E   F   G   H  ");
    }
}
