package selenium;

import org.openqa.selenium.chrome.ChromeDriver;

public class Test9 
{

	public static void main(String[] args) throws Exception
	{
		//Open Chrome browser
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\kamal\\Desktop\\Sugunakar\\chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		//Launch Site using base url given by developer
		driver.get("http://www.gmail.com");
		Thread.sleep(5000);
		//Get page source & window handle of the page
		//String x = driver.getPageSource();
		String y = driver.getWindowHandle();
		System.out.println(y);
		//System.out.println(x);
		//Close site
		driver.close();
	}

}
