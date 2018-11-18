package entities.pieces;

import entities.chess.ChessBoard;
import entities.chess.Coordinates;
import entities.pieces.availables.AvailablePawns;
import entities.tools.TransversalMethod;
import lombok.Getter;
import lombok.Setter;
import java.util.Iterator;

@Getter
@Setter
public class Pawn extends Pieces {

    private boolean isFirstShot;

    public Pawn(boolean color, int x, int y, String name){
        super(color, new Coordinates(x,y), name);
        super.setUnicode(TransversalMethod.valueOfPieces(color,this.getClass()));
        this.isFirstShot = true;
    }

    @Override
    public AvailablePawns verifyAvailability(ChessBoard chess){
        AvailablePawns availablePawns = availableAllShots();
        Iterator<Coordinates> iter = availablePawns.getStraightsAhead().iterator();
        boolean frontMove;
        while(iter.hasNext()){
            Coordinates coordinates = iter.next();
            frontMove = false;
            if((this.isColor() && coordinates.getX() < this.getCoordinates().getX()) ||
                    (!this.isColor() && coordinates.getX() > this.getCoordinates().getX())){
                frontMove = true;
            }
            if(chess.getChessBoard()[coordinates.getX()][coordinates.getY()] != null || !frontMove){
                iter.remove();
            }
        }
        iter = availablePawns.getDiagonals().iterator();
        while(iter.hasNext()){
            Coordinates coordinates = iter.next();
            Pieces piece = chess.getChessBoard()[coordinates.getX()][coordinates.getY()];
            if(piece == null || piece.isColor() == super.isColor()){
               iter.remove();
            }
        }
        availablePawns.getAllPieces().addAll(availablePawns.getDiagonals());
        availablePawns.getAllPieces().addAll(availablePawns.getStraightsAhead());
        return availablePawns;
    };


    @Override
    public AvailablePawns availableAllShots(){
        AvailablePawns availablePawns = new AvailablePawns();

        if(this.isFirstShot) {
            availablePawns.getStraightsAhead().add(new Coordinates(super.getCoordinates().getX() - 2, super.getCoordinates().getY()));
            availablePawns.getStraightsAhead().add(new Coordinates(super.getCoordinates().getX() - 1, super.getCoordinates().getY()));
            availablePawns.getStraightsAhead().add(new Coordinates(super.getCoordinates().getX() + 2, super.getCoordinates().getY()));
            availablePawns.getStraightsAhead().add(new Coordinates(super.getCoordinates().getX() + 1, super.getCoordinates().getY()));
        }else{
            availablePawns.getStraightsAhead().add(new Coordinates(super.getCoordinates().getX()-1, super.getCoordinates().getY()));
            availablePawns.getDiagonals().add(new Coordinates(super.getCoordinates().getX()-1, super.getCoordinates().getY()-1));
            availablePawns.getDiagonals().add(new Coordinates(super.getCoordinates().getX()-1, super.getCoordinates().getY()+1));
            availablePawns.getDiagonals().add(new Coordinates(super.getCoordinates().getX()+1, super.getCoordinates().getY()-1));
            availablePawns.getDiagonals().add(new Coordinates(super.getCoordinates().getX()+1, super.getCoordinates().getY()+1));
            availablePawns.getStraightsAhead().add(new Coordinates(super.getCoordinates().getX()+1, super.getCoordinates().getY()));
        }

        return availablePawns;
    }

}
