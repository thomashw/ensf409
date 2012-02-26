
public abstract class Shape {
	
	private Point origin;
	private String shapeName;
	private static int numShapes = 0;
	private String id;
	
	public Shape(  double x, double y, String name )
	{
		origin = new Point(x,y);
		shapeName = name;
		id = "Shape" + ++numShapes;
	}

    public abstract double area();
    public abstract double perimeter();
    public abstract double volume();
	
	public Point get_origin()
	{
		return origin;
	}
	
	public String get_name()
	{
		return shapeName;
	}
	
	public String get_id()
	{
		return id;
	}
	
	public static int count()
	{
		return numShapes;
	}
	
	public void set_name(String name)
	{
		shapeName = name;
	}
	
	public void set_origin(Point p)
	{
		origin = p;
	}
	
	public double distance(Shape s)
	{
		return this.origin.distance(s.get_origin());
	}
	
	public static double distance(Shape s1, Shape s2)
	{
		return Point.distance(s1.get_origin(), s2.get_origin());
	}
	
	public void move(double dx, double dy)
	{
		origin.set_x( origin.get_x() + dx );
		origin.set_y( origin.get_y() + dy );
	}
	
	public String toString()
	{
		return "Shape name: " + this.shapeName + 
				"\nShape Id: " + this.id + 
				"\nOrigin: Point Id: " + this.origin.get_id() + 
				"\nX_coordinate: " + this.origin.get_x() + 
				"\nY_coordinate: " + this.origin.get_y();
	}
	
}
