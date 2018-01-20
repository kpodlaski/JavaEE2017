package controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import model.Contact;
import model.ContactBook;

@Controller
public class MainController {
	
	@Autowired
	ContactBook book;
	
	@RequestMapping("test.html")
	public ModelAndView test(){
		ModelAndView mv = new ModelAndView("contact");
		mv.addObject("title","Kontakt Telefoniczny");
		Contact c = new Contact("Ala","12121234");
		mv.addObject("contact",c);
		return mv;
	}
	
	@RequestMapping("show.php")
	public ModelAndView showContact(String name, 
			String tel){
		ModelAndView mv = new ModelAndView("contact");
		Contact c = new Contact(name,tel);
		mv.addObject("title","Tel "+c.getName());
		mv.addObject("contact",c);
		return mv;
	}
	
	@RequestMapping("show,{name},{tel}")
	public ModelAndView showContact2(@PathVariable String name, 
			@PathVariable String tel){
		ModelAndView mv = new ModelAndView("contact");
		Contact c = new Contact(name,tel);
		mv.addObject("title","Tel "+c.getName());
		mv.addObject("contact",c);
		return mv;
	}
	
	
	@RequestMapping(value="contact/new",method=RequestMethod.GET)
	public ModelAndView newContact(){
		ModelAndView mv = new ModelAndView("contact2");
		mv.addObject("title","Nowy kontakt");
		Contact c = new Contact("","");
		mv.addObject("contact",c);
		return mv;
	}
	
	
	@RequestMapping(value="contact/new",method=RequestMethod.POST)
	public ModelAndView newContactPost(String name, String tel){
		ModelAndView mv = new ModelAndView("contact2");
		
		Contact c = new Contact(name,tel);
		book.add(c);
		mv.addObject("title","Stworzono nowy kontakt "+book.getContacts().size());
		mv.addObject("contact",c);
		return mv;
	}
	
	
	@RequestMapping(value="contact,{id}",method=RequestMethod.GET)
	public ModelAndView newContact(@PathVariable int id){
		ModelAndView mv = new ModelAndView("contact");
		Contact c = book.getContacts().get(id);
		mv.addObject("title","Kontakt "+id);
		mv.addObject("contact",c);
		return mv;
	}
	
	@RequestMapping(value="contact,{id}",method=RequestMethod.DELETE)
	public ModelAndView deleteContact(@PathVariable int id){
		ModelAndView mv = new ModelAndView("contact");
		Contact c = book.getContacts().get(id);
		mv.addObject("title","Skasowano Kontakt ");
		mv.addObject("contact",c);
		book.remove(c);
		return mv;
	}
	
	@RequestMapping(value="contact,{id}",method=RequestMethod.PUT)
	public ModelAndView putContact(@PathVariable int id, @RequestBody Contact newData){
		ModelAndView mv = new ModelAndView("contact");
		Contact c = book.getContacts().get(id);
		c.setName(newData.getName());
		c.setTel(newData.getTel());
		mv.addObject("title","Zmodyfikowano Kontakt ");
		mv.addObject("contact",c);
		return mv;
	}
	
	@RequestMapping(value="contact",method=RequestMethod.GET)
	public ModelAndView contactList(){
		ModelAndView mv = new ModelAndView("contact_list");
		mv.addObject("title","Lista Kontaktów");
		mv.addObject("contacts",book.getContacts());
		return mv;
	}
	
	@RequestMapping(value="contact",method=RequestMethod.POST)
	public ModelAndView newContactPost(@RequestBody Contact c){
		ModelAndView mv = new ModelAndView("contact2");
		book.add(c);
		mv.addObject("title","Stworzono nowy kontakt "+book.getContacts().size());
		mv.addObject("contact",c);
		return mv;
	}
}
