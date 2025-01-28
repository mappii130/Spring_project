package com.example.demo.calculator;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CalculatorController {
	private final CalculatorService calculatorService;
	
	public CalculatorController(CalculatorService calculatorService) {
		this.calculatorService = calculatorService;
	}
	
	@GetMapping("calculator")
	public String showCalculatorFrom() {
		return "calculator.html";
	}
	
	@PostMapping("calculatet")
	public String calculatet(@RequestParam("num1") int num1, @RequestParam("num2") int num2, @RequestParam("operator") String operator, Model model) {
		
		String result = calculatorService.calculator(num1, num2, operator);
		
		model.addAttribute("result", result);
        model.addAttribute("num1", num1);
        model.addAttribute("num2", num2);
        model.addAttribute("operator", operator);
		
		return "calculator.html";
	}
}