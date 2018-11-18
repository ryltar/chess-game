package entities.pieces;

import entities.chess.ChessBoard;
import entities.chess.Coordinates;
import entities.pieces.availables.AvailableKnights;
import entities.tools.TransversalMethod;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class Knight extends Pieces {

    public Knight(boolean color, int x, int y, String name){
        super(color, new Coordinates(x,y), name);
        super.setUnicode(TransversalMethod.valueOfPieces(color,this.getClass()));
    }

    @Override
    public void move(String yParam, String xParam, ChessBoard chess){
        int y = TransversalMethod.translateCoordinates(yParam);
        int x = TransversalMethod.translateCoordinates(xParam);
        Coordinates currentCoord = new Coordinates(x,y);
        for(Coordinates coord : verifyAvailability(chess).getAllPieces()){
            if(coord.equals(currentCoord)){
                super.movePieces(currentCoord,chess);
            }
        }
    };

    @Override
    public AvailableKnights availableAllShots(){
        AvailableKnights availableKnights = new AvailableKnights();
        availableKnights.getAllPieces().add(new Coordinates(super.getCoordinates().getX()+2,super.getCoordinates().getY()+1));
        availableKnights.getAllPieces().add(new Coordinates(super.getCoordinates().getX()+2,super.getCoordinates().getY()-1));
        availableKnights.getAllPieces().add(new Coordinates(super.getCoordinates().getX()-2,super.getCoordinates().getY()+1));
        availableKnights.getAllPieces().add(new Coordinates(super.getCoordinates().getX()-2,super.getCoordinates().getY()-1));
        availableKnights.getAllPieces().add(new Coordinates(super.getCoordinates().getX()-1,super.getCoordinates().getY()+2));
        availableKnights.getAllPieces().add(new Coordinates(super.getCoordinates().getX()+1,super.getCoordinates().getY()+2));
        availableKnights.getAllPieces().add(new Coordinates(super.getCoordinates().getX()-1,super.getCoordinates().getY()-2));
        availableKnights.getAllPieces().add(new Coordinates(super.getCoordinates().getX()-1,super.getCoordinates().getY()-2));
        return availableKnights;
    }

    @Override
    public AvailableKnights verifyAvailability(ChessBoard chess){
        AvailableKnights availableKnights = availableAllShots();
        List<Coordinates> coordinatesList = new ArrayList<Coordinates>(availableKnights.getAllPieces());
        for(Coordinates coordinates: availableKnights.getAllPieces()){
            Pieces currentPiece = chess.getChessBoard()[coordinates.getX()][coordinates.getY()];
            if(currentPiece != null && currentPiece.isColor() == super.isColor()){
                coordinatesList.remove(coordinates);
            }
        }
        availableKnights.setAllPieces(coordinatesList);
        return availableKnights;
    }

}
