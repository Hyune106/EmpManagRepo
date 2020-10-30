/*
 * Purpose: Company class was created to handle all information of company
 * Owner: HuyenLTM
 * Created date (MM/DD/YY): 10/10/20
 * Version: 1.0
 */

package company;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import employee.Director;
import employee.Employee;
import employee.Manager;
import employee.Worker;

public class Company {

// Constants
	private final int DIRECTOR = 1;
	private final int MANAGER = 2;
	private final int WORKER = 3;
	private final int ALL = 4;

	private final int CONTINUE = 1;
	private final int STOP = 2;
	private final int YES = 1;
	private final int NO = 2;

// Attributes
	private String companyName;
	private int businessCode; // ma cong ty
	private List<Employee> listEmployee;
	private float revenueOfMonth; // doanh thu thang
	private float payment; // tong luong
	private float profit; // loi nhuan

// Setter, getter methods and constructors
	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public int getBusinessCode() {
		return businessCode;
	}

	public void setBusinessCode(int businessCode) {
		this.businessCode = businessCode;
	}

	public List<Employee> getListEmployee() {
		return listEmployee;
	}

	public void setListEmployee(List<Employee> listEmployee) {
		this.listEmployee = listEmployee;
	}

	public float getRevenueOfMonth() {
		return revenueOfMonth;
	}

	public void setRevenueOfMonth(float revenueOfMonth) {
		this.revenueOfMonth = revenueOfMonth;
	}

	public float getPayment() {
		return payment;
	}

	public void setPayment(float payment) {
		this.payment = payment;
	}

	public float getProfit() {
		return profit;
	}

	public void setProfit(float profit) {
		this.profit = profit;
	}

	public Company() {
		this.listEmployee = new ArrayList<Employee>();
	}

	public Company(String companyName, int businessCode, float revenueOfMonth) {
		this.companyName = companyName;
		this.businessCode = businessCode;
		this.revenueOfMonth = revenueOfMonth;
	}

// Business methods

	public void calculatingPayment() {
		// Calculates total of payment

		this.payment = 0;
		for (Employee emp : this.listEmployee) {
			emp.calculatingSalary();
			this.payment += emp.getSalary();
		}
	}

	public void calculatingProfit() {
		// Calculates profit of company

		this.calculatingPayment();
		this.profit = this.revenueOfMonth - this.payment;
	}

	public void employeeInput(Scanner scan) {
		// adds employee information base on their position

		boolean check;
		Employee emp = null;
		do {
			check = true;
			System.out.println("Employee information: ");
			System.out.println("\tPosition of employee: \t1/ Director \t2/ Manager \t3/ Worker");
			System.out.print(" >>> Choose: ");
			int position = Integer.parseInt(scan.nextLine());
			switch (position) {
			case DIRECTOR: {
				emp = new Director();
				emp.infoInput(scan);
				this.listEmployee.add(emp);
				System.out.println("Updated!");
				break;
			}
			case MANAGER: {
				emp = new Manager();
				emp.infoInput(scan);
				this.listEmployee.add(emp);
				System.out.println("Updated!");
				break;
			}
			case WORKER: {
				emp = new Worker();
				emp.infoInput(scan);
				this.listEmployee.add(emp);
				increaseNumberWorkersOfManager((Worker) emp); // updates number of workers
																// of the related manager
				System.out.println("Updated!");
				break;
			}
			default: {
				System.out.println("Wrong input!! Please choose again.");
				check = false;
				break;
			}
			}
			if (check != false) {
				// if data successfully updated, user will decide to continue or stop adding
				// employee.
				check = nextAction(scan, check);
			}
		} while (check == false);
	}

	public void companyInput(Scanner scan) {
		// adds company information

		System.out.println("Please provide company information as below: ");

		System.out.print("Company name: ");
		this.companyName = scan.nextLine();
		System.out.print("Bussiness code: ");
		this.businessCode = Integer.parseInt(scan.nextLine());
		System.out.print("Revenue of month: ");
		this.revenueOfMonth = Float.parseFloat(scan.nextLine());
		// payment and profit will be added in Main class after this method is called

		employeeInput(scan); // adds employee information
		System.out.println("------------------------------------------------------------");
	}

