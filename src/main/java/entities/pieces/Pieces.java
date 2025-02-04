package entities.pieces;

import entities.chess.ChessBoard;
import entities.chess.Coordinates;
import entities.pieces.availables.AvailablePieces;
import entities.tools.TransversalMethod;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public abstract class Pieces {
    private boolean color;
    private String unicode;
    private Coordinates coordinates;
    private String name;

    Pieces(boolean color, Coordinates coordinates, String name) {
        this.color = color;
        this.coordinates = coordinates;
        this.name = name;
    }

    public String toString(){
        return unicode;
    }

    public abstract AvailablePieces verifyAvailability(ChessBoard chess);

    public void move(String yParam, String xParam, ChessBoard chess){
        int y = TransversalMethod.translateCoordinates(yParam);
        int x = TransversalMethod.translateCoordinates(xParam);
        Coordinates currentCoord = new Coordinates(x,y);
        for(Coordinates coord : verifyAvailability(chess).getAllPieces()){
            if(coord.equals(currentCoord)){
                this.movePieces(currentCoord,chess);
            }
        }
    };

    public abstract AvailablePieces  availableAllShots();

    public void movePieces(Coordinates coordinates, ChessBoard chess){
        chess.getChessBoard()[coordinates.getX()][coordinates.getY()] = chess.getChessBoard()[this.coordinates.getX()][this.coordinates.getY()];
        chess.getChessBoard()[this.coordinates.getX()][this.coordinates.getY()] = null;
        this.coordinates.setX(coordinates.getX());
        this.coordinates.setY(coordinates.getY());
    };

    public List<Coordinates> iterateOverEachDirectionAndVerify(List<Coordinates> availables, ChessBoard chess){
        List<Coordinates> tmp;
        for(Coordinates coordinates : availables){
            if(chess.getChessBoard()[coordinates.getX()][coordinates.getY()] != null){
                tmp = availables.subList(0,availables.indexOf(coordinates));
                if(chess.getChessBoard()[coordinates.getX()][coordinates.getY()].isColor() == this.isColor()) tmp.remove(coordinates);
                return tmp;
            }
        }
        return availables;
    }

}
