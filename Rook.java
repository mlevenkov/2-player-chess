
/**
 * Rook chess piece
 *
 * @author Michael Levenkov
 * @version v1, December 4 2018
 */
public class Rook
{
    public Rook(){
        super();
    }

    /**
     * Checks to see if the move can be performed by this type of piece. 
     * Assumes input is a valid notation (ie remains on the board).
     */
    public boolean moveIsValid(Notation input, Board board){
        int xStart = input.getXPosStart();
        int xEnd = input.getXPosEnd();
        int yStart = input.getYPosStart();
        int yEnd = input.getYPosEnd();
        
        if( ( (yEnd < yStart) && (xEnd == xStart) ) || 
            ( (yEnd > yStart) && (xEnd == xStart) ) ||
            ( (xEnd < xStart) && (yEnd == yStart) ) ||
            ( (xEnd > xStart) && (yEnd == yStart) ) ){
            return true;
        }
        else{
            return false;
        }
    }

    public boolean moveIsObstructed(Notation input, Board board){
        if(moveIsValid(input, board)){
            
        }
    }
}
