
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
    
    public Piece(color c){
        this.color = c;
    }
    
    public Piece(Piece original){
        this.color = original.color;
    }
    
    public void moveTo(Notation input, Board board){
        if(moveIsValid(input) && !moveIsObstructed(input)){
            board.setSquare(input.getXPosStart(), input.getYPosStart(), null);
            board.setSquare(input.getXPosEnd(), input.getYPosEnd(), this);
        }
        else{
            System.out.println("Error: move is invalid or obstructed.");
        }
    }
    
    public color getColor(){
        return color;
    }
    
    private boolean moveIsValid(Notation input){
        //will be overwritten by individual piece subclasses
        return true; //might work? needs test
    }
    
    private boolean moveIsObstructed(Notation input){
        //will be overwritten by individual piece subclasses
        return true; //might work? needs test
    }
}
