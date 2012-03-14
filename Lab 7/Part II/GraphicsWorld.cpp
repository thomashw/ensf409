#include <iostream>
using namespace std;

#include "Point.h"
#include "Shape.h"
#include "Rectangle.h"
#include "Square.h"
#include "GraphicsWorld.h"

GraphicsWorld::GraphicsWorld() {}

void GraphicsWorld::run()
{
	cout << "\n** Program Written by: Andrew Winkler & Thomas Hewton-Waters **\n";

	// Testing Point
	cout << "\nTesting Functions in class Point:\n";
	Point m ( 6, 8 );
	Point n ( 6, 8 );
	cout << "The number of points so far is: " << Point::counter() << "\n"; 
	n.setX(9); 
	m.display(); 
	n.display();
	cout << "The distance between the two points is: " << m.distance(n) << "\n";

	// Testing Square
	cout << "\nTesting Functions in class Square:\n";
	Square s( (char*)"SQUARE - S", 5, 7, 12 ); 
	s.display();
	cout << "The area of " << s.getName() << " is: " << s.area() << "\n"; 
	cout << "The perimeter of " << s.getName() << " is: " << s.perimeter() << "\n";

	// Testing Rectangle
	cout << "\nTesting Functions in class Rectangle:\n";
	Rectangle a( (char*)"RECTANGLE A", 5, 7, 12, 15 ); 
	a.display();
	Rectangle b( (char*)"RECTANGLE B", 16 , 7, 8, 9 ); 
	b.display();
	cout << "The area of " << a.getName() << " is: " << a.area() << "\n"; 
	cout << "The perimeter of " << a.getName() << " is: " << a.perimeter() << "\n";
	double d = a.distance(b);
	cout << "The distance between the two rectangles is: " << d << "\n";

	// Testing copy constructor
	cout << "\nTesting the copy constructor in class Rectangle:\n";
	Rectangle rec1 = a;
	rec1.display();

	cout << "\n.. Done Testing.\n\n";
}