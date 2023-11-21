import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.components.ChecksOutputInfoComponent;
import utils.RandomUtils;

import static io.qameta.allure.Allure.step;


public class DemoQaFormTests extends tests.TestBase {
    ChecksOutputInfoComponent tableUserInfo = new ChecksOutputInfoComponent();
    RandomUtils random = new RandomUtils();

    @Test
    @Tag("JenkinsDemoQA")
    @DisplayName("Successful Registration")
    void fillFormTest() {

        step("Open registration form", () -> {
            userInfoPage.openPage();
        });
        step("Fill user info and click submit", () -> {
            userInfoPage.setFirstName(random.firstName)
                    .setLastName(random.lastName)
                    .setUserEmail(random.email)
                    .setGender(random.gender)
                    .setUserNumber(random.phone)
                    .setDateOfBirth(random.dayOfBirth, random.monthOfBirth, random.yearOfBirth)
                    .setSubjectsInput(random.subjects)
                    .setHobbies(random.hobbies)
                    .uploadPicture(random.picture)
                    .setAddress(random.address)
                    .setState(random.chooseState)
                    .setCity(random.chooseCity)
                    .clickSubmit();
        });
        step("Verify results", () -> {
            tableUserInfo.checkResult("Student Name", random.firstName + " " + random.lastName)
                    .checkResult("Student Email", random.email)
                    .checkResult("Gender", random.gender)
                    .checkResult("Mobile", random.phone)
                    .checkResult("Date of Birth", random.dayOfBirth + " " + random.monthOfBirth + "," + random.yearOfBirth)
                    .checkResult("Subjects", random.subjects)
                    .checkResult("Hobbies", random.hobbies)
                    .checkResult("Picture", random.picture)
                    .checkResult("Address", random.address)
                    .checkResult("State and City", random.chooseState + " " + random.chooseCity);

        });
    }
}
