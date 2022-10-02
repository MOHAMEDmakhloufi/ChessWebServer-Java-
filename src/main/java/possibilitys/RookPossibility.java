package possibilitys;

import model.Connection;
import model.Piece;
import model.Square;

import java.util.ArrayList;
import java.util.List;

public class RookPossibility {
    public static List<String> rookPossibility(Connection connection, Square square, Piece piece){
        List<String> ids = new ArrayList<>();

        //get row and column
        String[] s = square.getKey().split("_");
        int row = Integer.parseInt(s[0]);
        int column = Integer.parseInt(s[1]);
        Square ijsquare;
        Piece ijpiece;
        //test2 next to the piece
        int j= column +1;
        while(j<=8){
            ijsquare= connection.getBoardChess().getSquare(Square.concatKey(row, j));
            ijpiece= connection.getBoardChess().getBoard().get(ijsquare);
            if(!ijpiece.getKey().isEmpty() && ijpiece.getColor()*piece.getColor()>0)
                break;
            if(!ijpiece.getKey().isEmpty() && ijpiece.getColor()*piece.getColor()<0){
                ids.add(Square.concatKey(row, j));
                break;
            }
            ids.add(Square.concatKey(row, j));
            j+=1;
        }
        //test1 next to the piece
        j= column-1;
        while(j>=1){
            ijsquare= connection.getBoardChess().getSquare(Square.concatKey(row, j));
            ijpiece= connection.getBoardChess().getBoard().get(ijsquare);
            if(!ijpiece.getKey().isEmpty() && ijpiece.getColor()*piece.getColor()>0)
                break;
            if(!ijpiece.getKey().isEmpty() && ijpiece.getColor()*piece.getColor()<0){
                ids.add(Square.concatKey(row, j));
                break;
            }
            ids.add(Square.concatKey(row, j));
            j-=1;
        }
        //test below the piece
        int i= row +1;
        while(i<=8){
            ijsquare= connection.getBoardChess().getSquare(Square.concatKey(i, column));
            ijpiece= connection.getBoardChess().getBoard().get(ijsquare);
            if(!ijpiece.getKey().isEmpty() && ijpiece.getColor()*piece.getColor()>0)
                break;
            if(!ijpiece.getKey().isEmpty() && ijpiece.getColor()*piece.getColor()<0){
                ids.add(Square.concatKey(i, column));
                break;
            }
            ids.add(Square.concatKey(i, column));
            i+=1;
        }
        //test above the piece
        i= row-1;
        while(i>=1){
            ijsquare= connection.getBoardChess().getSquare(Square.concatKey(i, column));
            ijpiece= connection.getBoardChess().getBoard().get(ijsquare);
            if(!ijpiece.getKey().isEmpty() && ijpiece.getColor()*piece.getColor()>0)
                break;
            if(!ijpiece.getKey().isEmpty() && ijpiece.getColor()*piece.getColor()<0){
                ids.add(Square.concatKey(i, column));
                break;
            }
            ids.add(Square.concatKey(i, column));
            i-=1;
        }
        return ids;
    }
}
