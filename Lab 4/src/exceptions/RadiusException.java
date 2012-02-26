package exceptions;

public class RadiusException extends Exception
{
    public RadiusException(String name)
    {
		super("Circle has incorrect radius in object: " + name);
    }

}
