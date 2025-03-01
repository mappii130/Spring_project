package com.example.demo.AnimalsAPI;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class AnimalsAPIService {
	
	private final AnimalsAPIRepository animalsAPIRepository;
	
	public AnimalsAPIService(AnimalsAPIRepository animalsAPIRepository) {
		this.animalsAPIRepository = animalsAPIRepository;
	}
	
	public List<AnimalsAPIData> getAllAnimals() throws IOException {
		return Arrays.asList(animalsAPIRepository.getAllAnimals());
	}
	
	public AnimalsAPIData getAnimalById(int id) throws IOException {
		return animalsAPIRepository.getAnimalById(id);
	}
}