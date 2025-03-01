package com.example.demo.AnimalsAPI;

import java.io.IOException;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AnimalsAPIController {
	
	private final AnimalsAPIService animalsAPIService;
	
	public AnimalsAPIController(AnimalsAPIService animalsAPIService) {
		this.animalsAPIService = animalsAPIService;
	}
	
	@GetMapping("/animals")
	public String showAnimalSearch(Model model) throws IOException {
		List<AnimalsAPIData> animalsList = animalsAPIService.getAllAnimals();
		model.addAttribute("animalsList", animalsList);
		return "animalsAPIsearch.html";
	}
	
	@GetMapping("/animals/detail")
	public String showAnimalDetail(@RequestParam("id") int id, Model model) throws IOException {
		AnimalsAPIData animal = animalsAPIService.getAnimalById(id);
		model.addAttribute("animal", animal);
		return "animalsAPIdetail.html";
	}
}