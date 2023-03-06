package tests.android;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;
import static io.appium.java_client.AppiumBy.accessibilityId;
import static io.appium.java_client.AppiumBy.id;
import static io.qameta.allure.Allure.step;

public class WikiTests extends TestBase {
    @DisplayName("Check search")
    @Test
    void searchTest () {
        step("Type search", () -> {
            $(accessibilityId("Search Wikipedia")).click();
            $(id("org.wikipedia.alpha:id/search_src_text")).sendKeys("BrowserStack");
        });
        step("Verify content found", () ->
                $$(id("org.wikipedia.alpha:id/page_list_item_title"))
                        .shouldHave(sizeGreaterThan(0)));
    }

    @DisplayName("Check going to the article")
    @Test
    void goToArticleTest () {
        step("Type search", () -> {
            $(accessibilityId("Search Wikipedia")).click();
            $(id("org.wikipedia.alpha:id/search_src_text")).sendKeys("BrowserStack");
        });
        step("Click on the  article", () -> {
            $(id("org.wikipedia.alpha:id/fragment_feed_header")).click();
        });
        step("Click on the back button", () -> {
            $(id("org.wikipedia.alpha:id/view_wiki_error_button")).click();
        });
        step("Check visibility of header logo", () ->
                $(id("org.wikipedia.alpha:id/single_fragment_toolbar_wordmark"))
                        .shouldBe(visible));
    }
    @Test
    @DisplayName("Проверка перехода по 4 страницам")
    void onboardingTest() {
        step("Open started page", () -> {
            $(id("org.wikipedia.alpha:id/primaryTextView"))
                    .shouldHave(text("The Free Encyclopedia …in over 300 languages"));
        });
        step("Go to the next onboarding page - New ways to explore", () -> {
            $(id("org.wikipedia.alpha:id/fragment_onboarding_forward_button")).click();
            $(id("org.wikipedia.alpha:id/primaryTextView"))
                    .shouldHave(text("New ways to explore"));
        });
        step("Go to the next onboarding page - Reading lists with sync", () -> {
            $(id("org.wikipedia.alpha:id/fragment_onboarding_forward_button")).click();
            $(id("org.wikipedia.alpha:id/primaryTextView"))
                    .shouldHave(text("Reading lists with sync"));
        });
        step("Go to the next onboarding page - Send anonymous data", () -> {
            $(id("org.wikipedia.alpha:id/fragment_onboarding_forward_button")).click();
            $(id("org.wikipedia.alpha:id/primaryTextView"))
                    .shouldHave(text("Send anonymous data"));
        });
    }

}
