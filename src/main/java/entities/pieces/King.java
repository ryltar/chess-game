package entities.pieces;

import entities.chess.ChessBoard;
import entities.chess.Coordinates;
import entities.pieces.availables.AvailableKings;
import entities.tools.TransversalMethod;
import lombok.Getter;
import lombok.Setter;

import java.util.Iterator;
import java.util.List;

@Getter
@Setter
public class King extends Pieces {

    public King(boolean color, int x, int y, String name){
        super(color, new Coordinates(x,y), name);
        super.setUnicode(TransversalMethod.valueOfPieces(color,this.getClass()));
    }

    @Override
    public AvailableKings availableAllShots(){
        AvailableKings availableKings = new AvailableKings();
        availableKings.getAllPieces().add(new Coordinates(super.getCoordinates().getX()+1, super.getCoordinates().getY()));
        availableKings.getAllPieces().add(new Coordinates(super.getCoordinates().getX()-1, super.getCoordinates().getY()));
        availableKings.getAllPieces().add(new Coordinates(super.getCoordinates().getX()+1, super.getCoordinates().getY()-1));
        availableKings.getAllPieces().add(new Coordinates(super.getCoordinates().getX()-1, super.getCoordinates().getY()-1));
        availableKings.getAllPieces().add(new Coordinates(super.getCoordinates().getX(), super.getCoordinates().getY()-1));
        availableKings.getAllPieces().add(new Coordinates(super.getCoordinates().getX()+1, super.getCoordinates().getY()+1));
        availableKings.getAllPieces().add(new Coordinates(super.getCoordinates().getX()-1, super.getCoordinates().getY()+1));
        availableKings.getAllPieces().add(new Coordinates(super.getCoordinates().getX(), super.getCoordinates().getY()+1));
        return availableKings;
    }

    @Override
    public  AvailableKings verifyAvailability(ChessBoard chess){
        AvailableKings availableKings = availableAllShots();
        Iterator<Coordinates> iter = availableKings.getAllPieces().iterator();
        while(iter.hasNext()){
            Coordinates coordinates = iter.next();
            Pieces piece = chess.getChessBoard()[coordinates.getX()][coordinates.getY()];
            if(piece != null && piece.isColor() == super.isColor()){
                iter.remove();
            }
        }
        return availableKings;
    }

    public boolean canBeTaken(ChessBoard board){
        List<Pieces> myPieces = (super.isColor()) ? board.getWhitePieces() : board.getBlackPieces();
        for(Pieces pieces: myPieces){
            if(pieces.equals(this)){
                return pieces.verifyAvailability(board).getAllPieces().contains(this.getCoordinates());
            }
        }
        return false;
    }
}
