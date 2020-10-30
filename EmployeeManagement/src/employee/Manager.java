/*
 * Purpose: Manager class (subclass) was created to inherit from Employee class
 * 			and handle information of manager
 * Owner: HuyenLTM
 * Created date (MM/DD/YY): 10/09/20
 * Version: 1.0
 */

package employee;
import java.util.Scanner;

public class Manager extends Employee{

// Constants
	private final float DAYRATEPAYMENT = 300000;	// luong 1 ngay lam viec
	
	
// Attributes
	private int numberWorkers;						// so luong nhan vien duoi quyen
	private float allowance;						// phu cap
	
	
// Setter, getter methods and constructors
	public int getNumberWorkers() {
		return numberWorkers;
	}
	public void setNumberWorkers(int numberWorkers) {
		this.numberWorkers = numberWorkers;
	}
	public float getAllowance() {
		return allowance;
	}
	public void setAllowance(float allowance) {
		this.allowance = allowance;
	}
	public float getDayRatePayment() {
		return DAYRATEPAYMENT;
	}
	
	public Manager(String fullName, int employeeNumber, String phoneNumber, String address,
			float workingDays, float allowance) {
		super(fullName, employeeNumber, phoneNumber, address, workingDays);
//		this.numberWorkers = numberWorkers;
		this.allowance = allowance;
	}
	public Manager(String fullName, int employeeNumber, String phoneNumber, String address,
			float workingDays) {
		super(fullName, employeeNumber, phoneNumber, address, workingDays);
	}
	public Manager() {
		this.numberWorkers = 0;
	}


// Business methods
	
	@Override
	public float calculatingSalary() {
		// Calculate salary of Manager
		
		return this.salary = DAYRATEPAYMENT*getWorkingDays() + allowance*this.numberWorkers;
	}
	
	@Override
	public void infoInput(Scanner scan) {
		// enter information of Manager
		
		super.infoInput(scan);
//		System.out.print("Number of dependent workers: ");
//		this.numberWorkers = Integer.parseInt(scan.nextLine());
		System.out.print("Allowance: ");
		this.allowance = Float.parseFloat(scan.nextLine());
		System.out.println("------------------------------------------------------------");
	}

	public void printInfo() {
		// print all information of Manager
		
		printNameNumberPosition();
		super.printAddressPhoneWorkingDays();
		System.out.println("Salary per day: " + this.DAYRATEPAYMENT);
		System.out.println("Salary: " + this.salary);
		System.out.println("Number of dependent workers: " + this.numberWorkers);
		System.out.println("Allowance: " + this.allowance);
	}
	
	public void printNameNumberPosition() {
		// print full name, employee number and position
		
		super.printNameAndNumber();
		System.out.println("\tPosition: Manager");
	}
	
}
