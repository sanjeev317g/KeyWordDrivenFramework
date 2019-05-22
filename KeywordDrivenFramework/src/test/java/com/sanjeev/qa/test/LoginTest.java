package com.sanjeev.qa.test;

import java.io.IOException;

import org.testng.annotations.Test;

import com.sanjeev.keyword.KeywordDriven;

public class LoginTest {
	
	@Test
	public void testLogin() {
		
		try {
			KeywordDriven.startExecution();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
