package ma.ensaf.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {
	@GetMapping(value = "/hello")
	public String hello(@RequestParam(value = "name") String nom, Model model) {
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
