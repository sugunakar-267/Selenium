package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test10 
{

	public static void main(String[] args) throws Exception
	{
		//Open browser
		System.setProperty("webdriver.chrome.driver","C:\\Users\\kamal\\Desktop\\Sugunakar\\chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		//Launch site
		driver.get("http://www.gmail.com");
		Thread.sleep(2000);
		//Do Registration
		driver.findElement(By.xpath("//span[text()='Create account']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[text()='For myself']")).click();
		Thread.sleep(3000);
		driver.findElement(By.name("firstName")).sendKeys("Sugun");
		driver.findElement(By.name("lastName")).sendKeys("kar");
		driver.findElement(By.name("Username")).sendKeys("sugun.automation251");
		driver.findElement(By.name("Passwd")).sendKeys("Ramya*124#");
		driver.findElement(By.name("ConfirmPasswd")).sendKeys("Ramya*124#");
		driver.findElement(By.xpath("//*[text()='Next']")).click();
		Thread.sleep(3000);
		driver.findElement(By.id("countryList")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("(//span[contains(text(),'India')])[last()]")).click();
		driver.findElement(By.id("phoneNumberId")).sendKeys("9381410339");
		driver.findElement(By.xpath("//*[text()='Next']/parent::*")).click();
		//driver.findElement(By.xpath("//*[text()='Enter verification code']")).sendKeys("991981");
		//Close Site
		driver.close();

	}

}
