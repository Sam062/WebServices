package base.restConsumer;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import base.model.Product;

@Component
public class ProductRestConsumer {
	@Autowired
	private RestTemplate template;

	public String saveProduct(Product product) {
		String url="http://localhost:2019/MiniProject-JaxRs_With_Hibernate-ProducerApp/rest/product/save";
		//Constructing Header param
		HttpHeaders headers=new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);

		//constructing head + body
		HttpEntity<Product> request=new HttpEntity<Product>(product, headers);

		//Make HTTP call, that gives Response
		ResponseEntity<String> resp=template.postForEntity(url, request, String.class);

		//return msg to UI
		return resp.getBody();
	}

	public List<Product> getAllProducts(){
		String url="http://localhost:2019/MiniProject-JaxRs_With_Hibernate-ProducerApp/rest/product/all";
		ResponseEntity<Product[]> resp=template.getForEntity(url, Product[].class);
		return Arrays.asList(resp.getBody());
	}

	public void deleteProduct(Integer id) {
		String url="http://localhost:2019/MiniProject-JaxRs_With_Hibernate-ProducerApp/rest/product/"+id;
		template.delete(url);;
	}
	public Product getOneProduct(Integer id) {
		String url="http://localhost:2019/MiniProject-JaxRs_With_Hibernate-ProducerApp/rest/product/"+id;
		return template.getForObject(url, Product.class);
	}
	
	public void updateProduct(Product product) {
		String url="http://localhost:2019/MiniProject-JaxRs_With_Hibernate-ProducerApp/rest/product/update";
		//Constructing Header param
		HttpHeaders headers=new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);

		//constructing head + body
		HttpEntity<Product> request=new HttpEntity<Product>(product, headers);

		template.put(url, request);
	}
	
}
