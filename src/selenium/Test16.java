package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test16 
{

	public static void main(String[] args) throws Exception
	{
		//Open browser
		System.setProperty("webdriver.chrome.driver","C:\\Users\\kamal\\Desktop\\Sugunakar\\chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		//Launch site
		driver.get("http://www.way2sms.com");	
		Thread.sleep(5000);	
		driver.findElement(By.name("mobileNo")).sendKeys("abdulkalam");	
		Thread.sleep(5000);	
	}
}
