package entities.pieces;

import entities.chess.ChessBoard;
import entities.pieces.availables.Coordinates;
import entities.pieces.availables.AvailableKnights;
import entities.tools.TransversalMethod;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class Knight extends Pieces {

    public Knight(boolean color, int x, int y){
        super(color, new Coordinates(x,y));
        super.setUnicode(TransversalMethod.valueOfPieces(color,this.getClass()));
    }

    @Override
    public void move(String yParam, String xParam, ChessBoard chess){
        int y = TransversalMethod.translateCoord(yParam);
        int x = TransversalMethod.translateCoord(xParam);
        Coordinates currentCoord = new Coordinates(x,y);
        for(Coordinates coord : verifyAvailability(chess).getAvailableKnights()){
            if(coord.equals(currentCoord)){
                super.movePieces(currentCoord,chess);
            }
        }
    };

    @Override
    public AvailableKnights availableAllShots(){
        AvailableKnights availableKnights = new AvailableKnights();
        availableKnights.getAvailableKnights().add(new Coordinates(super.getCoordinates().getX()+2,super.getCoordinates().getY()+1));
        availableKnights.getAvailableKnights().add(new Coordinates(super.getCoordinates().getX()+2,super.getCoordinates().getY()-1));
        availableKnights.getAvailableKnights().add(new Coordinates(super.getCoordinates().getX()-2,super.getCoordinates().getY()+1));
        availableKnights.getAvailableKnights().add(new Coordinates(super.getCoordinates().getX()-2,super.getCoordinates().getY()-1));
        availableKnights.getAvailableKnights().add(new Coordinates(super.getCoordinates().getX()-1,super.getCoordinates().getY()+2));
        availableKnights.getAvailableKnights().add(new Coordinates(super.getCoordinates().getX()+1,super.getCoordinates().getY()+2));
        availableKnights.getAvailableKnights().add(new Coordinates(super.getCoordinates().getX()-1,super.getCoordinates().getY()-2));
        availableKnights.getAvailableKnights().add(new Coordinates(super.getCoordinates().getX()-1,super.getCoordinates().getY()-2));
        return availableKnights;
    }

    @Override
    public  AvailableKnights verifyAvailability(ChessBoard chess){
        AvailableKnights availableKnights = availableAllShots();
        List<Coordinates> coordinatesList = new ArrayList<Coordinates>(availableKnights.getAvailableKnights());
        for(Coordinates coordinates: availableKnights.getAvailableKnights()){
            Pieces currentPiece = chess.getChessBoard()[coordinates.getX()][coordinates.getY()];
            if(currentPiece != null && currentPiece.isColor() == super.isColor()){
                coordinatesList.remove(coordinates);
            }
        }
        availableKnights.setAvailableKnights(coordinatesList);
        return availableKnights;
    }

}
