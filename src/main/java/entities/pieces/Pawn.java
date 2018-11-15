package entities.pieces;

import entities.chess.ChessBoard;
import entities.pieces.availables.Coordinates;
import entities.pieces.availables.AvailablePawns;
import entities.tools.TransversalMethod;
import lombok.Getter;
import lombok.Setter;

import java.util.Iterator;

@Getter
@Setter
public class Pawn extends Pieces {

    private boolean isFirstShot;

    public Pawn(boolean color, int x, int y){
        super(color, new Coordinates(x,y));
        super.setUnicode(TransversalMethod.valueOfPieces(color,this.getClass()));
        this.isFirstShot = true;
    }

    @Override
    public void move(String yParam, String xParam, ChessBoard chess){
        int y = TransversalMethod.translateCoord(yParam);
        int x = TransversalMethod.translateCoord(xParam);
        Coordinates currentCoordinates= new Coordinates(x,y);
        for(Coordinates coordinates : verifyAvailability(chess).getAllPawns()){
            if(coordinates.equals(currentCoordinates)){
                super.movePieces(coordinates,chess);
                this.isFirstShot = false;
            }
        }
    }

    @Override
    public AvailablePawns verifyAvailability(ChessBoard chess){
        AvailablePawns availablePawns = availableAllShots();
        Iterator<Coordinates> iter = availablePawns.getStraightsAhead().iterator();
        boolean frontMove;
        while(iter.hasNext()){
            Coordinates coord = iter.next();
            frontMove = false;
            if((this.isColor() && coord.getX() < this.getCoordinates().getX()) ||
                    (!this.isColor() && coord.getX() > this.getCoordinates().getX())){
                frontMove = true;
            }
            if(chess.getChessBoard()[coord.getX()][coord.getY()] != null || !frontMove){
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
        availablePawns.getAllPawns().addAll(availablePawns.getDiagonals());
        availablePawns.getAllPawns().addAll(availablePawns.getStraightsAhead());
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
