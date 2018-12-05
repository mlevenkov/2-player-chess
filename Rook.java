
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
     * 
     * @param input Notation for current move
     * @param board Board for moving on
     * @return whether this piece can legally make this move
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
     * 
     * @param input Notation for current move
     * @param board Board for moving on
     * @return whether the move is obstructed or not
     */
    public boolean moveIsObstructed(Notation input, Board board){
        int xStart = this.getXPos();
        int xEnd = input.getXPosEnd();
        int yStart = this.getYPos();
        int yEnd = input.getYPosEnd();
        boolean obstructed = false;

        if(moveIsValid(input, board)){
            if((yEnd < yStart) && (xEnd == xStart)){
                for(int i = yStart - 1; i > yEnd; i--){
                    if(board.getPiece(xEnd, i) != null){
                        obstructed = true;
                    }
                }
            }
            else if((yEnd > yStart) && (xEnd == xStart)){
                for(int i = yStart + 1; i < yEnd; i++){
                    if(board.getPiece(xEnd, i) != null){
                        obstructed = true;
                    }
                }
            }
            else if((xEnd < xStart) && (yEnd == yStart)){
                for(int i = xStart - 1; i > xEnd; i--){
                    if(board.getPiece(i, yEnd) != null){
                        obstructed = true;
                    }
                }
            }
            else if((xEnd > xStart) && (yEnd == yStart)){
                for(int i = xStart + 1; i < xEnd; i++){
                    if(board.getPiece(i, yEnd) != null){
                        obstructed = true;
                    }
                }
            }
        }
        else{
            obstructed = true;
        }

        if(board.getPiece(xEnd, yEnd) != null && 
            (board.getPiece(xEnd, yEnd).getColor() == this.getColor())){
            obstructed = true;
        }

        return obstructed;
    }

    public boolean equals(Object otherObject){
        if(otherObject == null){
            return false;
        }
        else if(otherObject.getClass() != this.getClass()){
            return false;
        }
        else{
            Rook otherRook = (Rook)otherObject;
            return (otherRook.getColor() == this.getColor() &&
                otherRook.getXPos() == this.getXPos() &&
                otherRook.getYPos() == this.getYPos() &&
                otherRook.getPieceName() == this.getPieceName());
        }
    }

    public String toString(){
        return ("Rook, color is" + this.getColor() + ", located at " + 
            this.getXPos() + ", " + this.getYPos());
    }

    public static void main(String[] args) {
        Board board = new Board();
        Notation not1 = new Notation("Ra1-a4");
        //Notation not2 = new Notation("Ra1-d1");
        Notation not3 = new Notation("rh8-h5");
        //Notation not4 = new Notation("rh8-e8");

        board.setUpBoard();
        System.out.println(board.getPiece(not1).moveTo(not1, board));
        //System.out.println(board.getPiece(not2).moveTo(not2, board));
        System.out.println(board.getPiece(not3).moveTo(not3, board));
        //System.out.println(board.getPiece(not4).moveTo(not4, board));
        board.printBoard();
        

    }
}
