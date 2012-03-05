/*  mystring.cpp*/

#include "mystring.h"
#include <string.h>

Mystring::Mystring()
{ 
  charsM = new char[1];

  // make sure memory is allocated.
  memory_check(charsM); 
  charsM[0] = '\0';
	cursorM = -1;
  lengthM = 0;
}

Mystring::Mystring(const char *s)
  : lengthM(strlen(s))
{
  charsM = new char[lengthM + 1];

 // make sure memory is allocated.
  memory_check(charsM);
  strcpy(charsM, s);
	if(lengthM > 0) cursorM = 0;
	else cursorM = -1;
}

Mystring::Mystring(int n)
  : lengthM(0), charsM(new char[n])
{
  // make sure memory is allocated.
  memory_check(charsM);
  charsM[0] = '\0';
	cursorM = -1;
}

Mystring::Mystring(const Mystring& source):
  lengthM(source.lengthM), charsM(new char[source.lengthM+1]), 
	cursorM(source.cursorM)
{
  memory_check(charsM);
  strcpy (charsM, source.charsM);
	cout << "\ncopy const.";
}

Mystring::~Mystring()
{
  delete [] charsM;
}

int Mystring::length() const
{
  return lengthM;
}


char Mystring::get_char(int pos) const
{
  if(pos < 0 || pos >= length()){
    cerr << "\nset_char: the position is out of boundary."
	 << " Nothing was changed.";
  }
  return charsM[pos];
}

const char * Mystring::c_str() const
{
  return charsM;
}

void Mystring::set_char(int pos, char c)
{
  if(pos < 0 || pos >= length()){
    cerr << "\nset_char: the position is out of boundary.";
     return;
  } 

  if (c == '\0'){
    cerr << "\nset_char: char c is empty."
	 << " Nothing was changed.";
    return;
  }

  charsM[pos] = c;
}

Mystring& Mystring::operator =(const Mystring& S)
{
  if(this == &S)
    return *this;
  delete [] charsM;
  lengthM = strlen(S.charsM);
  charsM = new char [lengthM+1];
  memory_check(charsM);
  strcpy(charsM,S.charsM);
	cout << "\n= operator.";
	cursorM = S.cursorM;
  return *this;
}

bool Mystring::operator >(const Mystring& s) const
{
  if( this == &s )
    return false;

  for( int i = 0; i < lengthM; i++ )
  {
    /* All letters are equal, but this.charsM is longer (so greater) */
    if( i == s.length() - 1 )
      return true;

    if( get_char(i) > s.get_char(i) )
      return true;
    else if( get_char(i) < s.get_char(i) )
      return false;
  }

  return false;
}

bool Mystring::operator <=(const Mystring& s) const
{
  return s > *this;
}

bool Mystring::operator ==(const Mystring& s) const
{
  if( this == &s )
    return true;

  if( lengthM != s.length() )
    return false;

  for( int i = 0; i < lengthM; i++ )
  {
    if( get_char(i) != s.get_char(i) )
      return false;
  }

  return true;
}

bool Mystring::operator <(const Mystring& s) const
{
  if( this == &s )
    return false;

  for( int i = 0; i < lengthM; i++ )
  {
    /* All letters are equal, but this.charsM is longer (so greater) */
    if( i == s.length() - 1 )
      return false;

    if( get_char(i) > s.get_char(i) )
      return false;
    else if( get_char(i) < s.get_char(i) )
      return true;
  }

  return true;
}

bool Mystring::operator >=(const Mystring& s) const
{
  return s < *this;
}

bool Mystring::operator !=(const Mystring& s) const
{
  return !(*this==s);
}

ostream& operator <<(ostream& os, const Mystring& s)
{
  os << s.c_str();;
  return os;
}

istream& operator >>(istream& is, Mystring& s)
{
  char* temp  = new char[100];
  is >> temp;

  s.set_str(temp);
  return is;
}

Mystring::operator char*()
{
  return charsM;
}

char Mystring::operator [](int index) const
{
  return get_char(index);
}

void Mystring::operator !()
{
  set_str("");
}

char* Mystring::operator +(const Mystring& rhs) const
{
  char *c = new char[lengthM + rhs.length() + 1];

  int i = 0;
  for( i = 0; i < lengthM; i++ )
  {
    c[i] = get_char(i);
  }

  for( int j = 0; j < rhs.length(); j++ )
  {
    c[i++] = rhs.get_char(j);
  }

  return c;
}

char* Mystring::operator +=(const Mystring& rhs)
{
  append(rhs);
  return charsM;
}

Mystring& Mystring::append(const Mystring& other)
{  
  lengthM+=other.lengthM;
  char *tmp = new char [lengthM + other.lengthM + 1];
  memory_check(tmp);
  lengthM+=other.lengthM;
  strcpy(tmp, charsM);
  strcat(tmp, other.charsM);
  delete []charsM;
  charsM = tmp;
  return *this;
}

 void Mystring::set_str(char* s)
{
    delete []charsM;
    lengthM = strlen(s);
    charsM=new char[lengthM+1];
    memory_check(charsM);
	  if(lengthM > 0) cursorM = 0;
	  else cursorM = -1;
    strcpy(charsM, s);
}

int Mystring::isEqual (const Mystring& s)const
{

  return (strcmp(charsM, s.charsM)== 0);
}


void Mystring::memory_check(char* s)
{
  if(s == 0)
    {
      cerr <<"Memory not available.";
      exit(1);
    }
}














