/*
 * Purpose: create dummy data for testing purpose.
 * Owner: HuyenLTM
 * Created date (MM/DD/YY): 10/15/20
 * Version: 1.0
 */

package data;

import java.util.ArrayList;
import java.util.List;


import company.Company;
import employee.Director;
import employee.Employee;
import employee.Manager;
import employee.Worker;

public class DummyData {

	public DummyData() {
		
	}
	
	
	public Company dummyData() {
		
		// Initialize employee list
		List<Employee> listEmp = new ArrayList<Employee>();
		Employee dir1 = new Director("Phạm Văn Đồng", 1, "0545451545", "Q7", 22, 11);
		Employee dir2 = new Director("Nguyễn Gia Thiều", 2, "0545488955", "Q8", 22, 10);
		Employee dir3 = new Director("Trương Định", 3, "0545495525", "Q10", 20, 9);
		Employee man1 = new Manager("Nguyễn Văn Bắc", 4, "0566596955", "Q8", 21, 100000);
		Employee man2 = new Manager("Nguyễn Thị Minh Khai", 5, "05661115955", "PN", 20, 100000);
		Employee man3 = new Manager("Huỳnh Tấn Phát", 6, "05661115005", "TB", 21, 100000);
		Employee man4 = new Manager("Nguyễn Đình Chiểu", 7, "05851115005", "TB", 21, 100000);
		Employee wor1 = new Worker("Hoàng Văn Quang", 8, "05454886991", "Q2", 20, 7);
		Employee wor2 = new Worker("Đỗ Nguyễn Nguyên Giáp", 9, "05451006991", "Q1", 20, 5);
		Employee wor3 = new Worker("Phan Đình Phùng", 10, "05451106991", "Q11", 21, 4);
		Employee wor4 = new Worker("Phan Thu Chiêu", 11, "05451106841", "Q10", 22, 6);
		Employee wor5 = new Worker("Nguyễn Thị Chiêu", 12, "05451206841", "Q10", 20, 5);
		Employee wor6 = new Worker("Phạm Hoàng Văn", 13, "05551206841", "Q8", 20, 7);
		Employee wor7 = new Worker("Phạm Thị Vân", 14, "05881206841", "Q8", 20, 7);
		Employee wor8 = new Worker("Tô Thị Hà", 15, "05881206841", "Q2", 20, 7);
		Employee wor9 = new Worker("Trương Thanh Long", 16, "05883106841", "Q2", 22, 4);
		Employee wor10 = new Worker("Hoàng Văn Giang", 17, "05898206841", "Q4", 21, 7);
		Employee wor11 = new Worker("Tạ Thị Văn", 18, "05881204541", "Q8", 19, 7);
		Employee wor12 = new Worker("Phan Văn Trị", 19, "0564876841", "Q7", 23, 5);
		Employee wor13 = new Worker("Nguyễn Hữu Thọ", 20, "05875306841", "PN", 22, 6);
		Employee wor14 = new Worker("Trương Đình", 21, "05692006841", "TP", 20, 4);
		Employee wor15 = new Worker("Nguyễn Đình Dũng", 22, "05881156941", "Q2", 20, 5);
		Employee wor16 = new Worker("Nguyễn Đình Dung", 23, "05881156941", "Q2", 20, 4);
		Employee wor17 = new Worker("Nguyễn Thiện Thuật", 24, "05881156941", "Q2", 20, 6);
		Employee wor18 = new Worker("Trương Hoàng Giang", 25, "05881156941", "Q2", 20, 5);
		Employee wor19 = new Worker("Đinh Văn Giang", 26, "05881156941", "Q2", 20, 7);
		Employee wor20 = new Worker("Nguyễn Văn Thọ", 27, "05881156941", "Q2", 20, 7);
		Employee wor21 = new Worker("Phan Đình Giáp", 28, "05881156941", "Q2", 20, 6);
		Employee wor22 = new Worker("Nguyễn Văn Trị", 29, "05881156941", "Q2", 20, 4);
		Employee wor23 = new Worker("Nguyễn Văn Minh", 30, "05881156941", "Q2", 20, 5);
		Employee wor24 = new Worker("Phạm Văn Đồng", 31, "05881156941", "Q2", 20, 4);
		Employee wor25 = new Worker("Nguyễn Thị Thập", 32, "05881156941", "Q2", 20, 4);
		Employee man5 = new Manager("Trương Văn Hà", 33, "05851115005", "TB", 21, 100000);
		Employee wor26 = new Worker("Trương Văn Định", 32, "05881156941", "Q2", 20, 33);
		Employee wor27 = new Worker("Nguyễn Thanh Long", 35, "05881156941", "Q2", 20, 33);
		Employee wor28 = new Worker("Võ Văn Kiệt", 36, "05881156941", "Q2", 20, 48);
		Employee wor29 = new Worker("Nguyễn Hữu Trí", 37, "05881156941", "Q2", 20, 33);
		Employee wor30 = new Worker("Ngô Hữu Thanh Thọ", 38, "05881156941", "Q2", 20, 5);
		Employee wor31 = new Worker("Nguyễn Văn Hà", 39, "05881156941", "Q2", 20, 7);
		Employee wor32 = new Worker("Nguyễn Ngọc Thanh Hà", 40, "05881156941", "Q2", 20, 7);
		Employee wor33 = new Worker("Phan Thành Dung", 41, "05881156941", "Q2", 20, 33);
		Employee wor34 = new Worker("Nguyễn Hoàng Văn Minh", 42, "05881156941", "Q2", 20, 6);
		Employee wor35 = new Worker("Nguyễn Ngọc Bắc", 43, "05881156941", "Q2", 20, 6);
		Employee wor36 = new Worker("Phạm Thị Ngọc Hà", 44, "05881156941", "Q2", 20, 6);
		Employee wor37 = new Worker("Nguyễn Ngọc Thanh", 45, "05881156941", "Q2", 20, 33);
		Employee wor38 = new Worker("Nguyễn Dũng", 46, "05881156941", "Q2", 20, 33);
		Employee wor39 = new Worker("Nguyễn Văn Thanh Long", 47, "05881156941", "Q2", 20, 48);
		Employee man6 = new Manager("Trương Thành Kiệt", 48, "05851115005", "TB", 21, 100000);
		Employee wor40 = new Worker("Nguyễn Ngọc Hiếu", 49, "05881156941", "Q2", 20, 48);
		Employee wor41 = new Worker("Nguyễn Văn Hoàng Lộc", 50, "05881156941", "Q2", 20, 48);
		
		// Add employees
		listEmp.add(dir1);
		listEmp.add(dir2);
		listEmp.add(dir3);
		listEmp.add(man1);
		listEmp.add(man2);
		listEmp.add(man3);
		listEmp.add(man4);
		listEmp.add(man5);
		listEmp.add(man6);
		listEmp.add(wor1);
		listEmp.add(wor2);
		listEmp.add(wor3);
		listEmp.add(wor4);
		listEmp.add(wor5);
		listEmp.add(wor6);
		listEmp.add(wor7);
		listEmp.add(wor8);
		listEmp.add(wor9);
		listEmp.add(wor10);
		listEmp.add(wor11);
		listEmp.add(wor12);
		listEmp.add(wor13);
		listEmp.add(wor14);
		listEmp.add(wor15);
		listEmp.add(wor16);
		listEmp.add(wor17);
		listEmp.add(wor18);
		listEmp.add(wor19);
		listEmp.add(wor20);
		listEmp.add(wor21);
		listEmp.add(wor22);
		listEmp.add(wor23);
		listEmp.add(wor24);
		listEmp.add(wor25);
		listEmp.add(wor26);
		listEmp.add(wor27);
		listEmp.add(wor28);
		listEmp.add(wor29);
		listEmp.add(wor30);
		listEmp.add(wor31);
		listEmp.add(wor32);
		listEmp.add(wor33);
		listEmp.add(wor34);
		listEmp.add(wor35);
		listEmp.add(wor36);
		listEmp.add(wor37);
		listEmp.add(wor38);
		listEmp.add(wor39);
		listEmp.add(wor40);
		listEmp.add(wor41);
		
		// Initialize company information and add employee list
		Company comp = new Company("Tobiji", 1576, 1000000000);
		comp.setListEmployee(listEmp);
		
		// Update number of workers of each manager
		comp.updateNumberWorkersOfManager();
		
		// Update payment and profit of this company
		comp.calculatingPayment();
		comp.calculatingProfit();
		
		
		System.out.println("Done!!");
		return comp;
	}
}
