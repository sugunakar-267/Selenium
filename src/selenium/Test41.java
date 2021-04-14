package selenium;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test41 
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
		int trc = 0;
		while(true)
		{
			pc++;
			System.out.println("Page-" +pc);
			System.out.println("----------");
			//Collect all results elements in current page
			List<WebElement> rl = driver.findElements(By.xpath("//div[@class='g']"));
			//Go to each one via looping
			int prc = 0;
			for(int i = 0; i<rl.size(); i++)
			{
				WebElement e = rl.get(i);
				if(e.isDisplayed())
				{
					prc++;
				}
			}
			System.out.println("Count of results in this page is "+prc);
			trc=trc+prc;
			//Go to next page
			try
			{
				driver.findElement(By.xpath("//span[text()='Next']")).click();
				Thread.sleep(5000);
			}
			catch(Exception ex)
			{
				break;//Terminate from infinite loop
			}
		}
		System.out.println("Total results count is " +trc);
		//Close site
		driver.close();
	}
 }

