/*
 * Purpose: Employee class (superclass) was created to handle basic information of employee
 * Owner: HuyenLTM
 * Created date (MM/DD/YY): 10/09/20
 * Version: 1.0
 */

package employee;
import java.util.Scanner;

public class Employee {
	
// Attributes
	protected String fullName;
	protected int employeeNumber;
	protected String phoneNumber;
	protected String address;
	protected float salary;
	protected float workingDays;
	
	
// Setter, getter methods and constructors	
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public int getEmployeeNumber() {
		return employeeNumber;
	}
	public void setEmployeeNumber(int employeeNumber) {
		this.employeeNumber = employeeNumber;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public float getSalary() {
		return salary;
	}
	public void setSalary(float salary) {
		this.salary = salary;
	}
	public float getWorkingDays() {
		return workingDays;
	}
	public void setWorkingDays(float workingDays) {
		this.workingDays = workingDays;
	}
	
	public Employee(String fullName, int employeeNumber, String phoneNumber, String address,
			float workingDays) {
		this.fullName = fullName;
		this.employeeNumber = employeeNumber;
		this.phoneNumber = phoneNumber;
		this.address = address;
		this.workingDays = workingDays;
	}
	public Employee() {
	}
	
	
// Business methods
	
	public float calculatingSalary() {
		return this.salary = 0;
	}
	
	public void infoInput(Scanner scan) {
		// enter basic information		
		
		System.out.println("Please provide employee information as below: ");
		
		System.out.print("Full name: ");
		this.fullName = scan.nextLine();
		System.out.print("Employee number: ");
		this.employeeNumber = Integer.parseInt(scan.nextLine());
		System.out.print("Number phone: ");
		this.phoneNumber = scan.nextLine();
		System.out.print("Address: ");
		this.address = scan.nextLine();
		System.out.print("Number of working days: ");
		this.workingDays = Float.parseFloat(scan.nextLine());
	}
	
	public void printNameAndNumber() {
		System.out.print("Full name: " + this.fullName + "\tEmployee number: " + this.employeeNumber);
	}
	
	public void printAddressPhoneWorkingDays() {
		System.out.println("Address: " + this.address);
		System.out.println("Number phone: " + this.phoneNumber);
		System.out.println("Number of working days: " + this.workingDays);
	}


}
