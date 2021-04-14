package selenium;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test60 
{
	public static void main(String[] args) throws Exception
	{
		// Open browser and launch site
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\kamal\\Desktop\\Sugunakar\\chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.way2sms.com");
		Thread.sleep(5000);
		//minimize browser
		driver.manage().window().minimize();
		Thread.sleep(5000);
		//Maximize browser
		driver.manage().window().maximize();
		Thread.sleep(5000);
		//Get size of browser window
		int w = driver.manage().window().getSize().getWidth();
		int h = driver.manage().window().getSize().getHeight();
		System.out.println(w+" "+h);
		//Set size for browser window
		Dimension d = new Dimension(300,200);
		driver.manage().window().setSize(d);
		Thread.sleep(5000);
		//Get position of browser window on desktop
		int x = driver.manage().window().getPosition().getX();
		int y = driver.manage().window().getPosition().getY();
		System.out.println(x+" "+y);
		//Set position for browser window on desktop
		Point p = new Point(400,300);
		driver.manage().window().setPosition(p);
		Thread.sleep(5000);
		//full screen
		driver.manage().window().fullscreen();
		Thread.sleep(5000);
		driver.close();
	}

}
