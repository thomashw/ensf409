# File name: Makefile - Part II
# Authors: Thomas Hewton-Waters & Andrew Winkler

myprog: Point.o testing.o
	g++ -o myprog Point.o testing.o
Point.o: Point.cpp Point.h
	g++ -c Point.cpp
testing.o: testing.cpp
	g++ -c testing.cpp