package possibilitys;

import model.Connection;
import model.Piece;
import model.Square;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

public class PawnPossibility {
    public static class TwoValue {
        private int x;
        private int y;

        TwoValue(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }
    }

    public static Predicate<Integer> predicateBlack = value -> value >= 1;
    public static Predicate<Integer> predicateWhite = value -> value <= 8;

    public static Function<TwoValue, Integer> functionBlack = twoValue -> twoValue.getX() - twoValue.getY();
    public static Function<TwoValue, Integer> functionWhite = twoValue -> twoValue.getX() + twoValue.getY();

    public static List<String> pawnPossibility(Connection connection, Square square, Piece piece, Predicate<Integer> predicate, Function<TwoValue, Integer> function, int testRow) {
        List<String> ids = new ArrayList<>();
        //get row and column
        String[] s = square.getKey().split("_");
        int row = Integer.parseInt(s[0]);
        int column = Integer.parseInt(s[1]);


        int j;

        if (row == testRow)
            for (int i = 1; i <= 2; i++) {
                j = function.apply(new TwoValue(row, i));
                if (!connection.getBoardChess().getBoard().get(new Square(Square.concatKey(j, column))).getKey().isEmpty())
                    break;
                ids.add(Square.concatKey(j, column));
            }
            //test other row
        else {
            j = function.apply(new TwoValue(row, 1));
            if (predicate.test(j) && connection.getBoardChess().getBoard().get(new Square(Square.concatKey(j, column))).getKey().equals("") )
                ids.add(Square.concatKey(j, column));
        }
        //test atack
        int i = function.apply(new TwoValue(row, 1));
        j = column + 1;
        if (predicate.test(i) && j <= 8) {
            Piece p = connection.getBoardChess().getBoard().get(new Square(Square.concatKey(i, j)));
            if (!p.getKey().equals("") && p.getColor() == -piece.getColor()) {
                ids.add(Square.concatKey(i, j));
            }
        }
        j = column - 1;
        if (predicate.test(i) && j >= 1) {
            Piece p = connection.getBoardChess().getBoard().get(new Square(Square.concatKey(i, j)));
            if (!p.getKey().equals("") && p.getColor() == -piece.getColor()) {
                ids.add(Square.concatKey(i, j));
            }
        }

        return ids;
    }

}
