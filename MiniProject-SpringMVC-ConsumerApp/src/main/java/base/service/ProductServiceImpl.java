package base.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import base.model.Product;
import base.restConsumer.ProductRestConsumer;

@Service
public class ProductServiceImpl implements IProductService {
	@Autowired
	private ProductRestConsumer consumer;

	@Override
	public String saveProduct(Product product) {
		return consumer.saveProduct(product);
	}

	@Override
	public void deleteProduct(Integer id) {
		consumer.deleteProduct(id);
	}

	@Override
	public Product getOneProduct(Integer id) {
		return consumer.getOneProduct(id);
	}

	@Override
	public List<Product> getAllProducts() {
		return consumer.getAllProducts();
	}

	@Override
	public void updateProduct(Product product) {
		consumer.updateProduct(product);
	}

}
