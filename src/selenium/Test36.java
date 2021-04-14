package selenium;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test36 
{
	public static void main(String[] args) throws Exception
	{
		//Open browser and Launch site
		System.setProperty("webdriver.chrome.driver","C:\\Users\\kamal\\Desktop\\Sugunakar\\chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://www.spicejet.com");
		Thread.sleep(2000);
		//Collect all radio buttons
		List<WebElement> l = driver.findElements(By.xpath("//input[@type='radio']"));
		System.out.println("Count of radio buttons is" +l.size());
		
		//Filter Visible and hidden radio buttons
		int nvrb = 0;
		int nhrb = 0;
		for(WebElement e:l)
		{
		  if(e.isDisplayed())
		   {
			  nvrb++;
			  if(nvrb==3)
			  {
				 e.click(); 
			  }
		   }
		  else
		  {
			  nhrb++;
		  }
		}
		System.out.println("Visible radio button count is" +nvrb);
		System.out.println("Hidden radio button count is" +nhrb);	 
		//Close site
		driver.close();

	}

}

