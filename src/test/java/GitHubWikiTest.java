import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class GitHubWikiTest {
    @BeforeAll
    static void setUp() {
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://github.com/";
    }

    @Test
    void SoftAssertionsPageHasJUnit5CodeSnippet() {
        open("selenide/selenide");
        $("#wiki-tab").click();
        $("[class='Box-row wiki-more-pages-link']").$("button").click();
        $x("//ul[@data-filterable-for='wiki-pages-filter']//a[.='SoftAssertions']")
                .shouldBe(visible) //проверку добавил исключительно из-за формулировки в ДЗ. Если оставить только .click(), то ничего не изменится
                .click();
        $x("//li[.='Using JUnit5 extend test class:']/../following-sibling::div[1]//span[3][.='.']").shouldBe(visible);
    }
}
