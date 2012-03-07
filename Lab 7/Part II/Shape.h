#ifndef SHAPE_H
#define SHAPE_H

class Shape
{
	public:
		Shape(char* name, double x, double y);
		~Shape();
		Point getOrigin();
		char* getName();
		void display();
		double distance(Shape s);
		static double distance(Shape s1, Shape s2);
		void move(double dx, double dy);
		Shape& operator =(Shape& s);

	private:
		Point origin;
		char* shapeName;
		int lenghtName;

};

#endif