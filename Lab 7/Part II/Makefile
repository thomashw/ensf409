# File name: Makefile - Part II
# Authors: Thomas Hewton-Waters & Andrew Winkler

myprog: Point.o testing.o Shape.o Square.o Rectangle.o
	g++ -o myprog Point.o testing.o Shape.o Square.o Rectangle.o

Point.o: Point.cpp Point.h
	g++ -c Point.cpp

Shape.o: Shape.cpp Shape.h
	g++ -c Shape.cpp

Square.o: Square.cpp Square.h
	g++ -c Square.cpp

Rectangle.o: Rectangle.cpp Rectangle.h
	g++ -c Rectangle.cpp

testing.o: testing.cpp
	g++ -c testing.cpp