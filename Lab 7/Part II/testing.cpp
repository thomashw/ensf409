#include <iostream>
using namespace std;

#include "Point.h"
#include "Shape.h"
#include "Square.h"
#include "Rectangle.h"

int main( void )
{
	cout << "\nTesting..\n";

	// Testing Point
	Point p1( 3, 4 );

	cout << "X is: " << p1.getX() << "\n";
	cout << "Y is: " << p1.getY() << "\n";
	cout << "ID is: " << p1.getID() << "\n";

	Point p2( 2, 6 );

	cout << "X is: " << p2.getX() << "\n";
	cout << "Y is: " << p2.getY() << "\n";
	cout << "ID is: " << p2.getID() << "\n";

	cout << "Distance is: " << p1.distance(p2) << "\n";
	cout << "Number of Points is: " << p1.counter() << "\n";

	p1.display();
	p2.display();

	// Testing Square
	Square s1( "Steve", 2, 9, 3 );
	s1.display();
	Square s2( "Bob", 1, 1, 5 );
	s2.display();

	cout << "Distance is: " << s1.distance(s2) << "\n";
	cout << "The Area is: " << s1.area() << "\n";
	cout << "The perimeter is: " << s1.perimeter() << "\n";

	// Testing Rectangle

	Rectangle r1( "Andrew", 2, 2, 3, 5 );
	r1.display();
	Rectangle r2( "Thomas", 4, 4, 5, 7);
	r2.display();

	cout << "Distance is: " << r1.distance(r2) << "\n";
	cout << "The Area is: " << r1.area() << "\n";
	cout << "The perimeter is: " << r1.perimeter() << "\n";

	cout << ".. Done Testing.\n\n";

}