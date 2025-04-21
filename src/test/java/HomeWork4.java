import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import net.bytebuddy.build.Plugin;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.time.Duration;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class HomeWork4 {

    @BeforeAll
    static void settingBrowse() {
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://github.com";
        Configuration.pageLoadStrategy = "eager";
    }

    @Test
    void selenideOnGitTest() {
        open("/selenide/selenide"); //открываем страницу

        $("#wiki-tab").click(); //открываем таб wiki
        $("#wiki-pages-filter").setValue("SoftAssertions"); //используем фильтр
        $(".js-wiki-sidebar-toggle-display").$("ul").shouldHave(text("SoftAssertions")); //проверяем что страница нашлась
        $(".js-wiki-sidebar-toggle-display").$("ul").$(byText("SoftAssertions")).click(); //откарываем страницу

        $("#wiki-body").shouldHave(text("Using JUnit5 extend test class:")); //проверяем заголовок
        $(".highlight-source-java", 3).$("pre").shouldHave(text("@ExtendWith({SoftAssertsExtension.class})\n" +
                "class Tests {\n" +
                "  @Test\n" +
                "  void test() {\n" +
                "    Configuration.assertionMode = SOFT;\n" +
                "    open(\"page.html\");\n" +
                "\n" +
                "    $(\"#first\").should(visible).click();\n" +
                "    $(\"#second\").should(visible).click();\n" +
                "  }\n" +
                "}"));
    }
}
