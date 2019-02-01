package FetchExcelData;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class DatadrivenFetching {

	public static void main(String[] args) throws IOException {
		
		File src = new File("D:\\Selenium_Projects\\Excel Data\\Testcases.xlsx");
		InputStream fis = new FileInputStream(src);
		//		XSSFWorkbook -: it willload the complete workbook(excel sheet)
		
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sheet = wb.getSheetAt(0);
		for(int i=0;i<sheet.getLastRowNum();i++)
		{
			for(int j=0;j<2;j++)
			{
				String s = sheet.getRow(i).getCell(j).getStringCellValue();
				System.out.println("Data from excel is "+s);
			}
		}
		
		wb.close();// if object is not close so we will get memory leak
	}
}
