
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
        //get start position of piece (2-3 or 1-2 if pawn)
        if(this.notationInput.length() == 5){
            //pawn movement
            
        }
        else if(this.notationInput.length() == 6){
            //non-pawn movement
        }
        else{
            //nothing should end up here except castling and maybe other things
            System.out.println("Error: invalid input - incorrect length.");
        }
    }

    /**
     * Takes in a file (vertical column) and returns the corresponding column 
     * index in the array in the Board class.
     * 
     * @param in char, must be a-h inclusive
     * @return index of corresponding column in array
     */
    private int convertFileToIndex(char in){
        switch (in) {
            case 'a':
                return 0;
            case 'b':
                return 1;
            case 'c':
                return 2;
            case 'd':
                return 3;
            case 'e':
                return 4;
            case 'f':
                return 5;
            case 'g':
                return 6;
            case 'h':
                return 7;
        
            default:
                System.out.println("Error: invalid input - file not on board");
                return -1;
        }
    }

    /**
     * Takes in a rank (horizonal row) and returns the index of the 
     * corresponding row in the array in the Board class. Note that chess ranks
     *  are numbered 1-8 starting from the bottom, whereas the array is indexed
     *  0-7 starting from the top.
     * 
     * @param in char, must be 1-8 inclusive
     * @return the corresponding index of the array row
     */
    private int convertRankToIndex(char in){
        switch (in) {
            case '1':
                return 7;
            case '2':
                return 6;
            case '3':
                return 5;
            case '4':
                return 4;
            case '5':
                return 3;
            case '6':
                return 2;
            case '7':
                return 1;
            case '8':
                return 0;            
        
            default:
                System.out.println("Error: invalid input - rank not on board");
                return -1;
        }
    }

    private boolean indexIsValid(int in){
        if(in >= 0 && in <= 7){
            return true;
        }
        else{
            return false;
        }
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
