package com.sanjeev.keyword;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.sanjeev.Framework.Base;

public class KeywordDriven {
	
	public static FileInputStream in;
	public static XSSFWorkbook book;
	
	public static Base base;
	
	public static WebDriver driver;
	public static void main(String args[]) throws IOException {
		startExecution();
	}
	
	public static void startExecution() throws IOException {
		
		
		try {
			in = new FileInputStream("/Users/sanjeevakumargeejula/Downloads/keyword.xlsx");
		} catch (FileNotFoundException e) {
		
			e.printStackTrace();
		}
		
		
			try {
				book = new XSSFWorkbook(in);
			} catch (EncryptedDocumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		 
		XSSFSheet sheet = book.getSheet("login");
		
		int k =0;
		String locatorName = null;
		String locatorValue = null;
		
		for(int i=0; i<sheet.getLastRowNum(); i++) {
			try {
				
			
			String locatorcolValue = sheet.getRow(i+1).getCell(k+1).toString().trim();
			
			if(!locatorcolValue.equalsIgnoreCase("NA")) {
				
				System.out.println( locatorcolValue );
				
				locatorName = locatorcolValue.split("=")[0].trim();
				
				locatorValue = locatorcolValue.split("=")[1].trim();
			}
			
			String action = sheet.getRow(i+1).getCell(k+2).toString().trim();
			
			String value = sheet.getRow(i+1).getCell(k+3).toString().trim();
			
			switch (action) {
			case "open browser":
				base = new Base();
				driver = Base.init_Driver("Web");
				break;
				
			case "enter url":
				driver.get(value);
				break;
			case "quit":
				driver.quit();
				locatorName=null;
				break;
				
			default:
				break;
			}
			
			switch (locatorName) {
			
			case "id":
				WebElement element = driver.findElement(By.id(locatorValue));
				if(action.equalsIgnoreCase("sendkeys")) {
				element.sendKeys(value);
				
				}
				else if (action.equalsIgnoreCase("click")) {
					element.click();
				}
				locatorName = null;
				break;
				
			case "linkText":
				WebElement element1 = driver.findElement(By.linkText(locatorValue));
				element1.click();
				locatorName = null;
				break;
			
			default:
				break;
			}
			//k = k+1;
		}
		
		catch(Exception e) {
		
		
	}

}
	}
}
