package selenium;

import java.time.Duration;
import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Test11 
{

	public static void main(String[] args)throws Exception
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Login ID");
		String lid = sc.nextLine();
		System.out.println("Enter Password");
		String pwd = sc.nextLine();
		System.out.println("Enter To Email ID");
		String toid = sc.nextLine();
		System.out.println("Enter Subject");
		String sub = sc.nextLine();
		System.out.println("Enter Message");
		String msg = sc.nextLine();
		sc.close();
		//Open browser
		System.setProperty("webdriver.chrome.driver","C:\\Users\\kamal\\Desktop\\Sugunakar\\chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		//Launch site
		driver.get("http://www.gmail.com");
		WebDriverWait w = new WebDriverWait(driver,20);
		w.until(ExpectedConditions.visibilityOfElementLocated(By.name("identifier"))).sendKeys(lid);
		w.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[text()='Next']/parent::*"))).click();
		w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@name='password']"))).sendKeys(pwd);
		w.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[text()='Next']/parent::*"))).click();	
		//Click compose
		w.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[text()='Compose']"))).click();
		w.until(ExpectedConditions.visibilityOfElementLocated(By.name("to"))).sendKeys(toid);
		w.until(ExpectedConditions.visibilityOfElementLocated(By.name("subjectbox"))).sendKeys(sub);
		w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[@aria-label='Message Body'])[2]"))).sendKeys(msg);
		w.until(ExpectedConditions.elementToBeClickable(By.xpath("(//*[starts-with(@aria-label,'Send')])[2]"))).click();
		Thread.sleep(5000);
		String op = w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='vh']/span"))).getText();
		System.out.println(op);
		

	}
	
	}

