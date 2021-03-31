package com.tests;

import java.io.File;
import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.driver.Driver;
import com.pages.Saucedemo_pages;
import com.utilities.ReadPropertiesFile;

public class SauceDemoTest extends Driver {

	public static final String filename = null;
	public Saucedemo_pages sauceDemo_page = new Saucedemo_pages();
	public ReadPropertiesFile readfile = new ReadPropertiesFile();
	public Properties prop = readfile.readPropertiesFile(filename);

	@BeforeClass
	public void initialization() {
		Driver.init(prop.getProperty("Browser"));
		sauceDemo_page.navigateTo_SauceDemoUI();
		System.out.println("Title of the application is : " + Driver.driver.getTitle());
	}

	@Test(priority = 0)
	public void negativeTest_NoInput() throws Throwable {
		sauceDemo_page.click_login_button();
		String error_msg = sauceDemo_page.get_error_message_no_username_no_pwd();
		Assert.assertEquals("Epic sadface: Username is required", error_msg);
	}

	@Test(priority = 1)
	public void negativeTest_onlyUsername_input() throws Throwable {
		sauceDemo_page.enter_username_Valid();
		sauceDemo_page.click_login_button();
		String error_msg = sauceDemo_page.get_error_message_no_username_no_pwd();
		Assert.assertEquals("Epic sadface: Password is required", error_msg);
	}

	@Test(priority = 2)
	public void negativeTest_Username_input_OnlyCharacters() throws Throwable {
		sauceDemo_page.clear_username();
		sauceDemo_page.enter_username_ValidCharacters();
		sauceDemo_page.click_login_button();
		String error_msg = sauceDemo_page.get_error_message_no_username_no_pwd();
		Assert.assertEquals("Epic sadface: Password is required", error_msg);
	}

	@Test(priority = 3)
	public void negativeTest_Username_input_OnlySpecial_Characters() throws Throwable {
		sauceDemo_page.clear_username();
		sauceDemo_page.enter_username_special_chars();
		sauceDemo_page.click_login_button();
		String error_msg = sauceDemo_page.get_error_message_no_username_no_pwd();
		Assert.assertEquals("Epic sadface: Password is required", error_msg);
	}

	@Test(priority = 4)
	public void negativeTest_Username_input_Only_Numericals() throws Throwable {
		sauceDemo_page.clear_username();
		sauceDemo_page.enter_username_numericals();
		sauceDemo_page.click_login_button();
		String error_msg = sauceDemo_page.get_error_message_no_username_no_pwd();
		Assert.assertEquals("Epic sadface: Password is required", error_msg);
	}

	@Test(priority = 5)
	public void negativeTest_Username_input_Numericals_and_SpecialChars() throws Throwable {
		sauceDemo_page.clear_username();
		sauceDemo_page.enter_username_numericals_and_splchars();
		sauceDemo_page.click_login_button();
		String error_msg = sauceDemo_page.get_error_message_no_username_no_pwd();
		Assert.assertEquals("Epic sadface: Password is required", error_msg);
	}

	@AfterTest
	public void quit() {
		Driver.driver.quit();
	}

	@AfterMethod
	public void tearDown(ITestResult result) {

		if (ITestResult.FAILURE == result.getStatus()) {
			try {
				TakesScreenshot ts = (TakesScreenshot) driver;
				File source = ts.getScreenshotAs(OutputType.FILE);
				FileHandler.copy(source, new File("./Screenshots/" + result.getName() + ".png"));
				System.out.println("Screenshot taken");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}