package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public class Test20 
{
	public static void main(String[] args) throws Exception
	{
		//Open browser
		System.setProperty("webdriver.chrome.driver","C:\\Users\\kamal\\Desktop\\Sugunakar\\chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		//Launch site
		driver.get("http://www.google.co.in");
		Thread.sleep(2000);
		//Locate Gmail link element
		WebElement e = driver.findElement(By.linkText("Gmail"));
		//Before focusing on element
		String x1 = e.getCssValue("text-decoration");
		String y1 = e.getCssValue("opacity");
		System.out.println("Before focus :");
		System.out.println(x1+" "+y1);
		//Move focus to element
		Actions a = new Actions(driver);
		a.moveToElement(e).perform();
		Thread.sleep(5000);
		//After focus on element
		String x2 = e.getCssValue("text-decoration");
		String y2 = e.getCssValue("opacity");
		System.out.println("After focus :");
		System.out.println(x2+" "+y2);
		//Test cas - 1
		if(x2.contains("under line"))
		{
		  System.out.println("Element text was underlined after getting focus");
		}
		else
		{
		  System.out.println("Element text was not underlined after getting focus");	
		}
		//Test cas - 2
		float f = Float.parseFloat(y2);
		if(f<1)
		{
		  System.out.println("Element color was shaded after getting focus");
		}
		else
		{
		  System.out.println("Element color was not shaded after getting focus");
		}
		//Close site
		driver.close();

	}

}
