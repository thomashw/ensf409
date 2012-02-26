import java.util.ArrayList;

public class Vector<X>
{
	private X data[];
    private int size;
    private int capacity;

    public Vector()
    {
        this( 10 );
    }

    @SuppressWarnings("unchecked")
    public Vector( int c )
    {
        this.capacity = c;
        this.data = (X[]) new Object[capacity];
        this.size = 0;
    }

    @SuppressWarnings("unchecked")
    public boolean add( X element )
    {
        if( element == null )
            throw new NullPointerException();

        if( size == capacity ) {
            capacity += 10;

            X temp[] = data;
            data = (X[]) new Object[capacity];

            for( int i = 0; i < size; i++ )
                data[i] = temp[i];
        }

        data[size++] = element;

        return true;
    }

    public int capacity()
    {
        return capacity;
    }

    public int size()
    {
        return size;
    }

    public void clear()
    {
        for( int i = 0; i < size; i++ ) {
            data[i] = null;
        }

        size = 0;
    }

    public boolean equals( Vector<X> vec )
    {
        if( size != vec.size() )
            return false;

        if( capacity != vec.capacity() )
            return false;

        for( int i = 0; i < size; i++ )
            if( data[i] != vec.data[i] )
                return false;

        return true;
    }

    public X get( int index )
    {
        if( index >= size )
            throw new IndexOutOfBoundsException();

        return data[index];
    }

    public void set( int index, X element )
    {
        if( element == null )
            throw new NullPointerException();

        if( index >= size )
            throw new IndexOutOfBoundsException();

        data[index] = element;
    }
    
    @SuppressWarnings("unchecked")
    public boolean add( int index, X element )
    {
    	if( element == null )
    		throw new NullPointerException();
    	
    	if( index >= size ) 
    		throw new IndexOutOfBoundsException();
    	
        if( size == capacity )
            capacity += 10;

        X temp[] = data;
        data = (X[]) new Object[capacity];

        for( int i = 0; i < index; i++ )
            data[i] = temp[i];
        
        data[index] = element;
        size++;
        
        for( int i = index + 1; i < size; i++ )
            data[i] = temp[i-1];        	
    	
    	return true;
    }
    
    @SuppressWarnings("unchecked")
    public X remove( int index )
    {
        if( index >= size )
            throw new IndexOutOfBoundsException();
    	
    	X itemToRemove = data[index];
    	
        X temp[] = data;
        data = (X[]) new Object[capacity];

        for( int i = 0; i < index; i++ )
            data[i] = temp[i];
    	
    	for( int i = index; i < size - 1; i++ )
    		data[i] = temp[i+1];

    	size--;
    	return itemToRemove;
    }
    
    public X remove( X itemToRemove ) throws NullPointerException
    {
    	if( itemToRemove == null )
    		throw new NullPointerException();
    	
    	for( int i = 0; i < size; i++ )
    		if( data[i] == itemToRemove )
    			return this.remove( i );

   		return null;    
    }
    
    public void copyInto( Object [] array )
    {	
    	for( int i = 0; i < size && i < array.length; i++ )
    		array[i] = data[i];
    }
    
    public String toString()
    {
        String returnString = "";

        if( size > 0 )
            returnString += data[0];

        for( int i = 1; i < size; i++ ) {
            returnString += ", " + data[i];
        }

        return returnString;
    }
    
    public static void main( String[] args )
    {
        Vector <ArrayList<Integer>> va = new Vector<ArrayList<Integer>> (2);
        
		ArrayList <Integer> list1 = new ArrayList<Integer> (3); 
		list1.add(4);
		list1.add(44);
		
		ArrayList <Integer> list2 = new ArrayList <Integer>(4); 
		list2.add(88);
		list2.add(1088);
		va.add(list1);
		va.add(list2);
		
		System.out.println(va);
		
		Vector<String>vs = new Vector <String>(6); 
		vs.add("MARS");
		vs.add("JUPITER"); 
		vs.add("NEPTUN");
		
		String [] ss = new String[1];
		
		vs.copyInto(ss); 
		System.out.println(vs); 
		System.out.println(ss.length); 
		
		for(int i = 0; i < ss.length; i++)
			System.out.println(ss[i]);
		
		Vector <String> vi = new Vector<String> (6); 
		vi.add("AGE");
		vi.add("Cage");
		vi.add("Page");
		
		if(vi.equals(vs)) 
			System.out.println("They are equal..."); 
		else 
			System.out.println("They are not equal...");
		
		String news = "Java";
		vs.set(2, news);
		vs.remove(1);
		vs.remove("JUPITER");
		System.out.println(vs);
    }
}
