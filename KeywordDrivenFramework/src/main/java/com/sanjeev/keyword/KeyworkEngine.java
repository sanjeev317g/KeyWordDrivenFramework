package com.sanjeev.keyword;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class KeyworkEngine {
	
	public FileInputStream in;
	
	public static Workbook book; 
	
	public static void main(String srgs[]) {
		KeyworkEngine kk = new KeyworkEngine();
		kk.startExecution("login");
	}
	
	public void startExecution(String sheetname) {
		
		
		try {
			in = new FileInputStream("/Users/sanjeevakumargeejula/Downloads/keyword.xlsx");
		} catch (FileNotFoundException e) {
		
			e.printStackTrace();
		}
		
		
			try {
				book = WorkbookFactory.create(in);
			} catch (EncryptedDocumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		 
		
	
		Sheet sheet = book.getSheet(sheetname);
		
		int k=0;
		for(int i=0; i<sheet.getLastRowNum(); i++) {
			
			String str = sheet.getRow(i+1).getCell(k+i).toString().trim();
			System.out.println(str);
		}
		
	}

}
