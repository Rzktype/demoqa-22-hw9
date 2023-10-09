import org.junit.jupiter.api.Test;
import pages.UserInfoPage;
import pages.components.ChecksOutputInfoComponent;
import utils.RandomUtils;


public class DemoQaFormTests extends tests.TestBase {
    UserInfoPage userInfoPage = new UserInfoPage();
    ChecksOutputInfoComponent tableUserInfo = new ChecksOutputInfoComponent();
    RandomUtils random = new RandomUtils();

    @Test
    void fillFormTest() {

        userInfoPage.openPage()
                .setFirstName(random.firstName)
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
    }
}
