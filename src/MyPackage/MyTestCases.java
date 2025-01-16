package MyPackage;

import static org.testng.Assert.assertEquals;

import java.time.Duration;
import java.time.LocalDate;
import java.util.List;

import javax.naming.spi.DirStateFactory.Result;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
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

		Assert.assertEquals(ActucalLangauge, ExpectedEnglishLanguage);

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

	@Test(priority = 7)
	public void CheckReturnDate() {

		List<WebElement> dates = driver.findElements(By.cssSelector(".sc-fvLVrH.hNjEjT"));

		String ActualReturnDate = dates.get(1).getText();

		Assert.assertEquals(ActualReturnDate, DayAfterTomorrow);

	}

	@Test(priority = 8)

	public void RandomlyChangeWebSiteLanguage() throws InterruptedException {

		// first solution
		driver.get(Websites[RandomIndexForTheWebSite]);
//		
//		if(driver.getCurrentUrl().contains("en")) {
//			
//			String ActucalLangauge = driver.findElement(By.tagName("html")).getDomAttribute("lang");
//
//			Assert.assertEquals(ActucalLangauge, ExpectedEnglishLanguage);
//			
//		}
//		
//		else {
//				String ActucalLangauge = driver.findElement(By.tagName("html")).getDomAttribute("lang");
//
//				Assert.assertEquals(ActucalLangauge, ExpectedArabicLanguage);
//				
//		}

//		second solution

		WebElement headerforTheLanguage = driver.findElement(By.xpath("//a[@data-testid='Header__LanguageSwitch']"));

		WebElement HotelTab = driver.findElement(By.id("uncontrolled-tab-example-tab-hotels"));
		HotelTab.click();

		WebElement SearchCityInput = driver.findElement(By.cssSelector(".sc-phbroq-2.uQFRS.AutoComplete__Input"));

		if (headerforTheLanguage.getText().equals("العربية")) {
			String ActucalLangauge = driver.findElement(By.tagName("html")).getDomAttribute("lang");

			Assert.assertEquals(ActucalLangauge, ExpectedEnglishLanguage);

			SearchCityInput.sendKeys(EnglishCities[RandomEnglishCity]);

			WebElement ListOfCities = driver.findElement(By.cssSelector(".sc-phbroq-4.gGwzVo.AutoComplete__List"));

			ListOfCities.findElements(By.tagName("li")).get(1).click();

		}

		else {
			String ActucalLangauge = driver.findElement(By.tagName("html")).getDomAttribute("lang");

			Assert.assertEquals(ActucalLangauge, ExpectedArabicLanguage);

			SearchCityInput.sendKeys(ArabicCities[RandomArabicCity]);

			WebElement ListOfCities = driver.findElement(By.cssSelector(".sc-phbroq-4.gGwzVo.AutoComplete__List"));

			ListOfCities.findElements(By.tagName("li")).get(1).click();

		}
		WebElement NumberofVisitor = driver.findElement(By.cssSelector(".sc-tln3e3-1.gvrkTi"));

		Select mySelector = new Select(NumberofVisitor);

		int RandomIndex = rand.nextInt(2);

		mySelector.selectByIndex(RandomIndex);
		
		WebElement SearchButton = driver.findElement(By.cssSelector(".sc-1vkdpp9-5.btwWVk"));
		SearchButton.click();
		
		Thread.sleep(5000);
		
		WebElement Results = driver.findElement(By.xpath("//span[@data-testid='srp_properties_found']\r\n"));
		
		System.out.println(Results.getText()+"@@@@@@@@@@@@@@@@@@@");
		
		boolean ActualResult =Results.getText().contains("stays")||Results.getText().contains("مكان");
		
		Assert.assertEquals(ActualResult, ExpectedResults);
		
		//erf3o git hub
	}

}
