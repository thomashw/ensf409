// LookupTable.h
// ENEL 409 - WINTER 2004
// Completed by: M. Moussavi

#ifndef LOOKUPTABLE_H
#define LOOKUPTABLE_H

#include <iostream>
#include <assert.h>

using namespace std;


// class LookupTable: GENERAL CONCEPTS
//
//    key/datum pairs are ordered.  The first pair is the pair with
//    the lowest key, the second pair is the pair with the second
//    lowest key, and so on.  This implies that you must be able to
//    compare two keys with the < operator.
//
//    Each LookupTable has an embedded iterator class that allows users
//    of the class to traverse trhough the list and  have acess to each
//    node. 

#include "Customer.h"

//    In this version of the LookupTable a new struct type called Pair
//    is introduced which represents a key/data pair.


struct Pair 
{
  //constructor
  Pair(int keyA,Customer datumA):key(keyA), datum(datumA)
  {
  } 
  
  int key;
  Customer datum;
};


class LT_Node {
  friend class LookupTable;
  friend class Iterator;
private:
  Pair pairM;
  LT_Node *nextM;

  // This ctor should be convenient in insert and copy operations.
  LT_Node(const Pair& pairA, LT_Node *nextA);
};

template <class T>
class LookupTable {
 public:

  // Nested class
  class Iterator {
    friend class LookupTable ;
    LookupTable *LT;
    LT_Node* cursor;
    
  public:
    Iterator():LT(0){}
    Iterator(LookupTable & x): LT(&x){}    
    const Customer&  operator *();
    const Customer& operator ++();
    const Customer& operator ++(int);
    int operator !();

    void step_fwd(){  assert(LT->cursor_ok());
    LT->step_fwd();}
  };

  LookupTable();
  LookupTable(const LookupTable  & source);
  LookupTable& operator =(const LookupTable& rhs);
  ~LookupTable();

  LookupTable& begin();

  int size() const;
  // PROMISES: Returns number of keys in the table.

  int cursor_ok() const;
  // PROMISES: 
  //   Returns 1 if the cursor is attached to a key/datum pair,
  //   and 0 if the cursor is in the off-list state.

  const int& cursor_key() const;
  // REQUIRES: cursor_ok()
  // PROMISES: Returns key of key/datum pair to which cursor is attached.

  const Customer& cursor_datum() const;
  // REQUIRES: cursor_ok()
  // PROMISES: Returns datum of key/datum pair to which cursor is attached.

  void insert(const Pair& pariA);
  // PROMISES:
  //   If keyA matches a key in the table, the datum for that
  //   key is set equal to datumA.
  //   If keyA does not match an existing key, keyA and datumM are
  //   used to create a new key/datum pair in the table.
  //   In either case, the cursor goes to the off-list state.

  void remove(const int& keyA);
  // PROMISES:
  //   If keyA matches a key in the table, the corresponding
  //   key/datum pair is removed from the table.
  //   If keyA does not match an existing key, the table is unchanged.
  //   In either case, the cursor goes to the off-list state.

  void find(const int& keyA);
  // PROMISES:
  //   If keyA matches a key in the table, the cursor is attached
  //   to the corresponding key/datum pair.
  //   If keyA does not match an existing key, the cursor is put in
  //   the off-list state.

  void go_to_first();
  // PROMISES: If size() > 0, cursor is moved to the first key/datum pair
  //   in the table.

  void step_fwd();
  // REQUIRES: cursor_ok()
  // PROMISES: 
  //   If cursor is at the last key/datum pair in the list, cursor
  //   goes to the off-list state.
  //   Otherwise the cursor moves forward from one pair to the next.

  void make_empty();
  // PROMISES: size() == 0.
  
  
  // friend  ostream& operator << <K,D> (ostream& os,const LookupTable<K,D>& lt);

  friend  ostream& operator << (ostream& os, const LookupTable& lt);

 private:
  int sizeM;
  LT_Node *headM;
  LT_Node *cursorM;

  void destroy();
  // Deallocate all nodes, set headM to zero.
  
  void copy(const LookupTable& source);
  // Establishes *this as a copy of source.  Cursor of *this will
  // point to the twin of whatever the source's cursor points to.
};

#endif

template <class T>
LookupTable& LookupTable<T>::begin(){
  cursorM = headM;
  return *this;
}


LT_Node::LT_Node(const Pair& pairA, LT_Node *nextA)
  : pairM(pairA), nextM(nextA)
{
}

template <class T>
LookupTable<t>::LookupTable()
  : sizeM(0), headM(0), cursorM(0)
{
}

template <class T>
LookupTable<T>::LookupTable(const LookupTable& source)
{
  copy(source);
}

