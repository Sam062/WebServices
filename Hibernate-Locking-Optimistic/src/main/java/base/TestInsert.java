package base;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class TestInsert {
	public static void main(String[] args) {
		Session ses=HibernateUtil.getSf().openSession();
		Transaction tx=null;
		try(ses) {
			tx=ses.beginTransaction();

			Student s=new Student();
			s.setSname("SAM");
			s.setSfee(123.4);

			ses.save(s);

			tx.commit();
		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		}
	}
}
