#include <iostream>
using namespace std;

#include <string.h>
#include "Point.h"
#include "Shape.h"
#include "Square.h"

void Square::f() {}

Square::Square(char* name, double x, double y, double side) : Shape(name,x,y)
{
	side_a = side;
}

double Square::area()
{
	return side_a * side_a;
}

double Square::perimeter()
{
	return 4 * side_a;
}

double Square::getSideA()
{
	return side_a;
}

void Square::setSideA(double side)
{
	side_a = side;
}

void Square::display()
{
	Shape::display();
}
