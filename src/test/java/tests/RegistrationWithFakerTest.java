package tests;

import com.codeborne.selenide.Configuration;
import com.github.javafaker.Faker;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Locale;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static tests.TestData.*;
import static util.RandomUtils.randomEmail;
import static util.RandomUtils.randomString;


public class RegistrationWithFakerTest {
//    String userName="Alex",
//            lastName="Egorov",
//            userEmail="Egor@mail.com";
//        String userName,
//            lastName,
//            userEmail;

      @BeforeEach
      public void BeforeEach() {
          //Faker faker =new Faker();
          Faker faker = new Faker(new Locale("ru"));
          userName=faker.name().firstName();
          lastName=faker.name().lastName();
          userEmail=faker.internet().emailAddress();
      }

    @BeforeAll
    static void beforeAll(){
        //Configuration.holdBrowserOpen = true;
        Configuration.browserSize="1920x1080";
        Configuration.baseUrl="https://demoqa.com";
    }
    @Test
    void fillFormTests() {

        open("/automation-practice-form");
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");

        $(".practice-form-wrapper").shouldHave(text("Student Registration Form"));

        $("#firstName").setValue(userName);
        $("#lastName").setValue(lastName);
        $("#userEmail").setValue(userEmail);
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
        $(".table-responsive").shouldHave(text(userName), text(userEmail), text("1234567890"));

    }
}

