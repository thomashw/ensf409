import java.util.NoSuchElementException;
import java.io.*;

public class WriteRecord {
	
	ObjectOutputStream output;

	/* Method checkPath: receives a file path and verifies:
	* 1. does the file exists
	* 2. is the given path a file. If it is, displays: "this is a file"
	* 3. is the given path a directory. If it is displays: "This is a directory".
	*/ 
	public void checkPath(String path)
	{
		File f = new File( path );

		if( f.exists() )
		System.out.println( "File exists." );

		if( f.isFile() )
		System.out.println( "This is a file." );
		else if( f.isDirectory() )
		System.out.println( "This is a directory." );
	}		 

	
	/* Method openFile opens with the given name for object serialization. 
	* From Java API find out about the possible exceptions and catach them, with
	* an appropriate message.  
	*/
	public void openFile(String name) throws FileNotFoundException, IOException
	{
		output = new ObjectOutputStream( new FileOutputStream( name ) );
	}
	
	/* This method prompts the user for several times, to enter 
	* songs information, reads the information from the the keyboard, creates 
	* a MusicRecod object based on given data by the user, and finally serializes
	*  the created object into a file called mySongs.ser
	*/
	public void addRecords() throws IOException
	{	
		BufferedReader br = new BufferedReader( new InputStreamReader( System.in ) );

		int numRecords = 1;
		char yn = 'y';
		while( yn == 'y' ) {
			yn = 'x';

			System.out.println( "\nEntering record number " + numRecords++ );
			System.out.println( "Please enter the year it was recorded: " );
			String year = br.readLine();

			System.out.println( "Please enter the song name: " );
			String song_name = br.readLine();

			System.out.println( "Please enter the singer name: " );
			String singer_name = br.readLine();

			System.out.println( "Please enter the purchase price: " );
			String purchase_price = br.readLine();

			MusicRecord m = new MusicRecord( Integer.parseInt( year ), song_name, singer_name, Double.parseDouble( purchase_price ) );
			output.writeObject( m );
			output.flush();

			while( yn != 'y' && yn != 'n' ) {
				System.out.println( "Would you like to enter another record? (y/n)" );
				String input = br.readLine();
				yn = input.charAt( 0 );				
			}
		}
	} 
	
	// This method is supposed to close the input stream.
	public void closeFile() throws IOException
	{
		output.close();
	} // end method closeFile
	
	
	public static void main(String [] args) throws IOException
	{
		WriteRecord d = new WriteRecord();
		String filename = "mySongs.ser";
		d.checkPath(filename);
		d.openFile(filename);
		d.addRecords();
		d.closeFile();
	}	
}
