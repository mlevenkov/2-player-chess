
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
    
    public Piece(color c){
        this.color = c;
    }
    
    public Piece(Piece original){
        this.color = original.color;
    }
    
    public void moveTo(Notation input, Board board){
        if(moveIsValid(input, board) && !moveIsObstructed(input, board)){
            board.setSquare(input.getXPosStart(), input.getYPosStart(), null);
            board.setSquare(input.getXPosEnd(), input.getYPosEnd(), this);
            this.xPos = input.getXPosEnd();
            this.yPos = input.getYPosEnd();
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

    public boolean equals(Piece otherPiece){
        //figure this out
    }
    public String toString(){
        //figure this out
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
