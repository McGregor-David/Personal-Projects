package ATM_;

import java.io.Serializable;
import java.util.Date;

public class Account implements Serializable{

	private int id;
	private int pin;
	private double accBalance;
	private double annualInterestRate;
	private Date dateCreated;
	String Fname;
	String Lname;
	boolean signedInBefore; // for first time log ins.. reset password
	
		
	public String getFname() {
		return Fname;
	}

	public void setFname(String fname) {
		Fname = fname;
	}

	public String getLname() {
		return Lname;
	}

	public void setLname(String lname) {
		Lname = lname;
	}
	
	Account(){
		id = 0;
		accBalance = 0;
		annualInterestRate = 0; //change this when you know what the interest is going to be
		dateCreated = new Date();
		pin = 0000;
		signedInBefore = false;
	}

	Account(int ident, double bal){
		id = ident;
		accBalance = bal;
		annualInterestRate = 0;
		dateCreated = new Date();
		pin = 0000;
		signedInBefore = false;
	}
	
	Account(int ident, double bal, String fName, String lName){
		id = ident;
		accBalance = bal;
		annualInterestRate = 0;
		dateCreated = new Date();
		Lname = new String(lName);
		Fname = new String(fName);
	}
	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getAccBalance() {
		return accBalance;
	}

	public void setAccBalance(double accBalance) {
		this.accBalance = accBalance;
	}

	public double getAnnualInterestRate() {
		return annualInterestRate;
	}

	public void setAnnualInterestRate(double annualInterestRate) {
		this.annualInterestRate = annualInterestRate;
	}

	public Date getDateCreated() {
		return dateCreated;
	}
	
	double getMonthlyInterestRate(){
		return annualInterestRate/12;
	}
	
	double getMonthlyInterest() {
		double rate = this.getMonthlyInterestRate();
		rate += 1;
		rate = Math.pow(rate, 12);
		rate -= 1;
		return rate;
	}
	
	void withdraw(double amount) {
		accBalance -= amount;
	}
	
	void deposit(double amount) {
		accBalance += amount;
	}
	
	private void changePin(int newPin) {
		this.pin = newPin;
	}
	
	public int getPin() {  //THIS SEEMS VERY WRONG, NEED TO FIND BETTER, MORE SECURE, SOLUTION
		return pin;
	}
}
