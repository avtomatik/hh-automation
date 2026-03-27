package com.example.hhautomation.resume;

import com.example.hhautomation.config.Config;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;

public class ResumeService {

    public static void refreshResume(Page page) {

        page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Резюме и профиль")).click();

        handlePopupIfPresent(page);

        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName(Config.RESUME_NAME)).click();

        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Поднять в поиске")).click();

        System.out.println("Resume refreshed");
    }

    private static void handlePopupIfPresent(Page page) {
        Locator popup = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Понятно"));

        if (popup.isVisible()) {
            popup.click();
        }
    }
}