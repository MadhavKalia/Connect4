import java.util.Scanner;


public class HumanPlayer extends Player{

    public HumanPlayer(char symbol, Board board, String name) {
        super(symbol, board, name);
        //TODO Auto-generated constructor stub
    }

    Scanner input = new Scanner(System.in);
    @Override
    public void makeMove(Board board) {
        // TODO Auto-generated method stub
        
        boolean flag = false;
        System.out.println(name+", please input your move:");
        int col = input.nextInt();
        col = col-1;
        if (board.getPiece(0,col)!=' '){
            do{
                System.out.println(name+", please input your move:");
                col = input.nextInt();
                col = col-1;
                if (board.getPiece(0, col) == ' '){
                    flag = true;
                }
            }while(!flag);
        }
        int row = board.getRow()-1;
        for (int i=0; i<board.getRow(); i++){
            if (board.getPiece(row, col) == ' '){
                board.placePiece(row, col, symbol);
                break;
            }
            row = row- 1  ;
        }

        
    }
    
}