	public float totalSalaryOfDirector(Employee emp) {
		// Calculates total salary of Director
		// makes sure "emp" is Director

		if (this.profit > 0) {
			return (emp.calculatingSalary() + this.profit * (((Director) emp).getShare() / 100));
		}
		return emp.calculatingSalary();
	}

	public void printEmployeeInfo(int position) {
		// shows employee information base on job classification (position)

		boolean check = false;
		if (position == DIRECTOR) {
			System.out.println("Information of directors: ");
		} else if (position == MANAGER) {
			System.out.println("Information of managers: ");
		} else {
			System.out.println("Information of workers: ");
		}
		for (Employee emp : this.listEmployee) {
			if (position == DIRECTOR) {
				if (emp instanceof Director) {
					((Director) emp).printInfo(totalSalaryOfDirector(emp));
					check = true;
				}
			} else if (position == MANAGER) {
				if (emp instanceof Manager) {
					((Manager) emp).printInfo();
					check = true;
				}
			} else {
				if (emp instanceof Worker) {
					((Worker) emp).printInfo();
					check = true;
				}
			}
		}
		if (check == false) {
			// if there is no employee, print "None"
			System.out.println("None!");
		}
	}

	public void printEmployeeWithSelection(Scanner scan) {
		// shows employee information with user's selection

		int position;
		do {
			System.out.println("Please choose position of employees: ");
			System.out.println("0. Exit \t1. Director \t2. Manager \t3. Worker \t4. All employees");
			System.out.print(">>> Choose: ");
			position = Integer.parseInt(scan.nextLine());

			if (position == DIRECTOR || position == MANAGER || position == WORKER) {
				printEmployeeInfo(position);
			} else if (position == ALL) {
				printEmployeeInfo(DIRECTOR);
				printEmployeeInfo(MANAGER);
				printEmployeeInfo(WORKER);
			} else if (position == 0){
				return;
			} else {
				// If the selection does not follow the instruction,
				// this message will be showed and user has to choose again.
				System.out.println("Wrong input!! Please choose again.");
			}
		} while (position > ALL);
	}

	public boolean printEmployeeNameNumberPosition(int type, List<Employee> listEmp) {
		// shows employee list (include full name, employee number and position)
		// base on job classification (position)
		// if no employee is showed, this method will return false and vice versa.

		boolean check = false;
		for (Employee emp : listEmp) {
			if (type == DIRECTOR) {
				if (emp instanceof Director) {
					((Director) emp).printNameNumberPosition();
					check = true;
				}
			} else if (type == MANAGER) {
				if (emp instanceof Manager) {
					((Manager) emp).printNameNumberPosition();
					check = true;
				}
			} else {
				if (emp instanceof Worker) {
					((Worker) emp).printNameNumberPosition();
					check = true;
				}
			}
		}
		return check;
	}

	public void printAllEmployeesNameNumberPosition() {
		// shows all employees as list (include full name, employee number and position)

		boolean check = false;
		for (int i = 1; i <= 3; i++) {
			check |= printEmployeeNameNumberPosition(i, this.listEmployee);
		}
		if (check == false) {
			// if no employee is showed, this message will be showed
			System.out.println("Empty list!");
		}
	}

	public void printCompanyInfo() {
		// shows company information

		System.out.println("------------------------------------------------------------");
		System.out.println("------------------ COMPANY INFORMATION ---------------------");
		System.out.println("Company name: " + this.companyName);
		System.out.println("Bussiness code: " + this.businessCode);
		System.out.println("Revenue of month: " + this.revenueOfMonth);
		System.out.println("Total of payment: " + this.payment);
		System.out.println("Profit: " + this.profit);
		System.out.println("\nEmployee list: ");
		printAllEmployeesNameNumberPosition(); // shows a list include all employees
		System.out.println("------------------------------------------------------------");
	}

