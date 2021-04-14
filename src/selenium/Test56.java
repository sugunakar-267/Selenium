package selenium;

import java.util.ArrayList;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test56 
{
	public static void main(String[] args) throws Exception
	{
		// Open browser and launch site
		System.setProperty("webdriver.chrome.driver","C:\\Users\\kamal\\Desktop\\Sugunakar\\chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		//Launch site
		driver.get("http://www.google.co.in");
		Thread.sleep(5000);
		driver.findElement(By.linkText("Gmail")).click();
		Thread.sleep(20000);
		driver.findElement(By.linkText("Sign in")).click();
		Thread.sleep(3000);
		Set<String> s = driver.getWindowHandles();
		ArrayList<String> a = new ArrayList<String> (s);
		driver.switchTo().window(a.get(1)); //Go to 2nd window/tab
		driver.findElement(By.name("identifier")).sendKeys("abdulkalam");
		Thread.sleep(3000);
		driver.close();// 2nd browser window/tab closing
		Thread.sleep(3000);
		driver.switchTo().window(a.get(0));//Back to first window/tab
		driver.close();// 1st browser window/tab closing
	}
}
