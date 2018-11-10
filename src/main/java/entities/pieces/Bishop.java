package entities.pieces;

import entities.chess.ChessBoard;
import entities.chess.Coordinates;
import entities.tools.TransversalMethod;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class Bishop extends Pieces {

    public Bishop(boolean color, int x, int y){
        super(color, x, y);
        super.setUnicode(TransversalMethod.valueOfPieces(color,this.getClass()));
    }

    @Override
    public void move(String yParam, String xParam, ChessBoard chess){
        int y = TransversalMethod.translateCoord(yParam);
        int x = TransversalMethod.translateCoord(xParam);
        Coordinates currentCoord = new Coordinates(x,y);
        for(Coordinates coord : verifyAvailability(chess).getAllBishops()){
            if(coord.equals(currentCoord)){
                super.movePieces(x,y,chess);
            }
        }
    };

    @Override
    public AvailableBishops availableAllShots(){
        List<Coordinates> availableLowLeftDiagonals = new ArrayList<Coordinates>();
        List<Coordinates> availableHighLeftDiagonals = new ArrayList<Coordinates>();
        List<Coordinates> availableLowRightDiagonals = new ArrayList<Coordinates>();
        List<Coordinates> availableHighRightDiagonals = new ArrayList<Coordinates>();

        int tmpX = super.getX();
        int tmpY = super.getY();
        while(tmpX != 0 && tmpY != 0 ){
            availableHighLeftDiagonals.add(new Coordinates(--tmpX,--tmpY));
        }
        tmpX = super.getX();
        tmpY = super.getY();
        while(tmpX != 7 && tmpY != 7 ){
            availableLowRightDiagonals.add(new Coordinates(++tmpX,++tmpY));
        }
        tmpX = super.getX();
        tmpY = super.getY();
        while(tmpX != 7 && tmpY != 0 ){
            availableLowLeftDiagonals.add(new Coordinates(++tmpX,--tmpY));

        }
        tmpX = super.getX();
        tmpY = super.getY();
        while(tmpX != 0 && tmpY != 7 ){
            availableHighRightDiagonals.add(new Coordinates(--tmpX,++tmpY));

        }
        return new AvailableBishops(availableLowRightDiagonals, availableHighRightDiagonals, availableLowLeftDiagonals, availableHighLeftDiagonals);
    };

    @Override
    public  AvailableBishops verifyAvailability(ChessBoard chess){
        AvailableBishops availableBishops = availableAllShots();
        List<Coordinates> tmp = new ArrayList<Coordinates>();
        List<Coordinates> availableLowLeftDiagonals = new ArrayList<Coordinates>(availableBishops.getAvailableLowLeftDiagonal());
        List<Coordinates> availableHighLeftDiagonals = new ArrayList<Coordinates>(availableBishops.getAvailableHighLeftDiagonal());
        List<Coordinates> availableLowRightDiagonals = new ArrayList<Coordinates>(availableBishops.getAvailableLowRightDiagonal());
        List<Coordinates> availableHighRightDiagonals = new ArrayList<Coordinates>(availableAllShots().getAvailableHighRightDiagonal());

        for(Coordinates coord : availableBishops.getAvailableLowLeftDiagonal()){
            if(chess.getChessBoard()[coord.getX()][coord.getY()] != null){
                availableLowLeftDiagonals = availableBishops.getAvailableLowLeftDiagonal().subList(0,availableBishops.getAvailableLowLeftDiagonal().indexOf(coord));
                availableLowLeftDiagonals.remove(coord);
            }
        }
        for(Coordinates coord : availableBishops.getAvailableHighLeftDiagonal()){
            if(chess.getChessBoard()[coord.getX()][coord.getY()] != null){
                availableHighLeftDiagonals = availableBishops.getAvailableHighLeftDiagonal().subList(0,availableBishops.getAvailableHighLeftDiagonal().indexOf(coord));
                availableHighLeftDiagonals.remove(coord);
            }
        }
        for(Coordinates coord : availableBishops.getAvailableLowRightDiagonal()){
            if(chess.getChessBoard()[coord.getX()][coord.getY()] != null){
                availableLowRightDiagonals = availableBishops.getAvailableHighLeftDiagonal().subList(0,availableBishops.getAvailableHighLeftDiagonal().indexOf(coord));
                availableLowRightDiagonals.remove(coord);
            }
        }
        for(Coordinates coord : availableBishops.getAvailableHighRightDiagonal()){
            if(chess.getChessBoard()[coord.getX()][coord.getY()] != null){
                availableHighRightDiagonals = availableBishops.getAvailableHighRightDiagonal().subList(0,availableBishops.getAvailableHighRightDiagonal().indexOf(coord));
                availableHighRightDiagonals.remove(coord);
            }
        }

        availableBishops.getAllBishops().addAll(availableLowLeftDiagonals);
        availableBishops.getAllBishops().addAll(availableHighLeftDiagonals);
        availableBishops.getAllBishops().addAll(availableLowRightDiagonals);
        availableBishops.getAllBishops().addAll(availableHighRightDiagonals);

        return availableBishops;
    }

}
