package base.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class EmpController {
	
	@RequestMapping("/")
	public String showReg() {
		return "index";
	}

	@RequestMapping("/add")
	public ModelAndView showString(
			@RequestParam("val1")int v1,
			@RequestParam("val2")int v2
			) {
		int addition=v1+v2;
		ModelAndView mv=new ModelAndView();
		mv.addObject("result", addition);
		mv.setViewName("index");
		return mv;
	}

}
