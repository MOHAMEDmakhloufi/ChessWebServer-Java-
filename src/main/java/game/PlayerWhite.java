package game;

import model.Piece;

import java.util.ArrayList;
import java.util.List;

public class PlayerWhite {
    private long id;
    private List<Piece> pieces= new ArrayList<>();
    private int countOfMoves=0;
    PlayerWhite(long id){
        this.id= id;

        pieces.add(new Piece(1, "&#9814;", 5));
        pieces.add(new Piece(1, "&#9816;", 2));
        pieces.add(new Piece(1, "&#9815;", 3));
        pieces.add(new Piece(1, "&#9813;", 9));
        pieces.add(new Piece(1, "&#9812;", 500));
        pieces.add(new Piece(1, "&#9815;", 3));
        pieces.add(new Piece(1, "&#9816;", 2));
        pieces.add(new Piece(1, "&#9814;", 5));

        for(int i=1; i<=8; i++)
            pieces.add(new Piece(1, "&#9817;", 1));
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

    public void setPieces(List<Piece> pieces) {
        this.pieces = pieces;
    }

    public int getCountOfMoves() {
        return countOfMoves;
    }

    public void setCountOfMoves() {
        this.countOfMoves ++;
    }
}
