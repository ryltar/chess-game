package entities.pieces;

import entities.chess.ChessBoard;
import entities.chess.Coordinates;
import entities.tools.TransversalMethod;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Getter
@Setter
public class Pawn extends Pieces {

    private boolean isFirstShot;

    public Pawn(boolean color, int x, int y){
        super(color, x, y);
        super.setUnicode(TransversalMethod.valueOfPieces(color,this.getClass()));
        this.isFirstShot = true;
    }

    @Override
    public void move(String yParam, String xParam, ChessBoard chess){
        int y = TransversalMethod.translateCoord(yParam);
        int x = TransversalMethod.translateCoord(xParam);
        Coordinates currentCoord = new Coordinates(x,y);
        for(Coordinates coord : verifyAvailability(chess).getAllPawns()){
            if(coord.equals(currentCoord)){
                super.movePieces(x,y,chess);
                this.isFirstShot = false;
            }
        }
    };

    @Override
    public AvailablePawns verifyAvailability(ChessBoard chess){
        AvailablePawns availablePawns = availableAllShots();
        Iterator<Coordinates> iter = availablePawns.getStraightsAhead().iterator();
        while(iter.hasNext()){
            Coordinates coord = iter.next();
            if(chess.getChessBoard()[coord.getX()][coord.getY()] != null){
                iter.remove();
            }
        }
        iter = availablePawns.getDiagonals().iterator();
        while(iter.hasNext()){
            Coordinates coord = iter.next();
            if(chess.getChessBoard()[coord.getX()][coord.getY()] == null){
               iter.remove();
            }
        }
        availablePawns.getAllPawns().addAll(availablePawns.getDiagonals());
        availablePawns.getAllPawns().addAll(availablePawns.getStraightsAhead());
        return availablePawns;
    };


    @Override
    public AvailablePawns availableAllShots(){
        List<Coordinates> availableStraightAhead = new ArrayList<Coordinates>();
        List<Coordinates> availableDiagonals = new ArrayList<Coordinates>();
        if(super.isColor()){
            if(this.isFirstShot){
                availableStraightAhead.add(new Coordinates(super.getX()-2, super.getY()));
                availableStraightAhead.add(new Coordinates(super.getX()-1, super.getY()));
            }else if(super.getX() > 0){
                availableStraightAhead.add(new Coordinates(super.getX()-1, super.getY()));
                if(super.getY() > 0) availableDiagonals.add(new Coordinates(super.getX()-1, super.getY()-1));
                if(super.getY() < 7) availableDiagonals.add(new Coordinates(super.getX()-1, super.getY()+1));
            }
        }else {
            if(this.isFirstShot){
                availableStraightAhead.add(new Coordinates(super.getX()+2, super.getY()));
                availableStraightAhead.add(new Coordinates(super.getX()+1, super.getY()));
            }else if(super.getX() < 7){
                availableStraightAhead.add(new Coordinates(super.getX()+1, super.getY()));
                if(super.getY() > 0) availableDiagonals.add(new Coordinates(super.getX()+1, super.getY()-1));
                if(super.getY() < 7) availableDiagonals.add(new Coordinates(super.getX()+1, super.getY()+1));
            }
        }
        return new AvailablePawns(availableStraightAhead, availableDiagonals);
    };

}
