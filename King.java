
/**
 * King chess piece
 *
 * @author Michael Levenkov
 */
public class King extends Piece
{
    public King(){
        super();
        this.setPieceName("king");
    }

    public King(Color c){
        super(c);
        this.setPieceName("king");
    }

    public King(King otherKing){
        if(otherKing == null){
            System.out.println("Error: cannot make copy of null King.");
        }
        else{
            this.setColor(otherKing.getColor());
            this.setPieceName(otherKing.getPieceName());
            this.setXPos(otherKing.getXPos());
            this.setYPos(otherKing.getYPos());
        }
        
    }

    public boolean moveIsValid(Notation input, Board board){
        int xStart = input.getXPosStart();
        int xEnd = input.getXPosEnd();
        int yStart = input.getYPosStart();
        int yEnd = input.getYPosEnd();

        if((Math.abs(xStart - xEnd) > 1) || (Math.abs(yStart - yEnd) > 1)){
            return false;
        }
        else{
            return true;
        }
    }

    public boolean moveIsObstructed(Notation input, Board board){
        int xEnd = input.getXPosEnd();
        int yEnd = input.getYPosEnd();

        if(board.getPiece(xEnd, yEnd) != null){
            return true;
        }
        else{
            return false;
        }
    }

    public boolean equals(Object otherObject){
        if(otherObject == null){
            return false;
        }
        else if(otherObject.getClass() != this.getClass()){
            return false;
        }
        else{
            King otherKing = (King)otherObject;
            return (otherKing.getColor() == this.getColor() &&
                otherKing.getPieceName() == this.getPieceName() && 
                otherKing.getXPos() == this.getXPos() && 
                otherKing.getYPos() == this.getYPos());
        }
    }

    public String toString(){
        return (this.getColor() + " " + this.getPieceName() + ", located at " +
             this.getXPos() + ", " + this.getYPos() + ".");
    }

    public static void main(String[] args){
        Board board = new Board();
        board.setUpBoard();

    }
}
