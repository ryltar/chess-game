package entities.pieces;

import entities.chess.ChessBoard;
import entities.chess.Coordinates;
import entities.pieces.availables.AvailableRooks;
import entities.tools.CoordinatesArray;
import entities.tools.TransversalMethod;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Rook extends Pieces {

    public Rook(boolean color, int x, int y, String name){
        super(color, new Coordinates(x,y), name);
        super.setUnicode(TransversalMethod.valueOfPieces(color,this.getClass()));
    }

    @Override
    public AvailableRooks availableAllShots(){
        AvailableRooks availableRooks = new AvailableRooks();
        int tmp = super.getCoordinates().getY();
        while(tmp < 7){
            int x = super.getCoordinates().getX();
            availableRooks.getAvailableYRight().add(new Coordinates(x, ++tmp));
        }
        tmp = super.getCoordinates().getX();
        while(tmp < 7){
            int y = super.getCoordinates().getY();
            availableRooks.getAvailableXDown().add(new Coordinates(++tmp, y));
        }
        tmp = tmp = super.getCoordinates().getY();
        while(tmp > 0){
            int x = super.getCoordinates().getX();
            availableRooks.getAvailableYLeft().add(new Coordinates(x, --tmp));
        }
        tmp = super.getCoordinates().getX();
        while(tmp > 0){
            int y = super.getCoordinates().getY();
            availableRooks.getAvailableXUp().add(new Coordinates(--tmp, y));
        }
        return availableRooks;
    }


    @Override
    public  AvailableRooks verifyAvailability(ChessBoard chess){
        AvailableRooks availableRooks = availableAllShots();
        List<Coordinates> availableXDownMoves = super.iterateOverEachDirectionAndVerify(availableRooks.getAvailableXDown(), chess);
        List<Coordinates> availableYLeftMoves = super.iterateOverEachDirectionAndVerify(availableRooks.getAvailableYLeft(), chess);
        List<Coordinates> availableXUpMoves = super.iterateOverEachDirectionAndVerify(availableRooks.getAvailableXUp(), chess);
        List<Coordinates> availableYRightMoves = super.iterateOverEachDirectionAndVerify(availableRooks.getAvailableYRight(), chess);
        availableRooks.setAllPieces(availableRooks.fusion(availableXDownMoves, availableXUpMoves, availableYLeftMoves, availableYRightMoves));
        return availableRooks;
    }


}
