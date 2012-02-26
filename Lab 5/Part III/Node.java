// Node.java
// Started By: M. Moussavi
// Completed By: Thomas Hewton-Waters

class Node <T>  {
	T itemM;
	Node nextM;
	Node previousM;

	public Node(T itemA, Node nextA, Node previousA)
	{
		itemM = itemA ;
		nextM = nextA;
		previousM = previousA;
	}

	public Object clone() throws CloneNotSupportedException
	{
	   Object obj = super.clone(); 
	   return obj;
	}

}