package entities.tools;

import java.util.HashMap;
import java.util.Map;

public class TransversalMethod {

    private static Map<String, Integer> translator = new HashMap<String, Integer>(){
        {
            put("A",0);
            put("B",1);
            put("C",2);
            put("D",3);
            put("E",4);
            put("F",5);
            put("G",6);
            put("H",7);
            put("1",7);
            put("2",6);
            put("3",5);
            put("4",4);
            put("5",3);
            put("6",2);
            put("7",1);
            put("8",0);
        }

    };

    /**
     * map a piece with the unicode associated
     *
     */
    public static String valueOfPieces(boolean color, Class pieces) throws IllegalArgumentException {
        for (UnicodeColorEnum value : UnicodeColorEnum.values()) {
            boolean colorEnum = value.isColor();
            Class piecesEnum = value.getPieces();
            if (colorEnum == color && pieces.getSimpleName().equals(piecesEnum.getSimpleName())) {
                return value.getUnicode();
            }
        }
        throw new IllegalArgumentException("There is no unicode character available for " + pieces.getSimpleName());
    }

    /**
     * method to translate input player to arrayList Coordinates
     *
     */
    public static int translateCoordinates(String coord) throws IllegalArgumentException{
        for(Map.Entry<String, Integer> entry : translator.entrySet()) {
            String key = entry.getKey();
            int value = entry.getValue();
            if(coord.toUpperCase().equals(key.toUpperCase())) return value;
        }
        throw new IllegalArgumentException("The coordinates are not on the chessboard! please try again");
    }

    /**
     * split input player
     *
     */
    public static String[] translateInputPlayer(String tmp) throws IllegalArgumentException{
        // TODO Problème sur le trim
        String[] elems = tmp.toUpperCase().replaceAll("\\s", "").split(",");
        if(elems.length != 1){
            return elems;
        }else{
            throw new IllegalArgumentException("Plea");
        }
    }

}
