import java.io.*;
import java.util.Random;

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

	public String getName()
	{
		return name;
	}

	/* Calculate's the move for any type of player (human or computer) */
	public Coordinate calculateMove( SquareType[][] gameBoard ) throws IOException
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
			coord = calculateMoveComputerBlocking( gameBoard );
			break;

			case PlayerTypeComputerSmart:
			coord = calculateMoveComputerSmart( gameBoard );
			break;

			case PlayerTypeComputerAidedHuman:
			coord = calculateMoveComputerAidedHuman( gameBoard );
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

	/* Generates a random row and column */
	private Coordinate calculateMoveComputerRandom()
	{
		Random rand = new Random();

		int row = rand.nextInt(3);
		int col = rand.nextInt(3);

		return new Coordinate( row, col );
	}

	/* Check for blocking first, if not then generate random */
	private Coordinate calculateMoveComputerBlocking( SquareType[][] gameBoard )
	{
		Coordinate coord = new Coordinate( 0, 0 );

		if( checkForBlocking( coord , gameBoard )  )
			return coord;

		else {
			coord = calculateMoveComputerRandom();
			return coord;
		}
	}

	/* Check for win first, then for blocking, if not then generate random */
	private Coordinate calculateMoveComputerSmart( SquareType[][] gameBoard )
	{
		Coordinate coord = new Coordinate( 0, 0 );

		if( checkForWin( coord, gameBoard ) )
			return coord;
		
		else if( checkForBlocking( coord, gameBoard ) )
			return coord;

		else {
			coord = calculateMoveComputerRandom();
			return coord;
		}
	}

	/* Check for blocking first, if not then lets user pick next move */
	private Coordinate calculateMoveComputerAidedHuman( SquareType[][] gameBoard ) throws IOException
	{
		Coordinate coord = new Coordinate( 0, 0 );
		
		if( checkForBlocking( coord, gameBoard )  )
			return coord;

		else {
			coord = calculateMoveHuman();
			return coord;
		}
	}

	private boolean checkForBlocking( Coordinate coord, SquareType[][] gameBoard  )
	{
		SquareType squareTypeWin;

		if( this.squareType == SquareType.SquareTypeO )
			squareTypeWin = SquareType.SquareTypeX;
		else
			squareTypeWin = SquareType.SquareTypeO;

		for( int i = 0; i < 3; i++ ) {
			for( int j = 0; j < 3; j++ ) {
				if( gameBoard[i][j] == SquareType.SquareTypeEmpty ) {
					/* Case 1 */
					if( i== 0 && j == 0 ) {
						if( gameBoard[0][1] == squareTypeWin && gameBoard[0][2] == squareTypeWin ) {
							coord.row = i;
							coord.col = j;
							return true;
						}
						if( gameBoard[1][0] == squareTypeWin && gameBoard[2][0] == squareTypeWin ) {
							coord.row = i;
							coord.col = j;
							return true;
						}
						if( gameBoard[1][1] == squareTypeWin && gameBoard[2][2] == squareTypeWin ) {
							coord.row = i;
							coord.col = j;
							return true;
						}
					}

					/* Case 2 */
					if( i== 0 && j == 1 ) {
						if( gameBoard[0][0] == squareTypeWin && gameBoard[0][2] == squareTypeWin ) {
							coord.row = i;
							coord.col = j;
							return true;
						}
						if( gameBoard[1][1] == squareTypeWin && gameBoard[1][2] == squareTypeWin ) {
							coord.row = i;
							coord.col = j;
							return true;
						}
					}	

					/* Case 3 */
					if( i== 0 && j == 2 ) {
						if( gameBoard[0][0] == squareTypeWin && gameBoard[0][1] == squareTypeWin ) {
							coord.row = i;
							coord.col = j;
							return true;
						}
						if( gameBoard[1][2] == squareTypeWin && gameBoard[2][2] == squareTypeWin ) {
							coord.row = i;
							coord.col = j;
							return true;
						}
						if( gameBoard[1][1] == squareTypeWin && gameBoard[2][0] == squareTypeWin ) {
							coord.row = i;
							coord.col = j;
							return true;
						}
					}


					/* Case 4 */
					if( i== 1 && j == 0 ) {
						if( gameBoard[0][0] == squareTypeWin && gameBoard[2][0] == squareTypeWin ) {
							coord.row = i;
							coord.col = j;
							return true;
						}
						if( gameBoard[1][1] == squareTypeWin && gameBoard[1][2] == squareTypeWin ) {
							coord.row = i;
							coord.col = j;
							return true;
						}
					}


					/* Case 5 */
					if( i== 1 && j == 1 ) {
						if( gameBoard[0][0] == squareTypeWin && gameBoard[2][2] == squareTypeWin ) {
							coord.row = i;
							coord.col = j;
							return true;
						}
						if( gameBoard[0][2] == squareTypeWin && gameBoard[2][0] == squareTypeWin ) {
							coord.row = i;
							coord.col = j;
							return true;
						}
						if( gameBoard[1][0] == squareTypeWin && gameBoard[1][2] == squareTypeWin ) {
							coord.row = i;
							coord.col = j;
							return true;
						}
						if( gameBoard[0][1] == squareTypeWin && gameBoard[2][1] == squareTypeWin ) {
							coord.row = i;
							coord.col = j;
							return true;
						}
					}

					/* Case 6 */
					if( i== 1 && j == 2 ) {
						if( gameBoard[1][0] == squareTypeWin && gameBoard[1][1] == squareTypeWin ) {
							coord.row = i;
							coord.col = j;
							return true;
						}
						if( gameBoard[0][2] == squareTypeWin && gameBoard[2][2] == squareTypeWin ) {
							coord.row = i;
							coord.col = j;
							return true;
						}

					}

					/* Case 7 */
					if( i== 2 && j == 0 ) {
						if( gameBoard[0][0] == squareTypeWin && gameBoard[1][0] == squareTypeWin ) {
							coord.row = i;
							coord.col = j;
							return true;
						}
						if( gameBoard[1][1] == squareTypeWin && gameBoard[0][2] == squareTypeWin ) {
							coord.row = i;
							coord.col = j;
							return true;
						}
						if( gameBoard[2][1] == squareTypeWin && gameBoard[2][2] == squareTypeWin ) {
							coord.row = i;
							coord.col = j;
							return true;
						}
					}

					/* Case 8 */
					if( i== 2 && j == 1 ) {
						if( gameBoard[0][1] == squareTypeWin && gameBoard[1][1] == squareTypeWin ) {
							coord.row = i;
							coord.col = j;
							return true;
						}
						if( gameBoard[2][0] == squareTypeWin && gameBoard[2][2] == squareTypeWin ) {
							coord.row = i;
							coord.col = j;
							return true;
						}
					}

					/* Case 9 */
					if( i== 2 && j == 2 ) {
						if( gameBoard[0][2] == squareTypeWin && gameBoard[1][2] == squareTypeWin ) {
							coord.row = i;
							coord.col = j;
							return true;
						}
						if( gameBoard[2][0] == squareTypeWin && gameBoard[2][1] == squareTypeWin ) {
							coord.row = i;
							coord.col = j;
							return true;
						}
						if( gameBoard[0][0] == squareTypeWin && gameBoard[1][1] == squareTypeWin ) {
							coord.row = i;
							coord.col = j;
							return true;
						}
					}

				}
			}
		}

		return false;
	}

	private boolean checkForWin( Coordinate coord, SquareType[][] gameBoard  )
	{
		SquareType squareTypeWin = this.squareType;

		for( int i = 0; i < 3; i++ ) {
			for( int j = 0; j < 3; j++ ) {
				if( gameBoard[i][j] == SquareType.SquareTypeEmpty ) {

					/* Case 1 */
					if( i== 0 && j == 0 ) {
						if( gameBoard[0][1] == squareTypeWin && gameBoard[0][2] == squareTypeWin ) {
							coord.row = i;
							coord.col = j;
							return true;
						}
						if( gameBoard[1][0] == squareTypeWin && gameBoard[2][0] == squareTypeWin ) {
							coord.row = i;
							coord.col = j;
							return true;
						}
						if( gameBoard[1][1] == squareTypeWin && gameBoard[2][2] == squareTypeWin ) {
							coord.row = i;
							coord.col = j;
							return true;
						}
					}

					/* Case 2 */
					if( i== 0 && j == 1 ) {
						if( gameBoard[0][0] == squareTypeWin && gameBoard[0][2] == squareTypeWin ) {
							coord.row = i;
							coord.col = j;
							return true;
						}
						if( gameBoard[1][1] == squareTypeWin && gameBoard[1][2] == squareTypeWin ) {
							coord.row = i;
							coord.col = j;
							return true;
						}
					}	

					/* Case 3 */
					if( i== 0 && j == 2 ) {
						if( gameBoard[0][0] == squareTypeWin && gameBoard[0][1] == squareTypeWin ) {
							coord.row = i;
							coord.col = j;
							return true;
						}
						if( gameBoard[1][2] == squareTypeWin && gameBoard[2][2] == squareTypeWin ) {
							coord.row = i;
							coord.col = j;
							return true;
						}
						if( gameBoard[1][1] == squareTypeWin && gameBoard[2][0] == squareTypeWin ) {
							coord.row = i;
							coord.col = j;
							return true;
						}
					}


					/* Case 4 */
					if( i== 1 && j == 0 ) {
						if( gameBoard[0][0] == squareTypeWin && gameBoard[0][2] == squareTypeWin ) {
							coord.row = i;
							coord.col = j;
							return true;
						}
						if( gameBoard[1][1] == squareTypeWin && gameBoard[1][2] == squareTypeWin ) {
							coord.row = i;
							coord.col = j;
							return true;
						}
					}


					/* Case 5 */
					if( i== 1 && j == 1 ) {
						if( gameBoard[0][0] == squareTypeWin && gameBoard[2][2] == squareTypeWin ) {
							coord.row = i;
							coord.col = j;
							return true;
						}
						if( gameBoard[0][2] == squareTypeWin && gameBoard[2][0] == squareTypeWin ) {
							coord.row = i;
							coord.col = j;
							return true;
						}
						if( gameBoard[1][0] == squareTypeWin && gameBoard[1][2] == squareTypeWin ) {
							coord.row = i;
							coord.col = j;
							return true;
						}
						if( gameBoard[0][1] == squareTypeWin && gameBoard[2][1] == squareTypeWin ) {
							coord.row = i;
							coord.col = j;
							return true;
						}
					}

					/* Case 6 */
					if( i== 1 && j == 2 ) {
						if( gameBoard[1][0] == squareTypeWin && gameBoard[1][1] == squareTypeWin ) {
							coord.row = i;
							coord.col = j;
							return true;
						}
						if( gameBoard[0][2] == squareTypeWin && gameBoard[2][2] == squareTypeWin ) {
							coord.row = i;
							coord.col = j;
							return true;
						}

					}

					/* Case 7 */
					if( i== 2 && j == 0 ) {
						if( gameBoard[0][0] == squareTypeWin && gameBoard[1][0] == squareTypeWin ) {
							coord.row = i;
							coord.col = j;
							return true;
						}
						if( gameBoard[1][1] == squareTypeWin && gameBoard[0][2] == squareTypeWin ) {
							coord.row = i;
							coord.col = j;
							return true;
						}
						if( gameBoard[2][1] == squareTypeWin && gameBoard[2][2] == squareTypeWin ) {
							coord.row = i;
							coord.col = j;
							return true;
						}
					}

					/* Case 8 */
					if( i== 2 && j == 1 ) {
						if( gameBoard[0][1] == squareTypeWin && gameBoard[1][1] == squareTypeWin ) {
							coord.row = i;
							coord.col = j;
							return true;
						}
						if( gameBoard[2][0] == squareTypeWin && gameBoard[2][2] == squareTypeWin ) {
							coord.row = i;
							coord.col = j;
							return true;
						}
					}

					/* Case 9 */
					if( i== 2 && j == 2 ) {
						if( gameBoard[0][2] == squareTypeWin && gameBoard[1][2] == squareTypeWin ) {
							coord.row = i;
							coord.col = j;
							return true;
						}
						if( gameBoard[2][0] == squareTypeWin && gameBoard[2][1] == squareTypeWin ) {
							coord.row = i;
							coord.col = j;
							return true;
						}
						if( gameBoard[0][0] == squareTypeWin && gameBoard[1][1] == squareTypeWin ) {
							coord.row = i;
							coord.col = j;
							return true;
						}
					}

				}
			}
		}

		return false;
	}
}