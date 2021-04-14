package selenium;

import org.openqa.selenium.chrome.ChromeDriver;

public class Test8 
{

	public static void main(String[] args) throws Exception
	{
		//Open Chrome browser
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\kamal\\Desktop\\Sugunakar\\chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		//Launch Site using base url given by developer
		driver.get("http://www.sentia.in");
		Thread.sleep(5000);
		//Get current url of the page
		String x = driver.getCurrentUrl();
		if(x.startsWith("https"))
		{
			System.out.println("Secured");
		}
		else
		{
			System.out.println("Not Secured");	
		}
		//Close site
		driver.close();
	}
}
