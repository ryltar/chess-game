package entities.pieces.availables;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@EqualsAndHashCode(of={"x","y"})
public class Coordinates {
    private int x;
    private int y;

    @Override
    public String toString(){
        return "("+this.x+","+this.y+")";
    }

}
