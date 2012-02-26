class Date implements Comparable<Date>  {
	private int day, month, year;
	public Date(int d, int m, int y)
	{
		day = d;
		month = m; 
		year = y;

	}
	int get_day() {
		return day;
	}

	int get_month() {
		return month;
	}
	int get_year()  {
		return year;
	}

	void set_day(int d) {day = d;}
	void set_month(int  m) {month = m;}
	void set_year(int y) {year = y;}

	public String toString(){
		String s = month + "/" + day + "/" + year;
		return s;
	}

	public int compareTo( Date d )
	{
		if( day == d.get_day() && month == d.get_month() && year == d.get_year() )
			return 0;

		return -1;
	}

}