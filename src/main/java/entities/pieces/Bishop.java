package entities.pieces;

import entities.chess.ChessBoard;
import entities.chess.Coordinates;
import entities.pieces.availables.AvailableBishops;
import entities.tools.TransversalMethod;
import lombok.Getter;
import lombok.Setter;
import java.util.List;

@Getter
@Setter
public class Bishop extends Pieces {

    public Bishop(boolean color, int x, int y, String name){
        super(color, new Coordinates(x,y), name);
        super.setUnicode(TransversalMethod.valueOfPieces(color,this.getClass()));
    }

    @Override
    public void move(String yParam, String xParam, ChessBoard chess){
        int y = TransversalMethod.translateCoordinates(yParam);
        int x = TransversalMethod.translateCoordinates(xParam);
        Coordinates currentCoord = new Coordinates(x,y);
        for(Coordinates coord : verifyAvailability(chess).getAllPieces()){
            if(coord.equals(currentCoord)){
                super.movePieces(currentCoord,chess);
            }
        }
    };

    @Override
    public AvailableBishops availableAllShots(){
        AvailableBishops availableBishops = new AvailableBishops();
        int tmpX = super.getCoordinates().getX();
        int tmpY = super.getCoordinates().getY();
        while(tmpX != 0 && tmpY != 0 ){
            availableBishops.getAvailableHighLeftDiagonal().add(new Coordinates(--tmpX,--tmpY));
        }
        tmpX = super.getCoordinates().getX();
        tmpY = super.getCoordinates().getY();
        while(tmpX != 7 && tmpY != 7 ){
            availableBishops.getAvailableLowRightDiagonal().add(new Coordinates(++tmpX,++tmpY));
        }
        tmpX = super.getCoordinates().getX();
        tmpY = super.getCoordinates().getY();
        while(tmpX != 7 && tmpY != 0 ){
            availableBishops.getAvailableLowLeftDiagonal().add(new Coordinates(++tmpX,--tmpY));

        }
        tmpX = super.getCoordinates().getX();
        tmpY = super.getCoordinates().getY();
        while(tmpX != 0 && tmpY != 7 ){
            availableBishops.getAvailableHighRightDiagonal().add(new Coordinates(--tmpX,++tmpY));

        }
        return availableBishops;
    }

    @Override
    public AvailableBishops verifyAvailability(ChessBoard chess){
        AvailableBishops availableBishops = availableAllShots();
        List<Coordinates> availableLowLeftDiagonals = super.iterateOverEachDirectionAndVerify(availableBishops.getAvailableLowLeftDiagonal(), chess);
        List<Coordinates> availableHighLeftDiagonals = super.iterateOverEachDirectionAndVerify(availableBishops.getAvailableHighLeftDiagonal(), chess);
        List<Coordinates> availableLowRightDiagonals = super.iterateOverEachDirectionAndVerify(availableBishops.getAvailableLowRightDiagonal(), chess);
        List<Coordinates> availableHighRightDiagonals = super.iterateOverEachDirectionAndVerify(availableAllShots().getAvailableHighRightDiagonal(), chess);
        availableBishops.setAllPieces(availableBishops.fusion(availableLowLeftDiagonals, availableHighLeftDiagonals,
                availableLowRightDiagonals, availableHighRightDiagonals));

        return availableBishops;
    }

}
