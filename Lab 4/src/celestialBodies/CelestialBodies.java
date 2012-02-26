package celestialBodies;

import java.math.*;
import shapes.*;
import exceptions.*;
import interfaces.*;

abstract class CelestialBodies implements Cloneable, Accessible, Calculable
{
	protected Point center;
	protected double radius;
	protected String id;
	protected String name;

	public CelestialBodies( Point c, double r, String id, String name ) throws RadiusException
	{
		if( r < 0 )
			throw new RadiusException(name);

		center = c;
		radius = r;
		this.id = id;
		this.name = name;
	}

	public String get_name()
	{
		return name;
	}

	public String get_id()
	{
		return id;
	}

	public void set_name( String n )
	{
		name = n;
	}
	
	public double area()
	{
		return 4 * Math.PI * Math.pow(radius, 2);
	}

	public double perimeter()
	{
		return 0;
	}

	public double volume()
	{
		return Math.PI * Math.pow( radius, 3 );
	}
}