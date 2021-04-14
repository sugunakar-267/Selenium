package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test31 
{
	public static void main(String[] args) throws Exception
	{
		// Open browser and launch site
		System.setProperty("webdriver.chrome.driver","C:\\Users\\kamal\\Desktop\\Sugunakar\\chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		//Launch site
		driver.get("https://www.gmail.com");
		Thread.sleep(2000);
		//Do login		
		driver.findElement(By.name("identifier")).sendKeys("sugunakart.it@narayanagroup.com");
		driver.findElement(By.xpath("//*[text()='Next']/parent::*")).click();
		Thread.sleep(5000);
		driver.findElement(By.name("password")).sendKeys("ramya*124#");
		driver.findElement(By.xpath("//*[text()='Next']")).findElement(By.xpath("parent::*")).click();
		Thread.sleep(5000);
		//Close site
		driver.close();
	}
}
