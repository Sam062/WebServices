package base.validator;

import org.hibernate.Session;
import org.hibernate.query.Query;

import base.model.User;

public class DBValidater {
	public static Boolean validateUser(String user,String pwd) {
		Session ses=HibernateUtil.getSf().openSession();
		boolean res=false;
		try(ses) {
			String hql="FROM "+User.class.getName()+" WHERE USERNNAME=?1 AND PASSWORD=?2";
			Query<User> q=ses.createQuery(hql);
			q.setParameter(1, user);
			q.setParameter(2, pwd);
			Object ob=q.uniqueResult();
			if(ob!=null) {
				User u=(User)ob;
				if(user.equals(u.getUserNname())&&pwd.equals(u.getPassword()))
					res=true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return res;
	}
	public static String getUserRole(String un,String pwd) {
		String role=null;
		Session ses=HibernateUtil.getSf().openSession();
		boolean res=false;
		try(ses) {
			String hql="FROM "+User.class.getName()+" WHERE USERNNAME=?1 AND PASSWORD=?2";
			Query<User> q=ses.createQuery(hql);
			q.setParameter(1, un);
			q.setParameter(2, pwd);
			Object ob=q.uniqueResult();
			if(ob!=null) {
				User u=(User)ob;
				role=u.getUserRole();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return role;
	}
}
