package selenium;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test61 
{
	public static void main(String[] args) throws Exception
	{
		// Open browser and launch site
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\kamal\\Desktop\\Sugunakar\\chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();//Browser opens without history and cookies
		driver.get("https://www.way2sms.com");
		driver.manage().window().maximize();
		Thread.sleep(5000);
		//Collect all loaded cookies
		Set<Cookie> s = driver.manage().getCookies();
		List<Cookie> l = new ArrayList<Cookie> (s);
		System.out.println("Count of Cookies is " +l.size());
		for(Cookie c:l)
		{
			System.out.println(c.getName());
		}
		//Delete all Cookies
		driver.manage().deleteAllCookies();
		//Collect all loaded cookies
		s = driver.manage().getCookies();
		l = new ArrayList<Cookie> (s);
		if(l.size()==0)
		{
			System.out.println("Cookies were deleted successfully");
		}
		else
		{
			System.out.println("Cookies were not deleted successfully");
		}
		//Close site
		driver.close();
				
	}

}
