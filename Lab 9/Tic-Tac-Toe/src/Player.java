import java.io.*;

public class Player
{
	public enum PlayerType
	{
		PlayerTypeHuman,
		PlayerTypeComputerRandom,
		PlayerTypeComputerBlocking,
		PlayerTypeComputerSmart,
		PlayerTypeComputerAidedHuman
	};

	private String name;
	private PlayerType playerType;

	/* Holds whether the player is X's or O's */
	private SquareType squareType;

	public Player( String name, PlayerType aPlayerType, SquareType aSquareType )
	{
		this.name = name;
		this.playerType = aPlayerType;
		this.squareType = aSquareType;
	}

	public SquareType getSquareType()
	{
		return squareType;
	}

	/* Calculate's the move for any type of player (human or computer) */
	public Coordinate calculateMove() throws IOException
	{
		Coordinate coord = null;

		switch( playerType )
		{
			case PlayerTypeHuman:
			coord = calculateMoveHuman();
			break;

			case PlayerTypeComputerRandom:
			coord = calculateMoveComputerRandom();
			break;

			case PlayerTypeComputerBlocking:
			coord = calculateMoveComputerBlocking();
			break;

			case PlayerTypeComputerSmart:
			coord = calculateMoveComputerSmart();
			break;

			case PlayerTypeComputerAidedHuman:
			coord = calculateMoveComputerAidedHuman();
			break;

			default:
			break;
		}

		return coord;
	}

	/* Takes input from the terminal for the person's next move */
	private Coordinate calculateMoveHuman() throws IOException
	{
		BufferedReader in = new BufferedReader( new InputStreamReader( System.in ) );

		System.out.println( "\n" + name + ", please enter your next move." );
		System.out.print( "row: " );
		int row = Integer.parseInt( in.readLine() );

		System.out.print( "col: " );
		int col = Integer.parseInt( in.readLine() );

		return new Coordinate( row, col );
	}

	/* WARNING: NEED TO IMPLEMENT ALGORITHM */
	private Coordinate calculateMoveComputerRandom()
	{
		Coordinate coord = new Coordinate( 0, 0 );

		return coord;
	}

	/* WARNING: NEED TO IMPLEMENT ALGORITHM */
	private Coordinate calculateMoveComputerBlocking()
	{
		Coordinate coord = new Coordinate( 0, 0 );

		return coord;
	}

	/* WARNING: NEED TO IMPLEMENT ALGORITHM */
	private Coordinate calculateMoveComputerSmart()
	{
		Coordinate coord = new Coordinate( 0, 0 );

		return coord;
	}

	/* WARNING: NEED TO IMPLEMENT ALGORITHM */
	private Coordinate calculateMoveComputerAidedHuman()
	{
		Coordinate coord = new Coordinate( 0, 0 );

		return coord;
	}
}