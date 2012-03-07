#ifndef SQUARE_H
#define SQUARE_H

class Square : public Shape
{
	public:
		virtual void f();
		Square(char* name, double x, double y, double side);
		double area();
		double perimeter();
		double getSideA();
		void setSideA(double side);
		void display();

	private:
		double side_a;
};

#endif