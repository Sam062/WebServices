package base.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import base.Model.Product;

@Controller
public class ProductContoller {
	@RequestMapping({"/","/user-reg"})
	public String homePage(@ModelAttribute("userReg")Product  product) {
		return "user-reg";
	}
	@RequestMapping("/show")
	public String showPage(@ModelAttribute()Product  product,Model model) {
		model.addAttribute("ob", product);
		return "show-data";
	}
	
}
