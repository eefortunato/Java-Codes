import java.util.Scanner;

public class Test {
	
	//transient static Scanner read = new Scanner(System.in);
	public static void main(String[] args) {
		
		AddressBook adb = new AddressBook();
		AddressBook adb2 = adb;
		Scanner read = new Scanner(System.in);
		int input = 0;
		
		while(true) {
			
			System.out.println("\n1. Add Contact");
			System.out.println("2. Remove Contact");
			System.out.println("3. Update Contact");
			System.out.println("4. Print Contact");
			System.out.println("5. PrintByName");
			System.out.println("6. PrintByZip");
			System.out.println("7. Save");
			System.out.println("8. Load");
			System.out.println("9. Quit");
			
			System.out.print("Enter [1 - 9]: ");
			input = read.nextInt();
			read.nextLine();
			
			if(input == 1) {
				adb.addContact();
			}
			
			else if(input == 2) {
				System.out.println("\nenter last name: ");
				String removeName = read.nextLine();
				adb.remove(removeName);
			}
			
			else if(input == 3){
				String fname= new String();
				int contactIndex = -1;
				System.out.print("\nEnter First Name of Contact: ");	
				fname=read.next();
				for(int i =0; i < adb.getAddressBook().size(); i++){
					if(adb.getAddressBook().get(i).getFirstName().equalsIgnoreCase(fname)){
						contactIndex=i;
					}
				}
				
				if( contactIndex != -1 )
					adb.updateContact(contactIndex, fname);
				else
					System.out.println("\nContact Not Found. ");
			}
			
			else if(input == 4) {
				
				System.out.print("\nenter last name:");
				String name = read.next();
				adb2.printOne(name);
			}
			
			else if(input == 5) {
				adb.setLastNameFlag(true);
				adb2.printByName();
			}
			
			else if(input == 6) {
				adb.setLastNameFlag(false);
				adb2.printByZip();
			}
			
			else if(input == 7) {
				CreateFile newFile = new CreateFile();
				newFile.openFile();
				newFile.addRecords(adb);
				newFile.closeFile();
			}
			
			else if(input == 8) {
				ReadFile readfile = new ReadFile();
				readfile.openFile();
				readfile.readRecords();
				adb2 = readfile.getObject();
				readfile.closeFile();
			}
			
			else if(input == 9) {
				System.out.println("\nExiting the Address Book. . .");
				read.close();
				break;
			}
		}
	}

}
