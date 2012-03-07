// ex1main.cpp
// Lab 7 - winter 2012
// Author - M. Moussavi

#include <iostream>
using namespace std;
#include "mystring.h"

int main(void)
{
  Mystring *ar[3];
  Mystring c(3);
  ar[2] = &c;
  ar[1] = ar[0] = NULL;
  // point one 
  {
    Mystring x[2];

    x[0].set_str("ENEL");
    x[1].set_str("0");
		Mystring* z = new Mystring("4");
    x[0].append(*z).append(x[1]);
		
    cout << "\nx[0] is: "; 
    cout << x[0].c_str();
  
    Mystring mars = x[0];

    if(mars.isEqual(x[0]))
      cout<< "\nmars is the copy of x[0]";

    x[1] = x[0];
    
		if(x[1].isEqual(x[0]))
      cout<< "\nx[1]is the copy of x[0]";
    
		Mystring jupiter("White");
    cout << "\njupiter is "; 
    cout << jupiter.c_str();

    ar[0] = new Mystring ("Yellow");
    cout << "\nar[0] points to "; 
    cout << ar[0]->c_str();

  }
  // point two

  c.set_str("A");
  delete  ar [0];
 
  Mystring d = "Green";
  cout << "\nd is "; 
  cout << d.c_str();
  
  cout << "\nProgram terminated successfully." <<endl;
  //point seven
  return 0;
}

