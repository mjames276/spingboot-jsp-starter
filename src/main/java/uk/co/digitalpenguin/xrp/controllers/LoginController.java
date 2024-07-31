package uk.co.digitalpenguin.xrp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import jakarta.servlet.http.HttpServletRequest;

@Controller
public class LoginController 
{
	@GetMapping("/login")
	public String login(HttpServletRequest request, Model model)
	{		
		return "login";
	}
}
