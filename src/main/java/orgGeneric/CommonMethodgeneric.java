package orgGeneric;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;







public class CommonMethodgeneric extends BaseClass {
	
		public static WebElement element=null;
		public static void navigate(WebDriver driver, String data)
		{
			try
			{
				driver.navigate().to(data);
			}
			catch(NoSuchElementException e)
			{
				logs.info(e.getMessage());
				System.out.println("#################################");
				Assert.assertEquals("Fail", "Pass");
			}
			catch(NullPointerException e)
			{
			
				System.out.println(e.getMessage());
				logs.info("######################");
				Assert.assertEquals("Fail", "Pass");
			}
			catch(AssertionError error)
			{
				logs.info(error.getMessage());
				Assert.fail();
			}
		}
		public static void mouseOver(String Object) 
		{
			try
			{
				Thread.sleep(2000);
				element=BaseClass.getElement(driver, BaseClass.webElements.getProperty(Object));
				if(element.isDisplayed())
				{
					logs.info("Web Element id displayed for Mousehover");
					Actions actions=new Actions(driver);
					actions.moveToElement(element).build().perform();
					logs.info("Mousehover Done on WebElement");
				}
				else
				{
					logs.info("Unable to do Mousehover");
					Assert.fail();
				}
			}
			catch(NoSuchElementException e)
			{			
				logs.info(e.getMessage());
				System.out.println("########################");
				Assert.assertEquals("Fail", "Pass");
			}
			catch(NullPointerException e)
			{
				System.out.println(e.getMessage());
				System.out.println("########################");
				Assert.assertEquals("Fail", "Pass");
			}
			catch(Exception e)
			{
				System.out.println(e.getMessage());
				System.out.println("########################");
				Assert.assertEquals("Fail", "Pass");
			}
			catch(AssertionError error)
			{
				logs.info(error.getMessage());
				Assert.fail();
			}
		}
		public static void commonClick(String object)
		{
			try
			{
				Thread.sleep(2000);
				WebElement element=BaseClass.getElement(driver, BaseClass.webElements.getProperty(object));
				if(element.isDisplayed())
				{
					element.click();
					logs.info("Clikked on WebElement");
				}
				else
				{
					logs.info("Unable to click");
				}
			}
			catch(NoSuchElementException e)
			{
				logs.info(e.getMessage());
				System.out.println("############################333");
				Assert.assertEquals("Fail", "Pass");
			}
			catch(NullPointerException e)
			{
				logs.info(e.getMessage());
				System.out.println("############################333");
				Assert.assertEquals("Fail", "Pass");
			}
			catch(Exception e)
			{
				logs.info(e.getMessage());
				System.out.println("############################333");
				Assert.assertEquals("Fail", "Pass");
			}
			catch(AssertionError e)
			{
				logs.info(e.getMessage());
				Assert.fail();
			}
		}
		public static void isVisible(String object)
		{
			try
			{
				boolean element=BaseClass.getElement(driver,BaseClass.webElements.getProperty(object)).isDisplayed();
				if(element==true)
				{
					logs.info("WebElement is visible");
				}
				else
				{
					Assert.assertEquals("Pass", "Fail");
				}
			}
			catch(NoSuchElementException e)
			{
				logs.info(e.getMessage());
				System.out.println("#####################");
				Assert.assertEquals("Fail", "Pass");
			}
			catch(NullPointerException e)
			{
				logs.info(e.getMessage());
				System.out.println("#####################");
				Assert.assertEquals("Fail", "Pass");
			}
			catch(Exception e)
			{
				logs.info(e.getMessage());
				System.out.println("#####################");
				Assert.assertEquals("Fail", "Pass");
			}
			catch(AssertionError error)
			{
				logs.info(error.getMessage());
				Assert.fail();
			}
		}
		public static void setText(String object, String text)
		{
			try
			{
				WebElement lemenet=BaseClass.getElement(driver, BaseClass.webElements.getProperty(object));
				if(element.isDisplayed())
				{
					element.sendKeys(text);
				}
			}
			catch(NoSuchElementException e)
			{
				logs.info("Element not found");
				Assert.fail();
			}
			catch(ElementNotInteractableException e)
			{
				logs.info(e.getMessage());
				Assert.fail();
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
		public static void selectByValue(WebDriver driver, String object, String value)
		{
			try
			{
				WebElement ele=BaseClass.getElement(driver,BaseClass.webElements.getProperty("objects"));
				String tagName=ele.getTagName();
				if(tagName.equalsIgnoreCase("Select"))
				{
					Select sel=new Select(ele);
					sel.selectByValue(value);
				}
				else
				{
					logs.info("Cannot handle this dropdown using select class due to this elementis developed using"+tagName+"tag");
				}
			}
			catch(Exception e)
			{
				System.out.println(e.getMessage());
				Assert.fail();
			}
			catch(AssertionError error)
			{
				logs.info(error.getMessage());
				Assert.fail();
			}
		}
		public void verifyerror(String object,String errorMessage)
		{
			try
			{
				
			WebElement ele=BaseClass.getElement(driver, BaseClass.webElements.getProperty(object));
			if(ele.getText().equalsIgnoreCase(errorMessage))
			{
				logs.info("error found");
			}
			else
			{
				logs.info(errorMessage+"Error not found");
				Assert.fail();
			}
		}
			catch(Exception e)
			{
				logs.info(e.getMessage());
				Assert.fail();
			}
			catch(AssertionError error)
			{
				logs.info(error.getMessage());
				
			}
		}
		public void verifyText(String object, String expectedText)
		{
			try
			{
				WebElement ele=BaseClass.getElement(driver,BaseClass.webElements.getProperty(object));
				String actualText=ele.getText();
				if(ele.getText().equals(expectedText))
				{
					logs.info("Actual Text is matching with expected Text");
				}
				else
				{
					logs.info("Actual text"+ actualText+"is not mtaching with expected one"+expectedText);
					Assert.fail();
				}
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
	
		
public void checkBrokenlinks(WebDriver driver, String url) throws IOException
{
	try
	{
		URL url1=new URL(url);
		HttpURLConnection conn=(HttpURLConnection) url1.openConnection();
		String message=conn.getResponseMessage();
		if(message.contains("404"))
		{
			logs.info(url+"is broken");
			Assert.fail();
		}
		else if(message.contains("200"))
		{
			logs.info(url+"is not broken");
		}
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
public void checkBrokenlinks(List<WebElement>allele)
{
	try
	{
		for(WebElement ele:allele)
		{
			String url=ele.getAttribute("href");
			URL u=new URL(url);
			HttpURLConnection conn=(HttpURLConnection)u.openConnection();
			String message=conn.getResponseMessage();
			if(message.contains("404"))
			{
				logs.info(url+"is broken");
				Assert.fail();
			}
			else if(message.contains("200"))
			{
				logs.info(url+"is not broken");
			}
		}
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
	/*check for all active links*/
public void verifyBrokenImages(String object)
{
	try
	{
		List<WebElement> elements=BaseClass.getElements(driver, BaseClass.webElements.getProperty(object));
		for(WebElement ele:elements)
		{
			String imagevalue=ele.getAttribute("id");
			URL url=new URL(imagevalue);
			HttpURLConnection conn=(HttpURLConnection)url.openConnection();
			int responsecodecode=conn.getResponseCode();
			if(responsecodecode==200)
			{
				logs.info(ele.getText()+imagevalue+"is not broken");
			}
			else
			{
				logs.info(ele.getText()+imagevalue+"is broken");
			}
		}
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

	
	






