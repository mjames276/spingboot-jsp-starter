package uk.co.digitalpenguin.xrp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class HomeController
{
	@RequestMapping("/")
	public String home(HttpServletRequest request, Model model)
	{		
		return "home";
	}
}
