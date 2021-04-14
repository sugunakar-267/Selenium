package selenium;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test40 
{
	public static void main(String[] args) throws Exception
	{
		//Get data from keyboard
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter a word to search");
		String word = sc.nextLine();
		sc.close();
		//Open browser
		System.setProperty("webdriver.chrome.driver","C:\\Users\\kamal\\Desktop\\Sugunakar\\chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		//Launch site
		driver.get("http://www.google.co.in");
		Thread.sleep(5000);
		//Search given word
		driver.findElement(By.name("q")).sendKeys(word,Keys.ENTER);
		Thread.sleep(5000);
		//Pagination on results pages
		int pc = 0;
		while(true)
		{
			pc++;
			System.out.println("Page-" +pc);
			System.out.println("----------");
			//Collect all link type elements in current page
			List<WebElement> l = driver.findElements(By.xpath("(//image)|(//link)|(//area)|(//a)|(//scrpit)|(//base)|(//div)"));
			//Go to each one via looping
			int tl = 0;
			int cwl = 0;
			int bl = 0;
			for(int i = 0; i<l.size(); i++)
			{
				try 
				{
					WebElement e = l.get(i);
					//Test case - 1: Whether that element has "href" attribute or not
					if(e.getAttribute("href")!=null)
					{
						String x = e.getAttribute("href");
						//Test case - 2: Whether that href attribute value is url(address) or not
						//Some elements "href" attribute value (not an url) refer local page only
						if(x.startsWith("https") || x.startsWith("http"))
						{
							//Test case - 3: Whether that url related server is responding or not
							tl++;
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
					System.out.println(ex.getMessage());
					if(ex.getMessage().contains("Stale element reference"))
					{
						//re collect again to avoid stale exception
						l = driver.findElements(By.xpath("(//image)|(//link)|(//area)|(//a)|(//scrpit)|(//base)|(//div)"));
						i--;//To re test current link
					}
				}
			}//Loop completion
			System.out.println("Total Links are "+tl);
			System.out.println("Correctly working Links are "+cwl);
			System.out.println("Broken Links Count is "+bl);	
			//go to next page
			try
			{
				if(driver.findElement(By.xpath("//span[text()='Next']")).isDisplayed())
				{
					driver.findElement(By.xpath("//span[text()='Next']")).click();
					Thread.sleep(5000);
				}
			}
			catch(Exception exc)
			{
				break;
			}
		}
		//Close site
		driver.close();
	}
 }


