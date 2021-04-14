package selenium;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test38 
{
	public static void main(String[] args) throws Exception
	{
		//Open browser
		System.setProperty("webdriver.chrome.driver","C:\\Users\\kamal\\Desktop\\Sugunakar\\chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		//Launch site
		driver.get("http://www.google.co.in");
		Thread.sleep(5000);
		//Collect all link type elements in that home page
		List<WebElement> l = driver.findElements(By.xpath("(//image)|(//link)|(//area)|(//a)|(//scrpit)|(//base)|(//div)"));
		//Go to each one via loping
		int tl = 0;
		int cwl = 0;
		int bl = 0;
		for(WebElement e:l)
		{
			try
			{
				//Test case - 1: Whether that element has "href" attribute or not
				//If an element has "href" attribute, that element is called as hyper link
				if(e.getAttribute("href")!=null)
				{
					String x = e.getAttribute("href");
					//Test case - 2: Whether that href attribute value is url(address) or not
					//Some elements "href" attribute value (not an url) refer local page only
					if(x.startsWith("https")||x.startsWith("http"))
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
			}
		}
		System.out.println("Total Links Count is "+tl);
		System.out.println("Correctly working Links are "+cwl);
		System.out.println("Broken Links Count is "+bl);
		//Close site
		driver.close();
	}

}