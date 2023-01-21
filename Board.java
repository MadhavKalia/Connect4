

public class Board {

	private final int NUM_OF_COLUMNS = 7;
	private final int NUM_OF_ROW = 6;
	
	/* 
	 * The board object must contain the board state in some manner.
	 * You must decide how you will do this.
	 * 
	 * You may add addition private/public methods to this class is you wish.
	 * However, you should use best OO practices. That is, you should not expose
	 * how the board is being implemented to other classes. Specifically, the
	 * Player classes.
	 * 
	 * You may add private and public methods if you wish. In fact, to achieve
	 * what the assignment is asking, you'll have to
	 * 
	 */
	private char board [][]= new char[NUM_OF_ROW][NUM_OF_COLUMNS];
	public Board() {
		for (int i = 0; i<NUM_OF_ROW; i++){
			for (int j=0; j<7; j++){
				board[i][j] = ' ';
			}
		}
	}

	public int getRow(){
		return NUM_OF_ROW;
	}

	public int getCol(){
		return NUM_OF_COLUMNS;
	}
	
	public void printBoard() {
		for (int i = 0; i<NUM_OF_ROW; i++){
			System.out.print("|");
			for (int j=0; j<NUM_OF_COLUMNS; j++){
				if (i==NUM_OF_ROW-1){
					if (board[i][j]==' '){
						System.out.print("_|");
					}
					else{
						System.out.print(board[i][j]+"|");
					}
				}
				else{
					System.out.print(board[i][j]+"|");
				}
			}
			System.out.println();

		}
	}
	

	public boolean containsWin() {

		//horizontal check
		for (int row = 0; row<NUM_OF_ROW; row++){
			for (int col =0; col<4; col++){
				if ((board[row][0+col]==board[row][1+col]) &&(board[row][1+col]==board[row][2+col]) &&(board[row][2+col]==board[row][3+col])&&(board[row][0+col]!= ' ')){
					return true;
				}

			}
		}

		//vertical check
		for (int row = 0; row<NUM_OF_COLUMNS; row++){
			for (int col =0; col<3; col++){
				if ((board[0+col][row]==board[1+col][row]) &&(board[1+col][row]==board[2+col][row]) &&(board[2+col][row]==board[3+col][row]) &&(board[0+col][row]!= ' ')){
					return true;
				}			
			}
		}

		//diagonal check
		for (int col = 0; col < 4; col++){
            for (int row = 3; row < NUM_OF_ROW; row++){
                if ((board[row][col] == board[row-1][col+1]) && (board[row-1][col+1] == board[row-2][col+2])&&(board[row-2][col+2]==board[row-3][col+3])&&(board[row][col]!= ' ')){
					return true;
				}
            }
        }

		for (int col = 0; col < 4; col++){
            for (int row = 0; row < 3; row++){
                if ((board[row][col] == board[row+1][col+1]) && (board[row+1][col+1] == board[row+2][col+2]) && (board[row+2][col+2]==board[row+3][col+3])&&(board[row][col] != ' ')){
					return true;
				}
            }
        }

		return false;
	}
	
	public boolean isTie() {
		for (int i = 0; i<board.length; i++){
			for (int j=0; j<board.length; j++){
				if (board[i][j] == ' '){
					return false;
				}
			}
		}
		return true;
	}
	
	public void reset() {
		for (int i = 0; i<board.length; i++){
			for (int j=0; j<board.length; j++){
				board[i][j] = ' ';
			}
		}
	}

	public char getPiece(int row, int col){
		return board[row][col];
	}

	public void placePiece(int row, int col, char x){
		board[row][col] = x;
	}
	
