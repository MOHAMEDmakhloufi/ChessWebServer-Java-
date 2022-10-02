package game;

import model.Piece;
import model.Square;

import java.util.*;

public class BoardChess {
    //The Players
    private PlayerWhite playerWhite;
    private PlayerBlack playerBlack= new PlayerBlack(-1);;
    //representation of board
    private Map<Square, Piece> board= new HashMap<>();
    //constructor
    public BoardChess(long idWhite){
        this.playerWhite = new PlayerWhite(idWhite);
        int color=-1;
        for(int i=1; i<=8; i++){
            for(int j=1; j<=8; j++){
                color *= -1;
                //initial White
                if(i==1)
                    board.put(new Square(i+"_"+j, color), playerWhite.getPieces().get(j-1));
                else if(i==2)
                    board.put(new Square(i+"_"+j, color), playerWhite.getPieces().get(7+j));
                //initial Black
                else if(i==7)
                    board.put(new Square(i+"_"+j, color), playerBlack.getPieces().get(7+j));
                else if (i==8)
                    board.put(new Square(i+"_"+j, color), playerBlack.getPieces().get(j-1));
                //initial other square
                else
                    board.put(new Square(i+"_"+j, color), new Piece());
            }
            color *= -1;
        }


    }

    //return html code
    public String getHtmlCode(){
        return "<div class='logo'>\n" +
                "        <span>Chess.fsb</span>\n" +
                "    </div>" +
                "<div class='chessboard'>\n" +
                "        <!-- 1st -->\n" +
                "        <div class='white' id='1_1'>"+board.get(new Square("1_1"))+"</div>\n" +
                "        <div class='black' id='1_2'>"+board.get(new Square("1_2"))+"</div>\n" +
                "        <div class='white' id='1_3'>"+board.get(new Square("1_3"))+"</div>\n" +
                "        <div class='black' id='1_4'>"+board.get(new Square("1_4"))+"</div>\n" +
                "        <div class='white' id='1_5'>"+board.get(new Square("1_5"))+"</div>\n" +
                "        <div class='black' id='1_6'>"+board.get(new Square("1_6"))+"</div>\n" +
                "        <div class='white' id='1_7'>"+board.get(new Square("1_7"))+"</div>\n" +
                "        <div class='black' id='1_8'>"+board.get(new Square("1_8"))+"</div>\n" +
                "        <!-- 2nd -->\n" +
                "        <div class='black' id='2_1'>"+board.get(new Square("2_1"))+"</div>\n" +
                "        <div class='white' id='2_2'>"+board.get(new Square("2_2"))+"</div>\n" +
                "        <div class='black' id='2_3'>"+board.get(new Square("2_3"))+"</div>\n" +
                "        <div class='white' id='2_4'>"+board.get(new Square("2_4"))+"</div>\n" +
                "        <div class='black' id='2_5'>"+board.get(new Square("2_5"))+"</div>\n" +
                "        <div class='white' id='2_6'>"+board.get(new Square("2_6"))+"</div>\n" +
                "        <div class='black' id='2_7'>"+board.get(new Square("2_7"))+"</div>\n" +
                "        <div class='white' id='2_8'>"+board.get(new Square("2_8"))+"</div>\n" +
                "        <!-- 3th -->\n" +
                "        <div class='white' id='3_1'>"+board.get(new Square("3_1"))+"</div>\n" +
                "        <div class='black' id='3_2'>"+board.get(new Square("3_2"))+"</div>\n" +
                "        <div class='white' id='3_3'>"+board.get(new Square("3_3"))+"</div>\n" +
                "        <div class='black' id='3_4'>"+board.get(new Square("3_4"))+"</div>\n" +
                "        <div class='white' id='3_5'>"+board.get(new Square("3_5"))+"</div>\n" +
                "        <div class='black' id='3_6'>"+board.get(new Square("3_6"))+"</div>\n" +
                "        <div class='white' id='3_7'>"+board.get(new Square("3_7"))+"</div>\n" +
                "        <div class='black' id='3_8'>"+board.get(new Square("3_8"))+"</div>\n" +
                "        <!-- 4st -->\n" +
                "        <div class='black' id='4_1'>"+board.get(new Square("4_1"))+"</div>\n" +
                "        <div class='white' id='4_2'>"+board.get(new Square("4_2"))+"</div>\n" +
                "        <div class='black' id='4_3'>"+board.get(new Square("4_3"))+"</div>\n" +
                "        <div class='white' id='4_4'>"+board.get(new Square("4_4"))+"</div>\n" +
                "        <div class='black' id='4_5'>"+board.get(new Square("4_5"))+"</div>\n" +
                "        <div class='white' id='4_6'>"+board.get(new Square("4_6"))+"</div>\n" +
                "        <div class='black' id='4_7'>"+board.get(new Square("4_7"))+"</div>\n" +
                "        <div class='white' id='4_8'>"+board.get(new Square("4_8"))+"</div>\n" +
                "        <!-- 5th -->\n" +
                "        <div class='white' id='5_1'>"+board.get(new Square("5_1"))+"</div>\n" +
                "        <div class='black' id='5_2'>"+board.get(new Square("5_2"))+"</div>\n" +
                "        <div class='white' id='5_3'>"+board.get(new Square("5_3"))+"</div>\n" +
                "        <div class='black' id='5_4'>"+board.get(new Square("5_4"))+"</div>\n" +
                "        <div class='white' id='5_5'>"+board.get(new Square("5_5"))+"</div>\n" +
                "        <div class='black' id='5_6'>"+board.get(new Square("5_6"))+"</div>\n" +
                "        <div class='white' id='5_7'>"+board.get(new Square("5_7"))+"</div>\n" +
                "        <div class='black' id='5_8'>"+board.get(new Square("5_8"))+"</div>\n" +
                "        <!-- 6th -->\n" +
                "        <div class='black' id='6_1'>"+board.get(new Square("6_1"))+"</div>\n" +
                "        <div class='white' id='6_2'>"+board.get(new Square("6_2"))+"</div>\n" +
                "        <div class='black' id='6_3'>"+board.get(new Square("6_3"))+"</div>\n" +
                "        <div class='white' id='6_4'>"+board.get(new Square("6_4"))+"</div>\n" +
                "        <div class='black' id='6_5'>"+board.get(new Square("6_5"))+"</div>\n" +
                "        <div class='white' id='6_6'>"+board.get(new Square("6_6"))+"</div>\n" +
                "        <div class='black' id='6_7'>"+board.get(new Square("6_7"))+"</div>\n" +
                "        <div class='white' id='6_8'>"+board.get(new Square("6_8"))+"</div>\n" +
                "        <!-- 7th -->\n" +
                "        <div class='white' id='7_1'>"+board.get(new Square("7_1"))+"</div>\n" +
                "        <div class='black' id='7_2'>"+board.get(new Square("7_2"))+"</div>\n" +
                "        <div class='white' id='7_3'>"+board.get(new Square("7_3"))+"</div>\n" +
                "        <div class='black' id='7_4'>"+board.get(new Square("7_4"))+"</div>\n" +
                "        <div class='white' id='7_5'>"+board.get(new Square("7_5"))+"</div>\n" +
                "        <div class='black' id='7_6'>"+board.get(new Square("7_6"))+"</div>\n" +
                "        <div class='white' id='7_7'>"+board.get(new Square("7_7"))+"</div>\n" +
                "        <div class='black' id='7_8'>"+board.get(new Square("7_8"))+"</div>\n" +
                "        <!-- 8th -->\n" +
                "        <div class='black' id='8_1'>"+board.get(new Square("8_1"))+"</div>\n" +
                "        <div class='white' id='8_2'>"+board.get(new Square("8_2"))+"</div>\n" +
                "        <div class='black' id='8_3'>"+board.get(new Square("8_3"))+"</div>\n" +
                "        <div class='white' id='8_4'>"+board.get(new Square("8_4"))+"</div>\n" +
                "        <div class='black' id='8_5'>"+board.get(new Square("8_5"))+"</div>\n" +
                "        <div class='white' id='8_6'>"+board.get(new Square("8_6"))+"</div>\n" +
                "        <div class='black' id='8_7'>"+board.get(new Square("8_7"))+"</div>\n" +
                "        <div class='white' id='8_8'>"+board.get(new Square("8_8"))+"</div>\n" +
                "    </div>\n";
    }

    public Map<Square, Piece> getBoard() {
        return board;
    }
    public Set<Square> getListOfSquares(){
        return board.keySet();
    }
    public Square getSquare(String index){
        return getListOfSquares().stream().filter(s -> s.getKey().equals(index)).findFirst().get();
    }

    public PlayerWhite getPlayerWhite() {
        return playerWhite;
    }

    public PlayerBlack getPlayerBlack() {
        return playerBlack;
    }
}
