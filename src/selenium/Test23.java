package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test23 
{

	public static void main(String[] args) throws Exception
	{
		//Open browser
		System.setProperty("webdriver.chrome.driver","C:\\Users\\kamal\\Desktop\\Sugunakar\\chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		//Launch site
		driver.get("http://www.spicejet.com");
		Thread.sleep(2000);
		//Locate element in page source
		WebElement e = driver.findElement(By.xpath("(//input[@value='RoundTrip'])[1]"));
		//Element is visible in page or not
		if(e.isDisplayed())
		{
			System.out.println("Element visible in page");
			//Element is enabled or not
			if(e.isEnabled())
			{
				System.out.println("Element is enabled in page");
				//Element selected or not
				if(e.isSelected())
				{
					System.out.println("Element is selected");
				}
				else
				{
					System.out.println("Element is not selected");
				}
			}
			else
			{
				System.out.println("Element is disabled");
			}
		}
		else
		{
			System.out.println("Element is Hidden");
		}
		//Close site
		driver.close();

	}

}
