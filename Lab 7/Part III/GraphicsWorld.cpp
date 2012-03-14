#include <iostream>
using namespace std;

#include "Point.h"
#include "Shape.h"
#include "Square.h"
#include "Circle.h"
#include "Rectangle.h"
#include "CornerCut.h"
#include "GraphicsWorld.h"

GraphicsWorld::GraphicsWorld() {}

void GraphicsWorld::run()
{
	cout << "\n** Program Written by: Andrew Winkler & Thomas Hewton-Waters **\n";

	Rectangle a ( "RECTANGLE A", 5, 7, 12, 15 );

	// Testing functions in class Circle
	cout << "\n-Testing Functions in class Circle:" << "\n";
	Circle c ( "CIRCLE C", 3, 5, 9 ); 
	c.display();
	cout << "The area of " << c.getName() << " is: " << c.area() << "\n"; 
	cout << "The circumference of " << c.getName() << " is: " << c.perimeter() << "\n"; 
	double d = a.distance(c);
	cout << "The distance between rectangle a and circle c is: " << d << "\n";

	// Testing functions in class CornerCut
	cout << "\n-Testing Functions in class CornerCut:" << "\n";
	CornerCut rc ( "CornerCut rc", 6, 5, 10, 12, 3 );
	rc.display();
	cout << "The area of " << rc.getName() << " is: " << rc.area() << "\n"; 
	cout << "The perimeter of " << rc.getName() << " is: " << rc.perimeter() << "\n";
	d = rc.Circle::distance(c);
	cout << "The distance between rc and c is: " << d << "\n";

	// Using array of Shape pointers
	cout << "\n-Testing array of Shape pointers:" << "\n";
	Square s ( "SQUARE - S", 5, 7, 12 ); 

	Shape* sh[4]; 
	sh[0] = &s;
	sh[1] = &a;
	sh[2] = &c;
	sh[3] = &rc;

	sh[0] -> display();
	cout << "The area of "<< sh[0] -> getName() << " is: " << sh[0] -> area();
	cout << "\nThe perimeter of " << sh[0] -> getName () << " is: " << sh[0] -> perimeter();
	
	cout << "\n\n";
	sh[1] -> display();
	cout << "The area of " << sh[1] -> getName() << " is: " << sh[1] -> area();
	cout << "\nThe perimeter of " << sh[0] -> getName () << " is: " << sh[1] -> perimeter();
	
	cout << "\n\n";
	sh[2] -> display();
	cout << "The area of " << sh[2] -> getName() << " is: " << sh[2] -> area();
	cout << "\nThe circumference of " << sh[2] -> getName () << " is: " << sh[2] -> perimeter();
	
	cout << "\n\n";
	sh[3] -> display();
	cout << "The area of " << sh[3] -> getName() << " is: " << sh[3] -> area();
	cout << "\nThe perimeter of " << sh[3] -> getName () << " is: " << sh[3] -> perimeter() << "\n";
	
	// Testing Copy and Assignment operators of class CornerCut
	cout << "\n-Testing copy constructor in class CornerCut:" << "\n"; 
	CornerCut cc = rc;
	cc.display();
	
	cout << "\n-Testing assignment operator in class CornerCut:" << "\n";
	CornerCut cc2( "CornerCut cc2", 2, 5, 100, 12, 9 ); 
	cc2.display();
	cc2 = cc;
	cout << "\n";
	cc2.display();

	cout << "\n.. Done Testing.\n\n";
}