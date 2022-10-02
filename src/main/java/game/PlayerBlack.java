package game;

import model.Piece;

import java.util.ArrayList;
import java.util.List;

public class PlayerBlack {
    private long id;
    private List<Piece> pieces= new ArrayList<>();
    private int countOfMoves=0;
    public PlayerBlack(long id){
        this.id= id;
        pieces.add(new Piece(-1, "&#9820;", 5));
        pieces.add(new Piece(-1, "&#9822;", 2));
        pieces.add(new Piece(-1, "&#9821;", 3));
        pieces.add(new Piece(-1, "&#9819;", 9));
        pieces.add(new Piece(-1, "&#9818;", 500));
        pieces.add(new Piece(-1, "&#9821;", 3));
        pieces.add(new Piece(-1, "&#9822;", 2));
        pieces.add(new Piece(-1, "&#9820;", 5));

        for(int i=1; i<=8; i++)
            pieces.add(new Piece(-1, "&#9823;", 1));
    }

    public List<Piece> getPieces() {
        return pieces;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getCountOfMoves() {
        return countOfMoves;
    }

    public void setCountOfMoves() {
        this.countOfMoves ++;
    }
}
