#include <iostream>
using namespace std;

#include "Point.h"

Point::Point(double x, double y)
{
	id = 1000 + ++numPoints;
	xCor = x;
	yCor = y;
}

int Point::numPoints = 0;

int Point::getX()
{
	return xCor;
}

int Point::getY()
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