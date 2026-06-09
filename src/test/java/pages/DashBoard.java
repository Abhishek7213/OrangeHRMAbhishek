package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DashBoard {
	WebDriver driver;
	
	@FindBy(xpath="//ul[@class='oxd-main-menu']/child::li")
	List<WebElement> sidemenubaroption;
	
	@FindBy(xpath="//nav[@aria-label='Topbar Menu']/child::ul/li")
	List<WebElement> topmenubaroption;
	
	@FindBy(css="p.oxd-userdropdown-name")
	WebElement logoutDropdown;
	
	@FindBy(css="ul.oxd-dropdown-menu li:last-child")
	WebElement selectLogout;
	
	public DashBoard(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	public void getSideMenu()
	{
		for(WebElement ele:sidemenubaroption)
		{
			System.out.println(ele.findElement(By.tagName("a")).getAttribute("href"));
		}
	}
	public void selectLogout()
	{
		logoutDropdown.click();	
		selectLogout.click();
	}
	
}
