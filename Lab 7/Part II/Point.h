#ifndef POINT_H
#define POINT_H

class Point 
{
	public:
		Point(double x, double y);
		int getX();
		int getY();
		void setX(double x);
		void setY(double y);
		int getID();

	private:
		static int numPoints;
		int id;
		double xCor;
		double yCor;
};

#endif
