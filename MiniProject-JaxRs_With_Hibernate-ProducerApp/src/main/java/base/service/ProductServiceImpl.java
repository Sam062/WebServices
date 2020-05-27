package base.service;

import java.util.Collections;
import java.util.List;

import javax.inject.Inject;
import base.dao.IProductDao;
import base.model.Product;

public class ProductServiceImpl implements IProductService {
	@Inject
	private IProductDao dao;

	@Override
	public Integer saveProduct(Product p) {
		var pcost=p.getProdCost();
		var gst=pcost*12/100.0;
		var discount=pcost*10/100.0;
		var totalToPay=pcost+gst-discount;

		p.setProdGst(gst);
		p.setProdDiscount(discount);
		p.setTotalToPay(totalToPay);

		return dao.saveProduct(p);
	}

	@Override
	public void updateProduct(Product p) {
		var pcost=p.getProdCost();
		var gst=pcost*12/100.0;
		var discount=pcost*10/100.0;
		
		var total=pcost+gst-discount;

		p.setProdGst(gst);
		p.setProdDiscount(discount);
		p.setTotalToPay(total);

		dao.updateProduct(p);
	}

	@Override
	public void deleteProduct(Integer id) {
		dao.deleteProduct(id);

	}

	@Override
	public Product getOneProduct(Integer id) {
		return dao.getOneProduct(id);
	}

	@Override
	public List<Product> getAllProducts() {
		List<Product> list=dao.getAllProducts();
		// SORT IN ASC ORDER 
		Collections.sort(list, (o1,o2)->o1.getProdId()-o2.getProdId());
		return list;
	}
}
