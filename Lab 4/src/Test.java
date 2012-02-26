import shapes.*;
import exceptions.*;
import celestialBodies.*;
import interfaces.*;

public class Test
{
	public static void main( String[] args ) throws RadiusException
	{
		// Testing cloning Point
		Point x = new Point( 0, 0 );
		Point y = new Point( 12, 21 );

		try {
			Point z = (Point)x.clone();
		} 
		catch ( Exception e ) {
			System.err.println( e );
		}

		Point[] pArray = new Point[11];

		for( int i = 0; i < pArray.length; i++ )
		pArray[i] = new Point( 100 + i, 200 + i );

		// Testing Moon
		Moon m[][] = new Moon[2][6];
		Moon n[] = new Moon[2];
		Moon o[] = new Moon[6];
		m[0] = n;
		m[1] = o;

		try {
			m[0][0] = new Moon( pArray[0], 1, "Hard Rock Moon", 443.211 );
			m[0][1] = new Moon( pArray[1], 5, "Soft Rock Moon", 434312.3 );
			m[1][0] = new Moon( pArray[2], 1, "Monkey Land", 9998 );
			m[1][1] = new Moon( pArray[3], 3, "Far Island", 9 );
			m[1][2] = new Moon( pArray[4], 9, "Planet of the Apes", 32 );
			m[1][3] = new Moon( pArray[5], 8, "Java Land", 10 );
			m[1][4] = new Moon( pArray[6], 7, "Black Rocks", 12 );
			m[1][5] = new Moon( pArray[7], 11, "Black Rocks", 12 );
		}
		catch ( Exception e ) {
			System.err.println( e );
			try {
				m[1][5] = new Moon( pArray[7], 10, "Black Rocks", 12, true );
			} catch ( Exception f ) {
				System.err.println( f );
			}
		}

		// Testing Planet
		Planet [] p = new Planet[2];

		try {
			p[0] = new Planet( pArray[8], 10001311.0, "H4X0rZ", 600.00, m[0], false );
		} catch ( Exception e ) {
			System.err.println( e );	
		}

		try {
			p[1] = new Planet( pArray[9], 10021, "Tatooine", 10.00, m[1] );
		}
		catch ( Exception e ) {
			System.err.println( e );
			try {
				p[1] = new Planet( pArray[9], 10021, "Tatooine", 10.00, m[1], true );
			} catch ( Exception f ) {
				System.err.println( f );
			}
		}

		System.out.println( p[0].toString() );
		System.out.println( p[1].toString() );

		// Testing Circle
		Circle small = null;
		try {
			small = new Circle(23, 25, 10, "small"); 
		}
		catch( RadiusException e) {
			System.err.println( e );
		}

		System.out.println(small);

		Circle copy = null;
		try{
			copy = (Circle)small.clone();
		}
		catch ( Exception e ) {
			System.err.println( e );
		}
		System.out.println( copy );

		// Testing Sun
		Sun s = null;
		try { 
			s = new Sun( pArray[9], 1123, 10009999, "The SUN", p);
		}
		catch( RadiusException e) {
			System.err.println( e );
		}

		System.out.println( s );

		Sun blackhole = null;
		try{
			blackhole = (Sun)s.clone();
		}
		catch ( Exception e ) {
			System.err.println( e );
		}
		System.out.println( blackhole );

		try {
			s.set_radius( 2000 );
		}
		catch ( RadiusException e ) {
			System.err.println( e );
		}

		System.out.println( s );
		System.out.println( blackhole );

		access(s, s);
		access(m[0][0], m[0][0]);
		access(p[0], p[0]);
		access(small, small);

	} // END OF MAIN METHOD

	static public void access ( Accessible ac, Calculable ca ) 
	{
		ac.get_name();
		ac.get_id();
		ac.set_name( "New Name" );

		ca.area();
		ca.perimeter();
		ca.volume();

	}// END OF ACCESS METHOD
}
