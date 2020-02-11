package com.qa.TestData;

import net.andreinc.mockneat.MockNeat;

public class TestData {
    static MockNeat mock = MockNeat.old();
    public static final String NEW_EMAIL = mock.emails().domain("testmail.com").val();
    public static final String NEW_FIRSTNAME = mock.names().first().val();
    public static final String NEW_LASTNAME = mock.names().last().val();
    public static final String NEW_ADDRESS1 = "1 The Street";
    public static final String NEW_CITY = mock.cities().us().val();
    public static final String NEW_ZIP = "90210";
    public static final String NEW_STATE = "California";
    public static final String NEW_MOBILE = "0123456789";
    public static final String NEW_PASS = "password";
}
