#include <iostream>
using namespace std;

#include "Point.h"
#include "Shape.h"

Shape::Shape(char* name, double x, double y)
{
	shapeName = name;
	origin(x,y);
}