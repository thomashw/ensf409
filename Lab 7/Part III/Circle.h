#ifndef CIRCLE_H
#define CIRCLE_H

class Circle : public Shape
{
	public:
		virtual void f();
		Circle(char* name, double x, double y, double radius);
		double area();
		double perimeter();
		double getRadius();
		void setRadius(double side);
		void display();

	private:
		double radius;
};

#endif