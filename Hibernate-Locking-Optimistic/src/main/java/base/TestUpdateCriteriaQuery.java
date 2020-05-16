package base;


import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaUpdate;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

public class TestUpdateCriteriaQuery {
	public static void main(String[] args) {
		Session ses=HibernateUtil.getSf().openSession();
		Transaction tx=null;
		try (ses){
			tx=ses.beginTransaction();

			CriteriaBuilder builder=ses.getCriteriaBuilder();
			CriteriaUpdate<Student> query=builder.createCriteriaUpdate(Student.class);

			Root<Student> root=query.from(Student.class);
			query.set("sname", "HELLO");
			query.set("sfee", 111.1);
			query.set("vrsn", 1);
			query.where(builder.isNull(root.get("sname")));

			Query<Student> q=ses.createQuery(query);
			int count=q.executeUpdate();

			System.out.println("============DONE-----------"+count);


			tx.commit();
		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		}
	}

}
