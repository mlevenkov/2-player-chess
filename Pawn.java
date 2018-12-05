
/**
 * Pawn chess piece
 *
 * @author Michael Levenkov
 */
public class Pawn extends Piece
{
    public Pawn(){
        super();
        this.setPieceName("pawn");
    }

    public Pawn(Color c){
        super(c);
        this.setPieceName("pawn");
    }

    public Pawn(Pawn otherPawn){
        if(otherPawn == null){
            System.out.println("Error: cannot make copy of null Pawn");
        }
        else{
            this.setColor(otherPawn.getColor());
            this.setPieceName(otherPawn.getPieceName());
            this.setXPos(otherPawn.getXPos());
            this.setYPos(otherPawn.getYPos());
        }
    }

    public boolean moveIsValid(Notation input, Board board){
        if(this.getColor() == Piece.Color.WHITE){

        }
        else{

        }
        return false;
    }

    public boolean moveIsObstructed(Notation input, Board board){
        if(this.getColor() == Piece.Color.WHITE){

        }
        else{

        }
        return true;
    }

    public boolean promote(){
        return false;
    }

    public boolean equals(Object otherObject){
        if(otherObject == null){
            return false;
        }
        else if(otherObject.getClass() != this.getClass()){
            return false;
        }
        else{
            Pawn otherPawn = (Pawn)otherObject;
            return (otherPawn.getColor() == this.getColor() &&
                otherPawn.getXPos() == this.getXPos() &&
                otherPawn.getYPos() == this.getYPos() &&
                otherPawn.getPieceName() == this.getPieceName());
        }
    }

    public String toString(){
        return (this.getColor() + " " + this.getPieceName() + ", located at " +
            this.getXPos() + ", " + this.getYPos());
    }

    public static void main(String[] args) {
        
    }
}
