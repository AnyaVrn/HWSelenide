package ru.netology;

import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;

import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;


public class CardDeliveryTest {

    @Test
    public void shouldTest() {

        open("http://localhost:9999");
        $("[data-test-id='city'] input").setValue("Екатеринбург");
        $("[data-test-id='date'] input").doubleClick().sendKeys(Keys.BACK_SPACE);
        String planningDate = LocalDate.now().plusDays(5).format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
        $("[data-test-id='date']  input").setValue(planningDate);
        $("[data-test-id = 'name'] input").setValue("Воронина Анна");
        $("[data-test-id='phone'] input").setValue("+79999999998");
        $("[data-test-id= 'agreement']").click();
        $(".grid-col button[role='button']").click();
        $("[data-test-id=notification]").shouldHave(Condition.text("Успешно!" +
                " Встреча успешно забронирована на " + planningDate), Duration.ofSeconds(15));

    }

}
