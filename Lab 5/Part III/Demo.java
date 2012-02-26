// Demo.java
// Started by: M. Moussavi
// Coompleted by: Thomas Hewton-Waters

public class Demo  {
	public void lab5_tests()
	{
		/* Testing Integer LinkedList */
		System.out.println("\nTesting LinkedList<Integer>");
		LinkedList<Integer> lt1 = new LinkedList<Integer>();
		lt1.push_back(1111);
		lt1.push_back(2222);
		System.out.println("Printing lt1:");
		lt1.print();
		lt1.remove(1111);
		lt1.remove(2992);

		/* Testing Product LinkedList */
		System.out.println("\nTesting LinkedList<Product>");
		Product p1 = new Product( "ProductA", 14, 8, 2003, 1 );
		Product p2 = new Product( "ProductB", 13, 9, 2004, 2 );
		LinkedList<Product> lt2 = new LinkedList<Product>();
		lt2.push_back( p1 );
		lt2.push_back( p2 );
		System.out.println("Printing lt2:");
		lt2.print();
		try_to_find(lt2, p1);
		
		/* Testing cloning Product LinkedList */
		System.out.println("\nTesting cloning LinkedList<Product>");
		LinkedList<Product> lt3;
		try {
			lt3 = (LinkedList<Product>) lt2.clone();
			System.out.println("Printing lt3 as a copy of lt2:");
			lt3.print();
			try_to_find(lt3, p2);
			
		}
		catch (CloneNotSupportedException e) {
			System.out.println("Copying lists failed....");
		}
		
		/* Testing Date LinkedList */
		System.out.println("\nTesting LinkedList<Date>");
		LinkedList<Date> lt4 = new LinkedList<Date>();
		Date d1 = new Date( 3, 5, 1988 );
		Date d2 = new Date( 5, 6, 2010 );
		lt4.push_back( d1 );
		lt4.push_back( d2 );
		System.out.println( "Printing lt4." );
		lt4.print();
		System.out.println( "Removing " + d1.toString() + " from lt4." );
		System.out.println( "Printing lt4." );
		lt4.remove( d1 );
		lt4.print();

		/* Test Point linked list */
		System.out.println("\nTesting LinkedList<Point>");
		LinkedList<Point> lt5 = new LinkedList<Point>();
		Point po1 = new Point( 1.0, 3.0 );
		Point po2 = new Point( 2.0, 4.0 );
		lt5.push_back( po1 );
		lt5.push_back( po2 );
		System.out.println( "Printing lt5." );
		lt5.print();
		try_to_find( lt5, po2 );

		/* Test String linked list */
		System.out.println("\nTesting LinkedList<String>");
		LinkedList<String> lt6 = new LinkedList<String>();
		lt6.push_front( "string1" );
		lt6.push_front( "string2" );
		System.out.println( "Printing lt6." );
		lt6.print();
		try_to_find( lt6, "string1" );
		System.out.println("Removing string1");
		lt6.remove( "string1" );
		try_to_find( lt6, "string1" );
		
		System.out.println ( "***----Finished testing----------------***"); 
	}

	public <T extends Comparable> void try_to_find(LinkedList lt, T keyA)

	{
		lt.find(keyA);
		if (lt.cursor_ok())

		System.out.println (keyA + " FOUND in the list." );

		else
		System.out.println(keyA + " NOT FOUND in the list.");
	}


	public static void main(String [] args)
	{
		Demo d = new Demo();
		d.lab5_tests();
	}
}