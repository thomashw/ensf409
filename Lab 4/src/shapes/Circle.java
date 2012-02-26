package shapes;

import exceptions.*;

public class Circle extends Shape {
	
	private static int numCircle = 0;
	private double radius;
	private String id;
	
	public Circle( double x, double y, double r, String name ) throws RadiusException
	{
		super( x, y, name );
		id = "C" + ++numCircle;

		if( r < 0 )
		    throw new RadiusException( id );
		else
		    radius = r;
	}
	
	public double get_radius()
	{
		return radius;
	}
	
	public String get_id()
	{
		return id;
	}
	
	public void set_radius( double r ) throws RadiusException
	{
	    if( r < 0 )
		throw new RadiusException( id );
	    else
		radius  = r;
	}
	
	public double area()
	{
		return Math.PI * Math.pow(radius, 2);
	}
	
	public double perimeter()
	{
		return 2 * Math.PI * radius;
	}

    public double volume()
    {
        return 0;
    }
	
	public String toString()
	{
		return "Shape name: " + super.get_name() +
				"\nShape ID: " + this.id +
				"\nOrigin: Point Id: " + super.get_origin().get_id() +
				"\nX_coordinate: " + super.get_origin().get_x() + 
				"\nY_coordinate: " + super.get_origin().get_y() +
				"\nRadius: " + this.radius;
	}
	
}