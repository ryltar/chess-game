package entities.tools;

import entities.pieces.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public enum UnicodeColorEnum {

    Bishop_white(true, "\u2657", Bishop.class),
    Bishop_black(false, "\u265D", Bishop.class),
    King_white(true, "\u2654", King.class),
    King_black(false, "\u265A", King.class),
    Pawn_white(true, "\u2659", Pawn.class),
    Pawn_black(false, "\u265F", Pawn.class),
    Queen_white(true, "\u2655", Queen.class),
    Queen_black(false, "\u265B", Queen.class),
    Rook_white(true, "\u2656", Rook.class),
    Rook_black(false, "\u265c", Rook.class),
    Knight_white(true, "\u2659", Knight.class),
    Knight_black(false, "\u265E", Knight.class);

    private boolean color = false;
    private String unicode = "";
    private Class pieces;

    public String toString(){
        return this.unicode;
    }

}