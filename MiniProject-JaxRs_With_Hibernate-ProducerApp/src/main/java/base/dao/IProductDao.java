package base.dao;

import java.util.List;

import base.model.Product;

public interface IProductDao {
	Integer saveProduct(Product p);
	void updateProduct(Product p);
	void deleteProduct(Integer id);

	Product getOneProduct(Integer id);
	List<Product> getAllProducts();
}
