package base;

import java.util.concurrent.TimeUnit;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class TestUpdate {
	public static void main(String[] args) {
		Session ses=HibernateUtil.getSf().openSession();
		Transaction tx=null;
		try {
			tx=ses.beginTransaction();
			
			Student s=ses.get(Student.class, 1);
			System.out.println(s);
			
			System.out.println("THREAD SLEEPING...");
			Thread.sleep(TimeUnit.SECONDS.toMillis(30));
			s.setSname("Updating parellel");
			ses.update(s);
			
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		}
	}
}
