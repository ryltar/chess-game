package entities.tools;

import entities.chess.Coordinates;
import java.util.ArrayList;

/**
 * My own arrayList which can only contains pieces from the chessboard
 */
public class CoordinatesArray extends ArrayList<Coordinates> {
    /**
     * Override method add to allow only pieces from the chessboard
     */
    @Override
    public boolean add(Coordinates coordinates){
        if(coordinates.getY() >= 0 && coordinates.getY() <= 7
                && coordinates.getX() >= 0 && coordinates.getX() <= 7){
            return super.add(coordinates);
        }
        return false;
    }
}
