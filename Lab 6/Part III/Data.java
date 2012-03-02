/*
 * Data.java
 *
 * Created on March 9, 2008, 10:00 AM
 */


/**
 *
 * @author  M. Moussavi
 * @version 
 */
public class Data {
	
	String id,faculty, major, year;
	
	public Data(String i, String f, String m, String y)
	{
		id = i;
		faculty = f;
		major = m;
		year = y;
	}
	
	public String toString()
	{
		return ("id : " + id + " faculty: " + faculty + " major: " + major + 
						" year: " + year);
	}
	
	
}
