#ifndef RECTANGLE_H
#define RECTANGLE_H

class Rectangle : virtual public Shape
{
	public:
		virtual void f();
		Rectangle(char* name, double x, double y, double sideA, double sideB);
		double area();
		double perimeter();
		double getSideA();
		double getSideB();
		void setSideA(double side);
		void setSideB(double side);
		char* getName();
		void display();

	private:
		double side_a;
		double side_b;
};

#endif