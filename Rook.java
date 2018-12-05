
/**
 * Rook chess piece
 *
 * @author Michael Levenkov
 * @version v1, December 4 2018
 */
public class Rook extends Piece
{
    public Rook(){
        super();
        this.setPieceName("rook");
    }

    public Rook(Color c){
        super(c);
        this.setPieceName("rook");
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

    /**
     * Checks to see if the path of the piece is obstructed by another piece. 
     * Note that if input is not a valid notation, this method will return 
     * true.
     */
    public boolean moveIsObstructed(Notation input, Board board){
        int xStart = input.getXPosStart();
        int xEnd = input.getXPosEnd();
        int yStart = input.getYPosStart();
        int yEnd = input.getYPosEnd();
        boolean obstructed = false;

        if(moveIsValid(input, board)){
            if((yEnd < yStart) && (xEnd == xStart)){
                for(int i = yStart; i > yEnd; i--){
                    if(board.getPiece(xEnd, i) != null){
                        obstructed = true;
                    }
                }
            }
            else if((yEnd > yStart) && (xEnd == xStart)){
                for(int i = yStart; i < yEnd; i++){
                    if(board.getPiece(xEnd, i) != null){
                        obstructed = true;
                    }
                }
            }
            else if((xEnd < xStart) && (yEnd == yStart)){
                for(int i = xStart; i > xEnd; i--){
                    if(board.getPiece(i, yEnd) != null){
                        obstructed = true;
                    }
                }
            }
            else if((xEnd > xStart) && (yEnd == yStart)){
                for(int i = xStart; i < xEnd; i++){
                    if(board.getPiece(i, yEnd) != null){
                        obstructed = true;
                    }
                }
            }
        }
        else{
            obstructed = true;
        }

        if(board.getPiece(xEnd, yEnd) != null){
            if(board.getPiece(xEnd, yEnd).getColor() == this.getColor()){
                obstructed = true;
            }
        }

        return obstructed;
    }
}
