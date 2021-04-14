package selenium;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;

public class Test29 
{
	public static void main(String[] args) throws Exception
	{
		// Open browser and launch site
		System.setProperty("webdriver.chrome.driver","C:\\Users\\kamal\\Desktop\\Sugunakar\\chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		//Launch site
		driver.get("https://www.w3schools.com/tags/tryit.asp?filename=tryhtml5_input_type_submit");
		Thread.sleep(2000);
		driver.switchTo().frame("iframeResult");
		driver.findElement(By.name("fname")).sendKeys("suchindra.raju");
		driver.findElement(By.name("lname")).sendKeys("suchindra");
		driver.findElement(By.xpath("//*[@value='Submit']")).submit();
		//Close site
		driver.close();

	}

}