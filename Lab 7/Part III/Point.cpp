#include <iostream>
using namespace std;

#include "Point.h"
#include "math.h"

Point::Point(double x, double y)
{
	id = 1000 + ++numPoints;
	xCor = x;
	yCor = y;
}

int Point::numPoints = 0;

int Point::getX() const
{
	return xCor;
}

int Point::getY() const
{
	return yCor;
}

void Point::setX(double x)
{
	xCor = x;
}

void Point::setY(double y)
{
	yCor = y;
}

int Point::getID()
{
	return id;
}

int Point::counter()
{
	return numPoints;
}

double Point::distance(Point p)
{
	return sqrt( pow( xCor - p.getX(), 2) + pow( yCor - p.getY() ,2) );
}

double Point::distance(Point p1, Point p2)
{
	return sqrt( pow( p1.getX() - p2.getX(), 2) + pow( p2.getY() - p2.getY() , 2) );
}

void Point::display()
{
	cout << "X-coordinate: " << xCor << "\n";
	cout << "Y-coordinate: " << yCor << "\n";
}
