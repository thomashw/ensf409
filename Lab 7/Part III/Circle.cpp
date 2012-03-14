#include <iostream>
using namespace std;

#include <string.h>
#include <math.h>
#include "Point.h"
#include "Shape.h"
#include "Square.h"
#include "Circle.h"
#include "Rectangle.h"
#include "CornerCut.h"
#include "GraphicsWorld.h"

void Circle::f() {}

Circle::Circle(char* name, double x, double y, double r) : Shape(name,x,y)
{
	radius = r;
}

double Circle::area()
{
	return 3.1416 * pow( radius, 2);
}

double Circle::perimeter()
{
	return 2 * 3.1416 * radius;
}

double Circle::getRadius()
{
	return radius;
}

void Circle::setRadius(double r)
{
	radius = r;
}

void Circle::display()
{
	Shape::display();
}
