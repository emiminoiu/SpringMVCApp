package springdemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import springdemo.entity.Customer;
import springdemo.service.CustomerService;


@Controller
@RequestMapping("/login")
public class LoginController {

	// need to inject our customer service
	@Autowired
	private CustomerService customerService;
	
	@GetMapping("/loginPage")
	public String loginPage()
	{
		return "loginPage";
	}
	/*
	@GetMapping("/verifyLogin")
	@Transactional
	public String verifyLogin(@ModelAttribute("login") @RequestParam("username") String theUsername,
			 @RequestParam("password") String thePassword )
	{
		List<Login> theLogin = customerService.getLogin();
		System.out.println(theLogin);
		return null;
	}
	*/
	
}

