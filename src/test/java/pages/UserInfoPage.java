package pages;


import com.codeborne.selenide.SelenideElement;
import pages.components.CalendarComponent;
import pages.components.ClearPageComponent;


import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class UserInfoPage extends ClearPageComponent {

    CalendarComponent calendar = new CalendarComponent();
    /// SelenideElements
    SelenideElement titleLabel = $(".practice-form-wrapper"),
            firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            userEmailInput = $("#userEmail"),
            genderWrapper = $("#genterWrapper"),
            setBirthDate = $("#dateOfBirthInput"),
            userNumberInput = $("#userNumber"),
            subjectsInput = $("#subjectsInput"),
            hobbiesCheckboxes = $("#hobbiesWrapper"),
            uploadPictureInput = $("#uploadPicture"),
            currentAddressTextArea = $("#currentAddress"),
            stateDropDown = $("#react-select-3-input"),
            cityDropDown = $("#react-select-4-input"),
            submitButton = $(".btn-primary");


    public UserInfoPage openPage() {
        open("/automation-practice-form");
        titleLabel.shouldHave(text("Student Registration"));
        removeBanners();
        return this;
    }


    public UserInfoPage setFirstName(String value) {
        firstNameInput.setValue(value);
        return this;
    }

    public UserInfoPage setLastName(String value) {
        lastNameInput.setValue(value);
        return this;
    }

    public UserInfoPage setUserEmail(String value) {
        userEmailInput.setValue(value);
        return this;
    }

    public UserInfoPage setGender(String gender) {
        genderWrapper.$(byText(gender)).click();
        return this;
    }

    public UserInfoPage setUserNumber(String value) {
        userNumberInput.setValue(value);
        return this;
    }

    public UserInfoPage setDateOfBirth(String day, String month, String year) {
        setBirthDate.click();
        calendar.setDate(day, month, year);
        return this;
    }

    public UserInfoPage setSubjectsInput(String value) {
        subjectsInput.setValue(value).pressEnter();
        return this;
    }

    public UserInfoPage setHobbies(String value) {
        hobbiesCheckboxes.$(byText(value)).click();
        return this;
    }

    public UserInfoPage uploadPicture(String filename) {
        uploadPictureInput.uploadFromClasspath(filename);
        return this;
    }

    public UserInfoPage setAddress(String value) {
        currentAddressTextArea.setValue(value);
        return this;
    }

    public UserInfoPage setState(String state) {
        stateDropDown.setValue(state).pressEnter();
        return this;
    }

    public UserInfoPage setCity(String city) {
        cityDropDown.setValue(city).pressEnter();
        return this;
    }

    public UserInfoPage clickSubmit() {
        submitButton.click();
        return this;
    }

}