	public void showEmployeeById(Scanner scan) {
		// shows details of an employee base on the given employee number

		System.out.print("Please enter the employee number: ");
		int id = Integer.parseInt(scan.nextLine());
		Employee emp = findEmployeeById(id); // calls the support method
		if (emp != null) {
			if (emp instanceof Director) {
				((Director) emp).printInfo(totalSalaryOfDirector(emp));
			} else if (emp instanceof Manager) {
				((Manager) emp).printInfo();
			} else {
				((Worker) emp).printInfo();
			}
		} else {
			System.out.println("The employee number: " + id + " does not exist!");
		}
	}

	public void findEmployeeByName(String requiredName) {
		// finds the employee base on the given name

		String[] listName = new String[this.listEmployee.size()]; // this array contains name of
																	// all employees
		List<Integer> listIndex = new ArrayList<Integer>(); // this list contains the index(es)
															// which represent(s) the found employee(s)
		int index = 0;

		for (Employee emp_i : this.listEmployee) {
			String fullName = emp_i.getFullName().trim(); // removes redundant "space" in the beginning
															// and the end of string
			for (int i = ((fullName.length()) - 1); i >= 0; i--) {
				// gets names from full names of all employees
				if (fullName.charAt(i) == ' ') {
					listName[index] = fullName.substring(i + 1);
					break;
				} else if (fullName.contains(" ") == false) {
					listName[index] = fullName;
					break;
				}
			}
			if (requiredName.equalsIgnoreCase(listName[index])) {
				// compares the given name and the name of employee
				// if it's the same, add to list of index
				listIndex.add(index);
			}
			index++;
		}
		if (listIndex.isEmpty()) {
			// if no employee is found, exit this method
			System.out.println("No employee with name: " + requiredName);
			return;
		}
		// If any employees are found, show them (full name, employee number and
		// position)
		System.out.println("The employee(s) with name: " + requiredName);
		for (Integer _index : listIndex) {
			if (this.listEmployee.get(_index) instanceof Director) {
				((Director) this.listEmployee.get(_index)).printNameNumberPosition();
			} else if (this.listEmployee.get(_index) instanceof Manager) {
				((Manager) this.listEmployee.get(_index)).printNameNumberPosition();
			} else {
				((Worker) this.listEmployee.get(_index)).printNameNumberPosition();
			}
		}

	}

	public void updateEmployee(Scanner scan) {
		// updates information of employee base on their employee number

		System.out.println("Employee list:");
		printAllEmployeesNameNumberPosition(); // shows all employees
		System.out.print(">>> Choose the employee number: ");
		int id = Integer.parseInt(scan.nextLine()); // enters the employee number
		Employee emp = findEmployeeById(id); // finds and returns the employee was found
												// by his/her employee number
		if (emp != null) {
			updateEmployeeInfo(scan, emp); // calls the support method
			this.calculatingPayment(); // updates payment
			this.calculatingProfit(); // updates profit
		} else {
			System.out.println("Can't find the employee with employee number " + id);
		}
	}

	public void updateCompanyInfo(Scanner scan) {
		// updates information of company

		boolean check = false;
		do {
			System.out.println("Which of the following will be updated?");
			System.out.println("0/ Exit \t1/ Company name \t2/ Business code \t3/ Revenue \t4/ Employee");
			System.out.print(">>> Choose: ");

			int select = Integer.parseInt(scan.nextLine());

			switch (select) {
			case 0:
				return;
			case 1: {
				System.out.print("Please provide new name: ");
				String companyName = scan.nextLine();
				this.setCompanyName(companyName);
				System.out.println("Updated!");
				check = true;
				break;
			}
			case 2: {
				System.out.print("Please provide new business code: ");
				int businessCode = Integer.parseInt(scan.nextLine());
				this.setBusinessCode(businessCode);
				System.out.println("Updated!");
				check = true;
				break;
			}
			case 3: {
				System.out.print("Please provide the lastest revenue: ");
				float revenue = Float.parseFloat(scan.nextLine());
				this.setRevenueOfMonth(revenue);
				this.calculatingProfit(); // updates profit after modifying revenue
				System.out.println("Updated!");
				check = true;
				break;
			}
			case 4: {
				updateEmployee(scan);
				check = true;
				break;
			}
			default:
				System.out.println("Wrong input! Please choose again.");
				break;
			}

			if (check != false) {
				// if data successfully updated, user will decide to continue or stop updating
				// employee
				check = nextAction(scan, check);
			}

		} while (check == false);

	}

