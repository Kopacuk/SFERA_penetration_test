import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;

public class UIScript {

    public static void main(String[] args) throws InterruptedException {
        // Установка пути к драйверу Chrome
        System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");

        // Создание экземпляра WebDriver
        ChromeOptions options = new ChromeOptions();
       //options.addArguments("--disable-dev-shm-usage");
       //options.addArguments("--no-sandbox");
        options.addArguments("--ignore-certificate-errors");
        //options.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
        options.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
        ChromeDriver driver = new ChromeDriver(options);

        System.out.println("string");
        // Открытие страницы с авторизацией
        driver.get("https://sfera.inno.local/testing/project/SGPS/test-plans/SGPS-TP-13/run/269576?plan-section=170346&section=125732");

        // Ввод логина и пароля
        WebElement usernameInput = driver.findElement(By.xpath("//input[@name='username']"));
        WebElement passwordInput = driver.findElement(By.xpath("//input[@name='password']"));
        usernameInput.sendKeys("vtb4056438@corp.dev.vtb");
        passwordInput.sendKeys("mhoFdYP2!@#QWEASD");

        // Нажатие кнопки авторизации
        WebElement loginButton = driver.findElement(By.xpath("//button[@name='sign-in']"));
        loginButton.click();

        // Пауза для загрузки страницы после авторизации
        Thread.sleep(2000);

        // Нажатие первой кнопки на странице
        WebElement button1 = driver.findElement(By.xpath(""));
        button1.click();

        // Нажатие второй кнопки на странице
        WebElement button2 = driver.findElement(By.xpath(""));
        button2.click();

        // Ожидание появления модального окна
        //Thread.sleep(2000);

        // Нажатие кнопки на модальном окне
        WebElement modalButton = driver.findElement(By.xpath(""));
        modalButton.click();

        // Обновление страницы
        driver.navigate().refresh();

        // Нажатие первой кнопки после обновления страницы
        //button1 = driver.findElement(By.id("id_первой_кнопки"));
        //button1.click();

        // Нажатие второй кнопки после обновления страницы
        //button2 = driver.findElement(By.id("id_второй_кнопки"));
        //button2.click();

        // Закрытие браузера
        driver.quit();
    }
}

