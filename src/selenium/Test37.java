package selenium;

import java.net.HttpURLConnection;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test37 
{
	public static void main(String[] args) throws Exception
	{
		//Open browser and Launch site
		System.setProperty("webdriver.chrome.driver","C:\\Users\\kamal\\Desktop\\Sugunakar\\chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://www.google.co.in");
		Thread.sleep(5000);
		//Locate one link and take href attribute value (GUI test using SWD)
		String x = driver.findElement(By.linkText("Gmail")).getAttribute("href");
		//href address value testing|Broken link testing (API test using JDK classes)
		try
		{
		  URL u = new URL(x);
		  HttpURLConnection con = (HttpURLConnection) u.openConnection();
		  con.connect();
		  String y = con.getResponseMessage();
		  int z = con.getResponseCode();
		  System.out.println(y+" "+z);
		  if(z>=200 && z<=299)
		  {
			  System.out.println(x+ " is working correctly");
		  }
		  else
		  {
			  System.out.println(x+ " is not working correctly due to" +y);
		  }
		}
		catch(Exception ex)
		{
			System.out.println(ex.getMessage());
		}
		//Close site
		driver.close();
	}

}
