package com.carousell.demo.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * @author syam
 *
 */
public class TestCarousellCarOfferWorkflow extends BaseTestClass {

	private String userName = "testuser1000";
	private String password = "password100";
	private String loginMode = "email";
	private String bidAmount = "99.99";
	private String displayAmountPrefix = "MADE AN OFFER S$";

	@Test
	public void verifyCarForSaleOfferWorkFlow() {

		// Log in using the credentials
		loginPage.login(userName, password, loginMode);
		// Verify whether the homepage is loaded after login
		Assert.assertEquals(true, homePage.isHomePageLoaded());
		// Select car section from home page
		homePage.selectCarMenu();
		// Click on OK GOT IT Button
		carPage.clickOnOKGotIT();
		// Veify the car page has been loaded
		Assert.assertEquals(true, carPage.isCarPageLoaded());
		// Select the Car for sale menu
		carPage.selectCarForSale();
		// Verify car for sale page is loaded
		Assert.assertEquals(true, carForSalePage.isCarForSalePageLoaded());
		// Select the first item from car for sale page
		carForSalePage.selectTheFirstItem();
		// Make an offer to the selected car
		carForSaleOfferPage.makeAnOffer(bidAmount);
		// Verify the chat page is loaded
		carForSaleOfferPage.isChatPageLoaded();
		// Get the amount offered by the user from the display
		String offeredAmountOnChat = carForSaleOfferPage.getDisplayedAmountOnChat();
		String actualAmountDisplayed = offeredAmountOnChat.substring(displayAmountPrefix.length());
		// Verify both amounts are same
		Assert.assertEquals(bidAmount, actualAmountDisplayed);

	}

}
