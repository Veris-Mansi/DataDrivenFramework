package LibraryDDFramework;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelDataconfig {
	XSSFWorkbook wb;
	XSSFSheet sheet;
	//to load the file
	public ExcelDataconfig(String excelpath)
	{
		File src = new File(excelpath);
		InputStream fis;
		try {
			fis = new FileInputStream(src);
			wb = new XSSFWorkbook(fis);
			 
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//		XSSFWorkbook -: it willload the complete workbook(excel sheet)
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public String getData(int sheetno,int row,int column)
	
	{
		sheet = wb.getSheetAt(sheetno);
		String data = sheet.getRow(row).getCell(column).getStringCellValue();
		return data;
		
	}
	public int getRowCount(int sheetno)
	{
		sheet=wb.getSheetAt(sheetno);
			int total = sheet.getLastRowNum()+1;
		return total;
		
	}
}
