package com.example.demo.fizzBuzz;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FizzBuzzController {
	private final FizzBuzzService fizzbuzzService;
	
	public FizzBuzzController(FizzBuzzService fizzbuzzService) {
		this.fizzbuzzService = fizzbuzzService;
	}

	@GetMapping("list")
	public String getFizzBuzzList(Model model) {
		
		List<Object> fizzBuzzList = fizzbuzzService.getFizzBuzzList();
		
		model.addAttribute("fizzBuzzList", fizzBuzzList);
		
		return "fizzBuzz.html";
	}

}
