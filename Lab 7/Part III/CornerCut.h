#ifndef CORNERCUT_H
#define CORNERCUT_H

#include "Circle.h"
#include "CornerCut.h"

class CornerCut : public Rectangle, public Circle
{
	public:
		virtual void f();
		CornerCut(char* name, double x, double y, double sideA, double sideB, double r);
		double area();
		double perimeter();
		char* getName();
		void display();

	private:

};

#endif