package entities.chess;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@EqualsAndHashCode(of={"x","y"})
public class Coordinates implements Cloneable {
    private int x;
    private int y;

    @Override
    public String toString(){
        return "("+this.x+","+this.y+")";
    }

    @Override
    public Coordinates clone() throws CloneNotSupportedException {
        return (Coordinates) super.clone();
    }

}
