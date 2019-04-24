package application;


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
		
		System.out.println("===Teste 1 findById===");
		Seller seller = sellerDao.findById(4);
		System.out.println(seller);
		

		System.out.println("\n===Teste 2 findByDepartment===");
		Department department = new Department(2, null);
		List<Seller> list = sellerDao.findByDepartment(department);
		for(Seller obj : list ) {
			System.out.println(obj);
		}
		
		System.out.println("\n===Teste 3 findByAll===");
		list = sellerDao.findAll();
		for(Seller obj : list ) {
			System.out.println(obj);
		}
		
		System.out.println("\n===Teste 4 insert===");
		Seller newSeller = new Seller( null, "Greg Black", "greg@gmail.com", new Date(), 4000.0, department);
		sellerDao.insert(newSeller);
		System.out.println("Inserted! New id " + newSeller.getId() );
		
		System.out.println("\n===Teste 5 SellerUpdate===");
		seller = sellerDao.findById(1);
		seller.setName("Martha Stwart");
		sellerDao.update(seller);
		System.out.println("Update completed! ");
		
	
		System.out.println("===\nTeste 6 deleteById===");
		System.out.println("Insira um id para teste de dele��o: ");
		int id = sc.nextInt();
		sellerDao.deleteById(id);
		System.out.println("Delete completed! ");
		sc.close();
		
	}

}
