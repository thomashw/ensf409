/**
 * Author: Thomas Hewton-Waters
 * Created on: February 10, 2012
 */

public class Vector <X>
{
    private X data[];
    private int size;
    private int capacity;

    public Vector()
    {
        this( 10 );
    }

    public Vector( int c )
    {
        this.capacity = c;
        this.data = (X[]) new Object[capacity];
        this.size = 0;
    }

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
        Vector<Integer> vp = new Vector <Integer> (4);

        vp.add(1223);
        vp.add(897);
        vp.add(8221);
        System.out.println( "The current capacity of vp is: " + vp.capacity() );
        System.out.println( "The current size of vp is: " + vp.size() );
        System.out.println(vp);
        Vector<String>vs = new Vector <String>(6);
        vs.add("MARS");
        vs.add("JUPITER");
        vs.add("NEPTUN");
        System.out.println(vs);
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
        System.out.println(vs);
    }
}
