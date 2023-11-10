package com.smart.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.smart.dao.UserRepository;
import com.smart.entities.User;
import com.smart.helper.Message;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
public class HomeController {
	
	
	@Autowired
	private UserRepository userRepository;

	@GetMapping("/")
	public String name(Model model) {

		model.addAttribute("title", "Home-Contact Page");
		return "home";
	}

	@GetMapping("/about")
	public String about(Model model) {

		model.addAttribute("title", "About");
		return "about";
	}

	@GetMapping("/signup")
	public String signup(Model model) {
		model.addAttribute("user",new User());
		return "signup";
	}

	
	@PostMapping("/do_register")
	public String registerUser( @Valid  @ModelAttribute("user") User user, BindingResult result,
			@RequestParam(value = "agreement", defaultValue = "false") boolean agreement, Model model,HttpSession session) {
		
		System.out.println(user);
		
		
		try {
			
			if (!agreement) {
				
				
				
				throw new Exception("Please check terms & conditions box");
				
			}
			if(result.hasErrors()) {
				model.addAttribute("user",user);
				System.out.println(result.toString());
				return "signup";
			}
			
			user.setRole("ROLE_USER");
			user.setEnabled(true);
			user.setImageUrl("default.png");
			model.addAttribute("user",new User());
			session.setAttribute("message", new Message("Successfully Registered","alert-success"));
			return "signup";
			
			
		} catch (Exception e) {
			// TODO: handle exception
			//e.printStackTrace();
			model.addAttribute("user",user);
			session.setAttribute("message", new Message(""+e.getMessage(),"alert-danger"));
			return "signup";
		}
		
		
					
	}

}
