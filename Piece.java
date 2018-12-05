
/**
 * Final project for CSS 142 - A chess piece
 *
 * @author Michael Levenkov
 * @version v1, November 30 2018
 */
public class Piece
{
    public static enum Color {WHITE, BLACK};
    private Color color;
    private int xPos;
    private int yPos;
    private String pieceName;
    
    public Piece(){

    }

    public Piece(Color c){
        this.color = c;
    }
    
    public Piece(Piece original){
        if(original == null){
            System.out.println("Error: cannot make copy of null object.");
        }
        else{
            this.color = original.color;
            this.xPos = original.xPos;
            this.yPos = original.yPos;
            this.pieceName = original.pieceName;
        }
    }
    
    public boolean moveTo(Notation input, Board board){
        if(board.getPiece(input) == null){
            System.out.println("Error: no piece at given location.");
            return false;
        }
        else if(moveIsValid(input, board) && !moveIsObstructed(input, board)){
            int xStart = input.getXPosStart();
            int xEnd = input.getXPosEnd();
            int yStart = input.getYPosStart();
            int yEnd = input.getYPosEnd();

            if(board.getPiece(xEnd, yEnd) != null){
                System.out.println("A " + board.getPiece(xEnd, yEnd).getColor()
                     + " " + board.getPiece(xEnd, yEnd).getPieceName() + 
                     " was " + "captured by a " + this.getColor() + " " + 
                     this.pieceName);
            }
            board.setPiece(xStart, yStart, null);
            board.setPiece(xEnd, yEnd, this);
            this.xPos = xEnd;
            this.yPos = yEnd;

            return true;
        }
        else{
            System.out.println("Error: move is invalid or obstructed.");
            //System.out.println(moveIsValid(input, board) + " " + !moveIsObstructed(input, board));
            return false;
        }
    }
    
    public Color getColor(){
        return color;
    }

    public int getXPos(){
        return this.xPos;
    }
    
    public int getYPos(){
        return this.yPos;
    }
    
    public String getPieceName(){
        return pieceName;
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

    public boolean setPieceName(String in){
        if(in.equals("")){
            return false;
        }
        else{
            this.pieceName = in;
            return true;
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
            Piece otherPiece = (Piece) otherObject;
            return((this.color == otherPiece.color) && 
                   (this.xPos == otherPiece.xPos) && 
                   (this.yPos == otherPiece.yPos));
        }
    }
    public String toString(){
        return ("Color is" + color + ", located at " + xPos + ", " + yPos);
    }
    
    public boolean moveIsValid(Notation input, Board board){
        //will be overwritten by individual piece subclasses
        return true; //might work? needs test
    }
    
    public boolean moveIsObstructed(Notation input, Board board){
        //will be overwritten by individual piece subclasses
        return true; //might work? needs test
    }

    public static void main(String[] args) {
        Board board = new Board();
        Notation goodNotation = new Notation("Ra1-a4");
        Notation badNotation = new Notation("Ra2-a3");
        board.setUpBoard();
        board.printBoard();
        System.out.println(board.getPiece(badNotation)); // should be null
        if(board.getPiece(badNotation) == null){
            System.out.println("Error: no piece at location specified" + 
                " by badNotation"); // should print
        }
        if(board.getPiece(goodNotation) == null){
            System.out.println("Error: no piece at location specified" + 
                " by goodNotation"); // should not print
        }
        else{
            board.getPiece(goodNotation).moveTo(goodNotation, board);
        }
        board.printBoard();
    }
}
