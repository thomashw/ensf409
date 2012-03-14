#ifndef CIRCLE_H
#define CIRCLE_H

#include "Point.h"
#include "Shape.h"

class Circle : virtual public Shape
{
	public:
		virtual void f();
		Circle(char* name, double x, double y, double radius);
		virtual double area();
		virtual double perimeter();
		double getRadius();
		void setRadius(double side);
		void display();

	protected:
		double radius;
};

#endif