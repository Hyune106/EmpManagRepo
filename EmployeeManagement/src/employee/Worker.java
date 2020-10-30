/*
 * Purpose: Worker class (subclass) was created to inherit from Employee class
 * 			and handle information of worker
 * Owner: HuyenLTM
 * Created date (MM/DD/YY): 10/09/20
 * Version: 1.0
 */

package employee;

import java.util.Scanner;

public class Worker extends Employee {

// Constants
	private final float DAYRATEPAYMENT = 200000; // luong 1 ngay lam viec

// Attributes
	private int managerNumber; // ma truong phong quan ly nhan vien

// Getter, setter methods and constructors	
	public int getManagerNumber() {
		return managerNumber;
	}

	public void setManagerNumber(int managerNumber) {
		this.managerNumber = managerNumber;
	}

	public float getDayRatePayment() {
		return DAYRATEPAYMENT;
	}

	public Worker(String fullName, int employeeNumber, String phoneNumber, String address, float workingDays,
			int managerNumber) {
		super(fullName, employeeNumber, phoneNumber, address, workingDays);
		this.managerNumber = managerNumber;
	}

	public Worker(String fullName, int employeeNumber, String phoneNumber, String address, float workingDays) {
		super(fullName, employeeNumber, phoneNumber, address, workingDays);
	}

	public Worker() {
	}

	
// Business methods

	@Override
	public float calculatingSalary() {
		// Calculate salary of Worker

		return salary = DAYRATEPAYMENT * getWorkingDays();
	}

	@Override
	public void infoInput(Scanner scan) {
		// enter information of Worker

		super.infoInput(scan);
		System.out.print("Management number of manager: ");
		this.managerNumber = Integer.parseInt(scan.nextLine());
		System.out.println("------------------------------------------------------------");
	}

	public void printInfo() {
		// print all information of Worker

		printNameNumberPosition();
		super.printAddressPhoneWorkingDays();
		System.out.println("Salary per day: " + this.DAYRATEPAYMENT);
		System.out.println("Salary: " + this.salary);
		System.out.println("Manager number: " + this.managerNumber);
	}

	public void printNameNumberPosition() {
		// print full name, employee number and position

		super.printNameAndNumber();
		System.out.println("\tPosition: Worker");
	}
}
