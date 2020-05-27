package base.model;

import org.hibernate.Session;

import base.util.HibernateUtil;

public class TestInsert {
	public static void main(String[] args) {
		Session ses=HibernateUtil.getSf().openSession();
		org.hibernate.Transaction tx=null;
		try(ses) {
			tx=ses.beginTransaction();

			Product p=new Product();
			p.setProdName("ABC");
			p.setProdCost(123.4);
			p.setProdDiscount(50.0);
			p.setProdGst(12.5);
			p.setTotalToPay(200.50);

			ses.save(p);

			tx.commit();
		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		}
	}

}
