public class LookupTable
{
	LT_Node headM;
	LT_Node cursorM;
	int sizeM;

	public LookupTable()
	{
		this.headM = null;
		this.cursorM = null;
		sizeM = 0;
	}

	public int size()
	{
		return sizeM;
	}

	public boolean cursor_ok()
	{
		return (cursorM != null);
	}

	public int cursor_key()
	{
		if( cursor_ok() ) {
			return cursorM.keyM;
		}

		return 0;
	}

	public Product cursor_product()
	{
		if( cursor_ok() ) {
			return cursorM.productM;
		}

		return null;
	}

	public void insert( int keyA, Product productA )
	{
		LT_Node newNode;

		/* If table is empty, create headM */
		if( headM == null ) {
			headM = new LT_Node(keyA, productA, null);
			sizeM++;
			return;
		}

		/* Begin searching with headM */
		cursorM = headM;
		LT_Node temp = headM;


		/* Search until we hit the end of the list, or until we surpass
			the key in the list */
		while( cursorM != null && keyA > cursorM.keyM ) {
			temp = cursorM;
			cursorM = temp.nextM;
		}

		/* If cursorM is null, we've searched through the entire list
			so add the node to the end */
		if( cursorM == null ) {
			newNode = new LT_Node(keyA, productA, null);
			temp.nextM = newNode;
			sizeM++;
		/* If we haven't hit the end, see if the keys are equal and
			replace the product */
		} else if( keyA == cursorM.keyM ) {
			cursorM.productM = productA;
		/* Otherwise just insert the product between tempM and cursorM */
		} else {
			newNode = new LT_Node(keyA, productA, cursorM);

			if( temp == headM )
				headM = newNode;
			else
				temp.nextM = newNode;

			sizeM++;
		}

		this.cursorM = null;
	}

	public void remove( int keyA )
	{
		/* Begin searching at headM */
		this.cursorM = headM;
		LT_Node temp = headM;

		/* Search until we hit the end of the list */
		while( cursorM.nextM != null ) {
			if( cursorM.keyM == keyA ) {
				temp.nextM = cursorM.nextM;
				cursorM.nextM = null;
				sizeM--;
			} else {
				temp = cursorM;
				cursorM = temp.nextM;
			}
		}

		cursorM = null;
	}

	public void find( int keyA )
	{
		cursorM = headM;

		while( cursorM!= null && cursorM.keyM != keyA )
		{
			cursorM = cursorM.nextM;
		}
	}

	public void go_to_first()
	{
		if( this.sizeM > 0 ) {
			cursorM = headM;
		}
	}

	public void step_fwd()
	{
		if( cursor_ok() ) {
			cursorM = cursorM.nextM;
		}
	}

	public boolean is_empty()
	{
		return (sizeM == 0);
	}

	public String toString()
	{
		return cursorM.productM.toString();
	}

	public void destroy()
	{
		cursorM = headM;
		LT_Node tempM = headM;

		while( cursorM != null )
		{
			tempM = cursorM;
			cursorM = tempM.nextM;
			tempM.nextM = null;
		}

		headM = null;
	}
}