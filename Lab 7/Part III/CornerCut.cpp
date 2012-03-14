#include <iostream>
using namespace std;

#include <string.h>
#include "Point.h"
#include "Shape.h"
#include "Square.h"
#include "Circle.h"
#include "Rectangle.h"
#include "CornerCut.h"
#include "GraphicsWorld.h"

void CornerCut::f() {}

CornerCut::CornerCut(char* name, double x, double y, double sideA, double sideB, double r) : Rectangle(name,x,y,sideA,sideB), Circle(name,x,y,r), Shape(name,x,y) 
{}

CornerCut::CornerCut(const CornerCut& c) : Rectangle(c.shapeName, c.origin.getX(), c.origin.getY(), c.side_a, c.side_b), Circle( c.shapeName, c.origin.getX(), c.origin.getY(), c.radius ), Shape( c.shapeName, c.origin.getX(), c.origin.getY() )
{
}

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

CornerCut& CornerCut::operator =(CornerCut& cc)
{
	if(this == &cc)
    	return *this;

    delete [] shapeName;
    lenghtName = strlen(cc.shapeName);
    shapeName = new char[lenghtName + 1];
    strcpy(shapeName, cc.shapeName);

    origin = cc.origin;
    side_a = cc.side_a;
    side_b = cc.side_b;
    radius = cc.radius;
    
    return *this;
}