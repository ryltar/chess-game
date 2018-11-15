package entities.pieces;

import entities.chess.ChessBoard;
import entities.pieces.availables.Coordinates;
import entities.pieces.availables.AvailableRooks;
import entities.tools.TransversalMethod;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class Rook extends Pieces {

    public Rook(boolean color, int x, int y){
        super(color, new Coordinates(x,y));
        super.setUnicode(TransversalMethod.valueOfPieces(color,this.getClass()));
    }

    @Override
    public void move(String yParam, String xParam, ChessBoard chess){
        int y = TransversalMethod.translateCoord(yParam);
        int x = TransversalMethod.translateCoord(xParam);
        Coordinates currentCoord = new Coordinates(x,y);
        for(Coordinates coord : verifyAvailability(chess).getAllRooks()){
            if(coord.equals(currentCoord)){
                super.movePieces(coord,chess);
            }
        }
    }

    @Override
    public AvailableRooks availableAllShots(){
        List<Coordinates> availableXDownMoves = new ArrayList<Coordinates>();
        List<Coordinates> availableYLeftMoves = new ArrayList<Coordinates>();
        List<Coordinates> availableXUpMoves = new ArrayList<Coordinates>();
        List<Coordinates> availableYRightMoves = new ArrayList<Coordinates>();
        int tmp = super.getCoordinates().getY();
        while(tmp < 7){
            int x = super.getCoordinates().getX();
            availableYRightMoves.add(new Coordinates(x, ++tmp));
        }
        tmp = super.getCoordinates().getX();
        while(tmp < 7){
            int y = super.getCoordinates().getY();
            availableXDownMoves.add(new Coordinates(++tmp, y));
        }
        tmp = tmp = super.getCoordinates().getY();
        while(tmp > 0){
            int x = super.getCoordinates().getX();
            availableYLeftMoves.add(new Coordinates(x, --tmp));
        }
        tmp = super.getCoordinates().getX();
        while(tmp > 0){
            int y = super.getCoordinates().getY();
            availableXUpMoves.add(new Coordinates(--tmp, y));
        }
        return new AvailableRooks(availableXDownMoves, availableXUpMoves, availableYLeftMoves, availableYRightMoves );
    }

    @Override
    public  AvailableRooks verifyAvailability(ChessBoard chess){
        AvailableRooks availableRooks = availableAllShots();
        List<Coordinates> availableXDownMoves = super.iterateOverEachDirectionAndVerify(availableRooks.getAvailableXDown(), chess);
        List<Coordinates> availableYLeftMoves = super.iterateOverEachDirectionAndVerify(availableRooks.getAvailableYLeft(), chess);
        List<Coordinates> availableXUpMoves = super.iterateOverEachDirectionAndVerify(availableRooks.getAvailableXUp(), chess);
        List<Coordinates> availableYRightMoves = super.iterateOverEachDirectionAndVerify(availableRooks.getAvailableYRight(), chess);
        availableRooks.setAllRooks(availableRooks.fusion(availableXDownMoves, availableXUpMoves, availableYLeftMoves, availableYRightMoves));
        return availableRooks;
    }


}
