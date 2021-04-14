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

public class Test45 
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
		System.out.println("Enter from address to delete emails ");
		String efrom = sc.nextLine();
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
		int eamc = 0;
		int dmc = 0;
		while(true)
		{
			//Locate current mailbox
			WebElement mailbox = driver.findElement(By.xpath("(//table[@role='grid'])[2]/tbody"));
			List<WebElement> mails = mailbox.findElements(By.xpath("child::tr"));			
			for(int i=0; i<mails.size(); i++)			
			{
				try
				{
					//Mail deletion
					String afrom = mails.get(i).findElement(By.xpath("child::td[4]/div[2]/span/span")).getAttribute("email");
					if(afrom.equalsIgnoreCase(efrom))
					{
						mails.get(i).findElement(By.xpath("child::td[2]/div[@role='checkbox']")).click();
						Thread.sleep(5000);
						driver.findElement(By.xpath("")).click();
						Thread.sleep(5000);
						i--;//due to cover next mail, which will come to deleted mail place
						dmc++;
					}
				}				
				catch(Exception ex)
				{
					System.out.println(ex.getMessage());
				}
			}//For loop completion
			//Recollect after deletion
			mails = mailbox.findElements(By.xpath("child::tr"));	
			eamc = eamc+mails.size();
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
		System.out.println("Count mails in allmailbox pages is "+eamc);
		System.out.println(" Count of deleted mails is "+dmc);			
		//Do logout
		driver.findElement(By.xpath("//*[starts-with(@aria-label, 'Google Account')]/img")).click();
		Thread.sleep(5000);
		driver.findElement(By.linkText("Sign out")).click();
		Thread.sleep(5000);
		//Close site
		driver.close();
	}

}