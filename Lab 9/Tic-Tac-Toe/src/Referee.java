import java.io.*;

public class Referee
{
	private SquareType[][] gameBoard;
	private Player player1;
	private Player player2;

	public Referee()
	{
		gameBoard = new SquareType[3][3];

		/* Initiate all squares to be empty at the beginning */
		for( int i = 0; i < SquareType.SquareTypeCount.ordinal(); i++ )
			for( int j = 0; j < SquareType.SquareTypeCount.ordinal(); j++ )
				gameBoard[i][j] = SquareType.SquareTypeEmpty;

		player1 = null;
		player2 = null;
	}

	public void playGame() throws IOException, PlayersNotInitializedException
	{
		initiateGame();

		/* Make sure both players have been initialized */
		if( player1 == null || player2 == null )
			throw new PlayersNotInitializedException( "Player 1 and Player 2 were not initialized correctly." );

		/* Play until there is a winner */
		boolean winner = false;
		while( winner == false ) {

			/* Draw the updated game board */
			drawScreen();

			/* Receive a move from player 1 */
			receiveMove( player1 );

			/* Check if player 1 won */
			winner = checkForWinner();

			/* Receive a move from player 2 */
			receiveMove( player2 );

			/* Check if player 2 won */
			winner = checkForWinner();
		}
	}

	private void receiveMove( Player player ) throws IOException
	{
		/* Get the player's next coordinate */
		Coordinate coord = player.calculateMove();

		/* Update the game board */
		gameBoard[coord.col][coord.row] = player.getSquareType();
	}

	/* WARNING: NEED TO ACTUALLY CHECK */
	private boolean checkForWinner()
	{
		return false;
	}

	private void initiateGame() throws IOException, PlayersNotInitializedException
	{
		System.out.println( "\n\nWelcome to Tic-Tac-Toe" );
		System.out.println( "Created by: Thomas Hewton-Waters & Andrew Winkler" );

		System.out.print( "\nPlease enter your name: " );

		BufferedReader in = new BufferedReader( new InputStreamReader( System.in ) );
		String userName = in.readLine();

		player1 = new Player( userName, Player.PlayerType.PlayerTypeHuman, SquareType.SquareTypeX );
		
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

	/* WARNING: NEED TO ACTUALLY DRAW X'S AND O'S */
	private void drawGameBoard()
	{
		System.out.println( "\n    Game Board");
		System.out.println( "+-----+-----+-----+" );
		System.out.println( "|     |     |     |" );
		System.out.println( "|     |     |     |" );
		System.out.println( "|     |     |     |" );
		System.out.println( "+-----+-----+-----+" );
		System.out.println( "|     |     |     |" );
		System.out.println( "|     |     |     |" );
		System.out.println( "|     |     |     |" );
		System.out.println( "+-----+-----+-----+" );
		System.out.println( "|     |     |     |" );
		System.out.println( "|     |     |     |" );
		System.out.println( "|     |     |     |" );
		System.out.println( "+-----+-----+-----+\n" );
	}

	public static void main( String[] args ) throws IOException, PlayersNotInitializedException
	{
		Referee ref = new Referee();
		ref.playGame();
	}
}