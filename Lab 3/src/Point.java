
public class Point {
	
	private double x_coordinate, y_coordinate;
	static int numPoints = 0;
	private String id;
	
	public Point( double x, double y)
	{
		x_coordinate = x;
		y_coordinate = y;
		id = "P" + ++numPoints;
	}
	
	public double get_x()
	{
		return x_coordinate;
	}
	
	public double get_y()
	{
		return y_coordinate;
	}
	
	public String get_id()
	{
		return id;
	}
	
	public static int count()
	{
		return numPoints;
	}
	
	public void set_x(double x)
	{
		x_coordinate = x;
	}
	
	public void set_y(double y)
	{
		y_coordinate = y;
	}
	
	public String toString()
	{
		return "\nPoint id: " + id + 
				"\nX-coordinate: " + x_coordinate + 
				"\nY-coordinate: " + y_coordinate;
	}
	
	public double distance( Point p )
	{
		return Math.sqrt(Math.pow(this.x_coordinate-p.get_x(),2) + Math.pow(this.y_coordinate-p.get_y(),2));
	}
	
	public static double distance( Point p1, Point p2 )
	{
		return Math.sqrt(Math.pow(p1.get_x()-p2.get_x(),2) + Math.pow(p1.get_y()-p2.get_y(),2));
	}
	
	public static void main( String[] args )
	{
		Point p1 = new Point(1,2);
		Point p2 = new Point(2,3);
		
		System.out.println(p1.toString());
		System.out.println(p2.toString());
		System.out.println("Distance P1-P2 (instance method): " + p1.distance(p2));
		System.out.println("Distance P1-P2 (class method): " + Point.distance(p1, p2));
	}
}
