import java.io.*;

public class Referee
{
	public void initiateGame() throws IOException
	{
		System.out.println( "Welcome to Tic-Tac-Toe" );
		System.out.println( "Created by: Thomas Hewton-Waters & Andrew Winkler" );

		System.out.print( "\nPlease enter your name: " );

		BufferedReader in = new BufferedReader( new InputStreamReader( System.in ) );
		String userName = in.readLine();

		Player player1 = new Player( userName, Player.PlayerType.PlayerTypeHuman );
		
		System.out.println( "\nPlease make a selection for your opponent from the following list:" );
		System.out.println( "1. Human Player" );
		System.out.println( "2. Computer Random Player" );
		System.out.println( "3. Computer Blocking Player" );
		System.out.println( "4. Computer Smart Player" );
		System.out.println( "5. Computer-Aided Human Player" );

		int playerSelection = Integer.parseInt( in.readLine() );
		Player player2 = null;

		switch ( playerSelection ) {
			case 1:
				player2 = new Player( null, Player.PlayerType.PlayerTypeHuman );
				break;
			case 2:
				player2 = new Player( null, Player.PlayerType.PlayerTypeComputerRandom );
				break;
			case 3:
				player2 = new Player( null, Player.PlayerType.PlayerTypeComputerBlocking );
				break;
			case 4:
				player2 = new Player( null, Player.PlayerType.PlayerTypeComputerSmart );
				break;
			case 5:
				player2 = new Player( null, Player.PlayerType.PlayerTypeComputerAidedHuman );
				break;
			default:
				System.out.println( "Incorrect selection made." );
				return;
		}
	}

	public static void main( String[] args ) throws IOException
	{
		Referee ref = new Referee();
		ref.initiateGame();
	}
}