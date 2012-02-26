package celestialBodies;

import shapes.*;
import exceptions.*;

public class Planet extends CelestialBodies
{
	private int num_moons = 0;
	private Moon[] moons;
	private double orbital_distance;
	private static int num_planets = 0;

	public Planet( Point c, double dist, String name, double r, Moon[] m ) throws MoreThanLimitException, RadiusException
	{
		this( c, dist, name, r, m, false );
	}

	public Planet( Point c, double dist, String name, double r, Moon[] m, boolean rebuild ) throws MoreThanLimitException, RadiusException
	{
		super(c, r, "PL" + num_planets++, name );

		orbital_distance = dist;
		num_moons = 0;

		if( rebuild == true ) {

			if( m.length <= 5 ) {
				moons = new Moon[m.length];
			} else {
				moons = new Moon[5];
			}

			System.out.println( "Rebuilt the planet with " + moons.length + " moons." );

			for( int i = 0; i < moons.length; i++ ) { 
				moons[i] = m[i];
				num_moons++;		
			}

		} else {
			if( m.length > 5 )
				throw new MoreThanLimitException();
			else {
				moons = new Moon[m.length];

				for( int i = 0; i < moons.length; i++ ) {
					moons[i] = m[i];
					num_moons++;	
				}
			}
		}
	}

	public String toString()
	{
		String returnString = 	
		"\nName: " + name + " Object ID: " + id + 
		"\n---------------------" + 
		"\nRadius: " + radius + 
		"\nArea: " + area() + 
		"\nCenter:" +
		"\nX-Coordinate: " + center.get_x() + 
		"\nY-Coordinate: " + center.get_y() + 
		"\nOrbital distance: " + orbital_distance + 
		"\nNumber of moons: " + num_moons;

		for( int i = 0; i < num_moons; i++ ) {
			returnString += moons[i].toString();
		} 

		return returnString;
	}

	public Object clone() throws CloneNotSupportedException
	{
		Planet p = (Planet)super.clone();

		p.moons = new Moon[num_moons];

		for( int i = 0; i < num_moons; i++ )
		p.moons[i] = (Moon)moons[i].clone();

		return p;
	}
}