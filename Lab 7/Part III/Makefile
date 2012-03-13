# File name: Makefile - Part III
# Authors: Thomas Hewton-Waters & Andrew Winkler

myprog: Point.o Shape.o Rectangle.o Circle.o CornerCut.o GraphicsWorld.o main.o 
	g++ -o myprog Point.o Shape.o Rectangle.o Circle.o CornerCut.o GraphicsWorld.o main.o 

Point.o: Point.cpp Point.h
	g++ -c Point.cpp

Shape.o: Shape.cpp Shape.h
	g++ -c Shape.cpp

Rectangle.o: Rectangle.cpp Rectangle.h
	g++ -c Rectangle.cpp

Circle.o: Circle.cpp Shape.h
	g++ -c Circle.cpp

CornerCut.o: CornerCut.cpp CornerCut.h
	g++ -c CornerCut.cpp

GraphicsWorld.o: GraphicsWorld.cpp	GraphicsWorld.h
	g++ -c GraphicsWorld.cpp

main.o: main.cpp
	g++ -c main.cpp