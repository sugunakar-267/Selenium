package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test25 
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
		//Get size of visible element in page
		Dimension d1 = e1.getSize();
		int w1 = d1.getWidth();
		int h1 = d1.getHeight();
		System.out.println("Size of visible element is"+w1+" "+h1);
		//Get size of hidden element in page				
		Dimension d2 = e2.getSize();
		int w2 = d2.getWidth();
		int h2 = d2.getHeight();
		System.out.println("Size of hidden element is"+w2+" "+h2);
		//Close site
		driver.close();

	}

}
