# File name: Makefile
# Authors: Thomas Hewton-Waters & Andrew Winkler

myprog: mystring.o ex1main.o
	g++ -o myprog mystring.o ex1main.o
mystring.o: mystring.cpp mystring.h
	g++ -c mystring.cpp
ex1main.o: ex1main.cpp
	g++ -c ex1main.cpp