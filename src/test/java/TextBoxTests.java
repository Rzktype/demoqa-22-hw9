import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.components.ChecksOutputInfoComponent;

import static io.qameta.allure.Allure.step;

public class TextBoxTests extends tests.TestBase {


    @Test
    @Tag("JenkinsTextBox")
    @DisplayName("Successfull Registration")
    void fillFormTest() {
        ChecksOutputInfoComponent checkOutput = new ChecksOutputInfoComponent();
// test
        step("Open and fill form", () -> {
            textBoxPage.openPage()
                    .setUserName("Dmitry Volkov")
                    .setUserEmail("DmitryVolkov@mail.ru")
                    .setCurrentAddress("Moscow")
                    .setPermanentAddress("86 Tatishcheva str., Yekaterinburg, Sverdlovsk region, 620028")
                    .clickButton();
        });
// checks
        step("Check Results", () -> {
            checkOutput.checkOutputResult("Name", "Dmitry Volkov")
                    .checkOutputResult("Email", "DmitryVolkov@mail.ru")
                    .checkOutputResult("Current Address", "Moscow")
                    .checkOutputResult("Permananet Address", "Yekaterinburg");
        });


    }
}