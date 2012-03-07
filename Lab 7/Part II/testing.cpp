#include <iostream>
using namespace std;

#include "Point.h"

int main( void )
{
	cout << "Testing..\n";

	Point p( 3, 4 );

	cout << "X is: " << p.getX() << "\n";
	cout << "Y is: " << p.getY() << "\n";
	cout << "ID is: " << p.getID() << "\n";

	Point q( 2, 6 );

	cout << "X is: " << q.getX() << "\n";
	cout << "Y is: " << q.getY() << "\n";
	cout << "ID is: " << q.getID() << "\n";

	cout << "Distance is: " << p.distance( q ) << "\n";

	cout << p.counter() << "\n";
	cout << q.counter() << "\n";

	cout << ".. Done Testing.\n";
}