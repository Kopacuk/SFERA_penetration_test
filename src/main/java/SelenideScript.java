import com.codeborne.selenide.Condition;
import java.time.Duration;
import static com.codeborne.selenide.Selenide.*;
import java.util.Scanner;


public class SelenideScript {

    public static void main(String[] args) throws InterruptedException {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите логин: ");
        String login = scanner.nextLine();

        System.out.print("Введите пароль: ");
        String password = scanner.nextLine();


        //указываем урл тест-плана
        open("https://sfera.inno.local/testing/project/SGPS/test-plans/SGPS-TP-13");

        $x("//input[@name='username']").sendKeys(login);
        $x("//input[@name='password']").sendKeys(password);
        $x("//button[@name='sign-in']").click();
        $x("//div[contains(@data-row,'case')][1]/..").shouldBe(Condition.visible, Duration.ofSeconds(10)).click();

        boolean continueFlag = true;

        while (continueFlag)
        {
            $x("//span[contains(text(),'Общий результат')]/../..//button[@data-status='SUCCESS'][1]").should(Condition.visible).click();
            $x("//div[contains(text(),'Завершить')]/../..").should(Condition.visible).click();
            $x("//h5/..//div[contains(text(),'Завершить')]/../..").should(Condition.visible).click();
            $x("//div[contains(text(),'Тест-кейс') and contains(text(),'пройден')]").shouldBe(Condition.visible);
            $x("//div[@class='toast-container']//button").shouldBe(Condition.visible).click();
            if ($x("//div[contains(text(),'Изменить наполнение')]").exists()) {
                continueFlag = false;
            }
        }
        System.out.println("Done");
    }
}