package entities.pieces.availables;

import java.util.ArrayList;
import java.util.List;

public abstract class AvailablePieces {
    public List<Coordinates> fusion(List<Coordinates>... tmp){
        List<Coordinates> allMoves = new ArrayList<Coordinates>();
        for(List<Coordinates> move: tmp){
            allMoves.addAll(move);
        }
        return allMoves;
    }
}
