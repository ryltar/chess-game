package entities.pieces.availables;

import entities.tools.CoordinatesArray;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class AvailablePawns extends AvailablePieces {

    private List<Coordinates> straightsAhead = new CoordinatesArray();
    private List<Coordinates> diagonals = new CoordinatesArray();
    private List<Coordinates> allPawns = new CoordinatesArray();

    public AvailablePawns(List<Coordinates> straightsAhead, List<Coordinates> diagonals){
        this.straightsAhead = straightsAhead;
        this.diagonals = diagonals;
    }

}
