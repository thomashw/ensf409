#include <iostream>
#include <assert.h>
#include "mystring.h"
#include "Vector.h"

using namespace std;

void Vector::ascending_sort()
{
	for(int i=0; i< size-1; i++)
		for(int j=i+1; j < size; j++)
			if(array[i] > array[j])
				swap(array[i], array[j]);
}

void Vector::swap(int& a, int& b)
{
	int tmp = a;
	a = b;
	b = tmp;
}

int Vector::VectIter::operator *()
{
  return v -> array[index];
}

Vector::VectIter::VectIter(Vector& x)
{
  v = &x;
  index = 0;
}

Vector::Vector(int sz)
{
  size=sz;
  array = new int [sz];
  assert (array != NULL);
}

Vector::~Vector()
{
  delete [] array;
  array = NULL;
}

int & Vector ::operator [] (int i)
{
  return array[i];
}
