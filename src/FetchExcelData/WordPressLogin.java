package FetchExcelData;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import LibraryDDFramework.ExcelDataconfig;

public class WordPressLogin {

	WebDriver driver;

	
	@Test(dataProvider="Wordpressdata")
	public void loginApp(String username,String password) throws InterruptedException
	{
		System.setProperty("webdriver.chrome.driver","D:\\Selenium_Projects\\chromedriver.exe");
		driver = new ChromeDriver();

		driver.navigate().to("http://demosite.center/wordpress/wp-login.php");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.id("user_login")).sendKeys(username);
		driver.findElement(By.id("user_pass")).sendKeys(password);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"wp-submit\"]")).click();
		Thread.sleep(5000);
		System.out.println(driver.getTitle());
		//Assert.assertTrue(driver.getTitle().contains("Dashboard"));;
	}
	@AfterClass
	public void closeApp()
	{
		driver.quit();
	}
	
	@DataProvider(name ="Wordpressdata")
		public Object[][] passData()
		{
			ExcelDataconfig config = new ExcelDataconfig("D:\\Selenium_Projects\\Excel Data\\Testcases.xlsx");
			int total=config.getRowCount(0);
			System.out.println("total rows "+total);
			Object data[][]=new Object[total][2];
			
			for(int i=0;i<total;i++)
			{
				for(int j=0;j<2;j++)
				{
					data[i][j]=config.getData(0, i, j);
				}
			}
			return data;
		}
	
}
