package selenium;

import java.util.List;
import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test47 
{
	public static void main(String[] args) throws Exception
	{	
		//Open browser and launch site
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\kamal\\Desktop\\Sugunakar\\chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://www.semantic-ui.com/modules/dropdown.html");
		Thread.sleep(5000);
		//Locate <div> tag drop down and get it into visible area of desktop via a neighbor element
		WebElement neighbor = driver.findElement(By.xpath("//h4[text()='Search Selection']"));
		driver.executeScript("arguments[0].scrollIntoView();", neighbor);
		WebElement dd = neighbor.findElement(By.xpath("following-sibling::div"));
		//Test Case - 1: Check for single select or not
		if(dd.getAttribute("class").contains("multiple"))
		{
			System.out.println("Multi - Select dropdown");
			//Stop testing			
		}
		else
		{
			System.out.println("Single - Select dropdown");
			//Start testing	
			//Test Case - 2: Collect all items in that single select drop down and display
			List<WebElement> items = dd.findElements(By.xpath("//child::div[2]/div"));
			System.out.println(" Count of items in drop down is "+items.size());
			System.out.println(" items are : ");
			for(WebElement item:items)
			{
				//Get hidden items text using JavaScript
				String x = (String) driver.executeScript("return(arguments[0].textContent);", item);
				System.out.println(x);
			}
			//Test Case-3: Select each item and test that selection
			for(WebElement item:items)
			{
				try
				{
					//Open drop down to get visibility of items
					dd.click();
					Thread.sleep(3000);
					//Check item for visibility
					if(item.isDisplayed())
					{
						//Remember text of that item to be selected
						String expected = item.getText();
						//Select that item
						item.click();
						Thread.sleep(3000);
						//Get selected item text
						String actual = dd.findElement(By.xpath("child::div[1]")).getText();
						//Compare both remembered text and visible text of selected item
						if(expected.equals(actual))
						{
							System.out.println(expected+ " Item selection test passed");
						}
						else
						{
							System.out.println(expected+ " Item selection test failed");
						}
					}
					else
					{
						String y = (String) driver.executeScript("return(arguments[0].textContent);", item);
						System.out.println(y+ " Item is hidden");
					}
				}
				catch(Exception ex)
				{
					System.out.println(ex.getMessage());
				}
			}//loop ending
		}//else ending
		//Close site
		driver.close();
	}

}
