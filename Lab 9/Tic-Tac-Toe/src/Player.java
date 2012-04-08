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

	public Coordinate calculateMove()
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

	private Coordinate calculateMoveHuman()
	{
		Coordinate coord = new Coordinate( 0, 0 );

		return coord;
	}

	private Coordinate calculateMoveComputerRandom()
	{
		Coordinate coord = new Coordinate( 0, 0 );

		return coord;
	}

	private Coordinate calculateMoveComputerBlocking()
	{
		Coordinate coord = new Coordinate( 0, 0 );

		return coord;
	}

	private Coordinate calculateMoveComputerSmart()
	{
		Coordinate coord = new Coordinate( 0, 0 );

		return coord;
	}

	private Coordinate calculateMoveComputerAidedHuman()
	{
		Coordinate coord = new Coordinate( 0, 0 );

		return coord;
	}
}