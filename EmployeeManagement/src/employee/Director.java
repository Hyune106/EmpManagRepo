/*
 * Purpose: Director class (subclass) was created to inherit from Employee class
 * 			and handle information of director
 * Owner: HuyenLTM
 * Created date (MM/DD/YY): 10/09/20
 * Version: 1.0
 */

package employee;

import java.util.Scanner;

public class Director extends Employee {

// Constants
	private final float DAYRATEPAYMENT = 500000;			// tien luong 1 ngay
	

// Attributes
	private float share;									// co phan

	
// Setter, getter methods and constructors
	public float getDayRatePayment() {
		return DAYRATEPAYMENT;
	}
	public float getShare() {
		return share;
	}
	public void setShare(float share) {
		this.share = share;
	}

	public Director(String fullName, int employeeNumber, String phoneNumber, String address, float workingDays) {
		super(fullName, employeeNumber, phoneNumber, address, workingDays);
	}
	public Director(String fullName, int employeeNumber, String phoneNumber, String address, float workingDays,
			float share) {
		super(fullName, employeeNumber, phoneNumber, address, workingDays);
		this.share = share;
	}

	public Director() {
	}


// Business methods
	
	@Override
	public float calculatingSalary() {
		// Calculate basic salary of director
		// not included share
		
		return this.salary = DAYRATEPAYMENT * getWorkingDays();
	}

	@Override
	public void infoInput(Scanner scan) {
		// enter information of director
		
		super.infoInput(scan);
		// check whether share in the range 0-100% or not
		do {
			System.out.print("Share: ");
			this.share = Float.parseFloat(scan.nextLine());
			if (this.share < 0 || this.share > 100) {
				System.out.println("Wrong value!! Please choose another value in the range 0-100");
			}
		} while (this.share < 0 || this.share > 100);
		System.out.println("------------------------------------------------------------");
	}
	
	public void printInfo(float totalSalary) {
		// print all information of Director
		
		printNameNumberPosition();
		super.printAddressPhoneWorkingDays();
		System.out.println("Salary per day: " + this.DAYRATEPAYMENT);
		System.out.println("Share: " + this.share);
		System.out.println("Total of salary: " + totalSalary);
	}
	
	public void printNameNumberPosition() {
		// print full name, employee number and position
		
		super.printNameAndNumber();
		System.out.println("\tPosition: Director");
	}
	

}
