package entities.chess;

import entities.pieces.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ChessBoard {
    private List<Pieces> blackPieces = new ArrayList<Pieces>(){
        {
            add(new Rook(false, 0, 0));
            add(new Knight(false, 0, 1));
            add(new Bishop(false, 0,2));
            add(new Queen(false,0,3));
            add(new King(false,0,4));
            add(new Bishop(false,0,5));
            add(new Knight(false,0,6));
            add(new Rook(false,0,7));
            add(new Pawn(false,1,0));
            add(new Pawn(false,1,1));
            add(new Pawn(false,1,2));
            add(new Pawn(false,1,3));
            add(new Pawn(false,1,4));
            add(new Pawn(false,1,5));
            add(new Pawn(false,1,6));
            add(new Pawn(false,1,7));
        }
    };

    private List<Pieces> whitePieces = new ArrayList<Pieces>(){
        {
            add(new Pawn(true,6,0));
            add(new Pawn(true,6,1));
            add(new Pawn(true,6,2));
            add(new Pawn(true,6,3));
            add(new Pawn(true,6,4));
            add(new Pawn(true,6,5));
            add(new Pawn(true,6,6));
            add(new Pawn(true,6,7));
            add(new Rook(true, 7, 0));
            add(new Knight(true,7,1));
            add(new Bishop(true, 7,2));
            add(new Queen(true,7,3));
            add(new King(true,7,4));
            add(new Bishop(true,7,5));
            add(new Knight(true,7,6));
            add(new Rook(true,7,7));
        }
    };

    private Pieces[][] chessBoard = {
            {blackPieces.get(0), blackPieces.get(1), blackPieces.get(2), blackPieces.get(3),
                    blackPieces.get(4), blackPieces.get(5), blackPieces.get(6), blackPieces.get(7)},
            {blackPieces.get(8), blackPieces.get(9), blackPieces.get(10), blackPieces.get(11),
                    blackPieces.get(12), blackPieces.get(13), blackPieces.get(14), blackPieces.get(15)},
            {null, null, null, null, null, null, null, null },
            {null, null, null, null, null, null, null, null },
            {null, null, null, null, null, null, null, null },
            {null, null, null, null, null, null, null, null },
            {whitePieces.get(0), whitePieces.get(1), whitePieces.get(2), whitePieces.get(3),
                    whitePieces.get(4), whitePieces.get(5), whitePieces.get(6), whitePieces.get(7)},
            {whitePieces.get(8), whitePieces.get(9), whitePieces.get(10), whitePieces.get(11),
                    whitePieces.get(12), whitePieces.get(13), whitePieces.get(14), whitePieces.get(15)}
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
