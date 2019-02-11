
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
        int xStart = input.getXPosStart();
        int xEnd = input.getXPosEnd();
        int yStart = input.getYPosStart();
        int yEnd = input.getYPosEnd();

        if(this.getColor() == Color.WHITE){ //white pawns move upwards
            if(yStart == 6 && xStart == xEnd && (yStart - yEnd) <= 2 && 
                (yStart-yEnd) > 0){ //move from starting position
                    return true;
            }
            else if(xStart == xEnd && (yStart - yEnd) == 1){ //regular move
                return true;
            }
            else if((xEnd == xStart + 1) && (yEnd == yStart - 1) && 
                (board.getPiece(xEnd, yEnd) != null)){ //diagonal to right
                    return true;
            }
            else if((xEnd == xStart - 1) && (yEnd == yStart - 1) && 
                (board.getPiece(xEnd, yEnd) != null)){ // diagonal to left
                    return true;
            }
            else{
                return false;
            }
            
        }
        else{ //black pawns move downwards
            if(yStart == 1 && xStart == xEnd && (yEnd - yStart) <= 2 && 
                (yEnd-yStart) > 0){ //move from starting position
                    return true;
            }
            else if(xStart == xEnd && (yEnd - yStart) == 1){ //regular move
                return true;
            }
            else if((xEnd == xStart + 1) && (yEnd == yStart + 1) && 
                (board.getPiece(xEnd, yEnd) != null)){ //diagonal to right
                    return true;
            }
            else if((xEnd == xStart - 1) && (yEnd == yStart + 1) && 
                (board.getPiece(xEnd, yEnd) != null)){ // diagonal to left
                    return true;
            }
            else{
                return false;
            }
        }
    }
    //TODO Pawn moveIsObstructed
    public boolean moveIsObstructed(Notation input, Board board){
        return true;
        
        /*if(moveIsValid(input, board)){
            int xStart = input.getXPosStart();
            int xEnd = input.getXPosEnd();
            int yStart = input.getYPosStart();
            int yEnd = input.getYPosEnd();
//tab in
            if(this.getColor() == Piece.Color.WHITE){ //white pawns move upwards
                if(yStart == 6 && xStart == xEnd && (yStart - yEnd) <= 2 && 
                    (yStart-yEnd) > 0 && 
                    (board.getPiece(xStart, yStart - 1) != null || 
                    board.getPiece(xEnd, yEnd) != null)){ //move from starting position
                    if(((yStart - yEnd) == 2) && 
                        (board.getPiece(xStart, yStart - 1) != null || 
                        board.getPiece(xEnd, yEnd) != null)){
                        return true;
                    }
                    else if(((yStart - yEnd) == 1) && 
                        board.getPiece(xEnd, yEnd) != null){
                        return true;
                    }
                    else{
                        return false;
                    }
                }
                else if(xStart == xEnd && (yStart - yEnd) == 1){ //regular move
                
                }
                else if((xEnd == xStart + 1) && (yEnd == yStart - 1) && 
                    (board.getPiece(xEnd, yEnd) != null)){ //diagonal to right
                    
                }
                else if((xEnd == xStart - 1) && (yEnd == yStart - 1) && 
                    (board.getPiece(xEnd, yEnd) != null)){ // diagonal to left
                    
                }
                else{
                
                }
            
            }
            else{ //black pawns move downwards
                if(yStart == 1 && xStart == xEnd && (yEnd - yStart) <= 2 && 
                    (yEnd-yStart) > 0){ //move from starting position
                
                }
                else if(xStart == xEnd && (yEnd - yStart) == 1){ //regular move
                    
                }
                else if((xEnd == xStart + 1) && (yEnd == yStart + 1) && 
                    (board.getPiece(xEnd, yEnd) != null)){ //diagonal to right
                    
                }
                else if((xEnd == xStart - 1) && (yEnd == yStart + 1) && 
                    (board.getPiece(xEnd, yEnd) != null)){ // diagonal to left
                    
                }
                else{
                
                }
            }
        }
        else{
            return true;
        }*/
    }

    //TODO Figure out promotion
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
