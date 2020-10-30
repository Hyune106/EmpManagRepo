/*
 * Purpose: Main class was created to execute the project
 * Owner: HuyenLTM
 * Created date (MM/DD/YY): 10/15/20
 * Version: 1.0
 */

package process;

import java.util.Scanner;

import company.Company;
import data.DummyData;

public class Main {

	public static void main(String[] args) {

		progress();

	}

	// Main menu
	public static void Menu() {
		System.out.println("---------------------------------------------------------------------");
		System.out.println("------------------------------ MENU ---------------------------------");
		System.out.println("---------------------------------------------------------------------");
		System.out.println("0. Exit");
		System.out.println("1. Provide the company information");
		System.out.println("2. Use dummy data");
		System.out.println("3. Get the company information");
		System.out.println("4. Get the employees details");
		System.out.println("5. Find the employee details by their employee number");
		System.out.println("6. Find the employee(s) by their name");
		System.out.println("7. Update company information (include employee)");
		System.out.println("8. Remove employee");
		System.out.println("9. Find the manager(s) who manage(s) the most workers");
		System.out.println("10. Find the manager(s) who manage(s) the least workers");

		System.out.print(">>> Choose: ");
	}

	// Handle options of users
	public static void progress() {
		int select;

		Scanner scan = new Scanner(System.in);
		Company comp = new Company();
		DummyData dum = new DummyData(); // initialize dummy data for 2nd option

		do {
			Menu();
			select = Integer.parseInt(scan.nextLine());

			switch (select) {
			case 0:
				break;
			case 1: {
				comp.companyInput(scan);
				comp.calculatingPayment(); // update payment after adding information of company
				comp.calculatingProfit(); // update profit after adding information of company
				break;
			}
			case 2: {
				comp = dum.dummyData();
				break;
			}
			case 3: {
				comp.printCompanyInfo();
				break;
			}
			case 4: {
				comp.printEmployeeWithSelection(scan);
				break;
			}
			case 5: {
				comp.showEmployeeById(scan);
				break;
			}
			case 6: {
				System.out.print("Please enter the employee name: ");
				String requiredName = scan.nextLine();
				comp.findEmployeeByName(requiredName);
				break;
			}
			case 7: {
				comp.updateCompanyInfo(scan);
				break;
			}
			case 8: {
				// Warning: need to update when there are any invalid id of manager
				// in case an manager is remove -> update new manager for the related workers 
				comp.removeEmployee(scan);
				break;
			}
			case 9: {
				comp.showManagerMostWorkers();
				break;
			}
			case 10: {
				comp.showManagerLeastWorkers();
				break;
			}
			default:
				System.out.println("Wrong input! Please choose again");
				break;
			}
		} while (select != 0);

	}

}
