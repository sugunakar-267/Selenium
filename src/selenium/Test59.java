package selenium;

import org.openqa.selenium.chrome.ChromeDriver;

public class Test59 
{
	public static void main(String[] args) throws Exception
	{
		// Open browser and launch site
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\kamal\\Desktop\\Sugunakar\\chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://www.gmail.com");
		Thread.sleep(5000);
		driver.switchTo().activeElement().sendKeys("9876789977");
	}

}
