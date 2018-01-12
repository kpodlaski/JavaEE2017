package controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import model.User;

@Controller
public class ExampleA {

	@RequestMapping(path="/simple.html")
	public ModelAndView simplePage(){
		ModelAndView mv =  new ModelAndView("Simple");
		mv.addObject("basicText", " Witam na naszej Stronie");
		User u = new User("Adam","1234");
		mv.addObject("user",u);
		return mv;
		
	}
}
