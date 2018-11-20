package entities.chess;

import entities.pieces.King;
import entities.pieces.Pieces;
import entities.players.Player;
import entities.tools.TransversalMethod;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class GameManager {
    boolean finished = false;
    ChessBoard chessBoard = new ChessBoard();
    Player playerBlack = new Player(chessBoard.getBlackPieces(), false);
    Player playerWhite = new Player(chessBoard.getWhitePieces(), true);
    List<Player> players = new ArrayList<Player>(){
        {
            add(playerBlack);
            add(playerWhite);
        }
    };

    /**
     * function that allows us to ask to choose a pawn
     */
    private String[] askPawn(Player player){
        String color = (player.isColor()) ? "WHITE" : "BLACK";
        Scanner sc = new Scanner(System.in);
        System.out.print(color+" player: enter a move");
        String line = sc.nextLine();
        return TransversalMethod.translateInputPlayer(line);
    }

    /**
     * this method contains all we need for a round of play
     */
    public void playerPlay(Player player, String[] input){
        Optional<Pieces> pieces;
        pieces = player.isColor()? this.playerWhite.getPieces().stream().filter(x -> x.getName().equals(input[0])).findFirst() :
                this.playerBlack.getPieces().stream().filter(x -> x.getName().equals(input[0])).findFirst();
        Pieces piece;
        if(pieces.isPresent()){
            piece = pieces.get();
            piece.move(String.valueOf(input[1].charAt(0)), String.valueOf(input[1].charAt(1)), chessBoard);
        }else{
            System.err.print("Try again, this piece doesn't exist on the chessBoard");

            playerPlay(player, askPawn(player));
            return;
        }
        Optional<Pieces> kingOpt = player.getKing();
        boolean chess = false;
        if(kingOpt.isPresent()){
            chess = ((King)kingOpt.get()).canBeTaken(chessBoard);
        }
        Coordinates saveCoordinates = null;
        try{
            saveCoordinates = piece.getCoordinates().clone();
        }catch(CloneNotSupportedException e){
            e.printStackTrace();
        }
        if (chess) piece.movePieces(saveCoordinates, chessBoard);
    }

    /**
     * Game loop
     */
    public void gameLoop(){
        while(!finished){
            Collections.reverse(players);
            this.getChessBoard().printChessBoard();
            this.playerPlay(players.get(0), askPawn(players.get(0)));
        }
    }

    /**
     * This method calls the game loop
     */
    public void main(){
        this.gameLoop();
    }
}
