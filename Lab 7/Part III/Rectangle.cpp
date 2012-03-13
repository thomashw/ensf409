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