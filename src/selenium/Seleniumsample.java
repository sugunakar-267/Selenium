package selenium;

import org.openqa.selenium.chrome.ChromeDriver;

public class Seleniumsample {

	public static void main(String[] args) 
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\kamal\\Desktop\\Sugunakar\\chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://www.gmail.com");

	}

}
