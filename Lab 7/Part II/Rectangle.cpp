#include <iostream>
using namespace std;

#include <string.h>
#include "Point.h"
#include "Shape.h"
#include "Rectangle.h"

void Rectangle::f() {}

Rectangle::Rectangle(char* name, double x, double y, double sideA, double sideB) : Shape(name,x,y)
{
	side_a = sideA;
	side_b = sideB;
}

Rectangle::Rectangle(Rectangle& r) : Shape(r.shapeName, r.origin.getX(), r.origin.getY())
{
	side_a = r.side_a;
	side_b = r.side_b;
}

Rectangle& Rectangle::operator =(const Rectangle& r)
{
	if( this == &r) {
		return *this;
	}

	delete [] shapeName;
	lengthName = strlen(r.shapeName);
    shapeName = new char[lengthName + 1];
    strcpy(shapeName, r.shapeName);

    origin = r.origin;
    side_a = r.side_a;
    side_b = r.side_b;

    return *this;
}

double Rectangle::area()
{
	return side_a * side_b;
}

double Rectangle::perimeter()
{
	return ( 2 * side_a ) + ( 2 * side_b );
}

double Rectangle::getSideA()
{
	return side_a;
}

double Rectangle::getSideB()
{
	return side_b;
}

void Rectangle::setSideA(double side)
{
	side_a = side;
}

void Rectangle::setSideB(double side)
{
	side_b = side;
}

void Rectangle::display()
{
	Shape::display();
}