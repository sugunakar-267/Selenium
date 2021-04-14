package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test13 
{

	public static void main(String[] args) throws Exception
	{
		//Open browser
		System.setProperty("webdriver.chrome.driver","C:\\Users\\kamal\\Desktop\\Sugunakar\\chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		//Launch site
		driver.get("http://www.gmail.com");
		Thread.sleep(5000);
		//driver.findElement(By.name("identifier")).sendKeys("sugunakart.it@narayanagroup.com");
		driver.findElement(By.xpath("//*[text()='Next']")).click();
		//Thread.sleep(5000);
		//driver.findElement(By.name("password")).sendKeys("ramya*124#");
		//driver.findElement(By.xpath("//*[text()='Next']/parent::*")).click();
		//Thread.sleep(5000);
		//Click compose
		//driver.findElement(By.xpath("//*[text()='Compose']")).click();
		//Thread.sleep(5000);	

	}

}
