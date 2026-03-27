package com.example.hhautomation;

import com.example.hhautomation.auth.AuthService;
import com.example.hhautomation.browser.BrowserFactory;
import com.example.hhautomation.resume.ResumeService;
import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class Main {

    public static void main(String[] args) {

        try (Playwright playwright = Playwright.create()) {

            Browser browser = BrowserFactory.create(playwright);
            BrowserContext context = AuthService.create(browser);

            Page page = context.newPage();

            AuthService.ensureLoggedIn(page, context);

            ResumeService.refreshResume(page);

            browser.close();
        }
    }
}