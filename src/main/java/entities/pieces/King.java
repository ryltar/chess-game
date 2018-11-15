package entities.pieces;

import entities.chess.ChessBoard;
import entities.pieces.availables.Coordinates;
import entities.pieces.availables.AvailableKings;
import entities.tools.TransversalMethod;
import lombok.Getter;
import lombok.Setter;

import java.util.Iterator;

@Getter
@Setter
public class King extends Pieces {

    public King(boolean color, int x, int y){
        super(color, new Coordinates(x,y));
        super.setUnicode(TransversalMethod.valueOfPieces(color,this.getClass()));
    }

    @Override
    public void move(String yParam, String xParam, ChessBoard chess){
        int y = TransversalMethod.translateCoord(yParam);
        int x = TransversalMethod.translateCoord(xParam);
        Coordinates currentCoordinates = new Coordinates(x,y);
        for(Coordinates coordinates : verifyAvailability(chess).getAvailableKings()){
            if(coordinates.equals(currentCoordinates)){
                super.movePieces(coordinates,chess);
            }
        }
    }

    @Override
    public AvailableKings availableAllShots(){
        AvailableKings availableKings = new AvailableKings();
        availableKings.getAvailableKings().add(new Coordinates(super.getCoordinates().getX()+1, super.getCoordinates().getY()));
        availableKings.getAvailableKings().add(new Coordinates(super.getCoordinates().getX()-1, super.getCoordinates().getY()));
        availableKings.getAvailableKings().add(new Coordinates(super.getCoordinates().getX()+1, super.getCoordinates().getY()-1));
        availableKings.getAvailableKings().add(new Coordinates(super.getCoordinates().getX()-1, super.getCoordinates().getY()-1));
        availableKings.getAvailableKings().add(new Coordinates(super.getCoordinates().getX(), super.getCoordinates().getY()-1));
        availableKings.getAvailableKings().add(new Coordinates(super.getCoordinates().getX()+1, super.getCoordinates().getY()+1));
        availableKings.getAvailableKings().add(new Coordinates(super.getCoordinates().getX()-1, super.getCoordinates().getY()+1));
        availableKings.getAvailableKings().add(new Coordinates(super.getCoordinates().getX(), super.getCoordinates().getY()+1));
        return availableKings;
    }

    @Override
    public  AvailableKings verifyAvailability(ChessBoard chess){
        AvailableKings availableKings = availableAllShots();
        Iterator<Coordinates> iter = availableKings.getAvailableKings().iterator();
        while(iter.hasNext()){
            Coordinates coordinates = iter.next();
            Pieces piece = chess.getChessBoard()[coordinates.getX()][coordinates.getY()];
            if(piece != null && piece.isColor() == super.isColor()){
                iter.remove();
            }
        }
        return availableKings;
    }


}
