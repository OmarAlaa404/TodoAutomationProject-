package com.qacart.todo.utils;

import io.restassured.http.Cookie;
import java.util.ArrayList;
import java.util.List;

/**
 * CookieUtils class provides utility methods for converting RestAssured cookies to Selenium cookies.
 */
public class CookieUtils {

    /**
     * Converts a list of RestAssured cookies to Selenium cookies.
     *
     * @param restAssuredCookies the list of RestAssured cookies to be converted.
     * @return a list of Selenium cookies.
     */
    public static List<org.openqa.selenium.Cookie> convertRestAssureCookiesToSeleniumCookies(List<Cookie> restAssuredCookies) {
        List<org.openqa.selenium.Cookie> seleniumCookies = new ArrayList<>();
        for (Cookie cookie : restAssuredCookies) {
            org.openqa.selenium.Cookie seleniumCookie = new org.openqa.selenium.Cookie(cookie.getName(), cookie.getValue());
            seleniumCookies.add(seleniumCookie);
        }
        return seleniumCookies;
    }
}
