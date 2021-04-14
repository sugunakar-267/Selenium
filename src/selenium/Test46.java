package selenium;

import java.util.List;
import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test46 
{
	public static void main(String[] args) throws Exception
	{
		// Get a word from key board
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter a word ");
		String word = sc.nextLine();
		sc.close();
		//Open browser and launch site
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\kamal\\Desktop\\Sugunakar\\chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://www.google.co.in");
		Thread.sleep(5000);
		//Enter given word
		driver.findElement(By.name("q")).sendKeys(word);//parameterization
		//It can raise a cache element with auto suggestions as per given word
		Thread.sleep(5000);
		//Locate cache/Auto-complete element
		WebElement ce = driver.findElement(By.xpath("//ul[@role='listbox']"));
		//Test Case - 1: Get count of suggestions in that cache element
		List<WebElement> items = ce.findElements(By.xpath("child::li"));
		System.out.println("No of suggestions in cache is "+items.size());
		//Test Case - 2: Get all suggestions text and display
		for(WebElement item:items)//For each item
		{
			System.out.println(item.getText());
		}
		//Test Case - 3: Check each item text, which consists of given word or not
		int flag = 0;
		for(WebElement item:items)//For each item
		{
			String y = item.getText();
			if(!y.contains(word))//
			{
				flag=1;
				break;//terminate loop
			}
		}
		if(flag==0)
		{
			System.out.println("Cache suggestions test passed for  "+word);
		}
		else
		{
			System.out.println("Cache suggestions test failed for  "+word);
		}
		//Close site
		driver.close();
	}

}
