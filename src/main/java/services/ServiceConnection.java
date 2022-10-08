package services;

import game.PlayerBlack;
import game.PlayerWhite;
import html.CodeHtml;
import model.Connection;
import model.Piece;
import model.Square;
import possibilitys.Possibilty;

import java.util.*;
import java.util.stream.Collectors;

public class ServiceConnection {
    private static long uniqueId=0;
    private static List<Connection> list= new ArrayList<>();
    public  static  String reponseForConnection(String req) throws Exception{

        List<String> champs= Arrays.asList(req.split("/"));

        if(req.contains("create")){
            return createConnection();

        }else if(req.contains("join")){
            return joinConnection(champs);

        }else if(req.contains("id-")&&req.contains("connection")){
            return connectionCompleted( champs);
        }else if(req.contains("click")){
            return clickEvent(champs);
        }else if(req.contains("move")){
            return moveEvent(champs);
        }else if(req.contains("isYourTurn")){
            return "{\"turn\": "+isYourTurn(champs)+"}";
        }
        else {
            return  CodeHtml.getFinalHtmlCode("bodyMenu", CodeHtml.getMenuHtmlCode(), CodeHtml.getScriptCode());
        }

    }
    //create connection
    public static String createConnection(){
        String code = CodeHtml.generateCode();
        Connection c= new Connection(code);
        list.add(c);
        return  CodeHtml.getFinalHtmlCode("bodyMenu", CodeHtml.getStepConnection(code, c.getPortC().getId()));
    }
    public static String connectionCompleted(List<String> champs){

        long id=getIdFromURL(champs);

        List<Connection> newlist= list.stream().filter(c -> c.getPortC().getId()==id && c.getPortU().getId()!=-1).collect(Collectors.toList());
        if(newlist.size()>0){
            return  CodeHtml.getFinalHtmlCode("bodyMenu", CodeHtml.getInputId(id), CodeHtml.joinReponseCode("#E4E4E4","connection successful !", id), CodeHtml.getScriptCodeClick());
        }else
            return  CodeHtml.getFinalHtmlCode("bodyMenu", CodeHtml.joinReponseCode("red","connection failed !",-1));
    }
    //join a connection
    public static String joinConnection(List<String> champs){
        String getCode= champs.get(champs.indexOf("join")+1);
        List<Connection> newlist= list.stream().filter(c -> c.getCode().equals(getCode)&& c.getPortU().getId()==-1).map(c ->{c.getPortU().setId(c.getPortC().getId()+1);return c;}).collect(Collectors.toList());
        if(newlist.size()>0){
            return  CodeHtml.getFinalHtmlCode("bodyMenu", CodeHtml.getInputId(newlist.get(0).getPortU().getId()), CodeHtml.joinReponseCode("#E4E4E4","connection successful !",newlist.get(0).getPortU().getId()), CodeHtml.getScriptCodeClick());
        }
        else
            return  CodeHtml.getFinalHtmlCode("bodyMenu", CodeHtml.joinReponseCode("red","connection failed !", -1));
    }
    public static String clickEvent(List<String> champs){
        //get connection
        long id= getIdFromURL(champs);

        Optional<Connection> optionalConnection= list.stream().filter(c -> c.getPortC().getId()==id || c.getPortU().getId()==id).findFirst();
        if(optionalConnection.isPresent()){
            Connection connection= optionalConnection.get();
            //test finish game
            if(connection.getFinishGame()!=-1){
                return CodeHtml.getFinalHtmlCode("chessBoard", CodeHtml.getDefaultCode(), connection.getBoardChess().getHtmlCode());
            }
            //test if the player can move pieces or not
            if(!isYourTurn(connection, id))
                return CodeHtml.getFinalHtmlCode("chessBoard", CodeHtml.getInputId(id), connection.getBoardChess().getHtmlCode(), CodeHtml.getScriptCodeClick(),  CodeHtml.isYourTurn());
            //get square
            String indexSquare= champs.get(champs.indexOf("click")+1);
            Square square= connection.getBoardChess().getSquare(indexSquare);
            //get piece
            Piece piece = connection.getBoardChess().getBoard().get(square);

            if (!piece.getKey().isEmpty() && correctPlayer(piece, connection, id)){
                List<String> ids= Possibilty.getPossibilty(connection, square, piece);
                if(ids.size()!=0){
                    return CodeHtml.getFinalHtmlCode("chessBoard", CodeHtml.getInputIdS(ids), CodeHtml.getInputId(id), connection.getBoardChess().getHtmlCode(), CodeHtml.getScriptCodeClick(), CodeHtml.getScriptBlueColor());
                }
            }
            if(connection.isCheck()){
                return CodeHtml.getFinalHtmlCode("chessBoard", CodeHtml.getInputId(id), CodeHtml.getIsCheckCode(), connection.getBoardChess().getHtmlCode(), CodeHtml.getScriptCodeClick(), CodeHtml.getScriptBlueColor());
            }
            return CodeHtml.getFinalHtmlCode("chessBoard", CodeHtml.getInputId(id), connection.getBoardChess().getHtmlCode(), CodeHtml.getScriptCodeClick());
        }

        return "";
    }
    public static String moveEvent(List<String> champs){
        //get connection
        long id= getIdFromURL(champs);
        Optional<Connection> optionalConnection= list.stream().filter(c -> c.getPortC().getId()==id || c.getPortU().getId()==id).findFirst();
        if(optionalConnection.isPresent()){
            Connection connection= optionalConnection.get();
            //get squares
            String from= champs.get(champs.indexOf("move")+1);
            Square squareFrom= connection.getBoardChess().getSquare(from);
            String to= champs.get(champs.indexOf("move")+2);
            Square squareTo= connection.getBoardChess().getSquare(to);
            //get pieces
            Piece pieceFrom = connection.getBoardChess().getBoard().get(squareFrom);
            Piece pieceTo = connection.getBoardChess().getBoard().get(squareTo);
            //change
            connection.getBoardChess().getBoard().put(squareTo, pieceFrom);
            connection.getBoardChess().getBoard().put(squareFrom, new Piece());
            if(!pieceTo.getKey().isEmpty()){
                if (pieceTo.getColor()==1)
                    connection.getPortC().getPieces().remove(pieceTo);
                else
                    connection.getPortU().getPieces().remove(pieceTo);
            }
            //increment the countOfMoves
            incrementCountOfMoves(connection,id);
            //test check
            connection.setCheck(Possibilty.isCheck(connection, -pieceFrom.getColor()));
            if (connection.isCheck()&&Possibilty.finishGame(connection, -pieceFrom.getColor())){
                connection.setFinishGame(id);
                return CodeHtml.getFinalHtmlCode("chessBoard", CodeHtml.getWinnerCode(), connection.getBoardChess().getHtmlCode());
            }
            return CodeHtml.getFinalHtmlCode("chessBoard", CodeHtml.getInputId(id), connection.getBoardChess().getHtmlCode(), CodeHtml.getScriptCodeClick(), CodeHtml.isYourTurn());

        }

        return "";
    }
    public static long generateUniqueId(){
        long uid= uniqueId;
        uniqueId +=2;
        return uid;
    }
    public static  long getIdFromURL(List<String> champs){
        String key=champs.stream().filter(c -> c.contains("id-")).findFirst().get();
        return  Long.parseLong(key.split("-")[1]);
    }
    public static boolean correctPlayer(Piece piece, Connection connection, long id){

        return (piece.getColor()==1 && connection.getPortC().getId()==id)||(piece.getColor()==-1 && connection.getPortU().getId()==id);
    }
    public static void incrementCountOfMoves(Connection connection, long id){

        if (connection.getPortC().getId()==id)
            connection.getPortC().setCountOfMoves();
        else
            connection.getPortU().setCountOfMoves();
    }
    public static boolean isYourTurn(Connection connection, long id){
        //System.out.println("Math.abs "+Math.abs(connection.getBoardChess().getPlayerWhite().getCountOfMoves() - connection.getBoardChess().getPlayerBlack().getCountOfMoves()));
        PlayerWhite playerWhite = connection.getPortC();
        PlayerBlack playerBlack = connection.getPortU();

        if((playerWhite.getId()==id && playerWhite.getCountOfMoves()> playerBlack.getCountOfMoves())||(playerBlack.getId()==id &&  (playerBlack.getCountOfMoves()>=playerWhite.getCountOfMoves() || playerWhite.getCountOfMoves()==0)))
            return false;
        return true;
    }
    public static boolean isYourTurn(List<String> champs){
        //get connection
        long id= getIdFromURL(champs);

        Optional<Connection> optionalConnection= list.stream().filter(c -> c.getPortC().getId()==id || c.getPortU().getId()==id).findFirst();
        if(optionalConnection.isPresent()) {
            Connection connection= optionalConnection.get();
            return isYourTurn(connection, id);
        }
        return false;
    }
}
