package com.pages;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;

import com.driver.Driver;
import com.utilities.ReadPropertiesFile;

public class Saucedemo_pages extends Driver {
	public static final String filename = null;
	public ReadPropertiesFile readPropertiesFile = new ReadPropertiesFile();
	public Properties prop = readPropertiesFile.readPropertiesFile(filename);

	public Saucedemo_pages() {
		PageFactory.initElements(driver, this);
	}

	public void navigateTo_SauceDemoUI() {
		driver.get(prop.getProperty("URL"));
	}

	public void click_login_button() {
		driver.findElement(By.xpath("//*[@id=\"login-button\"]")).click();
	}

	public String get_error_message_no_username_no_pwd() {
		String text_msg = driver.findElement(By.xpath("//*[@id=\"login-button\"]/../h3")).getText();
		return text_msg;
	}

	public String get_error_message_no_pwd() {
		String text_msg = driver.findElement(By.xpath("//*[@id=\"login-button\"]/../h3")).getText();
		return text_msg;
	}

	public void enter_username_Valid() {
		driver.findElement(By.id("user-name")).sendKeys("san53");
	}

	public void enter_username_ValidCharacters() {
		driver.findElement(By.id("user-name")).sendKeys("srinivas");
	}

	public void enter_username_special_chars() {
		driver.findElement(By.id("user-name")).sendKeys(")&*$#@");
	}

	public void enter_username_numericals() {
		driver.findElement(By.id("user-name")).sendKeys("98567");
	}

	public void enter_username_numericals_and_splchars() {
		driver.findElement(By.id("user-name")).sendKeys("*&^%347*(");
	}

	public void clear_username() {
		driver.findElement(By.id("user-name")).clear();
	}
}
