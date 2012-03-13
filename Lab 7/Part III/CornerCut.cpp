#include <iostream>
using namespace std;

#include <string.h>
#include "math.h"
#include "Point.h"
#include "Shape.h"
#include "Square.h"
#include "Rectangle.h"
#include "Circle.h"
#include "CornerCut.h"

void CornerCut::f() {}

CornerCut::CornerCut(char* name, double x, double y, double sideA, double sideB, double r) : Rectangle(name,x,y,sideA,sideB), Circle(name,x,y,r) 
{}

double CornerCut::area()
{
	return Rectangle::area() - ( 0.25 * Circle::area() );
}

double CornerCut::perimeter()
{
	return Rectangle::perimeter() - ( 2 * Circle::getRadius() ) + ( 0.25 * Circle::area() );
}

char* CornerCut::getName()
{
	return Rectangle::getName();
}

void CornerCut::display()
{
	Rectangle::display();
	cout << "Width: " << Rectangle::getSideA() << "\n";
	cout << "Length: " << Rectangle::getSideB() << "\n";
	cout << "Radius of the cut: " << Circle::getRadius() << "\n";
}