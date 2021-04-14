package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test22 
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
		//driver.findElement(By.name("identifier")).sendKeys("xxxxxxxx");
		WebElement e = driver.findElement(By.name("hiddenPassword"));
		//Locate element in page
		if(e.isDisplayed())
		{
			if(e.isEnabled())
			{
				System.out.println("Enabled");
			}
			else
			{
				System.out.println("Disabled");
			}
		}
		else
		{
			System.out.println("Hidden element");
		}
		//Close site
		driver.close();

	}

}
