// ReadRecord.java


public class ReadRecord
	{

		/* This method deserializes records (objects) in the given file, 'name':
		 * 1. It opens a file for deserialization. and catches the possible 
		 *    exceptions refer to the Java API.
		 * 2. uses a while loop to read the music records. The funciton to read
		 *    objects is: readObject()
		 * 3. as it reads the objects it uses the printf funtions to display them 
		 *    on the screen.
		 * 4. It catches all possible exceptions: 
		 *       - EOFException
		 *       - ClassNotFoundException, if it cannot create a record object
		 *       - IOException
		 * 5. etc...
		 */
		private void getRecords(String name)
		{

			// object to be written to file
			MusicRecord record ;
			
			// YOUR CODE GOES HERE
			
		} // end method readRecords
		
		
		public static void main(String [] args)
		{
			ReadRecord d = new ReadRecord();
			d.getRecords("mySongs.ser");
		}
		
	}






