package FetchExcelData;
import LibraryDDFramework.*;
public class Fetchingexceldata {

	public static void main(String[] args) {
		
		ExcelDataconfig config= new ExcelDataconfig("D:\\Selenium_Projects\\Excel Data\\Testcases.xlsx");
		System.out.println(config.getData(0, 0, 0));
		System.out.println(config.getData(1, 0, 0));
	}
}
