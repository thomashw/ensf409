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

		//Player user = new Player( userName );
		
		System.out.println( "\nPlease make a selection for your opponent from the following list:" );
		System.out.println( "1. Human Player" );
		System.out.println( "2. Computer Random Player" );
		System.out.println( "3. Computer Blocking Player" );
		System.out.println( "4. Computer Smart Player" );
		System.out.println( "5. Computer-Aided Human Player" );

		int playerSelection = Integer.parseInt( in.readLine() );
	}

	public static void main( String[] args ) throws IOException
	{
		Referee ref = new Referee();
		ref.initiateGame();
	}
}