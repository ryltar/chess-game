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

    /**
     * method which return string representation of the coordinates
     * @return String
     */
    @Override
    public String toString(){
        return "("+this.x+","+this.y+")";
    }

    /**
     * Method which allow us to clone a coordinate object
     * @return Coordinates
     */
    @Override
    public Coordinates clone() throws CloneNotSupportedException {
        return (Coordinates) super.clone();
    }

}
