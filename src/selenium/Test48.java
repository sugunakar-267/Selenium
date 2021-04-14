package selenium;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test48 
{
	public static void main(String[] args) throws Exception
	{	
		//Open browser and launch site
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\kamal\\Desktop\\Sugunakar\\chromedriver.exe");		
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://www.semantic-ui.com/modules/dropdown.html");
		Thread.sleep(5000);
		//Locate <div> tag drop down and get it into visible area of desktop via a neighbor element
		WebElement neighbor = driver.findElement(By.xpath("//h4[text()='Multiple Selection']"));
		driver.executeScript("arguments[0].scrollIntoView();", neighbor);
		WebElement dd = neighbor.findElement(By.xpath("following-sibling::div"));
		Thread.sleep(5000);
		//Test Case - 1: Check for multiple select or not
		if(dd.getAttribute("class").contains("multiple"))
		{
			System.out.println("Multi - Select dropdown");
			//Start testing	
			//Test Case - 2: Collect all items of it and display those items text
			List<WebElement> items = dd.findElements(By.xpath("//child::div[2]/div"));
			System.out.println(" Count of items in drop down is "+items.size());
			System.out.println(" items are : ");
			for(WebElement item:items)
			{
				//Get hidden items text using JavaScript
				String x = (String) driver.executeScript("return(arguments[0].textContent);", item);
				System.out.println(x);
			}
			//Test Case-3: Select each item, test that selection and deselect that item
			for(WebElement item:items)
			{
				try
				{
					//Open drop down
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
						String actual = dd.findElement(By.xpath("child::a")).getText();
						//Compare both remembered text and visible text of selected item
						if(expected.equals(actual))
						{
							System.out.println(expected+ " Item selection test passed");
						}
						else
						{
							System.out.println(expected+ " Item selection test failed");
						}
						//de select that item
						dd.findElement(By.xpath("child::a/i")).click();
						Thread.sleep(3000);
					}
					else
					{
						String y = (String) driver.executeScript("return arguments[0].textContent;", item);
						System.out.println(y+ " Item is hidden");
					}
					dd.sendKeys(Keys.ESCAPE);
					Thread.sleep(3000);
		        }		
				catch(Exception ex)
				{
					System.out.println(ex.getMessage());
				}
			}//loop ending
			//Test Case 4: Select multiple items and test them
			//Open drop down
			dd.click();
			Thread.sleep(3000);
			//Looping on items
			int flag = 0;
			for(int i = 0; i<items.size(); i++)
			{
				try
				{
					//Remember text of item to be selected
					String expected = items.get(i).getText();
					//Select item
					items.get(i).click();
					Thread.sleep(3000);
					//Get selected item text
					String actual = dd.findElement(By.xpath("child::a["+(i+1)+"]")).getText();
					//Compare remembered text and visible text of selected item
					if(!expected.equals(actual))
					{
						flag = 1;
					}
				}
				catch(Exception ex1)
				{
					System.out.println(ex1.getMessage());
				}
			}//Loop ending
			//Check flag after selecting all items
			if(flag == 0)
			{
				System.out.println("Multiple items selection is correct");
			}
			else
			{
				System.out.println("Multiple items selection is incorrect");
			}
		}
		else
		{
			System.out.println("Single select drop down");
		}
		//Close site
		driver.close();
	}

}
