import java.io.Serializable;

class MusicRecord implements Serializable
{
	private int year_recorded;
	private String songName;
	private String singerName;
	private double purchase_price;
	
	public MusicRecord() 
	{
		this( 0, "", "", 0.0 ); 
	} 

	public MusicRecord( int year, String song, String singer, double value )
	{
		setYear( year );
		setSongName( song );
		setSingerName( singer );
		setPrice( value );
	} 

	public void setYear( int year )
	{
		year_recorded = year;
	} 

	public int getYear() 
	{ 
		return year_recorded; 
	} 

	public void setSongName( String song )
	{
		songName = song;
	} 

	public String getSongName() 
	{ 
		return songName; 
	} 

	public void setSingerName( String singer )
	{
		singerName = singer;
	}

	public String getSingerName() 
	{
		return singerName; 
	} 

	public void setPrice( double value )
	{
		purchase_price = value;
	} 

	public double getPurchasePrice() 
	{ 
		return purchase_price; 
	} 
} 