package bases;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import utils.DriverFactory;
import utils.ConfigReader;

public class BaseTest {
	ConfigReader config;
	DriverFactory df;
	public WebDriver driver;
	@BeforeMethod
	public void setup() throws IOException
	{
		config = new ConfigReader();
        String browser = config.getBrowser();
		driver=DriverFactory.initDriver(browser);
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(config.getTimeout()));
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}


}
