
public class GraphicsWorld {

	public void create_shape_list()
	{
		System.out.println("This program has been written by: AW & THW." );
		System.out.println("Submitted at: 1:15 pm, February 3, 2012");
		System.out.println("Testing Functions in class Point:" );
		
		Point p1 = new Point(55, 66); 
		Point p2 = new Point (22, 33);
		
		System.out.println("\nThe distance between p1 and p2 is: " + p1.distance(p2));
		
		System.out.println("Testing Functions in class Rectangle:");
		Rectangle a = new Rectangle (5, 7, 12, 15, "RECTANGLE A"); 
		System.out.println(a);
		System.out.println("Area: " + a.area() + " Perimeter: " + a.perimeter());
		
		Rectangle b = new Rectangle (16 , 7, 8, 9, "RECTANGLE B"); 
		System.out.println(b);
		System.out.println("Area: " + b.area() + " Perimeter: " + b.perimeter());
		double d = a.distance(b); 
		System.out.println("\nThe distance between two rectangles is: " + d);
		
		System.out.println("Testing Functions in class Circle:");
		Circle c = new Circle (3, 5, 9, "CIRCLE C"); 
		System.out.println(c);
		
		System.out.println("Area: " + c.area() + " Perimeter: " + c.perimeter());
		d = a.distance(c);
		System.out.println("\nThe distance between rectangle a and circle c is: " +d);
		
		Prism p = new Prism (3, 5, 9, 10, 11, "PRISM P"); 
		System.out.println(p);
		System.out.println("Surface Area: " + p.area() + "\nBase Perimeter :" + p.perimeter() + "\nVolume: " + p.volume());
		d = a.distance(p);
		System.out.println("\nThe distance between rectangle a and prism p is: " +d);
		
		// Using array of Shape pointers:
		Shape shape_array[] = new Shape[4]; 
		shape_array[0] = a;
		shape_array[1] = b;
		shape_array [2] = c;
		shape_array [3] = p;
		System.out.println(shape_array[0]);
		System.out.println("Area: " + shape_array[0].area() + " Perimeter: " + shape_array[0].perimeter());
		System.out.println(shape_array[1]);
		System.out.println("Area: " + shape_array[1].area() + " Perimeter: " + shape_array[1].perimeter());
		System.out.println(shape_array[2]);
		System.out.println("Area: " + shape_array[2].area() + " Perimeter: " + shape_array[2].perimeter());
		System.out.println(shape_array[3]);
		System.out.println("Surface Area: " + shape_array[3].area() + "\nBase Perimeter:" + shape_array[3].perimeter() + "\nVolume: " + shape_array[3].volume());
		System.out.println("Counting the number of shapes and points:"); System.out.println("Total number of shapes: " + Shape.count()); System.out.println("Total number of points is: " + Point.count());
	}
    
    public static void main( String[] args )
    {
        GraphicsWorld world = new GraphicsWorld();
        world.create_shape_list();
    }
}
