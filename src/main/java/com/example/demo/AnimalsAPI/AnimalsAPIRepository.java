package com.example.demo.AnimalsAPI;

import java.io.IOException;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;

@Repository
public class AnimalsAPIRepository {
	
	private final RestTemplate restTemplate = new RestTemplate();
	private final ObjectMapper objectMapper = new ObjectMapper();
	
    public AnimalsAPIData[] getAllAnimals() throws IOException {
    	String url = "https://wsaz0e6z45.execute-api.ap-northeast-1.amazonaws.com/prod/animalsAPI";
        ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);
        return objectMapper.readValue(response.getBody(), AnimalsAPIData[].class);
    }
    
    // id で動物を取得（配列ではなく単一のオブジェクトを返す）
    public AnimalsAPIData getAnimalById(int id) throws IOException {
        String url = "https://wsaz0e6z45.execute-api.ap-northeast-1.amazonaws.com/prod/animalsAPI?id=" + id;
        ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);
        
        // 配列の最初の要素を取得して返す
        AnimalsAPIData[] animalsArray = objectMapper.readValue(response.getBody(), AnimalsAPIData[].class);
        return animalsArray.length > 0 ? animalsArray[0] : null;
    }
}
