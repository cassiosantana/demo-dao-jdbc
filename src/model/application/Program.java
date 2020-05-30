package model.application;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class Program {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        SellerDao sellerDao = DaoFactory.createSellerDao();

        // TEST 1
        System.out.println("===TEST 1: seller findByid ===");
        Seller seller = sellerDao.findById(3);
        System.out.println(seller);

        // TEST 2
        System.out.println("\n===TEST 2: seller findByDepartment ===");
        Department department = new Department(2, null);
        List<Seller> list = sellerDao.findByDepartment(department);

        for (Seller obj : list) {
            System.out.println(obj);
        }

        // TEST 3
        System.out.println("\n===TEST 3: seller findAll ===");
        list = sellerDao.findAll();
        
        for (Seller obj : list) {
            System.out.println(obj);
        }

        // TEST 4
        System.out.println("\n===TEST 4: seller insert ===");
        Seller newSeller = new Seller(null, "Marco", "marco@gmail.com", new Date(), 7500.0, department);
        sellerDao.insert(newSeller);
        System.out.println("Inserted! new id: " + newSeller.getId());
        
        // TEST 5
        System.out.println("\n===TEST 5: seller update ===");
        seller = sellerDao.findById(1);
        seller.setName("Brauleo ex Bob");
        sellerDao.update(seller);
        System.out.println("Update completed!");
        
        // TEST 6
        System.out.println("\n===TEST 6: seller delete ===");
        System.out.print("Enter id for delete test: ");
        int id = sc.nextInt();
        sellerDao.deleteById(id);
        System.out.println("Delete completed");

        sc.close();
    }
}