	public void removeEmployee(Scanner scan) {
		// deletes information of an employee base on his/her employee number

		System.out.println("Employee list:");
		printAllEmployeesNameNumberPosition(); // shows all employees
		System.out.print("Please provide the employee number: ");
		int id = Integer.parseInt(scan.nextLine());
		Employee emp = findEmployeeById(id); // gets an employee with the given id
		if (emp != null) {
			if (emp instanceof Worker) {
				this.listEmployee.remove(emp);
				decreaseNumberWorkersOfManager((Worker) emp); // updates number of workers
																// of the related manager
				System.out.println("The worker with employee number " + id + " has been removed!");
			} else if (emp instanceof Manager) {
				this.listEmployee.remove(emp);
				updateManagerNumberOfWorker(scan, (Manager) emp); // updates manager number for all workers
																	// who relate to the removed manager
				System.out.println("The manager with employee number " + id + " has been removed!");
				System.out.println("The manager number of the related workers has been updated also.");
			} else {
				this.listEmployee.remove(emp);
				System.out.println("The director with employee number " + id + " has been removed!");
			}

		} else {
			System.out.println("There is no employee with employee numer " + id);
		}

	}

	public void showManagerMostWorkers() {
		// shows the manager who has the most workers

		List<Manager> listMan = getListManagers(this.listEmployee);
		List<Manager> reqMan = findManagerMostWorkers(listMan);
		if (reqMan != null) {
			System.out.println("The manager managing the most workers is/are: ");
			for (Manager man : reqMan) {
				System.out.println(man.getFullName() + " with employee number " + man.getEmployeeNumber()
						+ " and number of workers is: " + man.getNumberWorkers() + " workers");
			}
		} else {
			System.out.println("There is no manager");
		}
	}

	public void showManagerLeastWorkers() {
		// shows the manager who has the most workers

		List<Manager> listMan = getListManagers(this.listEmployee);
		List<Manager> reqMan = findManagerLeastWorkers(listMan);
		if (reqMan != null) {
			System.out.println("The manager managing the least workers is/are: ");
			for (Manager man : reqMan) {
				System.out.println(man.getFullName() + " with employee number " + man.getEmployeeNumber()
						+ " and number of workers is: " + man.getNumberWorkers() + " workers");
			}
		} else {
			System.out.println("There is no manager");
		}
	}

// Support methods

	public List<Director> getListDirectors(List<Employee> listEmp) {
		// gets list of directors
		// support method

		if (listEmp != null) {
			List<Director> listDir = new ArrayList<Director>(); // initializes list of Directors

			for (Employee emp : listEmp) {
				if (emp instanceof Director) {
					listDir.add((Director) emp); // add to listDir if the employee is Director
				}
			}
			return listDir;
		}
		return null;
	}

	public List<Manager> getListManagers(List<Employee> listEmp) {
		// gets list of managers
		// support method

		if (listEmp != null) {
			List<Manager> listMan = new ArrayList<Manager>(); // initializes list of Managers

			for (Employee emp : listEmp) {
				if (emp instanceof Manager) {
					listMan.add((Manager) emp); // add to listMan if the employee is Manager
				}
			}
			return listMan;
		}
		return null;
	}

