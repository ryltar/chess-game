package entities.pieces.availables;

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

    private List<Coordinates> availableXDown = new ArrayList<Coordinates>();
    private List<Coordinates> availableXUp = new ArrayList<Coordinates>();
    private List<Coordinates> availableYLeft = new ArrayList<Coordinates>();
    private List<Coordinates> availableYRight = new ArrayList<Coordinates>();
    private List<Coordinates> allRooks = new ArrayList<Coordinates>();

    public AvailableRooks(List<Coordinates> availableXDown, List<Coordinates> availableXUp,
                          List<Coordinates> availableYLeft, List<Coordinates> availableYRight){
        this.availableXDown = availableXDown;
        this.availableXUp = availableXUp;
        this.availableYLeft = availableYLeft;
        this.availableYRight = availableYRight;
    }

}
