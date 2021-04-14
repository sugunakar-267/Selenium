package selenium;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test34 
{
	public static void main(String[] args) throws Exception
	{
		//Open browser
		System.setProperty("webdriver.chrome.driver","C:\\Users\\kamal\\Desktop\\Sugunakar\\chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		//Launch site
		driver.get("http://www.google.co.in");
		Thread.sleep(5000);
		//Collect all elements
		List<WebElement> l1 = driver.findElements(By.tagName("a"));
		System.out.println("Count of <a> tag elements is" +l1.size());
		List<WebElement> l2 = driver.findElements(By.xpath("//a"));
		System.out.println("Count of <a> tag elements is" +l2.size());
		//Close site
		driver.close();
	}

}