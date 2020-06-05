package base.validater;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import base.model.User;
import base.util.HibernateUtil;

public class DBValidater {
	public static Boolean isUserExist(String un,String pwd) {
		boolean res=false;
		Session ses=HibernateUtil.getSf().openSession();
		try(ses) {
			String hql="FROM "+User.class.getName()+" WHERE USERNAME=?1 AND PASSWORD=?2";
			Query<User> q=ses.createQuery(hql);
			q.setParameter(1, un);
			q.setParameter(2, pwd);

			Object ob=q.uniqueResult();
			if(ob!=null) {
				User u=(User)ob;
				if(u.getUserName().equals(un) && u.getPassword().equals(pwd))
					res=true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return res;
	}
	public static String getUserRole(String un) {
		String userRole=null;
		Session ses=HibernateUtil.getSf().openSession();
		try(ses) {
			String hql="SELECT userRole FROM "+User.class.getName()+" WHERE userName=?1";
			Query q=ses.createQuery(hql);
			q.setParameter(1, un);
			List<String> list=q.list();
			if(!(list==null || list.isEmpty()))
					userRole=list.get(0);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return userRole;
	}

}
