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
	private PlayerType type;

	public Player( String name, PlayerType type )
	{
		this.name = name;
		this.type = type;
	}

	public Coordinate calculateMove()
	{
		Coordinate coord = null;

		switch( type )
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