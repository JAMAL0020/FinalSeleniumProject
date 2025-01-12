package MyPackage;

import static org.testng.Assert.assertEquals;

import java.time.Duration;
import java.time.LocalDate;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class MyTestCases extends Parameters {

	@BeforeTest
	public void mySetup() {

		ConfigurationToAccess();

	}

	@Test(priority = 1)

	public void CheckTheDefaultLangaugeIsEnglish() {

		String ActucalLangauge = driver.findElement(By.tagName("html")).getDomAttribute("lang");

		Assert.assertEquals(ActucalLangauge, ExpectedLanguage);

	}

	@Test(priority = 2)

	public void CheckTheDefaultCurrency() {

		String ActucalCurrency = driver.findElement(By.cssSelector(".sc-dRFtgE.fPnvOO")).getText();

		Assert.assertEquals(ActucalCurrency, ExpectedCurrency);

	}

	@Test(priority = 3)

	public void CheckTheMoblieNumber() {

		String ActucalMobileNumber = driver.findElement(By.tagName("strong")).getText();

		Assert.assertEquals(ActucalMobileNumber, ExpectedMobileNumber);

	}

	@Test(priority = 4)

	public void CheckQitafLogo() {

		WebElement TheFooter = driver.findElement(By.tagName("footer"));

		WebElement TheContainerDiv = TheFooter.findElement(By.cssSelector(".sc-ghsgMZ.hIElfs"));
		WebElement QitafLogo = TheContainerDiv.findElement(By.tagName("svg"));

		boolean ActucalQitafLogoDisplay = QitafLogo.isDisplayed();

		Assert.assertEquals(ActucalQitafLogoDisplay, ExpectedQitafLogoDisplay);

	}

	@Test(priority = 5)

	public void CheckHotelTabIsNotSelected() {

		WebElement HotelTab = driver.findElement(By.id("uncontrolled-tab-example-tab-hotels"));

		String ActualValueforHotelTab = HotelTab.getDomAttribute("aria-selected");

		Assert.assertEquals(ActualValueforHotelTab, ExpectedValueForHotelTab);

	}

	@Test(priority = 6)

	public void CheckDepatureDate() {

		List<WebElement> dates = driver.findElements(By.cssSelector(".sc-fvLVrH.hNjEjT"));

		String ActualDepatureDate = dates.get(0).getText();
		
		Assert.assertEquals(ActualDepatureDate, Tomorrow);

	}

}
