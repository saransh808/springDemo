package com.example.demo.utilities;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class CommonUtility {
	
	public boolean isNum(String numberString) {
		if(numberString.contains("[a-zA-Z]")) return false;
		return true;
	}
	
	public String extractPhoneNumberFromString(String numberString) {
		String number = numberString.replaceAll("[^0-9]", "");
		if(number.length()==numberString.length())
			return number;
		return null;
	}

}
