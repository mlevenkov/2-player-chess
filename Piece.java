
/**
 * Final project for CSS 142 - A chess piece
 *
 * @author Michael Levenkov
 * @version v1, November 30 2018
 */
public class Piece
{
    enum color {WHITE, BLACK};
    private color color;
    private int xPos;
    private int yPos;
    private String pieceName;
    
    public Piece(){

    }

    public Piece(color c){
        this.color = c;
    }
    
    public Piece(Piece original){
        this.color = original.color;
    }
    
    public void moveTo(Notation input, Board board){
        if(moveIsValid(input, board) && !moveIsObstructed(input, board)){
            int xStart = input.getXPosStart();
            int xEnd = input.getXPosEnd();
            int yStart = input.getYPosStart();
            int yEnd = input.getYPosEnd();

            if(board.getPiece(xEnd, yEnd) != null){
                System.out.println("A " + board.getPiece(xEnd, yEnd).getColor()
                     + " " + board.getPiece(xEnd, yEnd).getName() + " was " + 
                     "captured by a " + this.getColor() + " " + 
                     this.pieceName);
            }
            board.setPiece(xStart, yStart, null);
            board.setPiece(xEnd, yEnd, this);
            this.xPos = xEnd;
            this.yPos = yEnd;
        }
        else{
            System.out.println("Error: move is invalid or obstructed.");
        }
    }
    
    public color getColor(){
        return color;
    }

    public int getXPos(){
        return this.xPos;
    }
    
    public int getYPos(){
        return this.yPos;
    }

    public boolean setXPos(int in){
        if((in >= 0) && (in <= 7)){
            this.xPos = in;
            return true;
        }
        else{
            System.out.println("Error: invalid x position.");
            return false;
        }
    }

    public boolean setYPos(int in){
        if((in >= 0) && (in <= 7)){
            this.xPos = in;
            return true;
        }
        else{
            System.out.println("Error: invalid y position.");
            return false;
        }
    }

    public boolean equals(Object otherObject){
        if(otherObject == null){
            return false;
        }
        else if(this.getClass != otherObject.getClass){
            return false;
        }
        else{
            Piece otherPiece = (Piece) otherObject;
            return((this.color == otherPiece.color) && 
                   (this.xPos == otherPiece.xPos) && 
                   (this.yPos == otherPiece.yPos);
        }
    }
    public String toString(){
        return ("Color is" + color + ", located at " + xPos + ", " + yPos);
    }

    public String getPieceName(){
        return pieceName;
    }
    
    private boolean moveIsValid(Notation input, Board board){
        //will be overwritten by individual piece subclasses
        return true; //might work? needs test
    }
    
    private boolean moveIsObstructed(Notation input, Board board){
        //will be overwritten by individual piece subclasses
        return true; //might work? needs test
    }
}
