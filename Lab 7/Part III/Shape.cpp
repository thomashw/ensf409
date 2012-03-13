#include <iostream>
using namespace std;

#include <string.h>
#include "Point.h"
#include "Shape.h"

Shape::Shape(char* name, double x, double y) : origin(x,y)
{
	lenghtName = strlen(name);
	shapeName = new char[lenghtName + 1];
	strcpy(shapeName, name);
}

Shape::~Shape()
{
	delete [] shapeName;
}

Shape& Shape::operator =(Shape& s)
{
	if(this == &s)
    	return *this;
    delete [] shapeName;
    lenghtName = strlen(s.shapeName);
    shapeName = new char[lenghtName + 1];
    strcpy(shapeName, s.shapeName);
    origin = s.origin;
    return *this;
}

Point Shape::getOrigin()
{
	return origin;
}

char* Shape::getName()
{
	return shapeName;
}

void Shape::display()
{
	cout << "Shape Name: ";

	for( int i = 0; i < lenghtName; i++ )
	{
		cout << shapeName[i];
	}

	cout << "\n";
	origin.display();
}

double Shape::distance(Shape& s)
{
	return origin.distance(s.getOrigin());
}

double Shape::distance(Shape& s1, Shape& s2)
{
	return Point::distance(s1.getOrigin(), s2.getOrigin());
}

void Shape::move(double dx, double dy)
{
	origin.setX( origin.getX() + dx );
	origin.setY( origin.getY() + dy );
}