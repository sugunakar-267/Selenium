package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public class Test21 
{
	public static void main(String[] args) throws Exception
	{
		//Open browser
		System.setProperty("webdriver.chrome.driver","C:\\Users\\kamal\\Desktop\\Sugunakar\\chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		//Launch site
		driver.get("http://www.gmail.com");
		Thread.sleep(2000);
		//Locate element in page source
		WebElement e = driver.findElement(By.name("hiddenPassword"));
		// Locate element in page
		if(e.isDisplayed())
		{
			System.out.println("Visible in page");
		}
		else
		{
			System.out.println("Hidden");
		}
		//Close site
		driver.close();
	}
}
