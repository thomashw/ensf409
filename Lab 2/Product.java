import java.lang.String;

class Product {

	// Variables
	private String name;
	private int shelf_number;
	private Date shelving_date;
	
	// Constructors
	public Product()
	{
		this( "N/A", 0, 0, 0, 0);
	}
	
	public Product( String n, int sn, int sd_d, int sd_m, int sd_y)
	{
		this.name = n;
		this.shelf_number = sn;
		this.shelving_date = new Date( sd_d, sd_m, sd_y );
	}
	
	/** public function that returns string "name" */
	public String get_name()
	{
		return this.name;
	}	
	
	/** public function that returns integer "shelf_number" */
	public int get_shelfNumber()
	{
		return this.shelf_number;
	}
	
	/** public function that returns a string of class Date in a DAY / MONTH / YEAR format */
	public String get_shelvingDate()
	{
		return shelving_date.toString();
	}
	
	/** public function that sets string "name" */
	public void set_name( String n )
	{
		this.name = n;
	}

	/** public function that sets integer "shelf_number" */
	public void set_shelfNumber( int sn )
	{
		this.shelf_number = sn;
	}

	/** public function that sets the full date of shelving_date */
	public void set_shelvingDate( int sd_d, int sd_m, int sd_y )
	{
		shelving_date.set_day(sd_d);
		shelving_date.set_month(sd_m);
		shelving_date.set_year(sd_y);
	}
	
	/** public function that returns a string of the information for this product in the format
		"Name || 'name' || Shelving Date: 'DAY / MONTH / YEAR' || Shelf #: 'shelf_number'"
	 */
	public String toString()
	{
		return "Name: " + get_name() + " || Shelving Date: " + shelving_date.toString() + " || Shelf #: " + get_shelfNumber();
	}
	
	public static void main( String[] args )
	{
		// User created Product
		Product product1 = new Product( args[0], Integer.parseInt(args[1]), Integer.parseInt(args[2]), Integer.parseInt(args[3]), Integer.parseInt(args[4]) );
		System.out.println( "User set Product:" );
		System.out.println( product1.toString() );
		
		// System created Product using set() functions
		Product product2 = new Product();
		product2.set_name( "iTV");
		product2.set_shelfNumber(69);
		product2.set_shelvingDate(2, 6, 2012);
		
		System.out.println( "\nMachine set Product:" );
		System.out.println( product2.toString() );
	}
	
}
