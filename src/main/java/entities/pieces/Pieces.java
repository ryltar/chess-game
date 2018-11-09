package entities.pieces;

import entities.chess.ChessBoard;
import entities.chess.Coordinates;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public abstract class Pieces {
    private boolean color;
    private String unicode;
    private Class currentClass;
    private int x;
    private int y;

    Pieces(boolean color, int x, int y){
        this.color = color;
        this.x = x;
        this.y = y;
    }

    public String toString(){
        return unicode;
    }

    public abstract void move(String x, String y, ChessBoard chess);

    public abstract AvailablePieces verifyAvailability(ChessBoard chess);

    public abstract AvailablePieces  availableAllShots();

    void movePieces(int x, int y, ChessBoard chess){
        chess.getChessBoard()[x][y] = chess.getChessBoard()[this.x][this.y];
        chess.getChessBoard()[this.x][this.y] = null;
        this.x = x;
        this.y = y;
    };

}
