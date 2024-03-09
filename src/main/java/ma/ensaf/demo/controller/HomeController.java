package ma.ensaf.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import ma.ensaf.demo.model.Client;

@Controller
public class HomeController {
	
	//Ajouter Model Client
	@GetMapping("/")
	public String home(){
		return "index";
	}
	
	@GetMapping("addClient/{id}/{name}")
	public String addClient(@PathVariable("id") int id, @PathVariable("name") String name, Model model) {
		
		Client client = new Client();
		client.setId(id);
		client.setName(name);
		
		model.addAttribute("client", client);
		return "resultat";
	}
	
	/*
	@GetMapping("addClient")
	public String addClient(@RequestParam("id") int id, @RequestParam("name") String name, Model model) {
		
		Client client = new Client();
		client.setId(id);
		client.setName(name);
		
		model.addAttribute("client", client);
		return "resultat";
	}
	*/
	
	//Exercice 1
	@GetMapping("/add")
	public String add(@RequestParam(value = "number1") int x, @RequestParam(value = "number2") int y, Model model) {
		int somme = x + y;
		model.addAttribute("number1", x);
		model.addAttribute("number2", y);
		model.addAttribute("somme", somme);
		return "resultat";
	}
	
	
	// Les variables de chemin (PathVariable)
	@GetMapping(value = "/hello/{name}/{prenom}/{email}")
	public String hello1(@PathVariable String name,@PathVariable String prenom,@PathVariable String email, Model model) {
		
		model.addAttribute("name", name);
		model.addAttribute("prenom", prenom);
		model.addAttribute("email", email);
		
		return "hello";
	}
	
	
	
	// RequestParam (Les paramètres de requête)
	@GetMapping(value = "/hello")
	public String hello(@RequestParam(value = "name", required = false, defaultValue = "Tom") String nom, Model model) {
		System.out.println("J'utilise Model !!");
		
		model.addAttribute("name", nom);
		model.addAttribute("email", "ykhamlichi@gmail.com");
		
		return "hello";
	}
	
	@GetMapping(value = "/bonjour")
	public String hello(ModelMap model) {
		System.out.println("J'utilise ModelMap !!");
		
		model.addAttribute("name", "Youness khamlichi");
		model.addAttribute("email", "ykhamlichi@gmail.com");
		
		return "hello";
	}
	
	@GetMapping(value = "/coucou")
	public ModelAndView hello(ModelAndView mv) {
		System.out.println("J'utilise ModelAndView !!");
		
		mv.addObject("name", "Youness khamlichi");
		mv.addObject("email", "ykhamlichi@gmail.com");
		
		mv.setViewName("hello");
		
		return mv;
	}

}