	public int[] winningMove(char symbol){
		int[] place=new int[2];
		place[0]=100;
		place[1] =100;

		//check horizontal move
		for (int row = 0; row<NUM_OF_ROW; row++){
			for (int col =0; col<4; col++){
				if ((board[row][0+col]==' ') &&(board[row][1+col]==board[row][2+col]) &&(board[row][2+col]==board[row][3+col])&&(board[row][1+col]== symbol)){
					place[0]= row;
					place[1]= 0+col;
					return place;
				}
				else if ((board[row][1+col]== ' ') &&(board[row][0+col]==board[row][2+col]) &&(board[row][2+col]==board[row][3+col])&&(board[row][0+col]== symbol)){
					place[0]= row;
					place[1] =1+col;
					return place;
				}
				else if ((board[row][2+col]== ' ') &&(board[row][0+col]==board[row][1+col]) &&(board[row][1+col]==board[row][3+col])&&(board[row][1+col]== symbol)){
					place[0]= row;
					place[1] = 2+col;
					return place;
				}
				else if ((board[row][3+col]== ' ') &&(board[row][0+col]==board[row][1+col]) &&(board[row][1+col]==board[row][2+col])&&(board[row][1+col]== symbol)){
					place[0]= row;
					place[1] = 3+col;
					return place;
				}

			}
		}

		//check vertical move
		for (int row = 0; row<NUM_OF_COLUMNS; row++){
			for (int col =0; col<3; col++){
				if ((board[0+col][row]==' ') &&(board[1+col][row]==board[2+col][row]) &&(board[2+col][row]==board[3+col][row]) &&(board[1+col][row]== symbol)){
					place[0]= 0+col;
					place[1]= row;
					return place;
				}	
			}
		}

		//check diagonal move
		for (int col = 0; col < 4; col++){
            for (int row = 3; row < NUM_OF_ROW; row++){
                if ((board[row][col] == ' ') && (board[row-1][col+1] == board[row-2][col+2])&&(board[row-2][col+2]==board[row-3][col+3])&&(board[row-1][col+1]== symbol)){
					place[0]= row;
					place[1]= col;
					return place;
				}
				else if ((board[row-1][col+1] == ' ') && (board[row][col] == board[row-2][col+2])&&(board[row-2][col+2]==board[row-3][col+3])&&(board[row][col]== symbol)){
					place[0]= row-1;
					place[1] = col+1;
					return place;
				}
				else if ((board[row-2][col+2] == ' ') && (board[row][col] == board[row-1][col+1])&&(board[row-1][col+1]==board[row-3][col+3])&&(board[row][col]== symbol)){
					place[0]= row-2;
					place[1]= col+2;
					return place;
				}
				else if ((board[row-3][col+3] == ' ') && (board[row][col] == board[row-1][col+1])&&(board[row-1][col+1]==board[row-2][col+2])&&(board[row][col]== symbol)){
					place[0]= row-3;
					place[1]= col+3;
					return place;
				}
            }
        }

		for (int col = 0; col < 4; col++){
            for (int row = 0; row < 3; row++){
                if ((board[row][col] == ' ') && (board[row+1][col+1] == board[row+2][col+2]) && (board[row+2][col+2]==board[row+3][col+3])&&(board[row+1][col+1] == symbol)){
					place[0]= row;
					place[1]= col;
					return place;
				}
				else if ((board[row+1][col+1] == ' ') && (board[row][col] == board[row+2][col+2]) && (board[row+2][col+2]==board[row+3][col+3])&&(board[row][col] == symbol)){
					place[0]= row+1;
					place[1]= col+1;
					return place;
				}
				else if ((board[row+2][col+2] == ' ') && (board[row][col] == board[row+1][col+1]) && (board[row+1][col+1]==board[row+3][col+3])&&(board[row][col] == symbol)){
					place[0]= row+2;
					place[1]= col+2;
					return place;
				}
				else if ((board[row+3][col+3] == ' ') && (board[row][col] == board[row+1][col+1]) && (board[row+1][col+1]==board[row+2][col+2])&&(board[row][col] == symbol)){
					place[0]= row+3;
					place[1] = col+3;
					return place;
				}
				
            }
        }

		return place;
	}