template <class T>
LookupTable& LookupTable<T>::operator =(const LookupTable& rhs)
{
  if (this != &rhs) {
    destroy();
    copy(rhs);
  }
  return *this;
}

template <class T>
LookupTable<T>::~LookupTable()
{
  destroy();
}

template <class T>
int LookupTable<T>::size() const
{
  return sizeM;
}

template <class T>
int LookupTable<T>::cursor_ok() const
{
  return cursorM != 0;
}

template <class T>
const int& LookupTable<T>::cursor_key() const
{
  assert(cursor_ok());
  return cursorM->pairM.key;
}

template <class T>
const Customer& LookupTable<T>::cursor_datum() const
{
  assert(cursor_ok());
  return cursorM->pairM.datum;
}

template <class T>
void LookupTable<T>::insert(const Pair& pairA)
{
  // Add new node at head?
  if (headM == 0 || pairA.key < headM->pairM.key) {
    headM = new LT_Node(pairA, headM);
    sizeM++;
  }

  // Overwrite datum at head?
  else if (pairA.key == headM->pairM.key)
    headM->pairM.datum = pairA.datum;

  // Have to search ...

  else {
    LT_Node* before= headM;
    LT_Node* after=headM->nextM;

    while(after!=NULL && (pairA.key > after->pairM.key))
      {
	before=after;
	after=after->nextM;
      }
    
    if(after!=NULL && pairA.key == after->pairM.key)
      {
	after->pairM.datum = pairA.datum;
      }
    else
      {
	before->nextM = new LT_Node (pairA, before->nextM);
	sizeM++;
      }
  }
}

template <class T>
void LookupTable<T>::remove(const int& keyA)
{

  if (headM == 0 || keyA < headM->pairM.key)
    return;

  LT_Node* doomed_node = 0;
  if (keyA == headM->pairM.key) {
    doomed_node = headM;
    headM = headM->nextM;
    sizeM--;
  }
  else {
    LT_Node      *before = headM;
    LT_Node *maybe_doomed = headM->nextM;
    while(maybe_doomed != 0 && keyA > maybe_doomed->pairM.key) {
      before = maybe_doomed;
      maybe_doomed = maybe_doomed->nextM;
    }

    if (maybe_doomed != 0 && maybe_doomed->pairM.key == keyA) {
      doomed_node = maybe_doomed;
      before->nextM = maybe_doomed->nextM;
      sizeM--;
    }      
  } 
  delete doomed_node;           // Does nothing if doomed_node == 0.
}

// This place-holder for find was added in order to
// allow successful linking when you're testing insert and remove.
// Replace it with a definition that works.


template <class T>
void LookupTable<T>::find(const int& keyA)
{
  LT_Node *ptr=headM;
  while (ptr!=NULL && ptr->pairM.key != keyA)
    {
     ptr=ptr->nextM;

    }

   cursorM = ptr;

}

template <class T>
void LookupTable<T>::go_to_first()
{
  cursorM = headM;
}

template <class T>
void LookupTable<T>::step_fwd()
{
  assert(cursor_ok());
  cursorM = cursorM->nextM;
}

template <class T>
void LookupTable<T>::make_empty()
{
  destroy();
  sizeM = 0;
  cursorM = 0;
}

template <class T>
void LookupTable<T>::destroy()
{

  LT_Node *ptr = headM;
  while (ptr!=NULL)
    {
      headM=headM->nextM;
      delete ptr;
      ptr=headM;

    }
  cursorM = NULL;
  sizeM=0;
}

template <class T>
void LookupTable<T>::copy(const LookupTable& source)
{

  headM=0;
  cursorM =0;

  if(source.headM ==0)
    return; 

 
  for(LT_Node *p = source.headM; p != 0; p=p->nextM)
    {
      insert(Pair (p->pairM.key, p->pairM.datum));
      if(source.cursorM == p)
	find(p->pairM.key);
    }

}

ostream& operator << (ostream& os, const LookupTable& lt)
{
  if (lt.cursor_ok())
    os <<lt.cursor_key() << "  " << lt.cursor_datum();
  else
    os<<"Not Found.";

  return os;
}

template <class T>
const Customer& LookupTable<T>::Iterator::operator *()
{
  assert(LT ->cursor_ok());
  return LT->cursor_datum();
}

template <class T>
const Customer& LookupTable<T>::Iterator::operator ++()
{
  assert(LT->cursor_ok());
  const Customer & x = LT->cursor_datum();
  LT->step_fwd();
  return x;
}

template <class T>
const Customer& LookupTable<T>::Iterator::operator ++(int)
{
  assert(LT->cursor_ok());
 
  LT->step_fwd();
  return LT->cursor_datum();
}

template <class T>
int LookupTable<T>::Iterator::operator!()
{
  return (LT->cursor_ok());
}