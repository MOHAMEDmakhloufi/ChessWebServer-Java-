package possibilitys;

import game.PlayerBlack;
import model.Connection;
import model.Piece;
import model.Square;

import java.util.*;
import java.util.stream.Collectors;


public class Possibilty {
    public static  List<String> getPossibiltyWithoutTestIsCheck(Connection connection, Square square, Piece piece) {
        //isPawan
        if(piece.getPower() == 1){
            if (piece.getColor() == 1)
                return PawnPossibility.pawnPossibility(connection, square, piece, PawnPossibility.predicateWhite, PawnPossibility.functionWhite, 2);

            return PawnPossibility.pawnPossibility(connection, square, piece, PawnPossibility.predicateBlack, PawnPossibility.functionBlack, 7);
        }
        else if(piece.getPower() == 2){
            return KnightPossibility.knightPossibility(connection, square, piece);
        }
        else if (piece.getPower() ==3){
            return BishopPossibility.bishopPossibility(connection, square, piece);
        }
        else if(piece.getPower() == 5){
            return RookPossibility.rookPossibility(connection, square, piece);
        }
        else if (piece.getPower() ==9){
            List<String> idsQueen= RookPossibility.rookPossibility(connection, square, piece);
            idsQueen.addAll(BishopPossibility.bishopPossibility(connection, square, piece));
            return idsQueen;
        }
        else if(piece.getPower() == 500){
            return KingPossibility.kingPossibility(connection, square, piece);
        }
        return new ArrayList<>();
    }
    public static List<String> getPossibilty(Connection connection, Square square, Piece piece) {
        List<String> ids = getPossibiltyWithoutTestIsCheck(connection, square, piece);

        List<String> copyList=new ArrayList<>(ids);
        for(String path : copyList){
            if(riskInCheck(connection, square, piece, path)){
                ids.remove(path);

            }

        }
        return ids;
    }

    public static boolean riskInCheck(Connection connection,Square squareFrom, Piece pieceFrom, String path){
        boolean test=false;
        //get square and piece
        Square squarePath= connection.getBoardChess().getSquare(path);
        Piece piecePath= connection.getBoardChess().getBoard().get(squarePath);
        //fake move
        connection.getBoardChess().getBoard().put(squarePath, pieceFrom);
        connection.getBoardChess().getBoard().put(squareFrom, new Piece());
        //test isCheck
        test= isCheck(connection, pieceFrom.getColor());
        //resume board
        connection.getBoardChess().getBoard().put(squarePath, piecePath);
        connection.getBoardChess().getBoard().put(squareFrom, pieceFrom);
        return test;
    }
    public static boolean isCheck(Connection connection,int color){

       //get all pieces of inverse
        Set<Map.Entry<Square, Piece>> entrySet=connection.getBoardChess().getBoard().entrySet().stream().filter(entry -> !entry.getValue().getKey().isEmpty() && entry.getValue().getColor()==-color).collect(Collectors.toSet());
        //get king  player
        Optional<Square> optionalSquare=connection.getBoardChess().getBoard().entrySet().stream().filter(entry -> !entry.getValue().getKey().isEmpty() && entry.getValue().getColor()==color && entry.getValue().getPower()==500).map(entry -> entry.getKey()).findFirst();
        if(optionalSquare.isPresent()){
            String idKing= optionalSquare.get().getKey();

            for (Map.Entry<Square, Piece> entry: entrySet){
                if(getPossibiltyWithoutTestIsCheck(connection, entry.getKey(), entry.getValue()).contains(idKing))
                    return true;
            }
        }
        return false;
    }
    //finish game
    public static boolean finishGame(Connection connection,int color){

        //get all pieces of inverse
        Set<Map.Entry<Square, Piece>> entrySet=connection.getBoardChess().getBoard().entrySet().stream().filter(entry -> !entry.getValue().getKey().isEmpty() && entry.getValue().getColor()==color).collect(Collectors.toSet());
        //test all piece if can move or not
        for (Map.Entry<Square, Piece> entry: entrySet){
            if(!getPossibilty(connection, entry.getKey(), entry.getValue()).isEmpty())
                return false;
        }
        return true;


    }
}
