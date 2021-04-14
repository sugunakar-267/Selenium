package selenium;

import java.util.Scanner;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

public class Test6 
{

	public static void main(String[] args) throws Exception
	{
		//Take browser name from keyboard
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Browser Name");
		String bn = sc.nextLine();
		sc.close();
		//Declare driver object to parent class
		RemoteWebDriver driver = null;
		if(bn.equalsIgnoreCase("Chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\kamal\\Desktop\\Sugunakar\\chromedriver.exe");
			driver = new ChromeDriver();
		}
		else if(bn.equals("Firefox"))
		{
			System.setProperty("webdriver.gecko.driver", "C:\\Users\\kamal\\Desktop\\Sugunakar\\geckodriver.exe");
			driver = new FirefoxDriver();
		}
		else if(bn.equals("Opera"))
		{
			System.setProperty("webdriver.opera.driver", "C:\\Users\\kamal\\Desktop\\Sugunakar\\operadriver.exe");
			driver = new OperaDriver();
		}
		else if(bn.equals("Edge"))
		{
			System.setProperty("webdriver.edge.driver", "C:\\Users\\kamal\\Desktop\\Sugunakar\\msedgedriver.exe");
			driver = new EdgeDriver();
		}
		else if(bn.equals("ie"))
		{
			System.setProperty("webdriver.ie.driver", "C:\\Users\\kamal\\Desktop\\Sugunakar\\iedriverserver.exe");
			driver = new InternetExplorerDriver();
		}
		else
		{
			System.out.println("Please check given browser name");
			System.exit(0);
		}
		//Common code
		driver.get("http://www.amazon.in");
		Thread.sleep(5000);
		driver.close();
	}

}
