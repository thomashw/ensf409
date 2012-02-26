
public class Rectangle extends Shape {

	private static int numRectangle = 0;
	private double width;
	private double length;
	private String id;
	
	public Rectangle(  double x, double y, double w, double l, String name )
	{
		super( x, y, name );
		width = w;
		length = l;
		id = "R" + ++numRectangle;
	}
	
	public double get_width()
	{
		return width;
	}
	
	public double get_length()
	{
		return length;
	}
	
	public String get_id()
	{
		return id;
	}
	
	public void set_width( double w )
	{
		width = w;
	}
	
	public void set_length( double l )
	{
		width = l;
	}
	
	public double area()
	{
		return width * length;
	}
	
	public double perimeter()
	{
		return 2 * (width + length);
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
				"\nWidth: " + this.width +
				"\nLength " + this.length;
	}
}
