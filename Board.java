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
    
    /**
     * Sets the piece at the given location to the given piece.
     * 
     * @param xPos x position of location to be set
     * @param yPos y position of location to be set
     * @param piece piece to be placed at location
     */
    public void setPiece(int xPos, int yPos, Piece piece){
        //we use xPos/yPos instead of rank/file because rank/file origin is 
        //in the bottom left corner and array origin is in top left corner
        if(isOnBoard(xPos) && isOnBoard(yPos)){
            board[yPos][xPos] = piece;
        }
        else{
            System.err.println("Error: trying to set location outside of" + 
                " board.");
        }
    }

    /**
     * TODO: Add rest of pieces
     * Returns a deep copy of the piece at the given location on the board.
     * xPos and YPos are zero-indexed and measured from the top left of the 
     * board.
     * 
     * @param xPos int, x position of piece
     * @param yPos int, y position of piece
     * @return a deep copy of the corresponding piece
     */
    public Piece getPiece(int xPos, int yPos){
        Piece currentPiece = board[yPos][xPos];
        if(currentPiece == null){
            return null;
        }
        else{
            String name = currentPiece.getPieceName();
            switch (name) {
                case "rook":
                    return new Rook(currentPiece.getColor());
                case "knight":
                    return null;
                case "bishop":
                    return null;
                case "queen":
                    return null;
                case "king":
                    return new King(currentPiece.getColor());
                case "pawn":
                    return null;
        
                default:
                    return null;
            }
        }  
    }

    /**
     * TODO: Add rest of pieces
     * Returns a deep copy of the piece at the start position in the notation.
     * xPos and YPos are zero-indexed and measured from the top left of the 
     * board.
     * 
     * @param input a valid and parsed Notation object
     * @return a deep copy of the corresponding piece
     */
    public Piece getPiece(Notation input){
        int xPos = input.getXPosStart();
        int yPos = input.getYPosStart();
        if(board[yPos][xPos] == null){
            return null;
        }
        else{
            String name = board[yPos][xPos].getPieceName();
            switch (name) {
                case "rook":
                    return new Rook(board[yPos][xPos].getColor());
                case "knight":
                    return null;
                case "bishop":
                    return null;
                case "queen":
                    return null;
                case "king":
                    return new King(board[yPos][xPos].getColor());
                case "pawn":
                    return null;
        
                default:
                    return null;
            }
        }  
    }

    /**
     * Sets up board with starting position (may be replaced with file i/o 
     * later)
     */
    public void setUpBoard(){
        board[0][0] = new Rook(Piece.Color.BLACK);
        board[0][4] = new King(Piece.Color.BLACK);

        board[0][7] = new Rook(Piece.Color.BLACK);

        board[7][0] = new Rook(Piece.Color.WHITE);
        board[7][4] = new King(Piece.Color.WHITE);

        board[7][7] = new Rook(Piece.Color.WHITE);
    }

    /**
     * Prints out current board state to console.
     */
    public void printBoard(){
        for(int row = 0; row < this.boardSize; row++){
            for(int column = 0; column < this.boardSize; column++){
                System.out.print(getLetterToPrint(board[row][column]) + " ");
            }
            System.out.println();
        }
    }

    public boolean equals(Object otherObject){
        if(otherObject == null){
            return false;
        }
        else if(this.getClass() != otherObject.getClass()){
            return false;
        }
        else{
            Board otherBoard = (Board)otherObject;
            for(int row = 0; row < this.boardSize; row++){
                for(int column = 0; column < this.boardSize; column++){
                    if(!otherBoard.getPiece(row, column).equals(this.getPiece(row, column))){
                        return false;
                    }
                }
            }
            return true;
        }
    }

    public String toString(){
        //TODO: make this return Forsyth-Edwards Notation
        return "A chess board storing some quantity of Pieces.";
    }

    /**
     * Determines and returns the letter to print to the screen for a 
     * particular piece.
     * 
     * @param piece Piece object to be displayed on screen
     * @return corresponding char to be displayed on screen
     */
    private char getLetterToPrint(Piece piece){
        if(piece == null){
            return '-';
        }
        else{
                String name = piece.getPieceName();
            if(piece.getColor().toString().equals("WHITE")){
                if(name.equals("knight")){
                    return 'N';
                }
                else{
                    return Character.toUpperCase(name.charAt(0));
                }
            }
            else{
                if(name.equals("knight")){
                    return 'n';
                }
                else{
                    return Character.toLowerCase(name.charAt(0));
                }
            }
        }
    }
    
    /**
     * Checks if a given int value is in the board.
     * 
     * @param pos int value to be checked
     * @return whether the value is in the board
     */
    private boolean isOnBoard(int pos){
        if(pos >= 0 && pos < boardSize){
            return true;
        }
        else{
            return false;
        }
    }

    public static void main(String[] args){
        Board board = new Board();
        board.setUpBoard();
        board.printBoard();
        Piece test1 = board.getPiece(3, 3);
        System.out.println(test1); //Should be null
        Notation testNotation = new Notation("Ra2-a3");
        Piece test2 = board.getPiece(testNotation);
        System.out.println(test2); //Should be null
    }
}
