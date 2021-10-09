import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;

public class TicTacToe
{
	//Variables
	private int dimension; // The number of dimensions the board has.
	private int[][] theBoard; // Two Dimensional Array that keeps track of the game board ([row][column]).
	public int playerTurn = 1; // Keeps track of the current players turn.
	private int moves = 0; // Keeps track of the moves that have been made on the board.
	private boolean loaded = false; // Keeps track of whether a board was loaded or not for child class.

        private int lastRow , lastColumn;
	//Constructors
	public TicTacToe( )
	{
		this.dimension = 6;
		theBoard = new int[dimension][dimension];
	}

	public TicTacToe( int dimension )
	{
		//error check board for minimum parameters
            this.lastRow = 0;
            this.lastColumn = 0;
		this.dimension = dimension;
		theBoard = new int[dimension][dimension];
	}

	//Accessors and Mutators
	public int getDimension()
	{
		return dimension;
	}

	public void setDimension(int dimension)
	{
		this.dimension = dimension;
	}

	public int[][] getTheBoard()
	{
		return theBoard;
	}

	public void setTheBoard(int[][] board)
	{
		this.theBoard = board;
	}

	public int getPlayerTurn()
	{
		return playerTurn;
	}

	public void setPlayerTurn(int playerTurn)
	{
		this.playerTurn = playerTurn;
	}

	public int getMoves()
	{
		return moves;
	}

	public void setMoves(int moves)
	{
		this.moves = moves;
	}

	public boolean getLoaded()
	{
		return this.loaded;
	}

	public void setLoaded(boolean loaded)
	{
		this.loaded = loaded;
	}

	//Methods
	/**
	 *  Places the current player in location x, y, where x is an index
	 *  between 0 and row length - 1, and y is an index between 0 and
	 *  column length - 1. If there is currently another player occupying
	 *  the space, no move is made, and a false is returned. If the player
	 *  successfully occupies the space, a true is returned.
	 *
	 * @param int x - row number.
	 * @param int y - column number.
	 * @return boolean - returns true if valid input, otherwise false.
	 */

	public boolean makeMove( int x, int y )
	{
		if (checkPosition(x, y) == -1 || theBoard[x][y] != 0)
			return false;
		moves++;
		theBoard[x][y] = playerTurn;
                
                lastRow = x;
                lastColumn = y;
                
		if (playerTurn == 1)
			playerTurn = 2;
		else
			playerTurn = 1;
		return true;
	}

	/**
	 *  Returns the player number who's turn it is .
	 *
	 * @return int - player turn.
	 */
	public int turn()
	{
		return getPlayerTurn();
	}

	/**
	 *  Returns a 0 if there are currently no winners, -1 if the game
	 *  ends in a tie, a 1 if player 1 is a winner, and 2 if player 2
	 *  is a winner.
	 *
	 * @return int - game status.
	 */
	public int gameStatus()
	{
		int gameStatus = 0;
		int playerEvaluated;

		//Checking Rows
		for(int i = 0; i < theBoard.length; i++)
		{
			playerEvaluated = theBoard[i][0];
			for(int j = 0; j < getDimension(); j++)
			{
				if(playerEvaluated == 0 || theBoard[i][j] != playerEvaluated) {
					gameStatus = 0;
					break;
				}
				if(j == getDimension() - 1)
				{
					gameStatus = playerEvaluated;
					return gameStatus;
				}
			}
		}

		//Checking Columns
		for(int i = 0; i < getDimension(); i++)
		{
			playerEvaluated = theBoard[0][i];
			for(int j = 0; j < getDimension(); j++)
			{
				if(playerEvaluated == 0 || theBoard[j][i] != playerEvaluated) {
					gameStatus = 0;
					break;
				}
				if(j == getDimension() - 1)
				{
					gameStatus = playerEvaluated;
					return gameStatus;
				}
			}
		}

		//Checking Diagonal (Top-Left to Down-Right)
		playerEvaluated = theBoard[0][0];
		for(int i = 0; i < getDimension(); i++)
		{
			if(playerEvaluated == 0 || theBoard[i][i] != playerEvaluated) {
				gameStatus = 0;
				break;
			}
			gameStatus = playerEvaluated;
		}

		if (gameStatus != 0)
			return gameStatus;

		//Checking Diagonal (Down-Left to Top Right)
		playerEvaluated = theBoard[0][getDimension() - 1];
		for(int i = 0, j = getDimension() - 1; i < getDimension(); i++,j--)
		{
			if(playerEvaluated == 0 || theBoard[i][j] != playerEvaluated) {
				gameStatus = 0;
				break;
			}
			gameStatus = playerEvaluated;
		}

		//Check if board is filled & players tied.
		if (moves == getDimension() * getDimension() && gameStatus == 0)
			gameStatus = -1;

		return gameStatus;
	}

	/**
	 *  Returns false if the game is still in progress.
	 *  
	 * @return boolean - game status.
	 */
	public boolean gameOver()
	{
		return gameStatus() != 0;
	}

	/**
	 * Returns a String that represents the current state of the board.
	 *  
	 * @return String - game board as a string.
	 */
	public String toString()
	{
		String board = "";
		for (int[] row : theBoard)
		{
			for (int item : row)
				board+= Integer.toString(item);
			board += "\n";
		}
		return board;
	}

	/**
	 * Overwrites the current contents of the board with the state of the
	 * board in the file, fileName.
	 *  
	 * @param String fileName - a file to read from.
	 * @return void
	 */
	public void loadBoard(String fileName)
	{
		try
		{
			FileReader fileReader = new FileReader( fileName );
			BufferedReader read = new BufferedReader( fileReader );
			String x = read.readLine();
			setLoaded(true);
			moves = 0;
			int loops = 0;
			boolean flag = false;
			while( x != null )
			{
				if(!flag)
				{
					setDimension(x.length());
					setTheBoard(new int[dimension][dimension]);
					flag = true;
				}
				for (int i = 0; i < x.length(); i++)
				{
					theBoard[loops][i] = x.charAt(i)-48;
					if(x.charAt(i) != '0')
						moves++;
				}
				loops++;
				x = read.readLine();
			}
			if(moves%2 == 0)
				playerTurn = 1;
			else
				playerTurn = 2;
			read.close();
		}
		catch( Exception e )
		{
			System.out.println(e);
		}
	}

	/**
	 * Writes the current state of the board to a text file,
	 * fileName.
	 *  
	 * @param String fileName - a file to write to.
	 * @return void
	 */
	public void saveBoard(String fileName)
	{
		try
		{
			FileWriter write = new FileWriter(fileName);
			write.write(toString());
			write.close();
		}
		catch (Exception e)
		{
			System.out.println(e);
		}
	}

	/**
	 * Accessor method that allows access to ONE position on
	 * the board at row x and column y. If the row or column
	 * is invalid, return a -1.  The reason why you should
	 * NOT return the entire board is because the board is an
	 * object, and by returning an object you are giving
	 * clients access to make changes directly, which violates
	 * our encapsulation philosophy.
	 *  
	 * @param int x - row in the game board.
	 * @param int y - column in the game board.
	 * @return int - the position requested on the board
	 */
	public int checkPosition (int x, int y)
	{
		if (x < 0 || y < 0 || x > dimension-1 || y > dimension-1)
			return -1;
		return theBoard[x][y];
	}
        
        public int[] get_last_cord(){
            int [] last = {this.lastColumn , this.lastRow};
            return last;
        }
        public void undo(int x , int y){
            theBoard[x][y] = 0;
        }
}