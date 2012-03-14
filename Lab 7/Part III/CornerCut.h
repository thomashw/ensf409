#ifndef CORNERCUT_H
#define CORNERCUT_H

#include "Point.h"
#include "Shape.h"
#include "Circle.h"
#include "Rectangle.h"

class CornerCut : public Rectangle, public Circle
{
	public:
		virtual void f();
		CornerCut(char* name, double x, double y, double sideA, double sideB, double r);
		virtual double area();
		virtual double perimeter();
		char* getName();
		void display();
		CornerCut& operator =(CornerCut& cc);

	private:

};

#endif