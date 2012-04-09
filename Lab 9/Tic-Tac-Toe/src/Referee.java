import java.io.*;

public class Referee
{
	private SquareType[][] gameBoard;
	private char[][] gameBoardChars;
	private Player player1;
	private Player player2;

	public Referee()
	{
		gameBoard = new SquareType[3][3];

		/* Initiate all squares to be empty at the beginning */
		for( int i = 0; i < SquareType.SquareTypeCount.ordinal(); i++ ) {
			for( int j = 0; j < SquareType.SquareTypeCount.ordinal(); j++ ) {
				gameBoard[i][j] = SquareType.SquareTypeEmpty;
			}
		}

		gameBoardChars = new char[3][3];

		for( int i = 0; i < SquareType.SquareTypeCount.ordinal(); i++ ) {
			for( int j = 0; j < SquareType.SquareTypeCount.ordinal(); j++ ) {
				gameBoardChars[i][j] = ' ';
			}
		}

		player1 = null;
		player2 = null;
	}

	public void playGame() throws IOException, PlayersNotInitializedException
	{
		System.out.println( "\n\nWelcome to Tic-Tac-Toe" );
		System.out.println( "Created by: Thomas Hewton-Waters & Andrew Winkler" );

		System.out.println( "\nPlease select from the following options:" );
		System.out.println( "1. Play Tic-Tac-Toe" );
		System.out.println( "2. Quit" );

		BufferedReader in = new BufferedReader( new InputStreamReader( System.in ) );
		String str = in.readLine();

		if( Integer.parseInt( str ) == 2 ) {
			System.out.println( "Bye!" );
			return;
		}

		initiateGame();

		/* Make sure both players have been initialized */
		if( player1 == null || player2 == null )
			throw new PlayersNotInitializedException( "Player 1 and Player 2 were not initialized correctly." );

		/* Play until there is a winner */
		boolean winner = false;


		/* Draw the updated game board */
		drawScreen();


		while( winner == false ) {

			/* Receive a move from player 1 */
			receiveMove( player1 );

			/* Draw the updated game board */
			drawScreen();

			/* Check if player 1 won */
			winner = checkForWinner();
			if( winner == true )
				break;

			/* Receive a move from player 2 */
			receiveMove( player2 );

			/* Draw the updated game board */
			drawScreen();

			/* Check if player 2 won */
			winner = checkForWinner();
		}
	}

	private void receiveMove( Player player ) throws IOException
	{
		/* Get the player's next coordinate */
		Coordinate coord = player.calculateMove();

		/* Update the game board */
		if( gameBoard[coord.row][coord.col] == SquareType.SquareTypeEmpty ) {
			gameBoard[coord.row][coord.col] = player.getSquareType();

			switch ( player.getSquareType() ) {
				case SquareTypeX:
				gameBoardChars[coord.row][coord.col] = 'X';
				break;
				case SquareTypeO:
				gameBoardChars[coord.row][coord.col] = 'O';
				break;
				default:
				break;
			}
		} else {
			System.out.println( "Someone already went there! You lose a turn." );
		}
	}

	private boolean checkForWinner()
	{
		/* Checking if Player 1 has won */

		if( gameBoardChars[0][0] == 'X' && gameBoardChars[0][1] == 'X' && gameBoardChars[0][2] == 'X' ) {
			System.out.println( "\n" + player1.getName() + " has won!" + "\n" );
			return true;
		}

		if( gameBoardChars[1][0] == 'X' && gameBoardChars[1][1] == 'X' && gameBoardChars[1][2] == 'X' ) {
			System.out.println( "\n" + player1.getName() + " has won!" + "\n" );
			return true;
		}

		if( gameBoardChars[2][0] == 'X' && gameBoardChars[2][1] == 'X' && gameBoardChars[2][2] == 'X' ) {
			System.out.println( "\n" + player1.getName() + " has won!" + "\n" );
			return true;
		}

		if( gameBoardChars[0][0] == 'X' && gameBoardChars[1][0] == 'X' && gameBoardChars[2][0] == 'X' ) {
			System.out.println( "\n" + player1.getName() + " has won!" + "\n" );
			return true;
		}

		if( gameBoardChars[0][1] == 'X' && gameBoardChars[1][1] == 'X' && gameBoardChars[2][1] == 'X' ) {
			System.out.println( "\n" + player1.getName() + " has won!" + "\n" );
			return true;
		}

		if( gameBoardChars[0][2] == 'X' && gameBoardChars[1][2] == 'X' && gameBoardChars[2][2] == 'X' ) {
			System.out.println( "\n" + player1.getName() + " has won!" + "\n" );
			return true;
		}

		if( gameBoardChars[0][0] == 'X' && gameBoardChars[1][1] == 'X' && gameBoardChars[2][2] == 'X' ) {
			System.out.println( "\n" + player1.getName() + " has won!" + "\n" );
			return true;
		}	

		if( gameBoardChars[0][2] == 'X' && gameBoardChars[1][1] == 'X' && gameBoardChars[2][0] == 'X' ) {
			System.out.println( "\n" + player1.getName() + " has won!" + "\n" );
			return true;
		}

		/* Checking if Player 2 has won */

		if( gameBoardChars[0][0] == 'O' && gameBoardChars[0][1] == 'O' && gameBoardChars[0][2] == 'O' ) {
			System.out.println( "\n" + player2.getName() + " has won!" + "\n" );
			return true;
		}

		if( gameBoardChars[1][0] == 'O' && gameBoardChars[1][1] == 'O' && gameBoardChars[1][2] == 'O' ) {
			System.out.println( "\n" + player2.getName() + " has won!" + "\n" );
			return true;
		}

		if( gameBoardChars[2][0] == 'O' && gameBoardChars[2][1] == 'O' && gameBoardChars[2][2] == 'O' ) {
			System.out.println( "\n" + player2.getName() + " has won!" + "\n" );
			return true;
		}

		if( gameBoardChars[0][0] == 'O' && gameBoardChars[1][0] == 'O' && gameBoardChars[2][0] == 'O' ) {
			System.out.println( "\n" + player2.getName() + " has won!" + "\n" );
			return true;
		}

		if( gameBoardChars[0][1] == 'O' && gameBoardChars[1][1] == 'O' && gameBoardChars[2][1] == 'O' ) {
			System.out.println( "\n" + player2.getName() + " has won!" + "\n" );
			return true;
		}

		if( gameBoardChars[0][2] == 'O' && gameBoardChars[1][2] == 'O' && gameBoardChars[2][2] == 'O' ) {
			System.out.println( "\n" + player2.getName() + " has won!" + "\n" );
			return true;
		}

		if( gameBoardChars[0][0] == 'O' && gameBoardChars[1][1] == 'O' && gameBoardChars[2][2] == 'O' ) {
			System.out.println( "\n" + player2.getName() + " has won!" + "\n" );
			return true;
		}	

		if( gameBoardChars[0][2] == 'O' && gameBoardChars[1][1] == 'O' && gameBoardChars[2][0] == 'O' ) {
			System.out.println( "\n" + player2.getName() + " has won!" + "\n" );
			return true;
		}		

		return false;
	}

