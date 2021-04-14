package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test26 
{
	public static void main(String[] args) throws Exception
	{
		// Open browser and launch site
		System.setProperty("webdriver.chrome.driver","C:\\Users\\kamal\\Desktop\\Sugunakar\\chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		//Launch site
		driver.get("http://www.amazon.in");
		Thread.sleep(2000);
		//Apply getRect() on an element at top of the page
		WebElement e1 = driver.findElement(By.xpath("//input[@value='Go']"));
		Rectangle r1 = e1.getRect();
		int w1 = r1.getWidth();
		int h1 = r1.getHeight();
		int x1 = r1.getX();
		int y1 = r1.getY();
		System.out.println("Size of element is"+w1+" "+h1);
		System.out.println("Location of element is"+x1+" "+y1);
		//Apply getRect() on an element at bottom of the page
		WebElement e2 = driver.findElement(By.id("icp-touch-link-language"));
		Rectangle r2 = e2.getRect();
		int w2 = r2.getWidth();
		int h2 = r2.getHeight();
		int x2 = r2.getX();
		int y2 = r2.getY();
		System.out.println("Size of element is"+w2+" "+h2);
		System.out.println("Location of element is"+x2+" "+y2);
		//Close site
		driver.close();

	}

}

