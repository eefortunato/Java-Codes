/*
 * ReadFile.java
 * 
 * Description: Reads object from a file
 * 
 * version:
 * 		$1.0$
 * 
 * @author: Eric Fortunato
 * @author: Sreeraj Paleri
 */

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class ReadFile {
	
	private ObjectInputStream filein;
	public AddressBook record;
	
	/*
	 * openFile()
	 * 
	 * Description: opens a file to read
	 * 
	 * @paramL none
	 * @return: none
	 */
	public void openFile() {
		
		try {
			filein = new ObjectInputStream(new FileInputStream("addressbook.ser"));
		}
		
		catch(IOException ioexception) {
			System.err.println("Error opening file ");
		}
	}
	
	/*
	 * readRecords()
	 * 
	 * Description: read records from a file
	 * 
	 * @paramL none
	 * @return: none
	 */
	public void readRecords() {
		
		try {
			while(true) {
				record = (AddressBook)filein.readObject();
			}
		}
		
		catch(EOFException eofexception) {
			return;
		}
		
		catch(IOException ioexception) {
			System.err.println("Error during reading file ");
			ioexception.printStackTrace();
		} 
		
		catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/*
	 * getObject()
	 * 
	 * Description: returns the record
	 * 
	 * @param: none
	 * @return: record
	 */
	public AddressBook getObject() {
		return record;
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
			if( filein != null)
				filein.close();
		}
		
		catch(IOException ioexception) {
			System.err.println("Error closing file ");
			System.exit(1);
		}
	}
	
}
