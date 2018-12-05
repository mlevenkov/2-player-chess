
/**
 * Final project for CSS 142 - Driver for chess playing program
 *
 * @author Michael Levenkov
 * @version v1, November 30 2018
 */
public class Driver
{
    public static void main(String[] args){
        Board board = new Board();
        board.setUpBoard();

        System.out.println("Welcome to 2 Player Chess!");
        System.out.println("The following elements of traditional chess " + 
            "are not implemented: castling, en passant, automatic checking" + 
            "of checks and checkmates.");
        System.out.println("Please enter all moves in Long Algebraic " + 
            "Notation.");
        System.out.println("Use '#' by itself to indicate a checkmate");
        System.out.println("Use '=' by intself to indicate a draw.");
        
        boolean isWhiteTurn = true;
        boolean isMate = false;
        boolean isDraw = false;
        while(!isMate && !isDraw){
            if(isWhiteTurn){
                //do white turn
                isWhiteTurn = false;
            }
            else{
                //do black turn
                isWhiteTurn = true;
            }
        }
        if(isMate && isWhiteTurn){
            System.out.println("Black wins.");
        }
        else if(isMate && isBlackTurn){
            System.out.println("White wins.");
        }
        else if(isDraw){
            System.out.println("Draw.");
        }
        else{
            System.out.println("Unexpected outcome.");
        }
        System.out.println("Thank you for playing 2 Player Chess.");
    }
}
