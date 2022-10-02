package possibilitys;

import model.Connection;
import model.Piece;
import model.Square;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class KingPossibility {
    public static List<String> kingPossibility(Connection connection, Square square, Piece piece) {
        List<String> ids = new ArrayList<>();
        //get row and column
        String[] s = square.getKey().split("_");
        int row = Integer.parseInt(s[0]);
        int column = Integer.parseInt(s[1]);
        //inialisation Places Of Knight
        int[] p1 = {row + 1, column };
        int[] p2 = {row + 1, column + 1};
        int[] p3 = {row + 1, column - 1};
        int[] p4 = {row , column + 1};
        int[] p5 = {row , column - 1};
        int[] p6 = {row - 1, column};
        int[] p7 = {row - 1, column + 1};
        int[] p8 = {row - 1, column - 1};
        List<int[]> listPlaceOfKnight = Arrays.asList(p1, p2, p3, p4, p5, p6, p7, p8);
        listPlaceOfKnight.forEach(couple -> {
            if (couple[0] <= 8 && couple[0] >= 1 && couple[1] <= 8 && couple[1] >= 1) {
                Square ijsquare = connection.getBoardChess().getSquare(Square.concatKey(couple[0], couple[1]));
                Piece ijpiece = connection.getBoardChess().getBoard().get(ijsquare);
                if ((!ijpiece.getKey().isEmpty() && ijpiece.getColor() * piece.getColor() < 0) || ijpiece.getKey().isEmpty())
                    ids.add(Square.concatKey(couple[0], couple[1]));
            }
        });
        return ids;
    }
}
