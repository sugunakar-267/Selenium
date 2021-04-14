package selenium;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Test35 
{
	public static void main(String[] args) throws Exception
	{
		//Open browser and Launch Site
		System.setProperty("webdriver.chrome.driver","C:\\Users\\kamal\\Desktop\\Sugunakar\\chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		//Launch site
		driver.get("http://www.mercurytravels.co.in");
		Thread.sleep(5000);
		//Collect all drop downs
		List<WebElement> l = driver.findElements(By.xpath("//select"));		
		System.out.println("Count of dropdowns is" +l.size());
		//Filter Visible and hidden drop downs
		int nvdd = 0;
		int nhdd = 0;
		for(WebElement e:l)
		{
			if(e.isDisplayed())
			{
				nvdd++;
				if(nvdd==3)
				{
					Select s = new Select(e);
					s.selectByVisibleText("Bangalore");
				}
			}
			else
			{
				nhdd++;
			}
		}
		System.out.println("Visible dropdowns count is" +nvdd);
		System.out.println("Hidden dropdowns count is" +nhdd);
		//Close site
		//driver.close();
	}

}