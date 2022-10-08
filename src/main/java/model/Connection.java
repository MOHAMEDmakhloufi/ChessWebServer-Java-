package model;

import game.BoardChess;
import game.PlayerWhite;
import game.PlayerBlack;
import services.ServiceConnection;

public class Connection {
    private PlayerWhite portC;
    private PlayerBlack portU;
    private String code;
    private boolean isCheck=false;
    private long finishGame=-1;
    private boolean eatPiece=true;

    public boolean isEatPiece() {
        return eatPiece;
    }

    public void setEatPiece(boolean eatPiece) {
        this.eatPiece = eatPiece;
    }

    private BoardChess boardChess= new BoardChess(ServiceConnection.generateUniqueId());

    public Connection( String code) {
        this.portC = this.boardChess.getPlayerWhite();
        this.portU = this.boardChess.getPlayerBlack();
        this.code = code;
    }

    public PlayerWhite getPortC() {
        return portC;
    }

    public void setPortC(PlayerWhite portC) {
        this.portC = portC;
    }

    public PlayerBlack getPortU() {
        return portU;
    }

    public void setPortU(PlayerBlack portU) {
        this.portU = portU;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public BoardChess getBoardChess() {
        return boardChess;
    }

    public void setBoardChess(BoardChess boardChess) {
        this.boardChess = boardChess;
    }

    public boolean isCheck() {
        return isCheck;
    }

    public void setCheck(boolean check) {
        isCheck = check;
    }

    public long getFinishGame() {
        return finishGame;
    }

    public void setFinishGame(long finishGame) {
        this.finishGame = finishGame;
    }
}
