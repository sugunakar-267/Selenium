package selenium;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test32 
{
	public static void main(String[] args) throws Exception
	{
		//Open browser
		System.setProperty("webdriver.chrome.driver","C:\\Users\\kamal\\Desktop\\Sugunakar\\chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		//Launch site
		driver.get("http://www.gmail.com");
		Thread.sleep(5000);
		//Do login
		driver.findElement(By.name("identifier")).sendKeys("sugunakart@gmail.com");
		driver.findElement(By.xpath("//*[text()='Next']/parent::*")).click();
		Thread.sleep(5000);
		driver.findElement(By.name("password")).sendKeys("ramya*124#");
		driver.findElement(By.xpath("//*[text()='Next']/parent::*")).click();
		Thread.sleep(5000);
		WebElement mailbox = driver.findElement(By.xpath("(//table[@role='grid'])[2]/tbody"));
		//Collect all mails/rows
		List<WebElement> mails = mailbox.findElements(By.xpath("child::tr"));
		System.out.println("Count of visible mails is" +mails.size());
		//Do logout
		driver.findElement(By.xpath("//*[starts-with(@aria-label, 'Google Account')]/img")).click();
		Thread.sleep(5000);
		driver.findElement(By.linkText("Sign out")).click();
		Thread.sleep(5000);
		//Close site
		driver.close();
	}

}