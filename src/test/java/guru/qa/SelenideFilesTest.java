package guru.qa;

import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDirFactory;
import org.openqa.selenium.devtools.v120.input.Input;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class SelenideFilesTest {

    @Test
    void downloadFileTest() throws Exception {
        open("https://github.com/junit-team/junit5/blob/main/README.md");
        File downloaded = $("a[data-testid='raw-button']")
                .download();

        String contentAsStringSimple = FileUtils
                .readFileToString(downloaded, StandardCharsets.UTF_8);

        try (InputStream is = new FileInputStream(downloaded)) {
            byte[] content = is.readAllBytes();
            String contentAsString = new String(content, StandardCharsets.UTF_8);
            Assertions.assertTrue(
                    contentAsString.contains("Contributions to JUnit 5 are both welcomed and appreciated")
            );
        }
    }

    @Test
        void fileUploadTest () {
            open("https://fineuploader.com/demos.html");
            $("input[type='file']").uploadFromClasspath("files/cat.png");
            $(".qq-file-info").shouldHave(text("cat.png"));
        }
    }



