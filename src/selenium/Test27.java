package selenium;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;

public class Test27 
{
	public static void main(String[] args) throws Exception
	{
		// Open browser and launch site
		System.setProperty("webdriver.chrome.driver","C:\\Users\\kamal\\Desktop\\Sugunakar\\chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		//Launch site
		driver.get("http://www.amazon.in");
		Thread.sleep(2000);
		//Apply getRect() on an element at top of the page
		File src = driver.findElement(By.xpath("//input[@value='Go']")).getScreenshotAs(OutputType.FILE);
		File dest = new File("C:\\Users\\kamal\\Desktop\\Sugunakar\\elescreenshot.png");
		FileHandler.copy(src,dest);
		//Close site
		driver.close();

	}

}


