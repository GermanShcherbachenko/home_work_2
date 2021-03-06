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
    void softAssertionsPageHasJUnit5CodeSnippet() {
        open("selenide/selenide");
        $("#wiki-tab").click();
        $x("//button[contains(text(), 'more pages')]").click();
        $x("//a[.='SoftAssertions']").shouldBe(visible).click();
        $x("//li[.='Using JUnit5 extend test class:']/../following-sibling::div[1]//span[3][.='.']").shouldBe(visible);
    }

//    тест для проверки первого задания
    @Test
    void checkCssSelectors() {
        open("selenide/selenide/wiki/SoftAssertions");
        String test1 = $("div a").getText();
        String test2 = $("div").$("a").getText();
        System.out.println(test1);
        System.out.println(test2);
    }
//    тест для проверки первого задания
}
