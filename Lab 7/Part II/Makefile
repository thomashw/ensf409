# File name: Makefile - Part II
# Authors: Thomas Hewton-Waters & Andrew Winkler

myprog: Point.o main.o Shape.o Square.o Rectangle.o GraphicsWorld.o
	g++ -o myprog Point.o main.o Shape.o Square.o Rectangle.o GraphicsWorld.o

Point.o: Point.cpp Point.h
	g++ -c Point.cpp

Shape.o: Shape.cpp Shape.h
	g++ -c Shape.cpp

Square.o: Square.cpp Square.h
	g++ -c Square.cpp

Rectangle.o: Rectangle.cpp Rectangle.h
	g++ -c Rectangle.cpp

GraphicsWorld.o: GraphicsWorld.cpp	GraphicsWorld.h
	g++ -c GraphicsWorld.cpp

main.o: main.cpp
	g++ -c main.cpp