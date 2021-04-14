package selenium;

import java.util.List;
import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

public class Test44 
{
	public static void main(String[] args) throws Exception
	{
		// Get data from key board
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Browser Name ");
		String bn = sc.nextLine();
		System.out.println("Enter User ID ");
		String uid = sc.nextLine();
		System.out.println("Enter Password ");
		String pwd = sc.nextLine();
		sc.close();
		//Open required browser
		RemoteWebDriver driver;//Declaration of object to parent
		if(bn.equalsIgnoreCase("Chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\kamal\\Desktop\\Sugunakar\\chromedriver.exe");
			driver = new ChromeDriver();
		}
		else if(bn.equalsIgnoreCase("Fire fox"))
		{
			System.setProperty("webdriver.gecko.driver", "C:\\Users\\kamal\\Desktop\\Sugunakar\\geckodriver.exe");
			driver = new FirefoxDriver();
		}
		else if(bn.equalsIgnoreCase("edge"))
		{
			System.setProperty("webdriver.edge.driver", "C:\\Users\\kamal\\Desktop\\Sugunakar\\msedgedriver.exe");
			driver = new EdgeDriver();
		}
		else if(bn.equalsIgnoreCase("Opera"))
		{
			System.setProperty("webdriver.opera.driver", "C:\\Users\\kamal\\Desktop\\Sugunakar\\operadriver.exe");
			driver = new OperaDriver();
		}
		else//by default, when all above conditions are false
		{
			System.setProperty("webdriver.ie.driver", "C:\\Users\\kamal\\Desktop\\Sugunakar\\iedriverserver.exe");
			driver = new InternetExplorerDriver();
		}
		//Launch Site
		driver.get("http://www.gmail.com");
		Thread.sleep(5000);
		//Do login
		driver.findElement(By.name("identifier")).sendKeys(uid);
		driver.findElement(By.xpath("//*[text()='Next']/parent::*")).click();
		Thread.sleep(5000);
		driver.findElement(By.name("password")).sendKeys(pwd);
		driver.findElement(By.xpath("//*[text()='Next']/parent::*")).click();
		Thread.sleep(5000);
		//Go to each mail to check that email is read or not
		int eam = 0;
		int mwattach = 0;
		while(true)
		{
			//Locate current mailbox
			WebElement mailbox = driver.findElement(By.xpath("(//table[@role='grid'])[2]/tbody"));
			List<WebElement> mails = mailbox.findElements(By.xpath("child::tr"));
			eam = eam+mails.size();
			for(WebElement mail:mails) //For each mail in current mail box				
			{
				try
				{
					WebElement e = driver.findElement(By.xpath("child::td[7]/img"));
					mwattach++;
				}
				catch(Exception ex)
				{
					
				}
			}//For loop completion
			//Go to next page			
			WebElement older = driver.findElement(By.xpath("//div[@aria-label='Older']"));
			try
			{				
				if(older.getAttribute("aria-disabled").equals("true"))
				{
					break;//terminate from infinite loop							
				}
			}
			catch(Exception ex)
			{	
				System.out.println("Info");					
				older.click();//Bcoz we are not in last page, so go to next page
				Thread.sleep(5000);				
			}
					
		}
		System.out.println("Count mails in allmailbox pages is "+eam);
		System.out.println(" Count of mails with attachment is "+mwattach);			
		//Do logout
		driver.findElement(By.xpath("//*[starts-with(@aria-label, 'Google Account')]/img")).click();
		Thread.sleep(5000);
		driver.findElement(By.linkText("Sign out")).click();
		Thread.sleep(5000);
		//Close site
		driver.close();
	}

}