package pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	WebDriver driver;
	DashBoard db;
	
	@FindBy(css = "div[class*='oxd-sheet'] p:first-child")
	WebElement useremail;
	
	@FindBy(css = "div[class*='oxd-sheet'] p:last-child")
	WebElement userpassword;
	
	@FindBy(name = "username")
	WebElement inputuname;
	
	@FindBy(name = "password")
	WebElement inputpass;
	
	@FindBy(xpath="//button[@type='submit']")
	WebElement clickbtn;
	
	@FindBy(css=".orangehrm-login-form div>i+p")
	WebElement errorInfo;
	
	
	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	public String errorInformation()
	{
		return errorInfo.getText();
	}
	
	public String getTitle()
	{
		return driver.getTitle();
	}
	
	public DashBoard userLogin(String u,String p)
	{
		/*  //using the loactor to get the username and password from Login page
		String uname=useremail.getText().trim().split(":")[1].toString().trim();
		String upass=userpassword.getText().split(":")[1].toString().trim();
		System.out.println(uname);
		System.out.println(upass);
		*/
		
		inputuname.sendKeys(u);
		inputpass.sendKeys(p);
		clickbtn.click();
		return new DashBoard(driver);
	}


}
