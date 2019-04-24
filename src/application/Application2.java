package application;

import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;

public class Application2 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		DepartmentDao departmentDao = DaoFactory.createDepartmentDao();
		Department dep = new Department(null, "Novo");
		
        System.out.println("===Test 1 insertDepartment===");
		departmentDao.insert(dep);
		System.out.println("New Department id = " + dep.getId());
		
		System.out.println("\n===Test 2 deleteDepartment");
		System.out.print("Insert id by department to be deleted? ");
		departmentDao.deleteById(sc.nextInt());
		System.out.println("Department deleted! ");
		
		System.out.println("\n===Test 3 updateDepartment===");
		departmentDao.update(dep);
		System.out.println("Department updated! ");
		
		System.out.println("\n===Test 4 findById===");
		System.out.print("Insert id by department ");
		dep = departmentDao.findById(sc.nextInt());
		System.out.println("Department " + dep.getName() + " id = " + dep.getId());
		
		System.out.println("\n===Test 5 findAllDepartment===");
		List<Department> depList = departmentDao.findAll();
		for(Department dp : depList) {
			System.out.println("Id " + dp.getId() + " Name " + dp.getName());
		}
		
		sc.close();
	}

}
