package ATM_;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class Tester {

	
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		String randomNameList[] = new String[] {"Shay","Raymonde","Thresa","Tessie","Damion","Alvaro","Ty","Dudley","Neely","Golda"};
		String randomLastName[] = new String[] {"Jardine", "Corey","Hartford","Hanby","Lindow","Overstreet","Devin","Chery","Iriarte","Eagar"};
		int n = 0; 
		int j = 0;
		
		File accountsFile = new File("accounts.bat");	
		
		ArrayList<Account> accountsList = new ArrayList<Account>();
		for(int i = 0; i < 10; i++) {
			accountsList.add(new Account(i, 100));
		};
		
		for(Account i : accountsList) {
			i.setFname(randomNameList[n]);
			i.setLname(randomLastName[n]);
			n++;
		}
	
		FileUtilities.writeTheFile(accountsList,accountsFile);
		
		try {
			ArrayList<Account> newList = FileUtilities.readTheFile(accountsFile);
			
			for(Account i : newList) {
				System.out.println("\nId: "    					 + newList.get(j).getId() 
								+  " \nName: " 					 + newList.get(j).Fname 
								+  " "       					 + newList.get(j).Lname
								+  " \nAccount Balance: "          + newList.get(j).getAccBalance()
								+  " \nAnnual Interest Rate: "     + newList.get(j).getAnnualInterestRate()
								+  " \nDate Account was created: " + newList.get(j).getDateCreated());
				j++;
			}
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		
		AtmSignIn.main(accountsFile);
//		AtmLoggedIn.main();
		
	}	
}
