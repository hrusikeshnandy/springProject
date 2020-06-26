package com.paychex.springmvc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.paychex.springmvc.DAO.AlienDao;
import com.paychex.springmvc.model.Alien;

@Controller
public class HomeController {
	@Autowired
	private AlienDao dao;
	@ModelAttribute
	public void addModelData(Model m) {
		m.addAttribute("name", "alien");
	}
	@RequestMapping("/")
	public String home() {
		System.out.println("calling the home controller");
		return "index";
	}
	@RequestMapping("add")
	public String add(@RequestParam("num1") int num1,@RequestParam("num2") int num2,Model m) {
		
		int sum = num1 + num2;
		
		m.addAttribute("sum", sum);
		return "result";
	}
	@RequestMapping("addAlien")
	public String addAlien(@ModelAttribute Alien a) {
		return "result";
	}
	@GetMapping("/getAlien")
	public String getAlienData(Model m) {
		System.out.println("in the list merthod");
		m.addAttribute("alien", dao.getAlien());
		return "alienList";
	}
	@RequestMapping("addAliens")
	public String addAlienDB(@ModelAttribute("result") Alien a) {
		System.out.println("Adding object to data base");
		dao.addAlien(a);
		
		return "result";
	}
	@GetMapping("/fetchAlien")
	public String getParticularRecord(@RequestParam("aid") int aid,Model m) {
		System.out.println("in sid efetch method");
		Alien a = dao.fetchAlien(aid);
		m.addAttribute("alienFilter", a);
		return "showList";
	}
}
