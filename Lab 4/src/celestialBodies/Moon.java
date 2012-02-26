package celestialBodies;

import shapes.*;
import exceptions.*;

public class Moon extends CelestialBodies 
{
	private static int num_moons = 0;
	private double distance_from_planet;

	public Moon( Point c, double r, String name, double dist ) throws MoonRadiusException, RadiusException
	{	
		this( c, r, name, dist, false );
	}

	public Moon( Point c, double r, String name, double dist, boolean rebuild ) throws MoonRadiusException, RadiusException
	{	
		super( c, r, "MO" + num_moons++, name );

		if( rebuild == true ) {
			System.out.println("Moon MO" + num_moons + " was rebuilt with a radius of 10.");
			radius = 10;
		} else {
			if( r <= 0 || r > 10 ) {
				throw new MoonRadiusException( name );
			}
		}

		distance_from_planet = dist;
	}

	public String toString()
	{
		return 	"\nName: " + name + "  Object ID: " + id + 
		"\n---------------------" + 
		"\nRadius: " + radius + 
		"\nArea: " + area() + 
		"\nCenter: " + 
		"\nX-Coordinate: " + center.get_x() + 
		"\nY-Coordinate: " + center.get_y() + 
		"\nDistance from planet: " + distance_from_planet;
	}

	public Object clone() throws CloneNotSupportedException
	{
		Moon m = (Moon)super.clone();

		return m;
	}
}