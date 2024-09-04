package utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataProviders {
	
	// DataProvider 1
	
	
	@DataProvider(name = "LoginData")
	public String [][] getData() throws IOException{
		
		String path = ".\\testData\\OpenCartLoginData.xlsx"; //
		
		ExcelUtilityFile xutil = new ExcelUtilityFile(path);
		
		int totalRows = xutil.getRowCount("Sheet1");
		int totalCols = xutil.getCellCount("Sheet1", 1);
		
		String loginData [][] = new String[totalRows][totalCols];
		
		for(int i =1 ; i<=totalRows ;i++) {
			
			for(int j =0 ; j<totalCols ; j++) {
				
				loginData [i-1][j] = xutil.getCellData("Sheet1", i, j) ;
				
			}		}
		return loginData;
	}
	
	// DataProvider 2
	
	
	// DataProvider 3

	
	// DataProvider 4

}