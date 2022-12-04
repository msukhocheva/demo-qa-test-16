package tests;

import org.junit.jupiter.api.Test;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationWithPageObjectsTest extends TestBase {

    @Test
    void fillFormTests() {
        String userName = "Alex";
        registrationPage.openPage()
                .setFirstName(userName)
                .setLastName(userName)
                .setEmail("Egor@mail.com")
                .setGender("Other")
                .setNumber("1234567890")
                .setAddress("Address")
                .setBirthdayDate("30","July","2008");


        $(byText("Male")).click();


       $("#subjectsInput").setValue("Maths").pressEnter();
        $("#hobbiesWrapper").$(byText("Sports")).click();
        //  $("#uploadPicture").uploadFile(new File("src/test/resources/img/1.png"));
        $("#uploadPicture").uploadFromClasspath("img/1.png");
        $("#state").click();
        $("#stateCity-wrapper").$(byText("NCR")).click();
        $("#city").click();
        $("#stateCity-wrapper").$(byText("Delhi")).click();
        $("#submit").click();
        registrationPage.verifyModalAppears()
                        .verifyResult("Student Name", userName+" "+userName)
                        .verifyResult("Student Email", "Egor@mail.com");

    }
}
