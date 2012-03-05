// ex2main.cpp
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
  // point one

  c.set_str("A");
  delete  ar [0];
 
  Mystring d = "Green";
  cout << "\nd is "; 
  cout << d.c_str();

  cout << "\n\nNEW TESTS\n";

  Mystring thomas("Thomas Hewton-Waters");
  Mystring thomasCopy = thomas;
  Mystring andrew("Andrew Winkler");

  if( thomas > andrew )
    cout << "\nThomas is greater/better than Andrew.";

  if( thomas >= andrew )
    cout << "\nThomas is greater or equal to Andrew.";

  if( thomas <  andrew )
    cout << "\nThomas is less than Andrew.";

  if( thomas <=  andrew )
    cout << "\nThomas is less than or equal to Andrew.";
  
  if( thomas == thomasCopy )
    cout << "\nThomas is equal to thomasCopy.";

  if( thomas != andrew )
    cout << "\nThomas does not equal Andrew.";

  cout << "\n" <<  thomas;

  cout << "\nEnter a new name for Thomas: ";
  cin >> thomas;
  cout << "New name: " << thomas;

 
  char* andy = andrew;
  cout << "\nAndy's char_str value: ";
  cout << andy;
  cout << "\n";

  if( thomas[1] > andrew[1] )
    cout << "Thomas's second letter: "<< thomas[1];
  else
    cout << "Andrew's second letter: " << andrew[1];

  cout << "\nNot operator thomasCopy:";
  !thomasCopy;
  cout << thomasCopy;
  
  cout << "\n" <<  (andrew + thomas);
  cout << "\n" <<  (andrew += thomas);
  cout << "\n" <<  andrew;

  cout << "\nProgram terminated successfully." <<endl;

  return 0;
}

