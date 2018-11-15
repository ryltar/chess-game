package entities.players;

import entities.pieces.Pieces;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Player {
    List<Pieces> pieces = new ArrayList<Pieces>();
    boolean color;
}
