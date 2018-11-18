package entities.players;

import entities.pieces.King;
import entities.pieces.Knight;
import entities.pieces.Pieces;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Player {
    List<Pieces> pieces = new ArrayList<>();
    boolean color;

    public Optional<Pieces> getKing(){
        return this.pieces.stream().filter(x -> x.getClass() == King.class).findFirst();
    }
}