	private void initiateGame() throws IOException, PlayersNotInitializedException
	{
		System.out.print( "\nGreat! Please enter your name: " );

		BufferedReader in = new BufferedReader( new InputStreamReader( System.in ) );
		String str = in.readLine();

		player1 = new Player( str, Player.PlayerType.PlayerTypeHuman, SquareType.SquareTypeX );
		
		System.out.println( "\nPlease make a selection for your opponent from the following list:" );
		System.out.println( "1. Human Player" );
		System.out.println( "2. Computer Random Player" );
		System.out.println( "3. Computer Blocking Player" );
		System.out.println( "4. Computer Smart Player" );
		System.out.println( "5. Computer-Aided Human Player" );

		int playerSelection = Integer.parseInt( in.readLine() );

		/* Initialize player 2 based on who player 1's selection of who to play */
		switch ( playerSelection ) {
			case 1:
			player2 = new Player( "Player 2", Player.PlayerType.PlayerTypeHuman, SquareType.SquareTypeO );
			break;
			case 2:
			player2 = new Player( null, Player.PlayerType.PlayerTypeComputerRandom, SquareType.SquareTypeO );
			break;
			case 3:
			player2 = new Player( null, Player.PlayerType.PlayerTypeComputerBlocking, SquareType.SquareTypeO );
			break;
			case 4:
			player2 = new Player( null, Player.PlayerType.PlayerTypeComputerSmart, SquareType.SquareTypeO );
			break;
			case 5:
			player2 = new Player( null, Player.PlayerType.PlayerTypeComputerAidedHuman, SquareType.SquareTypeO );
			break;
			default:
			break;
		}

		/* Make sure both players were initialized */
		if( player1 == null || player2 == null )
			throw new PlayersNotInitializedException( "An incorrect opponent selection was made." );
	}

	private void drawScreen()
	{
		drawGameBoard();
	}

	/* Draws the game board with X's and O's */
	private void drawGameBoard()
	{
		System.out.println( "\n    Game Board");
		System.out.println( "    0     1     2");
		System.out.println( " +-----+-----+-----+" );
		System.out.println( " |     |     |     |" );
		System.out.println( "0|  " + gameBoardChars[0][0] + "  |  " + gameBoardChars[0][1] + "  |  " + gameBoardChars[0][2] + "  |" );
		System.out.println( " |     |     |     |" );
		System.out.println( " +-----+-----+-----+" );
		System.out.println( " |     |     |     |" );
		System.out.println( "1|  " + gameBoardChars[1][0] + "  |  " + gameBoardChars[1][1] + "  |  " + gameBoardChars[1][2] + "  |" );
		System.out.println( " |     |     |     |" );
		System.out.println( " +-----+-----+-----+" );
		System.out.println( " |     |     |     |" );
		System.out.println( "2|  " + gameBoardChars[2][0] + "  |  " + gameBoardChars[2][1] + "  |  " + gameBoardChars[2][2] + "  |" );
		System.out.println( " |     |     |     |" );
		System.out.println( " +-----+-----+-----+\n" );
	}

	public static void main( String[] args ) throws IOException, PlayersNotInitializedException
	{
		Referee ref = new Referee();
		ref.playGame();
	}
}