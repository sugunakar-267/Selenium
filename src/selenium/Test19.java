package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test19 
{

	public static void main(String[] args) throws Exception
	{
		//Open browser
		System.setProperty("webdriver.chrome.driver","C:\\Users\\kamal\\Desktop\\Sugunakar\\chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		//Launch site
		driver.get("http://semantic-ui.com/modules/dropdown.html");
		Thread.sleep(2000);
		//Locate an element in page source
		WebElement e1 = driver.findElement(By.xpath("(//div[@class='text'])[1]"));
		//Get text of that element which is visible in page
		String x = e1.getText();
		System.out.println(x);
		//Locate an element in page source
		WebElement e2 = driver.findElement(By.xpath("(//div[@class='text'])/following::div[2]"));
		//Get text of that element which is hidden in page
		//String y = e2.getText();
		String y = (String) driver.executeScript("return(arguments[0].textContent);", e2);
		System.out.println(y);
		//Close site
		driver.close();

	}

}
