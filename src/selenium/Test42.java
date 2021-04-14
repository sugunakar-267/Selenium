package selenium;

import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test42 
{
	public static void main(String[] args) throws Exception
	{
		//Get data from keyboard
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter a word to search");
		String word = sc.nextLine();
		sc.close();//optional
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
		int flag = 0;		
		while(true)
		{
			String t = driver.getTitle();
			if(!t.contains(word))
			{
				flag =1;
				break;//Terminate from infinite loop when current page title is wrong.
			}
			//Go to next page
			try
			{
				driver.findElement(By.xpath("//span[text()='Next']")).click();
				Thread.sleep(5000);
			}
			catch(Exception ex)
			{
				break;//Terminate from infinite loop when we reached last page
			}
		}
		if(flag == 0)
		{
			System.out.println("Title of all results pages is correct ");
		}
		else 
		{
			System.out.println("One of the results page title is wrong ");
		}
		//Close site
		driver.close();
	}
 }

