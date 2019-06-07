import java.util.Scanner;

public class Complex implements Cloneable{
	private double realPart;
	private double imaginaryPart;
	
	//No argument constructor, sets to safe empty state
	public Complex() {
		this.realPart = 0;
		this.imaginaryPart = 0;
	}
	
	//One argument constructor, sets imaginary(b) to safe empty state
	public Complex(double realPart) {
		this.realPart = realPart;
	}
	
	//Two argument constructor, sets to input values
	public Complex(double realPart, double imaginaryPart) {
		this.realPart = realPart;
		this.imaginaryPart = imaginaryPart;
	}
	
	//Returns real part of the complex number
	public double getRealPart() {
		return this.realPart;
	}
	
	//Returns imaginary part of the complex number
	public double getImaginaryPart() {
		return this.imaginaryPart;
	}
	
	//Sets the values for real and imaginary parts
	private Complex setComplex(double a, double b) {
		realPart = a;
		imaginaryPart = b;
		
		return this;
	}
	
	//Adds complex number in new Complex() to not alter original value
	//returning type Complex
	public Complex add(Complex added) {
		return setComplex (
				this.realPart += added.realPart,
				this.imaginaryPart += added.imaginaryPart
		);			
	}
	
	//Subtracts complex number in new Complex() to not alter original value
	//returning type Complex
	public Complex subtract(Complex sub) {
		return setComplex(
				this.realPart -= sub.realPart,
				this.imaginaryPart -= sub.imaginaryPart
		);
	}

	//Multiplies complex number in new Complex() to not alter original value
	//returning type Complex
	public Complex multiply(Complex multi) {
		return setComplex (
				(this.realPart * multi.realPart) - 
				(this.imaginaryPart * multi.imaginaryPart),
				
				(this.imaginaryPart * multi.realPart) + 
				(this.realPart * multi.imaginaryPart)
				);
	}
	
	//Divides complex number in new Complex() to not alter original value
	//returning type Complex
	public Complex divide(Complex div) {
		double a = (div.realPart * div.realPart);
		double b = (div.imaginaryPart * div.imaginaryPart);
		return setComplex(
				((this.realPart * div.realPart) + 
				(this.imaginaryPart * div.imaginaryPart)) / (a + b),
				
				((this.imaginaryPart * div.realPart) - 
				(this.realPart * div.imaginaryPart)) / (a + b)
		);
	}
	
	//Gets the absolute of a complex number in new Complex() to not alter original
	//value returning type Complex
	public double abs() {
		return Math.sqrt(realPart * realPart + imaginaryPart *imaginaryPart);
	}
	
	//Overriding the toString() to make output readable
	public String toString() {
		String output = "";
		output = getRealPart() + " + " + getImaginaryPart() + "i";
		
		return output;
	}
	
	//Cloneable function to implement clone() on objects so we don't change
	//original values
	@Override
	public Complex clone() throws CloneNotSupportedException {
		return (Complex)super.clone();
	}
	
	public static Complex createComplex(Scanner input) {
		while(true) {
			try {
				double a = input.nextDouble();
				double b = input.nextDouble();
				return new Complex(a, b);
			} catch (Exception ex) {
				System.out.print("Please retry");
			}
		}
	}
	
	public static void main(String[] args) throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		Scanner input = new Scanner (System.in);
		System.out.print("Enter the first complex number:" );
		Complex a = createComplex(input);
		System.out.print("Enter the second complex number:" );
		Complex b = createComplex(input);
		
		try {
		System.out.println("(" + a + ") + (" + b + ") = " + a.clone().add(b));
		System.out.println("(" + a + ") - (" + b + ") = " + a.clone().subtract(b));
		System.out.println("(" + a + ") * (" + b + ") = " + a.clone().multiply(b));
		System.out.println("(" + a + ") / (" + b + ") = " + a.clone().divide(b));
		System.out.println("|(" + a + ")| = " + a.abs());
		} catch(CloneNotSupportedException ex){
			System.out.print("Clone not supported");
		} 
	}//Main function
} //Class Complex