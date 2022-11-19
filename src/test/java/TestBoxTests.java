import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class TestBoxTests {
    @BeforeAll
    static void beforeAll(){
        Configuration.holdBrowserOpen = true;
        Configuration.browserSize="1920x1080";
        Configuration.baseUrl="https://demoqa.com";
    }
    @Test
    void fillFormTests() {

        open("/text-box");
        $("#userName").setValue("Egor");
        $("#userEmail").setValue("Egor@mail.com");
        $("#currentAddress").setValue("Egor");
        $("#submit").click();
        $("#output").shouldBe(Condition.visible);
        $("#output #name").shouldHave(text("Egor"));
    }
}
