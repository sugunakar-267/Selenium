package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test15 
{

	public static void main(String[] args) throws Exception
	{
		//Open browser
		System.setProperty("webdriver.chrome.driver","C:\\Users\\kamal\\Desktop\\Sugunakar\\chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		//Launch site
		driver.get("http://www.w3schools.com/tags/tryit.asp?filename=tryhtml_button_disabled");	
		Thread.sleep(5000);	
		//Click on an element
		driver.switchTo().frame("iframeResult");
		driver.findElement(By.xpath("//button[text()='Click Me!']")).click();		
		Thread.sleep(5000);	
	}
}
