package com.example.demo.calculator;

import org.springframework.stereotype.Service;

@Service
public class CalculatorService {
	
	public String calculator(int num1, int num2, String operator) {
		
		String result;
		
		switch (operator) {
		case "+":
			result = String.valueOf(num1 + num2);
			break;
			
		case "-":
			result = String.valueOf(num1 - num2);
			break;
			
		case "*":
			result = String.valueOf(num1 * num2);
			break;
			
		case "/":
			if (num2 != 0) {
				result = String.valueOf(num1 / num2);
			} else {
				result = "未定義";
			}
			break;
			
		default:
			result = "無効な演算子";
			break;
		}
		
		return result;
	}
}