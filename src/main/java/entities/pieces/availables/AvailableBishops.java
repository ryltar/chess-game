package entities.pieces.availables;

import entities.chess.Coordinates;
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
public class AvailableBishops extends AvailablePieces {

    private List<Coordinates> availableLowRightDiagonal = new CoordinatesArray();
    private List<Coordinates> availableHighRightDiagonal = new CoordinatesArray();
    private List<Coordinates> availableLowLeftDiagonal = new CoordinatesArray();
    private List<Coordinates> availableHighLeftDiagonal = new CoordinatesArray();

}
