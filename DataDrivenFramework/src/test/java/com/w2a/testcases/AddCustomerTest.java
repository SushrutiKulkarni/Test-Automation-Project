package com.w2a.testcases;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class AddCustomerTest {

	@Test(dataProvider="getData")
	public void addCustomer(String fisrtName, String lastName, String postCode){
		
		
		
	}
	
	
	@DataProvider
	public Object[][] getData(){
		
		int rows = excel.getRowCount(sheetName);
		int cols = excel.getColCount(sheetName);
		
		Object[][] data = new Object[rows-1][cols];
		
		
		for (rowNum = 2; rowNum <= rows; rowNum++) { //2
			
			for (int colNum = 0; colNum < cols; colNum++) {
				
				data[rowNum - 2][colNum] = excel.getCellData(sheetName, colNum, rowNum);
				//-2
			}
		}
		
		return data;
		
	}
}