	public int[] blockWinningMove(char symbol){
		int []place = new int[2];
		place[0]=100;
		place[1] = 100;

		//check horizontal move
		for (int row = 0; row<NUM_OF_ROW; row++){
			for (int col =0; col<4; col++){
				if ((board[row][0+col]==' ') &&(board[row][1+col]==board[row][2+col]) &&(board[row][2+col]==board[row][3+col])&&(board[row][1+col]!= symbol && board[row][1+col]!= ' ')){
					place[0] = row;
					place[1]= 0+col;
					return place;
				}
				else if ((board[row][1+col]== ' ') &&(board[row][0+col]==board[row][2+col]) &&(board[row][2+col]==board[row][3+col])&&(board[row][0+col]!= symbol && board[row][0+col]!= ' ')){
					place[0] = row;
					place[1]= 1+col;
					return place;
				}
				else if ((board[row][2+col]== ' ') &&(board[row][0+col]==board[row][1+col]) &&(board[row][1+col]==board[row][3+col])&&(board[row][1+col]!= symbol && board[row][1+col]!= ' ')){
					place[0] = row;
					place[1] = 2+col;
					return place;
				}
				else if ((board[row][3+col]== ' ') &&(board[row][0+col]==board[row][1+col]) &&(board[row][1+col]==board[row][2+col])&&(board[row][1+col]!= symbol && board[row][1+col]!= ' ')){
					place[0] = row;
					place[1]= 3+col;
					return place;
				}

			}
		}

		//check vertical move
		for (int row = 0; row<NUM_OF_COLUMNS; row++){
			for (int col =0; col<3; col++){
				if ((board[0+col][row]==' ') &&(board[1+col][row]==board[2+col][row]) &&(board[2+col][row]==board[3+col][row]) &&(board[1+col][row]!= symbol && board[1+col][row]!= ' ')){
					place[0] = 0+col;
					place[1]= row;
					return place;
				}
			}
		}

		//check diagonal move
		for (int col = 0; col < 4; col++){
            for (int row = 3; row < NUM_OF_ROW; row++){
                if ((board[row][col] == ' ') && (board[row-1][col+1] == board[row-2][col+2])&&(board[row-2][col+2]==board[row-3][col+3])&&(board[row-1][col+1]!= symbol && board[row-1][col+1]!= ' ')){
					place[0] = row;
					place[1] = col;
					return place;
				}
				else if ((board[row-1][col+1] == ' ') && (board[row][col] == board[row-2][col+2])&&(board[row-2][col+2]==board[row-3][col+3])&&(board[row][col]!= symbol && board[row][col]!= ' ')){
					place[0] = row-1;
					place[1] = col+1;
					return place;
				}
				else if ((board[row-2][col+2] == ' ') && (board[row][col] == board[row-1][col+1])&&(board[row-1][col+1]==board[row-3][col+3])&&(board[row][col]!= symbol && board[row][col]!= ' ')){
					place[0] = row-2;
					place[1] = col+2;
					return place;
				}
				else if ((board[row-3][col+3] == ' ') && (board[row][col] == board[row-1][col+1])&&(board[row-1][col+1]==board[row-2][col+2])&&(board[row][col]!= symbol && board[row][col]!= ' ')){
					place[0] = row-3;
					place[1]= col+3;
					return place;
				}
            }
        }

		for (int col = 0; col < 4; col++){
            for (int row = 0; row < 3; row++){
                if ((board[row][col] == ' ') && (board[row+1][col+1] == board[row+2][col+2]) && (board[row+2][col+2]==board[row+3][col+3])&&(board[row+1][col+1]!= symbol && board[row+1][col+1]!= ' ')){
					place[0] = row;
					place[1]= col;
					return place;
				}
				else if ((board[row+1][col+1] == ' ') && (board[row][col] == board[row+2][col+2]) && (board[row+2][col+2]==board[row+3][col+3])&&(board[row][col]!= symbol && board[row][col]!= ' ')){
					place[0] = row+1;
					place[1] = col+1;
					return place;
				}
				else if ((board[row+2][col+2] == ' ') && (board[row][col] == board[row+1][col+1]) && (board[row+1][col+1]==board[row+3][col+3])&&(board[row][col] != symbol && board[row][col]!= ' ')){
					place[0] = row+2;
					place[1]= col+2;
					return place;
				}
				else if ((board[row+3][col+3] == ' ') && (board[row][col] == board[row+1][col+1]) && (board[row+1][col+1]==board[row+2][col+2])&&(board[row][col]!= symbol && board[row][col]!= ' ')){
					place[0] = row+3;
					place[1] = col+3;
					return place;
				}
				
            }
        }

		return place;
	}

}
