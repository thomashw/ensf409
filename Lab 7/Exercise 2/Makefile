# File name: Makefile
# Authors: Thomas Hewton-Waters & Andrew Winkler

myprog: mystring.o ex2main.o
	g++ -o myprog mystring.o ex2main.o
mystring.o: mystring.cpp mystring.h
	g++ -c mystring.cpp
ex2main.o: ex2main.cpp
	g++ -c ex2main.cpp