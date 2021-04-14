package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Admissions 
{
	public static void main(String[] args) throws Exception
	{
		// Open browser and launch site
		System.setProperty("webdriver.chrome.driver","C:\\Users\\kamal\\Desktop\\Sugunakar\\chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();		
		//Launch site
		driver.get("http://uatintegratednry.pappaya.education");
		Thread.sleep(5000);
		driver.findElement(By.name("login")).sendKeys("176545");
		driver.findElement(By.name("password")).sendKeys("Pappaya@2020");
		driver.findElement(By.xpath("//*[text()='Login']")).click();
		Thread.sleep(10000);		
		driver.findElement(By.xpath("//i[@class='fa fa-menu-admission']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//li[@class='active']//a[@class='oe_menu_leaf'][contains(text(),'Admission')]")).click();

		
		
		

	}

}