	public List<Worker> getListWorkers(List<Employee> listEmp) {
		// gets list of workers
		// support method

		if (listEmp != null) {
			List<Worker> listWor = new ArrayList<Worker>(); // initializes list of Workers

			for (Employee emp : listEmp) {
				if (emp instanceof Worker) {
					listWor.add((Worker) emp); // add to listWor if the employee is Workers
				}
			}
			return listWor;
		}
		return null;
	}

	public List<Manager> findManagerLeastWorkers(List<Manager> listMan) {
		// finds the manager(s) who has(ve) the least workers
		// support method

		if (listMan != null) {
			List<Manager> listRequiredMan = new ArrayList<Manager>(); // no manager
			int index = 0;
			int temp = listMan.get(0).getNumberWorkers(); // considers the first manager
															// as the manager has the most workers
			for (int i = 1; i < listMan.size(); i++) {
				// compares with the next manager if he/she has number of workers more than
				// the previous manager, add to temp for the next comparison
				if (listMan.get(i).getNumberWorkers() < temp) {
					temp = listMan.get(i).getNumberWorkers();
					index = i;
				}
			}
			listRequiredMan.add(listMan.get(index)); // adds the first manager having the most workers to
														// listRequiredMan
			for (int i = index + 1; i < listMan.size(); i++) {
				// compares the number of workers of the manager who has been found to the
				// others, if same value -> add to the list
				if (listMan.get(index).getNumberWorkers() == listMan.get(i).getNumberWorkers()) {
					listRequiredMan.add(listMan.get(i));
				}
			}
			return listRequiredMan;
		}
		return null;
	}

	public List<Manager> findManagerMostWorkers(List<Manager> listMan) {
		// finds the manager(s) who has(ve) the most workers
		// support method

		if (listMan != null) {
			List<Manager> listRequiredMan = new ArrayList<Manager>(); // no manager
			int index = 0;
			int temp = listMan.get(0).getNumberWorkers(); // considers the first manager
															// as the manager has the most workers
			for (int i = 1; i < listMan.size(); i++) {
				// compares with the next manager if he/she has number of workers more than
				// the previous manager, add to temp for the next comparison
				if (listMan.get(i).getNumberWorkers() > temp) {
					temp = listMan.get(i).getNumberWorkers();
					index = i;
				}
			}
			listRequiredMan.add(listMan.get(index)); // adds the first manager having the most workers to
														// listRequiredMan
			for (int i = index + 1; i < listMan.size(); i++) {
				// compares the number of workers of the manager who has been found to the
				// others, if same value -> add to the list
				if (listMan.get(index).getNumberWorkers() == listMan.get(i).getNumberWorkers()) {
					listRequiredMan.add(listMan.get(i));
				}
			}
			return listRequiredMan;
		}

		return null;
	}

	public List<Integer> getWorkersOfManager(int idManager) {
		// gets the dependent workers of a manager base on his/her employee number
		// support method

		List<Integer> listWorkerNo = new ArrayList<Integer>(); // this list contains employee number
																// of the workers who under control
																// of the required manager
		for (Employee emp_i : this.listEmployee) {
			if (emp_i instanceof Worker) {
				if (idManager == ((Worker) emp_i).getManagerNumber()) {
					// check if employee number of that Manager is the same with
					// manager numbers of any workers
					// if yes, add them to listWorkerNo
					listWorkerNo.add(emp_i.getEmployeeNumber());
				}
			}
		}
		return listWorkerNo;
	}

	public List<Integer> updateWorkersOfManager(int idWorkerRemove) {
		// updates dependent of workers of a manager
		// unused method

		Employee worker = null;
		Employee manager = null;
		worker = findEmployeeById(idWorkerRemove); // gets the worker base on
													// the required employee number
		int idManager = ((Worker) worker).getManagerNumber(); // gets the manager number
																// (employee number of the required
																// manager) base on that worker
		List<Integer> idList = getWorkersOfManager(idManager); // gets index list of workers
																// who depend on that manager
		idList.remove(Integer.valueOf(idWorkerRemove)); // deletes the employee number of the worker
														// from the index list of workers who
														// depend on that manager
		manager = findEmployeeById(idManager); // gets the manager
		((Manager) manager).setNumberWorkers(idList.size()); // updates number of workers

		return idList;
	}

