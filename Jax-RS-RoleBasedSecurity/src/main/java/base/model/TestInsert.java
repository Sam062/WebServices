package base.model;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import base.validator.DBValidater;
import base.validator.HibernateUtil;

public class TestInsert {
	public static void main1(String[] args) {
		Session ses=HibernateUtil.getSf().openSession();
		Transaction tx=null;
		try(ses) {
			tx=ses.beginTransaction();

			User u=new User();
			u.setUserNname("cust");
			u.setPassword("cust");
			u.setUserRole("CUSTOMER");

			ses.save(u);

			tx.commit();
		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		}

	}
	public static void main(String[] args) {
//		System.out.println(DBValidater.validateUser("sam", "sam"));
//		System.out.println(DBValidater.getUserRole("sam", "sam"));
		
		List<String> list=List.of("EMPLOYEE","ADMIN","CUSTOMER");
		System.out.println(list.contains("EMPLOYEE"));
		
		
	}
}
