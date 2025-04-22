import com.codeborne.selenide.*;
import net.bytebuddy.build.Plugin;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.time.Duration;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.*;


public class HomeWork5 {
    @BeforeAll
    static void prepareEnvironment() {
        Configuration.browserSize = "1920x1080";
        Configuration.pageLoadStrategy = "eager";
    }

    @Test
    void gitEnterprisesTest() {
        open("https://github.com");
        $(byText("Solutions")).hover();
        $(byTagAndText("a", "Enterprises")).click();
        $("#hero-section-brand-heading").shouldHave(text("The AI-powered developer platform"));
    }

    @Test
    void dragAndDropTest() {
        open("https://the-internet.herokuapp.com/drag_and_drop");
        $("#column-a").shouldHave(text("A"));
        $("#column-b").shouldHave(text("B"));
        $("#column-a").dragAndDrop(DragAndDropOptions.to($("#column-b")));
        $("#column-a").shouldHave(text("B"));
        $("#column-b").shouldHave(text("A"));

        Selenide.actions()
                .clickAndHold($("#column-a"))
                .moveToElement($("#column-b"))
                .release()
                .perform();

        $("#column-a").shouldHave(text("A"));
        $("#column-b").shouldHave(text("B"));
    }
}
