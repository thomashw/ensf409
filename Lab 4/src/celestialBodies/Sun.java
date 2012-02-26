package celestialBodies;

import exceptions.*;
import shapes.*;

public class Sun extends CelestialBodies {
	
	private double min_distance;
	private int num_planets;
	private Planet[] planets;
	static int num_suns = 0;

	public Sun( Point c, double r, double min_dist, String name, Planet[] p ) throws RadiusException
	{
		super(c, r, "S" + num_suns++, name );

		min_distance = min_dist;

		planets = new Planet[p.length];
		for( int i = 0; i < planets.length; i++ ) {
			planets[i] = p[i];
			num_planets++;
		}
	}

	public Object clone() throws CloneNotSupportedException
	{
		Sun s = (Sun)super.clone();

		s.planets = new Planet[num_planets];
		
		for( int i = 0; i < num_planets; i++ )
			s.planets[i] = (Planet)planets[i].clone();

		return s;
	}

	public void set_radius( double r ) throws RadiusException
	{
		if( radius < 0 )
			throw new RadiusException(name);
		else
			radius = r;
	}

	public String toString()
	{
		String returnString = 	"\nName: " + name + " Object ID: " + id + 
								"\n---------------------" + 
								"\nRadius: " + radius + 
								"\nArea: " + area() + 
								"\nCenter: " +
								"\nX-Coordinate: " + center.get_x() + 
								"\nY-Coordinate: " + center.get_y() + 
								"\nMinimum approach distance: " + min_distance + 
								"\nNumber of planets: " + num_planets;
								
		for( int i = 0; i < num_planets; i++ ) {
			returnString += planets[i].toString();
		} 

		return returnString;
	}
}