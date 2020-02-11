package com.qa.Base;


public final class FrameworkProperties {
	public static final String BASE_URL = System.getProperty("selenium.baseURL", "https://www.amazon.ca/");
	static final Integer DEFAULT_TIMEOUT = Integer.parseInt(System.getProperty("selenium.defaultTimeout", "5"));
	static final Integer EXTENDED_TIMEOUT = Integer.parseInt(System.getProperty("selenium.defaultTimeout", "10"));
	public static final String UNAME = System.getProperty("selenium.baseURL", "ecompliancetest@gmail.com");
	public static final String PWD = System.getProperty("selenium.baseURL", "Test1234");
	static final String BROWSER = System.getProperty("selenium.browser", "chrome");
}

