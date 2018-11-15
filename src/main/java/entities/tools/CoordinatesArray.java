package entities.tools;

import entities.pieces.availables.Coordinates;

import java.util.ArrayList;

public class CoordinatesArray extends ArrayList<Coordinates> {
    @Override
    public boolean add(Coordinates coordinates){
        if(coordinates.getY() >= 0 && coordinates.getY() <= 7
                && coordinates.getX() >= 0 && coordinates.getX() <= 7){
            return super.add(coordinates);
        }
        return false;
    }
}
