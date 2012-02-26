package exceptions;

public class MoonRadiusException extends Exception
{
	public MoonRadiusException( String name )
	{
		super( "Moon radius out of range (0 - 10), in object: " + name );
	}
}