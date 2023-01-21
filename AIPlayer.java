import java.util.Random;
public class AIPlayer extends Player {

    public AIPlayer(char symbol, Board board, String name) {
        super(symbol, board, name);
        //TODO Auto-generated constructor stub
    }
    Random random = new Random();
    @Override
    public void makeMove(Board board) {

        //first checking any winning moves available to make
        boolean madeMove = false;
        int winningPosition []= board.winningMove(symbol);
        int blockingPosition []= board.blockWinningMove(symbol);
        int row2 = board.getRow();
        int row = board.getRow()-1;
        int boardCol = board.getCol();
        if (winningPosition[0]!=100){
            
            for (int i=0; i<row2; i++){
                if (board.getPiece(row, winningPosition[1]) == ' '){
                    if (board.getRow()-1 == winningPosition[0]){
                        board.placePiece(row, winningPosition[1], symbol);
                        madeMove = true;
                        break;
                    }
                    else if ((board.getPiece(winningPosition[0]+1, winningPosition[1]) != ' ')){
                        board.placePiece(row, winningPosition[1], symbol);
                        madeMove = true;
                        break;
                    }
                    
                }
                row = row- 1  ;
            }
           

        }//checking if opponent has any winning moves to block
        else if (blockingPosition[0]!=100){
            for (int i=0; i<row2; i++){
                if (board.getPiece(row, blockingPosition[1]) == ' '){
                    if (board.getRow()-1 == blockingPosition[0]){
                        board.placePiece(row, blockingPosition[1], symbol);
                        madeMove = true;
                        break;
                    }
                    else if ((board.getPiece(blockingPosition[0]+1, blockingPosition[1]) != ' ')){
                        board.placePiece(row, blockingPosition[1], symbol);
                        madeMove = true;
                        break;
                    }
                    
                }
                row = row- 1  ;
            }
        }
        if (!madeMove){
            //finally make a random move
            row  = board.getRow()-1;
            boolean flag = false;
            int col = random.nextInt(1,boardCol+1);
            col = col-1;
            if (board.getPiece(0,col)!=' '){
                do{
                    col = random.nextInt(1,boardCol+1);
                    col = col-1;
                    if (board.getPiece(0, col) == ' '){
                        flag = true;
                    }
                }while(!flag);
            }
            for (int i=0; i<row2; i++){
                if (board.getPiece(row, col) == ' '){
                    board.placePiece(row, col, symbol);
                    break;
                }
                row = row- 1  ;
            }

         }


        
    }
    

}
