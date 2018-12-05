import java.util.Scanner;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
/**
 * Final project for CSS 142 - The chess board
 *
 * @author Michael Levenkov
 * @version v1, November 30 2018
 */
public class Board
{
    private Piece[][] board;
    private final int boardSize = 8;
    
    public Board(){
        board = new Piece[boardSize][boardSize];
    }
    
    public void setPiece(int xPos, int yPos, Piece piece){
        if(isOnBoard(xPos) && isOnBoard(yPos)){
            board[yPos][xPos] = piece;
        }
        else{
            System.err.println("Error: trying to set location outside of" + 
                " board.");
        }
    }

    public Piece getPiece(int xPos, int yPos){
        return new Piece(board[yPos][xPos]);
    }

    public void setUpBoard(){
        //ask dad what the best way to declare a ton of objects is
    }
    
    private boolean isOnBoard(int pos){
        if(pos >= 0 && pos < boardSize){
            return true;
        }
        else{
            return false;
        }
    }
}
