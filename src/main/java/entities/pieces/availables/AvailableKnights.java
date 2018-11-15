package entities.pieces.availables;

import entities.tools.CoordinatesArray;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AvailableKnights extends AvailablePieces {
    private List<Coordinates> availableKnights = new CoordinatesArray();
}
