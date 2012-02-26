import java.lang.String;

 class Date {

	// Variables
	private int day;
	private int month;
	private int year;
	
	// Constructors
	public Date()
	{
		this(0,0,0);
	}
	
	public Date( int d, int m , int y )
	{
		this.day = d;
		this.month = m;
		this.year = y;
	}
		
	/** public function that returns integer "day" */
	public int get_day()
	{
		return this.day;
	}
	
	/** public function that returns integer "month" */
	public int get_month()
	{
		return this.month;
	}
	
	/** public function that returns integer "year" */
	public int get_year()
	{
		return this.year;
	}
	
	/** public function that sets integer "day" */
	public void set_day( int d )
	{
		this.day = d;
	}
	
	/** public function that sets integer "month" */
	public void set_month( int m )
	{
		this.month = m;
	}
	
	/** public function that sets integer "year" */
	public void set_year( int y )
	{
		this.year = y;
	}
	
	/** public function that returns a string in DAY / MONTH / YEAR format */
	public String toString()
	{
		return String.valueOf(day) + " / " + String.valueOf(month) + " / " + String.valueOf(year);
	}
	
	public static void main( String[] args )
	{
		// User set date
		Date date1 = new Date( Integer.parseInt(args[0]), Integer.parseInt(args[1]), Integer.parseInt(args[2]) );
		
		System.out.println( "User set date:");
		System.out.println( "The day is the " + date1.get_day() );
		System.out.println( "The month number is " + date1.get_month() );
		System.out.println( "The year is " + date1.get_year() );
		System.out.println( "The full date is " + date1.toString() );
		
		// Machine set date with set() functions used
		Date date2 = new Date();
		date2.set_day(4);
		date2.set_month(1);
		date2.set_year(1989);
		
		System.out.println( "\nMachine set date:");
		System.out.println( "The day is the " + date2.get_day() );
		System.out.println( "The month number is " + date2.get_month() );
		System.out.println( "The year is " + date2.get_year() );
		System.out.println( "The full date is " + date2.toString() );	
	}
}
