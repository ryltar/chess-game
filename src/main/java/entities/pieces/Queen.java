package entities.pieces;

import entities.chess.ChessBoard;
import entities.chess.Coordinates;
import entities.pieces.availables.AvailableQueens;
import entities.tools.TransversalMethod;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Queen extends Pieces {

    public Queen(boolean color, int x, int y, String name){
        super(color, new Coordinates(x,y), name);
        super.setUnicode(TransversalMethod.valueOfPieces(color,this.getClass()));
    }

    @Override
    public AvailableQueens availableAllShots() {
        AvailableQueens availableQueens = new AvailableQueens();
        int tmpX = super.getCoordinates().getX();
        int tmpY = super.getCoordinates().getY();
        while(tmpX != 0 && tmpY != 0 ){
            availableQueens.getAvailableHighLeftDiagonal().add(new Coordinates(--tmpX,--tmpY));
        }
        tmpX = super.getCoordinates().getX();
        tmpY = super.getCoordinates().getY();
        while(tmpX != 7 && tmpY != 7 ){
            availableQueens.getAvailableLowRightDiagonal().add(new Coordinates(++tmpX,++tmpY));
        }
        tmpX = super.getCoordinates().getX();
        tmpY = super.getCoordinates().getY();
        while(tmpX != 7 && tmpY != 0 ){
            availableQueens.getAvailableLowLeftDiagonal().add(new Coordinates(++tmpX,--tmpY));

        }
        tmpX = super.getCoordinates().getX();
        tmpY = super.getCoordinates().getY();
        while(tmpX != 0 && tmpY != 7 ){
            availableQueens.getAvailableHighRightDiagonal().add(new Coordinates(--tmpX,++tmpY));

        }
        int tmp = super.getCoordinates().getY();
        while(tmp < 7){
            int x = super.getCoordinates().getX();
            availableQueens.getAvailableYRight().add(new Coordinates(x, ++tmp));
        }
        tmp = super.getCoordinates().getX();
        while(tmp < 7){
            int y = super.getCoordinates().getY();
            availableQueens.getAvailableXDown().add(new Coordinates(++tmp, y));
        }
        tmp = tmp = super.getCoordinates().getY();
        while(tmp > 0){
            int x = super.getCoordinates().getX();
            availableQueens.getAvailableYLeft().add(new Coordinates(x, --tmp));
        }
        tmp = super.getCoordinates().getX();
        while(tmp > 0){
            int y = super.getCoordinates().getY();
            availableQueens.getAvailableXUp().add(new Coordinates(--tmp, y));
        }
        return availableQueens;
    }

    @Override
    public  AvailableQueens verifyAvailability(ChessBoard chess){
        AvailableQueens availableQueens = availableAllShots();
        List<Coordinates> availableXDownMoves = super.iterateOverEachDirectionAndVerify(availableQueens.getAvailableXDown(), chess);
        List<Coordinates> availableYLeftMoves = super.iterateOverEachDirectionAndVerify(availableQueens.getAvailableYLeft(), chess);
        List<Coordinates> availableXUpMoves = super.iterateOverEachDirectionAndVerify(availableQueens.getAvailableXUp(), chess);
        List<Coordinates> availableYRightMoves = super.iterateOverEachDirectionAndVerify(availableQueens.getAvailableYRight(), chess);
        List<Coordinates> availableLowLeftDiagonals = super.iterateOverEachDirectionAndVerify(availableQueens.getAvailableLowLeftDiagonal(), chess);
        List<Coordinates> availableHighLeftDiagonals = super.iterateOverEachDirectionAndVerify(availableQueens.getAvailableHighLeftDiagonal(), chess);
        List<Coordinates> availableLowRightDiagonals = super.iterateOverEachDirectionAndVerify(availableQueens.getAvailableLowRightDiagonal(), chess);
        List<Coordinates> availableHighRightDiagonals = super.iterateOverEachDirectionAndVerify(availableAllShots().getAvailableHighRightDiagonal(), chess);
        availableQueens.setAllPieces(availableQueens.fusion(availableLowLeftDiagonals, availableHighLeftDiagonals,
                availableLowRightDiagonals, availableHighRightDiagonals, availableXDownMoves, availableXUpMoves, availableYLeftMoves, availableYRightMoves));
        return availableQueens;
    }


}
