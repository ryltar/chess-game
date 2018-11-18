package entities.pieces.availables;

import entities.chess.Coordinates;
import entities.tools.CoordinatesArray;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public abstract class AvailablePieces {

    private List<Coordinates> allPieces = new CoordinatesArray();

    public List<Coordinates> fusion(List<Coordinates>... tmp){
        List<Coordinates> allMoves = new ArrayList<Coordinates>();
        for(List<Coordinates> move: tmp){
            allMoves.addAll(move);
        }
        return allMoves;
    }
}