	public void _updateNumberWorkersOfManager(int idManager) {
		// updates number of workers of an manager
		// support method

		int count = 0;
		Employee manager = null;
		for (Employee emp_i : this.listEmployee) {
			if (emp_i instanceof Worker) {
				if (idManager == ((Worker) emp_i).getManagerNumber()) {
					// check if employee number of that Manager is the same with
					// manager numbers of any workers
					// if yes, increase counter
					count++;
				}
			}
		}
		manager = findEmployeeById(idManager); // gets the manager
		((Manager) manager).setNumberWorkers(count); // updates number workers
	}

	public void updateNumberWorkersOfManager() {
		// updates number of workers for all managers
		// purpose: support for testing when use DummyData.java

		for (Employee emp_i : this.listEmployee) {
			if (emp_i instanceof Manager) {
				_updateNumberWorkersOfManager(emp_i.getEmployeeNumber());
			}
		}
	}

	public boolean yesOrNo(Scanner scan) {
		// decides the next action - yes (return true) or no (return false)
		// support method

		boolean check;
		do {
			System.out.println("Your answer: \t\t1/ Yes \t\t2/ No");
			System.out.print(">>> Choose: ");
			int answer = Integer.parseInt(scan.nextLine());
			check = true;
			switch (answer) {
			case YES:
				break;
			case NO:
				return false;
			default:
				System.out.println("Wrong input!! Please choose again.");
				check = false;
				break;
			}
		} while (check == false);
		return true;
	}

	public boolean nextAction(Scanner scan, boolean check) {
		// decides the next action - stop (return true) or continue (return false)

		boolean check_act;
		do {
			System.out.println("Please choose next action: \t1/ Continue \t2/ Stop");
			System.out.print(">>> Choose: ");
			int action = Integer.parseInt(scan.nextLine());
			check_act = true;
			switch (action) {
			case CONTINUE:
				check = false;
				break;
			case STOP:
				check = true;
				break;
			default:
				System.out.println("Wrong input!! Please choose again.");
				check_act = false;
				break;
			}
		} while (check_act == false);
		return check;
	}

	public void updateManagerNumberOfWorker(Scanner scan, Manager manager) {
		// updates manager number for all workers who relate to the removed manager
		// support method

		int newNo = 0; // initializes value for the new manager number
		System.out.println("Do you need to update new manager for the related workers?");
		boolean answer = yesOrNo(scan); // asks users if they want to update the new manager number
		List<Integer> listWorkersNo = getWorkersOfManager(manager.getEmployeeNumber()); // gets list of workers
																						// who under control by the
																						// removed manager
		if (answer) {
			// if users decide to update manager number
			System.out.println("The below are manager list. Please choose one for each worker");
			System.out.println("** If any workers do not need to update. Please fill with 0");
			printEmployeeNameNumberPosition(MANAGER, this.listEmployee); // shows all the remaining managers
			for (int i = 0; i < listWorkersNo.size(); i++) {
				System.out.println("Please update manager number for the below worker: ");
				Employee wor = findEmployeeById(listWorkersNo.get(i)); // gets the worker who relate to the removed
																		// manager
				wor.printNameAndNumber();
				System.out.print("\nNew manager number: ");
				newNo = Integer.parseInt(scan.nextLine());
				((Worker) wor).setManagerNumber(newNo); // sets new manager number to the worker
				increaseNumberWorkersOfManager((Worker) wor); // updates number of workers for that manager
				System.out.println("Update!");
			}
		} else {
			// if users decide to not update manager number
			for (int i = 0; i < listWorkersNo.size(); i++) {
				Employee wor = findEmployeeById(listWorkersNo.get(i));
				((Worker) wor).setManagerNumber(newNo);
			}
		}
	}

