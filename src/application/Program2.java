package application;

import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;
public class Program2 {

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);

        DepartmentDao departmentDao = DaoFactory.createDepartmentDao();

        System.out.println("=== TEST 1: DELETE");
        System.out.println("Enter id for delete test: ");
        int id = sc.nextInt();
        departmentDao.deleteById(id);
        System.out.println("Delete completed!");


        System.out.println("=== TEST 2: DEPARTMENT FIND BY ID ===");
        Department department = departmentDao.findById(3);
        System.out.println(department);

        System.out.println("\n=== TEST 3: DEPARTMENT FIND ALL ===");
        List<Department> list = departmentDao.findAll();
        for(Department obj : list){
            System.out.println(obj);
        }

        System.out.println("\n=== TEST 4: DEPARTMENT INSERT ===");
        Department newDepartment = new Department(null, "Comida");
        departmentDao.insert(newDepartment);
        System.out.println("Inserted! New Id = " + newDepartment.getId());

        System.out.println("\n=== TEST 5: DEPARTMENT UPDATE ===");
        department = departmentDao.findById(1);
        department.setName("Cellphone");
        departmentDao.update(department);
        System.out.println("Update completed");

        sc.close();


    }

}
