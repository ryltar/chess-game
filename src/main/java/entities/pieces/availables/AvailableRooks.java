package entities.pieces.availables;

import entities.chess.Coordinates;
import entities.tools.CoordinatesArray;
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
public class AvailableRooks extends AvailablePieces {

    private List<Coordinates> availableXDown = new CoordinatesArray();
    private List<Coordinates> availableXUp = new CoordinatesArray();
    private List<Coordinates> availableYLeft = new CoordinatesArray();
    private List<Coordinates> availableYRight = new CoordinatesArray();

}
