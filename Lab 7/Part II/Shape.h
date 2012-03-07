#ifndef SHAPE_H
#define SHAPE_H

class Shape
{
	public:
		Shape(char* name, double x, double y);

	private:
		Point origin;
		char* shapeName;
};

#endif