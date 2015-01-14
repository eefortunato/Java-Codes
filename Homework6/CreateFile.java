/*
 *CreateFile.java
 *
 * Description: Creates a sequential file using Object serialization
 * 
 * version:
 * 		$1.0$
 * 
 * @author: Eric Fortunato
 * @author: Sreeraj Paleri
 */

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class CreateFile {
	
	private ObjectOutputStream output;
	
	/*
	 * openFile()
	 * 
	 * Description: opens a file to write
	 * 
	 * @paramL none
	 * @return: none
	 */
	public void openFile() {
		
		try {
			output = new ObjectOutputStream(new FileOutputStream("addressbook.ser"));
		}
		
		catch(IOException ioexception) {
			System.err.println("Error opening file.");
		}
	}
	
	/*
	 * addRecords()
	 * 
	 * Description: write records to file
	 * 
	 * @param: none
	 * @return: none
	 */
	public void addRecords(AddressBook addbook) {
		
		try {
			output.writeObject(addbook);
		}
		
		catch(IOException ioexception) {
			
			ioexception.printStackTrace();
			//System.out.println("Error writing to file ");
		}
	}
	
	/*
	 * closeFile()
	 * 
	 * Description: close file
	 * 
	 * @param: none
	 * @return: none
	 */
	public void closeFile() {
		
		try {
			if( output != null)
				output.close();
		}
		
		catch(IOException ioexception) {
			System.err.println("Error closing file ");
			System.exit(1);
		}
	}
}
