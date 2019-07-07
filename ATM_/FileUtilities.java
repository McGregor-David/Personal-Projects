package ATM_;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

public class FileUtilities implements Serializable{

	private static ArrayList<Account> accountsAvail; 

	public static void writeTheFile(ArrayList<Account> accObj, File file) throws FileNotFoundException, IOException {
		ObjectOutputStream outputStreamObj = new ObjectOutputStream(new FileOutputStream(file));
		ArrayList<Account> accountsAvail = (ArrayList<Account>)accObj.clone();
		outputStreamObj.writeObject(accObj);
		outputStreamObj.close();
	}

	public static ArrayList<Account> readTheFile(File file) throws FileNotFoundException, IOException, ClassNotFoundException {
		ObjectInputStream inputStreamObj = new ObjectInputStream(new FileInputStream(file));
		
		ArrayList<Account> listOfAccounts = (ArrayList<Account>) inputStreamObj.readObject();
		inputStreamObj.close();
		return listOfAccounts;
	}

	public static boolean accountVerifier(int accountNumber, int pin) {
		
		for(Account i : accountsAvail) {
			if(i.getId() == accountNumber && i.getPin() == pin);
			return true;
		}
		
		return false;
	}
}
