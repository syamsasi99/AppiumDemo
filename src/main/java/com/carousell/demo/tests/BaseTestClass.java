package com.carousell.demo.tests;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.carousell.demo.helper.AppiumBaseClass;
import com.carousell.demo.helper.AppiumController;
import com.carousell.demo.pages.CarForSaleOfferPage;
import com.carousell.demo.pages.CarForSaleOfferPageAndroid;
import com.carousell.demo.pages.CarForSalePage;
import com.carousell.demo.pages.CarForSalePageAndroid;
import com.carousell.demo.pages.CarPage;
import com.carousell.demo.pages.CarPageAndroid;
import com.carousell.demo.pages.HomePage;
import com.carousell.demo.pages.HomePageAndroid;
import com.carousell.demo.pages.LoginPage;
import com.carousell.demo.pages.LoginPageAndroid;

/**
 * @author syam
 *
 */
public class BaseTestClass extends AppiumBaseClass {

	protected LoginPage loginPage;
	protected HomePage homePage;
	protected CarPage carPage;
	protected CarForSalePage carForSalePage;
	protected CarForSaleOfferPage carForSaleOfferPage;

	@BeforeSuite
	public void setUp() throws Exception {
		AppiumController.instance.start();
		switch (AppiumController.executionOS) {
		case ANDROID:

			loginPage = new LoginPageAndroid(driver());
			homePage = new HomePageAndroid(driver());
			carPage = new CarPageAndroid(driver());
			carForSalePage = new CarForSalePageAndroid(driver());
			carForSaleOfferPage = new CarForSaleOfferPageAndroid(driver());
			break;

		}
	}

	@AfterSuite
	public void tearDown() {
		AppiumController.instance.stop();
	}
}
