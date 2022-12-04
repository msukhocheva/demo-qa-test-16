package pages;

import com.codeborne.selenide.SelenideElement;
import pages.components.CalendarComponent;
import pages.components.RegistrationResultModal;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationPage {
    CalendarComponent calendarComponent = new CalendarComponent();
    RegistrationResultModal registrationResultModal = new RegistrationResultModal();
    private static final String title="Student Registration Form";
    private SelenideElement
            firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            EmailInput=$("#userEmail"),
            GenderInput =$("#genterWrapper"),
            NumberInput= $("#userNumber"),
            AddressInput=$("#currentAddress");

    public RegistrationPage openPage() {
        open("/automation-practice-form");
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");

        $(".practice-form-wrapper").shouldHave(text(title));
        return this;
    }

    public RegistrationPage setFirstName(String value) {
        firstNameInput.setValue(value);
        return this;
    }
    public RegistrationPage setLastName(String value) {
        lastNameInput.setValue(value);
        return this;
    }

    public RegistrationPage setEmail(String value) {
        EmailInput.setValue(value);
        return this;
    }
    public RegistrationPage setNumber(String value) {
        NumberInput.setValue(value);
        return this;
    }
    public RegistrationPage setAddress(String value) {
        AddressInput.setValue(value);
        return this;
    }

    public RegistrationPage setGender(String value) {
        // $("#gender-radio-1").parent().click();
        GenderInput.$(byText(value)).click();
        return this;
    }

    public RegistrationPage setBirthdayDate(String day, String month, String year) {
        $("#dateOfBirthInput").click();
        calendarComponent.setDate(day, month, year);
        return this;
    }
    public RegistrationPage verifyModalAppears() {
        registrationResultModal.verifyModalAppears();
        return this;
    }
    public RegistrationPage verifyResult(String key, String value) {
        registrationResultModal.verifyResult(key, value);
        return this;
    }
}
