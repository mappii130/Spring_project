package com.example.demo.multi;

import org.springframework.stereotype.Service;

@Service
public class MultiService {
	
	public int multiply(int num1, int num2) {
		
		int result = num1 * num2;
		
		return result;
	}

}
