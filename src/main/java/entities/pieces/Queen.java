package entities.pieces;

import entities.chess.ChessBoard;
import entities.pieces.availables.Coordinates;
import entities.pieces.availables.AvailablePawns;
import entities.tools.TransversalMethod;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Queen extends Pieces {

    public Queen(boolean color, int x, int y){
        super(color, new Coordinates(x,y));
        super.setUnicode(TransversalMethod.valueOfPieces(color,this.getClass()));
    }

    @Override
    public void move(String xParam, String yParam, ChessBoard chess){

    };

    @Override
    public AvailablePawns availableAllShots() {
        return null;
    }

    @Override
    public  AvailablePawns verifyAvailability(ChessBoard chess){
        return null;
    }


}
