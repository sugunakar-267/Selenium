package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test24 
{
	public static void main(String[] args) throws Exception
	{
		//Open browser and launch site
		System.setProperty("webdriver.chrome.driver","C:\\Users\\kamal\\Desktop\\Sugunakar\\chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		//Launch site
		driver.get("http://www.gmail.com");
		Thread.sleep(2000);
		//Locate elements in page source
		WebElement e1 = driver.findElement(By.name("identifier"));
		WebElement e2 = driver.findElement(By.name("hiddenPassword"));
		//Get location of visible element in page
		Point p1 = e1.getLocation();
		int x1 = p1.getX();
		int y1 = p1.getY();
		System.out.println("Location is"+x1+" "+y1);
		//Get location of hidden element in page
		Point p2 = e2.getLocation();
		int x2 = p2.getX();
		int y2 = p2.getY();
		System.out.println("Location is"+x2+" "+y2);
		//Close site
		driver.close();

	}

}
