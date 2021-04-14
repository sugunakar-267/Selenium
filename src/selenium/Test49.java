package selenium;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test49 
{
	public static void main(String[] args) throws Exception
	{
		//Open browser
		System.setProperty("webdriver.chrome.driver","C:\\Users\\kamal\\Desktop\\Sugunakar\\chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		//Launch site
		driver.get("http://in.ebay.com");
		Thread.sleep(5000);
		//Locate carousel slider
		WebElement cslider = driver.findElement(By.className("carousel__list"));
		//Common code
		//Test Case 1: get count of visible sliders
		String tn = cslider.getTagName();
		int count = 0;
		List<WebElement> slides;
		if(tn.equals("div"))
		{
			//Every child div is a slide
			slides = cslider.findElements(By.xpath("child::div"));
			for(WebElement slide:slides)
			{
				try
				{
					if(slide.getAttribute("data-clone").equals("false"))
					{
						count = count+1;
					}
				}
				catch(Exception ex)
				{
					//Developer did not use data-clone concept
					count = count+1;
				}
			}
		}
		else  //Developed using <ul> or <ol>
		{
			//Each slide is child <li> tag
			slides = cslider.findElements(By.xpath("child::li"));
			count = slides.size(); //took all slides bcoz all slides are visible by default
		}
		System.out.println("Count of all visible slides is "+count);
		//Test Case 2: 2D or 3D slider
		String a = cslider.getCssValue("transform");
		if(a.equals("none"))
		{
			//Take transform style property value
			a = cslider.getCssValue("transform-style");
		}
		//verification
		if(a.contains("3d"))
		{
			System.out.println("3D Slider");
		}
		else
		{
			System.out.println("2D Slider");
		}
		//Test Case 3: Slides are moving automatically or not
		String b = cslider.getCssValue("transform");
		if(b.equals("none"))
		{
			System.out.println("not moving automatically");
		}
		else
		{
			System.out.println("Carousel slider slides are moving automatically");
			//Test case 4: Get direction of moving slides
			System.out.println("Transform property value is " +b);
			String c = b.substring(7,b.length()-1);
			String[] p = c.split(",");
			p[4] = p[4].trim(); //remove unwanted spaces at before and after
			p[5] = p[5].trim();
			float x = Float.parseFloat(p[4]);
			float y = Float.parseFloat(p[5]);
			if(x<0 && y==0)
			{
				System.out.println("Slides are moving from Right to Left");
			}
			else if(x>0 && y==0)
			{
				System.out.println("Slides are moving from Left to Right");
			}
			else if(x==0 && y<0)
			{
				System.out.println("Slides are moving from Bottom to Top");
			}
			else //Here y>0
			{
				System.out.println("Slides are moving from Top to Bottom");
			}
			//Test Case 5: Get ease options, duration and delay
			String d = cslider.getCssValue("transition");
			System.out.println(d);
			String[] q = d.split(" ");//Separator is blank space
			if(q[2].equals("ease-in"))
			{
				System.out.println("Slow start for each slide");
			}
			else if(q[2].equals("ease-out"))
			{
				System.out.println("Slow end for each slide");
			}
			else
			{
				System.out.println("Slow start and Slow end for each slide");
			}
			//Test Case 6: Get duration of slide
			System.out.println("Duration of each slide is "+q[1]);
			//Test Case 7: Get delay between slides
			q[3].replace(",",""); //Remove "," in value if exists
		}
		//Close site
		driver.close();
	}
}
