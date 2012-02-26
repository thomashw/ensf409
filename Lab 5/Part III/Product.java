
class Product implements Comparable<Product>  {

	private String name;
	private Date shelving;
	private int shelf;

	public Product(String n, int day, int month, int year, int sh){
		name = n;
		shelving = new Date(day, month, year);
		shelf = sh;
	}

	public Date get_date() {
		return shelving;
	}

	public void set_date(Date newDate) {
		shelving = newDate;
	}

	public String get_name() {
		return name;
	}

	public void setname(String newName) {
		name = newName;
	}

	public int get_shelf() {
		return shelf;
	}

	public void set_shelf(int sh) {
		shelf = sh;
	}

	public String toString(){
		String s;
		s = " Name: " + name + " Shelving Date: " + shelving.toString() + " Shelf #: " + shelf;
		return s;
	}

	public int compareTo( Product p )
	{
		if( name.compareTo( p.get_name() ) == 0 && shelving.compareTo( p.get_date() ) == 0 && shelf == p.get_shelf() )
			return 0;

		else return -1;
	}

}