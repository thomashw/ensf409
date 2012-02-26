class LinkedList <T extends Comparable<T>> implements Cloneable {
	
	private int sizeM;
	private Node<T>   headM;
	private Node<T>   tailM;
	private Node<T>   cursorM;


	public Object clone() throws CloneNotSupportedException
	{
		LinkedList obj = (LinkedList)super.clone();

		obj.sizeM = 0;
		obj.headM = null;
		obj.tailM = null;
		obj.cursorM = null;

		go_to_first();

		/* Clone all the nodes */
		while( cursor_ok() ) {
			obj.push_front( cursor_item() );
			step_fwd();
		}

		return obj;
	}

	public LinkedList()
	{
		sizeM = 0;
		headM = null;
		tailM = null;
		cursorM = null;
	}


	public int size() 
	{
		return sizeM;
	}

	public boolean cursor_ok()    
	{
		return cursorM != null;
	}

	public T cursor_item()    
	{
		assert(cursor_ok());
		return cursorM.itemM;
	}
	
	public void go_to_first()
	{
		cursorM = headM;
	}

	void step_fwd()
	{
		if(cursor_ok())
		cursorM = cursorM.nextM;
	}

	void make_empty()
	{
		headM = tailM = cursorM = null;
		sizeM = 0;

	}

	/** moves the cursorM to a node that its itemM matches itemA. Otherwise 
	cursorM will be null */
	public void find(T itemA)
	{
		go_to_first();

		while( cursor_ok() ) {
			if( cursorM.itemM.compareTo( itemA ) == 0 ) {
				break;
			}

			step_fwd();
		}
	}
	
	/** Adds a new item to the beginning of the list. */
	public void push_back (T itemA)
	{
		if( sizeM == 0 ) {
			headM = new Node( itemA, null, null );
			tailM = null;
		} else {
			Node n = new Node( itemA, headM, null );
			headM.previousM = n;
			tailM = headM;
			headM = n;
		}

		sizeM++;
	}
	
	/** Appends a new item to the end of the list. */ 
	public void push_front (T itemA)
	{
		if( sizeM == 0 ) {
			headM = new Node( itemA, null, null );
			tailM = headM;
		} else if( sizeM == 1 ) {
			tailM = new Node( itemA, null, headM );
			headM.nextM = tailM;
		} else {
			Node n = new Node( itemA, null, tailM );
			tailM.nextM = n;
			tailM = n;
		}

		sizeM++;
	}
	
	/** removes a node that matched its itemM with itemA */
	void remove( T itemA )
	{	
		go_to_first();

		while( cursor_ok() ) {
			if( cursorM.itemM.compareTo( itemA ) == 0 ) {
				if( cursorM == headM ) {
					headM = cursorM.nextM;
					headM.previousM = null;
				} else if( cursorM == tailM ) {
					tailM = tailM.previousM;
					tailM.nextM = null;
				} else {
					cursorM.previousM.nextM = cursorM.nextM;
					cursorM.nextM.previousM = cursorM.previousM;
				}
				sizeM--;
				break;
			}

			step_fwd();
		}
	}
	
	/** prints the entire list in a columnar format */
	public void print()
	{ 
		int nodeNum = 0;
		go_to_first();

		while( cursor_ok() ) {
			System.out.println( "Node " + nodeNum++ + ": " + cursorM.itemM.toString() );
			step_fwd();
		}
	}

}