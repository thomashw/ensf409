class LT_Node 
{
	int keyM;
	Product productM;
	LT_Node nextM;

	public LT_Node( int keyA, Product productA, LT_Node nextA ) 
	{
		this.keyM = keyA;
		this.productM = productA;
		this.nextM = nextA;
	}

	public static void main( String[] args)
	{
		Product prodA = new Product( "productA", 1, 15, 8, 1988);
		LT_Node nodeA = new LT_Node( 12345, prodA, null);
		System.out.println(nodeA.productM.toString());
	}
}