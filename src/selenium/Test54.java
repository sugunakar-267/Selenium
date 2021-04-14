package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test54 
{
	public static void main(String[] args) throws Exception
	{
		//Open browser
		System.setProperty("webdriver.chrome.driver","C:\\Users\\kamal\\Desktop\\Sugunakar\\chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		//Launch site
		driver.get("http://www.w3schools.com/js/tryit.asp?filename=tryjs_confirm");
		Thread.sleep(5000);
		//Switch to frame using name of that frame
		driver.switchTo().frame("iframeResult");
		//Click on a button
		driver.findElement(By.xpath("//button[text()='Try it']")).click();
		Thread.sleep(10000);
		//Switch to alert
		String x = driver.switchTo().alert().getText();
		System.out.println(x);
		driver.switchTo().alert().dismiss();
		Thread.sleep(5000);
		//Back to page and switch to frame using name of that frame
		driver.switchTo().defaultContent();
		driver.switchTo().frame("iframeResult");
		//Test output
		try
		{		
		  if(driver.findElement(By.xpath("//*[text()='You pressed Cancel!']")).isDisplayed())
		   {
			 System.out.println("Alert is correctly working");
		   }
		   else
		   {
			 System.out.println("Alert is not correctly working");
		   }
		}
		catch(Exception ex)
		{
			System.out.println("Alert is not correctly working");
		}
		//Close site
		driver.close();

	}

}
