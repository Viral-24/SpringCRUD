package com.learning.mvc.ForntController;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.bind.annotation.RequestMethod;
import com.learning.mvc.service.IDAO;


@Controller
public class UserController {

	@Autowired
	UserModels model;

	@Autowired
	IDAO  ido;

	@RequestMapping("/")
	public String index(ModelMap map) {

		List<UserModels> recevied = ido.getRecords();
		map.addAttribute("List", recevied);

		return "index";
	}

	@RequestMapping("/register")
	public String register() {
		return "register";
	}
	
	@RequestMapping(value="/save",method =RequestMethod.POST)
	public ModelAndView savedetail(ModelMap map,HttpServletRequest request) {
		
		int Uid=Integer.parseInt(request.getParameter("uid"));
		String Uname=request.getParameter("uname");
		String Uemail=request.getParameter("uemail");
		String Uaddr=request.getParameter("uaddr");
		String Uphone=request.getParameter("uphone");
		
		model.setId(Uid);
		model.setName(Uname);
		model.setEmail(Uemail);
		model.setAddr(Uaddr);
		model.setPhone(Uphone);
		
	
		ido.insertingRecords(model);
		return new ModelAndView("redirect:/");
	}
	
	@RequestMapping(value="/delete{id}",method =RequestMethod.GET)
	public ModelAndView deletedetail(@PathVariable("id") int Uid) {
		ido.deleteRecords(Uid);
		return new ModelAndView("redirect:/");
	}	
	
	/*
	 * @RequestMapping("/editbyid") public String edit() {
	 * 
	 * return"editbyid"; }
	 * 
	 * @RequestMapping(value="/edit/{id}",method =RequestMethod.GET) public
	 * ModelAndView editdetail(@PathVariable("id") int Uid,ModelMap map) {
	 * 
	 * new ModelAndView("redirect:/editbyid");
	 * //System.out.println("User id is "+Uid); UserModels model=
	 * ido.getRecordsById(Uid); map.addAttribute("List", model);
	 * 
	 * //return "List";
	 * 
	 * return new ModelAndView("redirect:/editbyid"); }
	 */
	
	
	@RequestMapping(value="/editbyid{id}",method =RequestMethod.GET)
	public String editbyid(@PathVariable("id") int Uid,ModelMap map)
	{
		UserModels model2=ido.getRecordsById(Uid);
		map.addAttribute("List", model2);
		//System.out.println("value"+model2);
		return "editbyid";
	}
	
	@RequestMapping(value="/editbyid{id}",method =RequestMethod.POST)
	public String editbyid(HttpServletRequest request,ModelMap map)
	{
		
		 int Uid=Integer.parseInt(request.getParameter("uid")); 
		 String Uname=request.getParameter("uname"); 
		 String Uemail=request.getParameter("uemail"); 
		 String Uaddr=request.getParameter("uaddr"); 
		 String Uphone=request.getParameter("uphone");
		  
		  model.setId(Uid); model.setName(Uname); model.setEmail(Uemail);
		  model.setAddr(Uaddr); model.setPhone(Uphone);
		  
		 //System.out.println(model);
		  ido.editRecords(Uid, model);
		 
		return ("redirect:/");
	}
	
	 
	
}
