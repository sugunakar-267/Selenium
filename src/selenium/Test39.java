package selenium;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test39 
{
	public static void main(String[] args) throws Exception
	{
		//Open browser
		System.setProperty("webdriver.chrome.driver","C:\\Users\\kamal\\Desktop\\Sugunakar\\chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		//Launch site
		driver.get("http://www.gmail.com");
		Thread.sleep(5000);
		//Do login
		driver.findElement(By.name("identifier")).sendKeys("sugunakart.it@narayanagroup.com");
		driver.findElement(By.xpath("//*[text()='Next']/parent::*")).click();
		Thread.sleep(5000);
		driver.findElement(By.name("password")).sendKeys("ramya*124#");
		driver.findElement(By.xpath("//*[text()='Next']/parent::*")).click();
		Thread.sleep(10000);
		//Collect all elements in that target page
		List<WebElement> l = driver.findElements(By.xpath("(//image)|(//link)|(//area)|(//a)|(//scrpit)|(//base)|(//div)"));
		//Go to each one from 1st element (index=0) to last element (index = l.size()-1)		
		int cwl = 0;
		int bl = 0;
		for(int i = 0; i<l.size(); i++)//Loop for all collected elements			
		{
			try//To handle exception and to continue further loop
			{
				WebElement e = l.get(i);
				//Test case - 1: Whether that element has "href" attribute or not
				if(e.getAttribute("href")!=null)
				{
					String x = e.getAttribute("href");
					//Test case - 2: Whether that href attribute value is url(address) or not
					//Some elements "href" attribute value (not an url) refer local page only
					if(x.startsWith("https")||x.startsWith("http"))
					{
						//Test case - 3: Whether that url related server is responding or not
						URL u = new URL(x);
						HttpURLConnection con = (HttpURLConnection)u.openConnection();
						con.connect();
						String y = con.getResponseMessage();
						int z = con.getResponseCode();
						con.disconnect();
						if(z>=200 && z<=299)
						{
							cwl++;
						}
						else
						{
							bl++;
							System.out.println(x+" send"+y+" with"+z);
						}
					}
				}
			}
			catch(Exception ex)
			{
				System.out.println(ex.getMessage()+ " Exception raised for "+i);
				if(ex.getMessage().contains("Stale element reference"))
				{
					//re collect again to avoid stale exception
					l = driver.findElements(By.xpath("(//image)|(//link)|(//area)|(//a)|(//scrpit)|(//base)|(//div)"));
					i--;//To re test current link
				}
			}
		}//Loop completion
		System.out.println("Correctly working Links are "+cwl);
		System.out.println("Broken Links Count is "+bl);
		//Do logout
		driver.findElement(By.xpath("//*[starts-with(@aria-label, 'Google Account')]/img")).click();
		Thread.sleep(5000);
		driver.findElement(By.linkText("Sign out")).click();
		Thread.sleep(5000);
		//Close site
		driver.close();
	}
}
