package possibilitys;

import model.Connection;
import model.Piece;
import model.Square;

import java.util.ArrayList;
import java.util.List;

public class BishopPossibility {
    public static List<String> bishopPossibility(Connection connection, Square square, Piece piece) {
        List<String> ids = new ArrayList<>();
        //get row and column
        String[] s = square.getKey().split("_");
        int row = Integer.parseInt(s[0]);
        int column = Integer.parseInt(s[1]);

        Square ijsquare;
        Piece ijpiece;
        //test1 below right the piece
        int i= row +1;
        int j= column +1;
        while (i<=8 && j<=8){
            ijsquare= connection.getBoardChess().getSquare(Square.concatKey(i, j));
            ijpiece= connection.getBoardChess().getBoard().get(ijsquare);
            if(!ijpiece.getKey().isEmpty() && ijpiece.getColor()*piece.getColor()>0)
                break;
            if(!ijpiece.getKey().isEmpty() && ijpiece.getColor()*piece.getColor()<0){
                ids.add(Square.concatKey(i, j));
                break;
            }
            ids.add(Square.concatKey(i, j));
            i+=1;
            j+=1;
        }
        //test2 below left the piece
        i= row +1;
        j= column -1;
        while (i<=8 && j>=1){
            ijsquare= connection.getBoardChess().getSquare(Square.concatKey(i, j));
            ijpiece= connection.getBoardChess().getBoard().get(ijsquare);
            if(!ijpiece.getKey().isEmpty() && ijpiece.getColor()*piece.getColor()>0)
                break;
            if(!ijpiece.getKey().isEmpty() && ijpiece.getColor()*piece.getColor()<0){
                ids.add(Square.concatKey(i, j));
                break;
            }
            ids.add(Square.concatKey(i, j));
            i+=1;
            j-=1;
        }
        //test3 above right the piece
        i= row -1;
        j= column +1;
        while (i>=1 && j<=8){
            ijsquare= connection.getBoardChess().getSquare(Square.concatKey(i, j));
            ijpiece= connection.getBoardChess().getBoard().get(ijsquare);
            if(!ijpiece.getKey().isEmpty() && ijpiece.getColor()*piece.getColor()>0)
                break;
            if(!ijpiece.getKey().isEmpty() && ijpiece.getColor()*piece.getColor()<0){
                ids.add(Square.concatKey(i, j));
                break;
            }
            ids.add(Square.concatKey(i, j));
            i-=1;
            j+=1;
        }
        //test4 above left the piece
        i= row -1;
        j= column -1;
        while (i>=1 && j>=1){
            ijsquare= connection.getBoardChess().getSquare(Square.concatKey(i, j));
            ijpiece= connection.getBoardChess().getBoard().get(ijsquare);
            if(!ijpiece.getKey().isEmpty() && ijpiece.getColor()*piece.getColor()>0)
                break;
            if(!ijpiece.getKey().isEmpty() && ijpiece.getColor()*piece.getColor()<0){
                ids.add(Square.concatKey(i, j));
                break;
            }
            ids.add(Square.concatKey(i, j));
            i-=1;
            j-=1;
        }
        return ids;
    }
}
