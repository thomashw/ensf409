#include <iostream>
#include "Vector.h"
#include <string.h>

using namespace std;

int main()
{

	Vector <int> x(3);
	x[0] = 999;
	x[1] = -77;
	x[2] = 88;

	cout << "\nCreating an <int> vector";

	Vector<int>::VectIter iter(x);

	cout << "\nThe first element of vector x contains: " << *iter; 
	cout << "\nTesting an <int> Vector: ";
	cout << "\nTesting sort:";

	x.ascending_sort();
	
	for (int i=0; i<3 ; i++)
		cout << endl << iter++;
	
	cout << "\n\nTesting Prefix --:";
	for (int i=0; i<3 ; i++)
		cout << endl << --iter;
	
	cout << "\n\nTesting Prefix ++:";
	for (int i=0; i<3 ; i++)
		cout << endl << ++iter;	
	
	cout << "\n\nTesting Postfix --:";
	for (int i=0; i<3 ; i++)
		cout << endl << iter--;
	
	cout << endl;
	
	cout << "\nTesting a <String> Vector: ";
	Vector<string> y(3);
	y[0] = "Bar";
	y[1] = "Foo";
	y[2] = "All";;
	
	Vector<string>::VectIter iters(y);
	
	cout << "\nTesting sort:";
	y.ascending_sort();
	
	for (int i=0; i<3 ; i++)
		cout << endl << iters++;
	
	cout << "\n\nTesting Prefix --:";
	for (int i=0; i<3 ; i++)
		cout << endl << --iters;
	
	cout << "\n\nTesting Prefix ++:";
	for (int i=0; i<3 ; i++)
		cout << endl << ++iters;
	
	cout << "\n\nTesting Postfix --:";
	for (int i=0; i<3 ; i++)
		cout << endl << iters--;
	
	cout << endl; 

	cout << "\nTesting a <char *> Vector: ";
	Vector<char*> z(3);
	z[0] = (char*)"Orange";
	z[1] = (char*)"Pear";
	z[2] = (char*)"Apple";;
	
	Vector<char*>::VectIter iterchar(z);
	
	cout << "\nTesting sort:";
	z.ascending_sort();
	
	for (int i=0; i<3 ; i++)
		cout << endl << iterchar++;
	
	cout << "\n\nProgram Terminated Successfully." << endl;
	
	return 0;
}