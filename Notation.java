
/**
 * Final project for CSS 142 - Manipulates chess notation (in Long Algebraic 
 * Form)
 *
 * @author Michael Levenkov
 * @version v1, November 30 2018
 */
public class Notation
{
    private String notationInput;
    private int xPosStart;
    private int xPosEnd;
    private int yPosStart;
    private int yPosEnd;
    private Piece pieceMoved;
    private Piece pieceCaptured;
    
    public Notation(String input){
        this.notationInput = input;
    }
    
    public void parseInput(){
        //get rank of piece (first char or none if pawn)
        //get start position of piece (2-3 ro 1-2 if pawn)
    }
    
    public int getXPosStart(){
        return this.xPosStart;
    }
    
    public int getYPosStart(){
        return this.yPosStart;
    }
    
    public int getXPosEnd(){
        return this.xPosEnd;
    }
    
    public int getYPosEnd(){
        return this.yPosEnd;
    }
}
