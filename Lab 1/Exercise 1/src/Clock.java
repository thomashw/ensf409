/*
	Author: Thomas Hewton-Waters
	Date: January 13, 2012
*/

public class Clock {
	private int days, hours, minutes, seconds;

	/* Constructors */
	public Clock( int days, int hours, int minutes, int seconds )
	{
		this.days = days;
		this.hours = hours;
		this.minutes = minutes;
		this.seconds = seconds;
	}

	public Clock()
	{
		this( 0, 0, 0, 0);
	}

	/* Getters */
	public int get_days()
	{
		return this.days;
	}

	public int get_hours()
	{
		return this.hours;
	}

	public int get_minutes()
	{
		return this.minutes;
	}

	public int get_seconds()
	{
		return this.seconds;
	}

	/* Setters */
	public void set_days( int days )
	{
		this.days = days;
	}

	public void set_hours( int hours )
	{
		if( hours >= 0 && hours <= 23 )
			this.hours = hours;
	}

	public void set_minutes( int minutes )
	{
		if( minutes >= 0 && minutes <= 59 )
			this.minutes = minutes;
	}

	public void set_seconds( int seconds )
	{
		if( seconds >= 0 && seconds <= 59 )
			this.seconds = seconds;
	}

	/* Methods */
	// increment_seconds is required to be >=0 & <= 59
	public void increment( int increment_seconds )
	{	
		/* Check for incorrect input */
		if( increment_seconds <= 0 || increment_seconds >= 59 )
			return;

		/* If adding the incremented seconds makes seconds roll over,
		add a minute instead */
		if( ( this.seconds + increment_seconds ) > 59 ) {

			/* If adding a minute rolls over the minutes, add an hour instead */
			if( ( this.minutes + 1 ) > 59 ) {

				/* If adding an hour rolls over the hours, add a day */
				if( ( this.hours + 1 ) > 23 ) {
					this.days++;
					this.hours = 0;
					this.minutes = 0;
					this.seconds = 0;
				} else {
					this.hours++;
					this.minutes = 0;
					this.seconds = 0;
				}
			} else {
				this.minutes++;
				this.seconds = 0;
			}
		} else {
			this.seconds += increment_seconds;
		}
	}

	public int calc_total_secs()
	{
		return 	this.seconds + 
				(this.minutes * 60) +
				(this.hours * 60 * 60) + 
				(this.days * 24 * 60 * 60);
	}

	/* Main */
	public static void main( String[] args)
	{
		// Defaults the elapsed time to zero
		Clock t1 = new Clock(); // Default constructor

		// Elapsed time is 3 days, 1 hour, 4 mins, 5 secs
		Clock t2 = new Clock(3, 1, 4, 5);

		/* t1 tests */
		t1.set_hours(23); 	// Set hour to 23
		t1.set_days(1); 		// Set day to 1
		t1.set_minutes(59);	// Sets minute to 59
		t1.set_seconds(16);	// Set seconds to 16

		// prints: 1:23:59:16
		System.out.println( "t1 time: " + t1.get_days() + ":" + 
							t1.get_hours() + ":" + 
							t1.get_minutes() + ":" + 
							t1.get_seconds());

		// increments time t1 by 44 seconds
		t1.increment(44);

		// prints: 2:0:0:0
		System.out.println(	"t1 time: " + t1.get_days() + ":" + 
							t1.get_hours() + ":" + 
							t1.get_minutes() + ":" + 
							t1.get_seconds());
							
		// prints: 172800
		System.out.println( "t1 secs: " + t1.calc_total_secs() );

		/* t2 tests */
		// prints: 3:1:4:5
		System.out.println(	"t2 time: " + t2.get_days() + ":" + 
							t2.get_hours() + ":" + 
							t2.get_minutes() + ":" + 
							t2.get_seconds());

		t2.increment(40);

		// prints: 3:1:4:45
		System.out.println(	"t2 time: " + t2.get_days() + ":" + 
							t2.get_hours() + ":" + 
							t2.get_minutes() + ":" + 
							t2.get_seconds());

		t2.increment(15);

		// prints: 3:1:5:0
		System.out.println( "t2 time: " + t2.get_days() + ":" + 
							t2.get_hours() + ":" + 
							t2.get_minutes() + ":" + 
							t2.get_seconds());

		System.out.println( "t2 secs: " + t2.calc_total_secs() );
	}
}