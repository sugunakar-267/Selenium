package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test18 
{

	public static void main(String[] args) throws Exception
	{
		//Open browser
		System.setProperty("webdriver.chrome.driver","C:\\Users\\kamal\\Desktop\\Sugunakar\\chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		//Launch site
		driver.get("http://www.google.co.in");
		Thread.sleep(2000);
		//Locate search box element
		WebElement e = driver.findElement(By.name("q"));
		//Get html attribute value of an element
		String x = e.getAttribute("maxlength");
		System.out.println("Max length value is "+x);
		//Get CSS attribute value of an element
		String y = e.getCssValue("background-color");
		System.out.println("background-color is "+y);
		//Close site
		driver.close();

	}

}
