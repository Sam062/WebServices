package base.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.fasterxml.jackson.annotation.JsonCreator.Mode;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

import java.util.List;


import base.model.Product;
import base.service.IProductService;

@Controller
public class ProductController {

	@Autowired
	private IProductService service;

	@RequestMapping({"/","/home"})
	public String showModel() {
		return "home";
	}

	@RequestMapping(value = "/save",method = POST)
	public String saveProduct(
			@ModelAttribute Product product, //FORM DATA INPUT
			Model model //SEND DATA BACK TO UI
			) {
		String msg=service.saveProduct(product);
		model.addAttribute("msg",msg);
		return "home";
	}

	@RequestMapping("/all")
	public String getAllProduct(Model model) {
		List<Product> list=service.getAllProducts();
		model.addAttribute("list", list);
		return "data";
	}

	@RequestMapping("/editPage")
	public String showEdit(
			@RequestParam("id")Integer id,
			Model model
			) {
		Product p=service.getOneProduct(id);
		model.addAttribute("ob", p);
		return "edit";
	}
	@RequestMapping("/update")
	public String updateProduct(
			@ModelAttribute Product product,
			Model model
			) {
		service.updateProduct(product);
		model.addAttribute("msg", "Product '"+product.getProdId()+"' UPDATED!!");
		List<Product> list=service.getAllProducts();
		model.addAttribute("list", list);
		return "data";
	}

	@RequestMapping("/delete")
	public String deleteProduct(@RequestParam("id")Integer id,Model model) {
		service.deleteProduct(id);
		model.addAttribute("msg", "Product '"+id+"' Deleted !!");

		List<Product> list=service.getAllProducts();
		model.addAttribute("list", list);

		return "data";
	}
}
