import java.io.*;

public class ReadRecord
	{
		ObjectInputStream input;
		
		/* This method deserializes records (objects) in the given file, 'name':
		 * 
		 * 1. It opens a file for deserialization. and catches the possible 
		 *    exceptions refer to the Java API.
		 * 2. uses a while loop to read the music records. The function to read
		 *    objects is: readObject()
		 * 3. as it reads the objects it uses the printf function to display them 
		 *    on the screen.
		 * 4. It catches all possible exceptions: 
		 *       - EOFException
		 *       - ClassNotFoundException, if it cannot create a record object
		 *       - IOException
		 * 5. etc...
		 */
		private void getRecords(String name)
		{
			checkPath(name);
			
			try{ 
				openFile(name);
			}
			catch( FileNotFoundException e ) {
				System.out.println( e );
			}
			catch( IOException e ) {
				System.out.println( e );
			}
			
			// Don't know how to to end the while loop when it hits the end of the file
			// Just have a "break" at the bottom, only reads one record
			// ** Get a java.io.EOFException when I run **
			while(true)
			{
				MusicRecord record = new MusicRecord();
				
				try {
					record.setYear( input.readInt() );
					System.out.println( record.getYear() );
					
					record.setSongName( input.readUTF() );
					System.out.println( record.getSongName() );
					
					record.setSingerName( input.readUTF() );
					System.out.println( record.getSingerName() );
					
					record.setPrice( input.readDouble() );
					System.out.println( record.getPurchasePrice() );
				}
				catch( EOFException e ) {
					System.out.println( e );
				}
				catch( IOException e ) {
					System.out.println( e );
				}
				
				break;
			}
			
			try {
				input.close();
			}
			catch( IOException e ) {
				System.out.println( e );
			}
			
		} 
		
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
		
		public void openFile(String name) throws FileNotFoundException, IOException
		{
			input = new ObjectInputStream( new FileInputStream( name ) );
		}
		
		// main begin
		public static void main(String [] args)
		{
			ReadRecord d = new ReadRecord();
			d.getRecords("mySongs.ser");
		}
		// main end
	}

