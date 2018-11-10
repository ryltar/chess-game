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
public class AvailableBishops extends AvailablePieces {

    private List<Coordinates> availableLowRightDiagonal = new ArrayList<Coordinates>();
    private List<Coordinates> availableHighRightDiagonal = new ArrayList<Coordinates>();
    private List<Coordinates> availableLowLeftDiagonal = new ArrayList<Coordinates>();
    private List<Coordinates> availableHighLeftDiagonal = new ArrayList<Coordinates>();
    private List<Coordinates> allBishops = new ArrayList<Coordinates>();

    public AvailableBishops(List<Coordinates> availableLowRightDiagonal, List<Coordinates> availableHighRightDiagonal,
                            List<Coordinates> availableLowLeftDiagonal, List<Coordinates> availableHighLeftDiagonal ){
        this.availableLowRightDiagonal = availableLowRightDiagonal;
        this.availableHighRightDiagonal = availableHighRightDiagonal;
        this.availableLowLeftDiagonal = availableLowLeftDiagonal;
        this.availableHighLeftDiagonal = availableHighLeftDiagonal;
    }

}
