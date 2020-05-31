package application;

import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;

public class Program2 {
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        DepartmentDao departmentDao = DaoFactory.createDepartmentDao();

        // TEST 1
        System.out.println("=== TEST 1: department findById ===");
        Department department = departmentDao.findById(2);
        System.out.println(department);
        
        // TEST 2
        System.out.println("\n=== TEST 2: department findAll ===");
        List<Department> list = departmentDao.findAll();
        for (Department dep : list) {
            System.out.println(dep);
        }
        
        // TEST 3
        System.out.println("\n=== TEST 3: department insert ===");
        Department newDepartment = new Department(null, "Personal");
        departmentDao.insert(newDepartment);
        System.out.println("Inserted! New Id: " + newDepartment.getId());
        
        // TEST 4
        System.out.println("\n=== TEST 4: department update ===");
        Department updatedDepartment = departmentDao.findById(6);
        updatedDepartment.setName("Business");
        departmentDao.update(updatedDepartment);
        System.out.println("Update Completed!");

        // TEST 5
        System.out.println("\n=== TEST 5: department delete ===");
        System.out.print("Enter id for delete test: ");
        int id = sc.nextInt();
        departmentDao.deleteById(id);
        System.out.println("Delete Completed!");

        sc.close();
    }
}