package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test30 
{
	public static void main(String[] args) throws Exception
	{
		// Open browser and launch site
		System.setProperty("webdriver.chrome.driver","C:\\Users\\kamal\\Desktop\\Sugunakar\\chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		//Launch site
		driver.get("https://www.google.co.in");
		Thread.sleep(2000);
		String tn = driver.findElement(By.name("q")).getTagName();
		System.out.println(tn);
		//Close site
		driver.close();
	}
}
