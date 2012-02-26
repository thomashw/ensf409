
public class Prism extends Rectangle {

	private static int numPrism = 0;
	private double height;
	private String id;
	
	public Prism( double x, double y, double w, double l, double h, String name )
	{
		super( x, y, w , l, name );
		height = h;
		id = "PR" + ++numPrism;
	}
	
	public double get_height()
	{
		return height;
	}
	
	public String get_id()
	{
		return id;
	}
	
	public void set_height( double h )
	{
		height = h;
	}
	
	public double area()
	{
		return 2 * ( (super.area())
				   + (super.get_length() * this.height)
				   + (super.get_width() * this.height) );
	}
	
	public double perimeter()
	{
		return super.perimeter();
	}
	
	public double volume()
	{
		return super.area() * this.height;
	}
	
	public String toString()
	{
		return "Shape name: " + super.get_name() +
				"\nShape ID: " + this.id +
				"\nOrigin: Point Id: " + get_id() +
				"\nX_coordinate: " + super.get_origin().get_x() + 
				"\nY_coordinate: " + super.get_origin().get_y() +
				"\nWidth: " + super.get_width() +
				"\nLength " + super.get_length() +
				"\nHeight " + this.height;
	}
}
