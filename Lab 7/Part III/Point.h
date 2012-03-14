#ifndef POINT_H
#define POINT_H

class Point 
{
	public:
		Point(double x, double y);
		int getX() const;
		int getY() const;
		void setX(double x);
		void setY(double y);
		int getID();
		static int counter();
		double distance(Point p);	
		static double distance(Point p1, Point p2);
		void display();

	private:
		static int numPoints;
		int id;
		double xCor;
		double yCor;
};

#endif
