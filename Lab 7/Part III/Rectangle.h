#ifndef RECTANGLE_H
#define RECTANGLE_H

#include "Point.h"
#include "Shape.h"

class Rectangle : virtual public Shape
{
	public:
		virtual void f();
		Rectangle(char* name, double x, double y, double sideA, double sideB);
		virtual double area();
		virtual double perimeter();
		double getSideA();
		double getSideB();
		void setSideA(double side);
		void setSideB(double side);
		char* getName();
		void display();

	protected:
		double side_a;
		double side_b;
};

#endif