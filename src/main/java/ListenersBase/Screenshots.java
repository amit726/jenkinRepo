package ListenersBase;

import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import orgGeneric.BaseClass;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.comparison.ImageDiff;
import ru.yandex.qatools.ashot.comparison.ImageDiffer;

public class Screenshots extends BaseClass {
	public static AShot ashot=new AShot();
	public static void screenshot(String nameoftheTestMethod)
	{
		try
		{
			logs.info("Taking acreenshot");
			TakesScreenshot ts=(TakesScreenshot) driver;
			
			File file=ts.getScreenshotAs(OutputType.FILE);
			
			String path="D:\\Nov_java program\\AmitMaven\\Screenshots"+nameoftheTestMethod+".png";
			
			FileUtils.copyFile(file, new File(path));
			logs.info("screenshot taken and saved to the location:"+path);
		}
		catch(Exception e)
		{
			logs.info(e.getMessage());
			Assert.fail();
		}
	}
	public static void screenshotusingrobot() throws Exception
	{
		Robot r=new Robot();
		Rectangle rect=new Rectangle(500,500);
		BufferedImage image=r.createScreenCapture(rect);
		ImageIO.write(image, "JPG", new File("path"));
	}
	
	public static void screenofElement(WebElement ele, String nameoftheclass)
	{
		try
		{
			logs.info("taking screenshot of an element");
			String path="D:\\Nov_java program\\AmitMaven\\Screenshots"+nameoftheclass+".png";
			TakesScreenshot ts=(TakesScreenshot)driver;
			File screenshot=ts.getScreenshotAs(OutputType.FILE);
			BufferedImage fullImage=ImageIO.read(screenshot);
			Point point=ele.getLocation();
			int width=ele.getSize().getWidth();
			int height=ele.getSize().getHeight();
			BufferedImage subImage=fullImage.getSubimage(point.getX(), point.getY(), width, height);
			ImageIO.write(subImage, ".png", new File(path));
		}
		catch(Exception e)
		{
			logs.info(e.getMessage());
			Assert.fail();
		}
	}
	
	public static void screenshotofElemenyusingAshot(String object, String nameoftheclass)
	{
		try
		{
			logs.info("Taking screenshot of an element");
			WebElement ele=BaseClass.getElement(driver, BaseClass.webElements.getProperty(object));
			Screenshot screenshot=ashot.takeScreenshot(driver,ele);
			String path="D:\\Nov_java program\\AmitMaven\\Screenshots"+nameoftheclass+".png";
			ImageIO.write(screenshot.getImage(), ".png", new File(path));
			logs.info("screenshot taken and saveed to the location:"+path);
		}
		catch(Exception e)
		{
			logs.info(e.getMessage());
			Assert.fail();
		}
	}
	
		public static void screenshotUsingAshot(String nameoftheclass)
		{
			try
			{
				logs.info("taking screenshot of an element");
				Screenshot screenshot=ashot.takeScreenshot(driver);
				String path="D:\\Nov_java program\\AmitMaven\\Screenshots"+nameoftheclass+".png";
				ImageIO.write(screenshot.getImage(), ".png", new File(path));
				logs.info("screenshot taken and saved to the location:"+path);
			}
			catch(Exception e)
			{
				logs.info(e.getMessage());
				Assert.fail();
			}
		}
		
	public static void compareTwoImages(String expectedImagepath, String actualImagePath)
	{
		try
		{
			logs.info("Comparing two images");
			BufferedImage expectedImage=ImageIO.read(new File(expectedImagepath));
			BufferedImage actualImage=ImageIO.read(new File(actualImagePath));
			
			ImageDiffer differ=new ImageDiffer();
			ImageDiff diff=differ.makeDiff(expectedImage, actualImage);
			Assert.assertFalse(diff.hasDiff(), "Image are not matching");
		}
		catch(Exception e)
		{
			logs.info(e.getMessage());
			Assert.fail();
		}
		catch(AssertionError error)
		{
			logs.info(error.getMessage());
			Assert.fail();
		}
	} 
	

}
