package com.example.hhautomation;

import com.microsoft.playwright.*;

public class Main {

    public static void main(String[] args) {
        try (Playwright playwright = Playwright.create()) {
            Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
            Page page = browser.newPage();
            page.navigate("https://hh.ru");
            System.out.println("Page title: " + page.title());
            Thread.sleep(5000);
            browser.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
