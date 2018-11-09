package entities.pieces;

import entities.chess.ChessBoard;
import entities.chess.Coordinates;
import entities.tools.TransversalMethod;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class King extends Pieces {

    public King(boolean color, int x, int y){
        super(color, x, y);
        super.setUnicode(TransversalMethod.valueOfPieces(color,this.getClass()));
    }

    @Override
    public void move(String xParam, String yParam, ChessBoard chess){

    };

    @Override
    public AvailablePawns availableAllShots(){
        return null;
    };

    @Override
    public  AvailablePawns verifyAvailability(ChessBoard chess){
        return null;
    }


}
