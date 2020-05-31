package base.service;

import java.util.List;

import base.model.Product;

public interface IProductService {
	String saveProduct(Product product);
	void deleteProduct(Integer id);
	Product getOneProduct(Integer id);
	List<Product> getAllProducts();
	void updateProduct(Product product);
}
