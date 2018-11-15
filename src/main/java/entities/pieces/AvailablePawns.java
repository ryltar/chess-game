package entities.pieces;

import entities.chess.Coordinates;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class AvailablePawns extends AvailablePieces {

    private List<Coordinates> straightsAhead = new ArrayList<Coordinates>();
    private List<Coordinates> diagonals = new ArrayList<Coordinates>();
    private List<Coordinates> allPawns = new ArrayList<Coordinates>();

    public AvailablePawns(List<Coordinates> straightsAhead, List<Coordinates> diagonals){
        this.straightsAhead = straightsAhead;
        this.diagonals = diagonals;
    }

}
