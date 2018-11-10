package entities.pieces;

import entities.chess.ChessBoard;
import entities.chess.Coordinates;
import entities.tools.TransversalMethod;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

@Getter
@Setter
public class Rook extends Pieces {

    public Rook(boolean color, int x, int y){
        super(color, x, y);
        super.setUnicode(TransversalMethod.valueOfPieces(color,this.getClass()));
    }

    @Override
    public void move(String yParam, String xParam, ChessBoard chess){
        int y = TransversalMethod.translateCoord(yParam);
        int x = TransversalMethod.translateCoord(xParam);
        Coordinates currentCoord = new Coordinates(x,y);
        for(Coordinates coord : verifyAvailability(chess).getAllRooks()){
            if(coord.equals(currentCoord)){
                super.movePieces(x,y,chess);
            }
        }
    };

    @Override
    public AvailableRooks availableAllShots(){
        List<Coordinates> availableXMoves = new ArrayList<Coordinates>();
        List<Coordinates> availableYMoves = new ArrayList<Coordinates>();

        for(int i = 0; i < 8; i++){
            if(super.getY() != i){
                availableYMoves.add(new Coordinates(super.getX(),i));
            }
            if(super.getX() != i){
                availableXMoves.add(new Coordinates(i,super.getY()));
            }
        }
        return new AvailableRooks(availableXMoves, availableYMoves);
    };

    @Override
    public  AvailableRooks verifyAvailability(ChessBoard chess){
        AvailableRooks availableRooks = availableAllShots();
        List<Coordinates> tmp = new ArrayList<Coordinates>();
        List<Coordinates> availableXMoves = new ArrayList<Coordinates>(availableRooks.getAvailableX());
        List<Coordinates> availableYMoves = new ArrayList<Coordinates>(availableRooks.getAvailableY());

        for(Coordinates coord : availableRooks.getAvailableX()){
            if(chess.getChessBoard()[coord.getX()][coord.getY()] == this) tmp.clear();
            if(chess.getChessBoard()[coord.getX()][coord.getY()] != null){
                tmp.add(coord);
                availableXMoves.removeAll(tmp);
            }else{
                tmp.add(coord);
            }
        }

        tmp.clear();

        for(Coordinates coord : availableRooks.getAvailableY()){
            if(chess.getChessBoard()[coord.getX()][coord.getY()] == this) tmp.clear();
            if(chess.getChessBoard()[coord.getX()][coord.getY()] != null){
                tmp.add(coord);
                availableYMoves.removeAll(tmp);
            }else{
                tmp.add(coord);
            }
        }

        availableRooks.getAllRooks().addAll(availableXMoves);
        availableRooks.getAllRooks().addAll(availableYMoves);

        return availableRooks;

    }


}
