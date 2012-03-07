#include <iostream>
using namespace std;

#include "Point.h"
#include "Shape.h"
#include "Square.h"

int main( void )
{
	cout << "\nTesting..\n";

	// Testing Point
	Point p( 3, 4 );

	cout << "X is: " << p.getX() << "\n";
	cout << "Y is: " << p.getY() << "\n";
	cout << "ID is: " << p.getID() << "\n";

	Point q( 2, 6 );

	cout << "X is: " << q.getX() << "\n";
	cout << "Y is: " << q.getY() << "\n";
	cout << "ID is: " << q.getID() << "\n";

	cout << "Distance is: " << p.distance(q) << "\n";
	cout << "Number of Points is: " << p.counter() << "\n";

	p.display();
	q.display();

	// Testing Square
	Square s( "Steve", 2, 9, 3);
	s.display();
	Square t("Bob", 1, 1, 5);
	t.display();

	cout << "Distance is: " << s.distance(t) << "\n";
	cout << "The Area is: " << s.area() << "\n";
	cout << "The perimeter is: " << s.perimeter() << "\n";

	cout << ".. Done Testing.\n\n";
}