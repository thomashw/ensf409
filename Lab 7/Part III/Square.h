#ifndef SQUARE_H
#define SQUARE_H

#include "Point.h"
#include "Shape.h"

class Square : public Shape
{
	public:
		virtual void f();
		Square(char* name, double x, double y, double sideA);
		virtual double area();
		virtual double perimeter();
		double getSideA();
		void setSideA(double side);
		void display();

	private:
		double side_a;
};

#endif