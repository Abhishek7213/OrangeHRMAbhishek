package tests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;
import bases.BaseTest;
import pages.DashBoard;
import pages.LoginPage;
import utils.ConfigReader;

public class DasboardElementTest extends BaseTest {	

	
	@Test(priority=1)
	public void checkInvalidUser() throws IOException
	{
		ConfigReader config = new ConfigReader();     
		LoginPage lp=new LoginPage(driver);
		lp.userLogin(config.getUsername(),"fhghf");
		lp.errorInformation();
	}
	@Test(priority=2)
	public void checkInvalidPass() throws IOException
	{
		ConfigReader config = new ConfigReader();     
		LoginPage lp=new LoginPage(driver);
		lp.userLogin("fgfh",config.getPassword());
		lp.errorInformation();
	}
	
	@Test(priority=3)
	public void verifyTitle() throws IOException
	{
		ConfigReader config = new ConfigReader();     
		LoginPage lp=new LoginPage(driver);
		lp.userLogin(config.getUsername(),config.getPassword());
		Assert.assertEquals(lp.getTitle(),"OrangeHRM");
	}
	
	@Test(priority=4)
	public void dasboardTest() throws IOException
	{
		ConfigReader config = new ConfigReader();     
		LoginPage lp=new LoginPage(driver);
		DashBoard dash=new DashBoard(driver);
		dash=lp.userLogin(config.getUsername(),config.getPassword());
		dash.getSideMenu();
		dash.selectLogout();
	}
	
	

}
