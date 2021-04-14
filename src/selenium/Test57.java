package selenium;

import java.util.ArrayList;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test57 
{
	public static void main(String[] args) throws Exception
	{
		// Open browser and launch site
		System.setProperty("webdriver.chrome.driver","C:\\Users\\kamal\\Desktop\\Sugunakar\\chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		//Launch site
		driver.get("http://www.gmail.com");
		Thread.sleep(5000);
		//Do login gmail site
		driver.findElement(By.name("identifier")).sendKeys("sugunakart.it@narayanagroup.com");
		driver.findElement(By.xpath("//*[text()='Next']/parent::*")).click();
		Thread.sleep(5000);
		driver.findElement(By.name("password")).sendKeys("ramya*124#");
		driver.findElement(By.xpath("//*[text()='Next']/parent::*")).click();
		Thread.sleep(10000);
		//Click compose and fill fields in gmail site
		driver.findElement(By.xpath("//*[text()='Compose']")).click();
		Thread.sleep(5000);
		driver.findElement(By.name("to")).sendKeys("sugun.at250@yahoo.com");
		driver.findElement(By.name("subjectbox")).sendKeys("Hello world");
		driver.findElement(By.xpath("//div[@aria-label='Message Body']")).sendKeys("Hi \n How are you? \n Thanks, \n Sugunakar");
		//Send mail from gmail site and display output message
		driver.findElement(By.xpath("//div[text()='Send']")).click();
		Thread.sleep(5000);
		String o = driver.findElement(By.className("bAq")).getText();
		System.out.println(o);
		//Take new window or tab and switch to it
		driver.switchTo().newWindow(WindowType.WINDOW);
		Thread.sleep(5000);
		Set<String> s = driver.getWindowHandles();
		ArrayList<String> l = new ArrayList<String> (s);
		//switch to newly created window or tab
		driver.switchTo().window(l.get(1));
		//Launch Yahoo site
		driver.get("http://www.yahoomail.com");
		Thread.sleep(15000);
		//Click on signin in yahoo
		driver.findElement(By.xpath("//span[text()='Sign in']")).click();
		Thread.sleep(5000);
		//Do login in yahoo
		driver.findElement(By.name("username")).sendKeys("sugun.at250");
		driver.findElement(By.name("signin")).click();
		Thread.sleep(5000);
		driver.findElement(By.name("password")).sendKeys("Ramya*124#");
		driver.findElement(By.name("verifyPassword")).click();
		Thread.sleep(5000);
		try
		{
			driver.findElement(By.xpath("//a[@title='Mail']")).click();
			Thread.sleep(5000);
		}
		catch(Exception ex)
		{
			
		}
		//Get from address of latest mail in mailbox
		String x = driver.findElement(By.xpath("//*[@data-test-id='virtual-list']/ul/li[2]/descendant::span[4]")).getAttribute("title");
		System.out.println(x);
		if(x.contains("sugunakart.it@narayanagroup.com"))
		{
			System.out.println("Gmail mail sent completely working");
		}
		else
		{
			System.out.println("Gmail mail sent completely not working");
		}
		//Do log out in yahoo
		driver.findElement(By.xpath("(//img[@alt='Profile image'])[1]")).click();
		Thread.sleep(10000);
		driver.findElement(By.xpath("//span[text()='Sign out']")).click();
		Thread.sleep(5000);
		//Close yahoo site
		driver.close();
		//Switch back to gmail
		driver.switchTo().window(l.get(0));
		//do log out		
		driver.findElement(By.xpath("//a[contains(@aria-label, 'Google Account')]/child::img")).click();
		Thread.sleep(5000);
		driver.findElement(By.linkText("Sign out")).click();
		Thread.sleep(5000);
		//Close gmail site
		driver.close();
	}
}
