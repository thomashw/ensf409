#include <assert.h>

template <class T>
class Vector {
public: 

  class VectIter{
    friend class Vector;
  private:
    Vector *v; // points to a vector object of type T
    int index;    // represents the subscript number of the vector's
                  // array.
  public:
    VectIter(Vector<T>& x);
 
    T operator++();
    //PROMISES: increments the iterator's indes and return the 
    //          value of the element at the index position. If
    //          index exceeds the size of the array it will 
    //          be set to zero. Which means it will be circulated
    //          back to the first element of the vector.

    T  operator++(int);
    // PRIMISES: returns the value of the element at the index
    //           position, then increments the index. If
    //           index exceeds the size of the array it will 
    //           be set to zero. Which means it will be circulated
    //           back to the first element of the vector.

    T  operator--();
    // PROMISES: decrements the iterator index, and return the
    //           the value of the element at the index. If
    //           index is less than zero it will be set to the 
    //           last element in the aray. Which means it will be
    //           circulated to the last element of the vector.

    T  operator--(int);
    // PRIMISES: returns the value of the element at the index
    //           position, then decrements the index. If
    //           index is less than zero it will be set to the 
    //           last element in the aray. Which means it will be
    //           circulated to the last element of the vector.

    T operator *();
    // PRIMISES: returns the value of the element at the current 
    //           index position.
  };

  Vector(int sz); 
  ~Vector();

  T & operator[](int i);
  // PRIMISES: returns existing value in the ith element of 
  //           array or sets a new value to  the ith element in
  //           array. 
  
	void ascending_sort();
  // PRIMISES: sorts the vector values in ascending order. 
	
private:
  T *array;               // points to the first element of an array of T
  int size;               // size of array
	void swap(T&, T&); // swaps the values of two elements in array 
public:
};

template <class T>
Vector<T>::Vector(int sz)
{
  size=sz;
  array = new T [sz];
  assert (array != NULL);
}

template <class T>
T & Vector<T>::operator [] (int i)
{
  return array[i];
}

template <class T>
Vector<T>::~Vector()
{
  delete [] array;
  array = NULL;
}

template <class T>
void Vector<T>::ascending_sort()
{
  for(int i=0; i< size-1; i++)
    for(int j=i+1; j < size; j++)
      if(array[i] > array[j])
        swap(array[i], array[j]);
}

template <class T>
void Vector<T>::swap(T& a, T& b)
{
  T tmp = a;
  a = b;
  b = tmp;
}

template <class T>
Vector<T>::VectIter::VectIter(Vector<T>& x)
{
  v = &x;
  index = 0;
}

template <class T>
T Vector<T>::VectIter::operator *()
{
  return v -> array[index];
}

template <class T>
T Vector<T>::VectIter::operator ++()
{
  if( ++index >= v->size )
    index = 0;

  return v->array[index];
}

template <class T>
T Vector<T>::VectIter::operator ++(int)
{
  int old_index = index;

  if( ++index >= v->size )
    index = 0;

  return v->array[old_index];
}

template <class T>
T Vector<T>::VectIter::operator --()
{
  if( --index < 0 )
    index = v->size - 1;

  return v->array[index];
}

template <class T>
T Vector<T>::VectIter::operator --(int)
{
  int old_index = index;

  if( --index < 0 )
    index = v->size - 1;

  return v->array[old_index];
}

