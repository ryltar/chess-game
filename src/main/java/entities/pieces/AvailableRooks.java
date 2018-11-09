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
public class AvailableRooks extends AvailablePieces {

    private List<Coordinates> availableX = new ArrayList<Coordinates>();
    private List<Coordinates> availableY = new ArrayList<Coordinates>();
    private List<Coordinates> allRooks = new ArrayList<Coordinates>();

    public AvailableRooks(List<Coordinates> availableX, List<Coordinates> availableY){
        this.availableX = availableX;
        this.availableY = availableY;
    }

}
