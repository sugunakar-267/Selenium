package selenium;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;

public class Test28 
{
	public static void main(String[] args) throws Exception
	{
		// Open browser and launch site
		System.setProperty("webdriver.chrome.driver","C:\\Users\\kamal\\Desktop\\Sugunakar\\chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		//Launch site
		driver.get("http://www.gmail.com");
		Thread.sleep(2000);
		//Get hidden element screenshot as a file
		File src = driver.findElement(By.name("hiddenPassword")).getScreenshotAs(OutputType.FILE);
		File dest = new File("C:\\Users\\kamal\\Desktop\\Sugunakar\\elescreenshot1.png");
		FileHandler.copy(src,dest);
		//Close site
		driver.close();

	}

}


