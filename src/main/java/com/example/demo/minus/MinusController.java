package com.example.demo.minus;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MinusController {
	private final MinusService minusService;
	
	public MinusController(MinusService minuseService) {
		this.minusService = minuseService;
	}
	
	@GetMapping("minus")
	public String showMinusForm() {
		return "minus.html";
	}
	
	@GetMapping("subtraction")
	public String minus(@RequestParam("num1") int num1, @RequestParam("num2") int num2, Model model) {
		
		String result = "";
		
		result = String.valueOf(minusService.minus(num1, num2));
		
		model.addAttribute("result", result);
		
		return "minus.html";
	}
}
