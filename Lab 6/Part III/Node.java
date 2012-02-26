/*
 * Node.java
 *
 * Created on March 9, 2002, 9:59 AM
 */


/**
 *
 * @author  M. Moussavi
 * @version 
 */
class Node {
	
	Data data;
	Node left, right;
	
	public Node(String id, String faculty, String major, String year)
	{
		data = new Data(id, faculty, major, year);
		left = null;
		left = null;
	}
	
	public String toString()
	{
		return data.toString();
	}
	
}

