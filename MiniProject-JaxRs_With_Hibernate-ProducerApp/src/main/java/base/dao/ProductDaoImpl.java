package base.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import base.model.Product;
import base.util.HibernateUtil;

public class ProductDaoImpl implements IProductDao {
	@Override
	public Integer saveProduct(Product p) {
		Session ses=HibernateUtil.getSf().openSession();
		Transaction tx=null;
		Integer id=null;
		try(ses) {
			tx=ses.beginTransaction();

			id=(Integer)ses.save(p);

			tx.commit();
		} catch (Exception e) {
			if(tx!=null && tx.getStatus().canRollback())
				tx.rollback();
			e.printStackTrace();
		}
		return id;
	}

	@Override
	public void updateProduct(Product p) {
		Session ses=HibernateUtil.getSf().openSession();
		Transaction tx=null;
		try(ses) {
			tx=ses.beginTransaction();

			ses.update(p);

			tx.commit();
		} catch (Exception e) {
			if(tx!=null && tx.getStatus().canRollback())
				tx.rollback();
			e.printStackTrace();
		}
	}

	@Override
	public void deleteProduct(Integer id) {
		Session ses=HibernateUtil.getSf().openSession();
		Transaction tx=null;
		try(ses) {
			tx=ses.beginTransaction();

			Product p=new Product();
			p.setProdId(id);
			ses.delete(p);
			tx.commit();
		} catch (Exception e) {
			if(tx!=null && tx.getStatus().canRollback())
				tx.rollback();
			e.printStackTrace();
		}
	}

	@Override
	public Product getOneProduct(Integer id) {
		Session ses=HibernateUtil.getSf().openSession();
		Product p=null;
		try(ses) {
			p=ses.get(Product.class, id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return p;
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Product> getAllProducts() {
		Session ses=HibernateUtil.getSf().openSession();
		List<Product> list=null;
		try(ses) {
			String hql="FROM "+Product.class.getName();
			Query<Product> q=ses.createQuery(hql);
			list=q.list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
}