	public Employee findEmployeeById(int id) {
		// finds and returns an employee base on the given employee number
		// this method support for other methods

		for (Employee emp_i : this.listEmployee) {
			if (id == emp_i.getEmployeeNumber()) {
				return emp_i;
			}
		}
		return null;
	}

	public void increaseNumberWorkersOfManager(Worker worker) {
		// increases number of workers of manager
		// when a worker has been added

		Manager _manager = null;
		_manager = (Manager) findEmployeeById((worker).getManagerNumber()); // gets the related manager
																			// base on manager number
																			// of worker
		_manager.setNumberWorkers(_manager.getNumberWorkers() + 1); // increases workers and update
	}

	public void decreaseNumberWorkersOfManager(Worker worker) {
		// decreases number of workers of manager
		// when a worker has been removed

		Manager _manager = null;
		_manager = (Manager) findEmployeeById((worker).getManagerNumber()); // gets the related manager
		// base on manager number
		// of worker
		_manager.setNumberWorkers(_manager.getNumberWorkers() - 1); // decreases workers and update
	}

	public void updateEmployeeInfo(Scanner scan, Employee emp) {
		// updates information of employee
		// this method support for the "updateEmployee" method

		boolean check = false;
		do {
			System.out.println("Which of the following will be updated?");
			System.out.println("0. Exit");
			System.out.println("1. Full name");
			System.out.println("2. Number phone");
			System.out.println("3. Address");
			System.out.println("4. Number of working days: ");
			if (emp instanceof Director) {
				// In case the employee is Director, 5th option will require to update share
				System.out.println("5. Share");
			} else if (emp instanceof Manager) {
				// In case the employee is Manager, 5th and 6th option will require to
				// update number of dependent workers and allowance
				System.out.println("5. Allowance");
			} else {
				// In case the employee is Worker, 5th option will require to
				// update manager number
				System.out.println("5. Manager number");
			}
			System.out.print(">>> Choose: ");
			int select = Integer.parseInt(scan.nextLine());

			switch (select) {
			case 0:
				// If user choose 0, there is no update
				return;
			case 1: {
				System.out.print("Update full name: ");
				emp.setFullName(scan.nextLine());
				System.out.println("Updated!");
				check = true;
				break;
			}
			case 2: {
				System.out.print("Update number phone: ");
				emp.setPhoneNumber(scan.nextLine());
				System.out.println("Updated!");
				check = true;
				break;
			}
			case 3: {
				System.out.print("Update address: ");
				emp.setAddress(scan.nextLine());
				System.out.println("Updated!");
				check = true;
				break;
			}
			case 4: {
				System.out.print("Update number of working days: ");
				emp.setWorkingDays(Integer.parseInt(scan.nextLine()));
				emp.calculatingSalary(); // Updates salary after updating number of working days
				System.out.println("Updated!");
				check = true;
				break;
			}
			case 5: {
				if (emp instanceof Director) {
					System.out.print("Update share: ");
					((Director) emp).setShare(Float.parseFloat(scan.nextLine()));
					totalSalaryOfDirector(emp); // Updates total salary of Director
												// after updating share
				} else if (emp instanceof Manager) {
					System.out.print("Update allowance: ");
					((Manager) emp).setAllowance(Float.parseFloat(scan.nextLine()));
					emp.calculatingSalary(); // Updates salary of Manager after updating allowance
				} else {
					System.out.print("Update manager number: ");
					((Worker) emp).setManagerNumber(Integer.parseInt(scan.nextLine()));
					increaseNumberWorkersOfManager((Worker) emp); // updates number of workers of the related manager
					// Updates salary of the related manager
					Employee _manager = findEmployeeById(((Worker) emp).getManagerNumber());
					_manager.calculatingSalary();
				}
				System.out.println("Updated!");
				check = true;
				break;
			}
			default:
				System.out.println("Wrong input!! Please choose again.");
				break;
			}

			if (check != false) {
				// if data successfully updated, user will decide to continue or stop updating
				// employee
				check = nextAction(scan, check);
			}

		} while (check == false);
	}

}
