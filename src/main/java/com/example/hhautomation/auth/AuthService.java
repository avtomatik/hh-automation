package com.example.hhautomation.auth;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import com.example.hhautomation.config.Config;
import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import com.microsoft.playwright.options.WaitUntilState;

public class AuthService {

    public static BrowserContext create(Browser browser) {
        Path path = Paths.get(Config.STORAGE_PATH);

        if (Files.exists(path)) {
            return browser.newContext(
                    new Browser.NewContextOptions().setStorageStatePath(path));
        }

        return browser.newContext();
    }

    public static void ensureLoggedIn(Page page, BrowserContext context) {

        // page.navigate(Config.BASE_URL);

        // if (isLoggedIn(page)) {
        //     System.out.println("Already logged in (session restored");
        //     return;
        // }

        System.out.println("Not logged in >> performing login");

        performLogin(page);
    }

    // private static boolean isLoggedIn(Page page) {
    //     return page.locator("text=Резюме и профиль").isVisible();
    // }

    private static void performLogin(Page page) {

        page.navigate(Config.LOGIN_URL, new Page.NavigateOptions().setWaitUntil(WaitUntilState.DOMCONTENTLOADED));

        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Войти")).click();

        page.getByText("Почта").first().click();

        page.getByRole(AriaRole.TEXTBOX).first().fill(Config.EMAIL);

        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Войти с паролем")).click();

        page.getByRole(AriaRole.TEXTBOX).fill(Config.PASSWORD);

        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Войти").setExact(true)).click();
    }
}
