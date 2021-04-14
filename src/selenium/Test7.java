package selenium;

import org.openqa.selenium.chrome.ChromeDriver;

public class Test7 
{

	public static void main(String[] args) throws Exception
	{
		//Open Chrome browser
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\kamal\\Desktop\\Sugunakar\\chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		//Launch Site
		driver.get("http://www.amazon.in");
		//Get title of the page
		String t = driver.getTitle();
		System.out.println(t);
		Thread.sleep(5000);
		//Close site
		driver.close();
	}

}
