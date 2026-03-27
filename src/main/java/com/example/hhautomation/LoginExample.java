package com.example.hhautomation;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.options.AriaRole;
import com.microsoft.playwright.options.WaitUntilState;

import io.github.cdimascio.dotenv.Dotenv;

public class LoginExample {

    static final String LOGIN_URL = "https://hh.ru/account/login?role=applicant";

    public static void main(String[] args) {

        Dotenv dotenv = Dotenv.load();

        String EMAIL = dotenv.get("HH_EMAIL");
        String PASSWORD = dotenv.get("HH_PASSWORD");

        if (EMAIL == null || PASSWORD == null) {
            System.out.println("Missing HH_EMAIL / HH_PASSWORD in .env.");
            return;
        }

        try (Playwright playwright = Playwright.create()) {

            Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions()
                    .setHeadless(false));

            BrowserContext context = browser.newContext();

            Page page = context.newPage();

            page.setDefaultTimeout(60000);
            page.setDefaultNavigationTimeout(60000);

            navigateToLogin(page);

            openEmailLogin(page);

            enterEmail(page, EMAIL);

            switchToPasswordLogin(page);

            enterPassword(page, PASSWORD);

            submitLogin(page);

            System.out.println("Login flow completed (check manually if successfull)");

            page.waitForTimeout(5000);

            browser.close();
        }
    }

    private static void navigateToLogin(Page page) {
        page.navigate(LOGIN_URL,
                new Page.NavigateOptions().setWaitUntil(WaitUntilState.DOMCONTENTLOADED));
    }

    private static void openEmailLogin(Page page) {
        Locator loginButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Войти"));

        loginButton.waitFor(new Locator.WaitForOptions().setTimeout(10000));
        loginButton.click();

        page.getByText("Почта").first().click();
    }

    private static void enterEmail(Page page, String email) {
        page.getByRole(AriaRole.TEXTBOX).first().fill(email);
    }

    private static void switchToPasswordLogin(Page page) {
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Войти с паролем")).click();
    }

    private static void enterPassword(Page page, String password) {
        page.getByRole(AriaRole.TEXTBOX).fill(password);
    }

    private static void submitLogin(Page page) {
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Войти").setExact(true)).click();
    }
}
