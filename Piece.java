
/**
 * Final project for CSS 142 - A chess piece
 *
 * @author Michael Levenkov
 * @version v1, November 30 2018
 */
public abstract class Piece
{
    public static enum Color {WHITE, BLACK}; //used throughout program
    private Color color;
    private int xPos; //between 0 and 7 inclusive
    private int yPos; //between 0 and 7 inclusive
    private String pieceName; //should be the same as the name of the subclass
    
    /**
     * Constructs a Piece object.
     */
    public Piece(){

    }

    /**
     * Constructs a Piece object of the given color
     * 
     * @param c Color, either BLACK or WHITE
     */
    public Piece(Color c){
        this.color = c;
    }
    
    /**
     * Constructs a deep copy of the given piece
     * 
     * @param original Piece to be copied
     */
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
    
    /**
     * Moves the piece from its current location on the board to a new 
     * location that is specified in input. Performs checks on whether 
     * there is a piece at the start location, whether that piece can make 
     * the move legally, and whether the move results in the capture of 
     * another piece. 
     * 
     * Assumptions: input has been parsed, input and board are not null
     * 
     * @param input parsed Notation for the current move
     * @param board Board for moving on
     * @return whether the move was successful
     */
    public boolean moveTo(Notation input, Board board){
        if(board.getPiece(input) == null){
            System.out.println("Error: no piece at given location.");
            return false;
        }
        //check if move is legal
        else if(moveIsValid(input, board) && !moveIsObstructed(input, board)){
            int xStart = input.getXPosStart();
            int xEnd = input.getXPosEnd();
            int yStart = input.getYPosStart();
            int yEnd = input.getYPosEnd();

            //checks if a piece is captured
            //no check for piece color because that is performed in 
            //moveIsObstructed
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
            System.out.println(moveIsValid(input, board) + " " + 
                !moveIsObstructed(input, board));
            return false;
        }
    }
    
    /**
     * Getter method for the color of the piece.
     * 
     * @return enum, either BLACK or WHITE
     */
    public Color getColor(){
        return this.color;
    }

    /**
     * Getter method for the x position on the Board array of this piece.
     * 
     * @return int between 0 and 7 inclusive
     */
    public int getXPos(){
        return this.xPos;
    }
    
    /**
     * Getter method for the y position on the Board array of this piece.
     * 
     * @return int between 0 and 7 inclusive
     */
    public int getYPos(){
        return this.yPos;
    }
    
    /**
     * Getter method for the name of this piece.
     * 
     * @return the name of the piece, should be the same as the name of the 
     * subclass
     */
    public String getPieceName(){
        return this.pieceName;
    }

    /**
     * Mutator method for the color of this piece.
     * 
     * @param c Color, either BLACK or WHITE
     * @return whether the setting was successful
     */
    public boolean setColor(Color c){
        this.color = c;
        return true;
    }

    /**
     * Mutator method for x position of this piece.
     * 
     * @param in int, should be between 0 and 7 inclusive
     * @return whether the setting was successful
     */
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

    /**
     * Mutator method for y position of this piece.
     * 
     * @param in int, should be between 0 and 7 inclusive
     * @return whether the setting was successful
     */
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

    /**
     * Mutator method for name of this piece
     * 
     * @param in String, should be the same as the name of the subclass
     * @return whether the setting was successful
     */
    public boolean setPieceName(String in){
        if(in.equals("")){
            return false;
        }
        else{
            this.pieceName = in;
            return true;
        }
    }

    /**
     * Checks if otherObject is equal to this object.
     * 
     * @param otherObject Object to be checked
     * @return whether the two objects are equal
     */
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

    /**
     * Returns a string describing this piece.
     * 
     * @return String
     */
    public String toString(){
        return ("Color is" + color + ", located at " + xPos + ", " + yPos);
    }
    
    /**
     * Dummy method, is overwritten by subclass methods
     * 
     * @param input Notation for current move
     * @param board Board for moving on
     * @return false
     */
    public abstract boolean moveIsValid(Notation input, Board board);
    
    /**
     * Dummy method, is overwritten by subclass methods
     * 
     * @param input Notation for current move
     * @param board Board for moving on
     * @return true
     */
    public abstract boolean moveIsObstructed(Notation input, Board board);

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
