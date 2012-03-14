#ifndef SHAPE_H
#define SHAPE_H

class Shape
{
	public:
		// Pure virtual function makes this class an Abstract class
		virtual void f() = 0;
		
		Shape(char* name, double x, double y);
		~Shape();
		Point getOrigin();
		char* getName();
		void display();
		double distance(Shape& s);
		static double distance(Shape& s1, Shape& s2);
		void move(double dx, double dy);
		Shape& operator =(Shape& s);

	protected:
		Point origin;
		char* shapeName;
		int lengthName;

};

#endif