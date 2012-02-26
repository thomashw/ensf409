package exceptions;

public class MoreThanLimitException extends Exception 
{
	public MoreThanLimitException() 
	{
		super( "Number of planets or moons is greater than 5." );
	}
}