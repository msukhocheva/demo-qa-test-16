package tests;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationTest {
    @BeforeAll
    static void beforeAll(){
        //Configuration.holdBrowserOpen = true;
        Configuration.browserSize="1920x1080";
        Configuration.baseUrl="https://demoqa.com";
    }
    @Test
    void fillFormTests() {
        String userName="Alex";
        open("/automation-practice-form");
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");

        $(".practice-form-wrapper").shouldHave(text("Student Registration Form"));

        $("#firstName").setValue(userName);
        $("#lastName").setValue(userName);
        $("#userEmail").setValue("Egor@mail.com");
        $("#userNumber").setValue("1234567890");
        $("#currentAddress").setValue(userName);
        $("#gender-radio-1").parent().click();
        $(byText("Male")).click();


        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption("July");
        //$(".react-datepicker__month-select").selectOptionByValue("8");
        $(".react-datepicker__year-select").selectOption("2008");
        $(".react-datepicker__day--030:not(.react-datepicker__day--outside-month)").click();
        $("#subjectsInput").setValue("Maths").pressEnter();
        $("#hobbiesWrapper").$(byText("Sports")).click();
      //  $("#uploadPicture").uploadFile(new File("src/test/resources/img/1.png"));
        $("#uploadPicture").uploadFromClasspath("img/1.png");
        $("#state").click();
        $("#stateCity-wrapper").$(byText("NCR")).click();
        $("#city").click();
        $("#stateCity-wrapper").$(byText("Delhi")).click();
        $("#submit").click();
        $(".modal-dialog").should(appear);
        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
        $(".table-responsive").shouldHave(text(userName), text("Egor@mail.com"), text("1234567890"));

    }
}

