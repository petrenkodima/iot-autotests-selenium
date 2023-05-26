package iot.tests;

import iot.actions.IotAuthActions;
import iot.actions.IotUserAndAdminActions;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;
import java.util.logging.Logger;


class IotUserAndAdminTest {
    private WebDriver driver;
    private IotUserAndAdminActions actions;
    private IotAuthActions authActions;
    private final Logger log = Logger.getLogger(String.valueOf(this.getClass()));
    private static final String MESSAGE = "The resulting value does not match the expected value";
    private static final Integer WAIT_SHORT_SEC = 2000;

    @BeforeEach
    void setup() {
        log.info("Открыть приложение перейти по ссылке");
        System.setProperty("webdriver.gecko.driver", "C:\\Users\\dimap\\Downloads\\driver\\geckodriver.exe");
        System.setProperty("webdriver.firefox.bin", "C:\\Program Files\\Mozilla Firefox\\firefox.exe");
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().window().maximize();
        driver.get("http://localhost:8088");
        actions = new IotUserAndAdminActions(driver);
        authActions = new IotAuthActions(driver);
    }

    @Test
    @DisplayName("Авторизация пользователя в системе")
    void signInTest() {
        authActions.loginWithValidCred("admin","admin");
        authActions.sleep(WAIT_SHORT_SEC);
        String heading = actions.getMainHeadingText();
        Assertions.assertEquals("Доступное для пользователей c ролями ADMIN & USER" , heading, MESSAGE);
    }

    @Test
    @DisplayName("Вывести информацию о пользователе")
    void getUserInformationTest() {
        signInTest();
        authActions.sleep(WAIT_SHORT_SEC);
        actions.getUserInformation("admin");
        authActions.sleep(WAIT_SHORT_SEC);
    }

    @Test
    @DisplayName("Выход пользователя из системы")
    void signOutTest() {
        signInTest();
        authActions.sleep(WAIT_SHORT_SEC);
        authActions.logoutWithValidCred();
        authActions.sleep(WAIT_SHORT_SEC);
        String welcome = authActions.getWelcomeHeadingText();
        Assertions.assertEquals("Добро пожаловать!" , welcome, MESSAGE);
    }

    @Test
    @DisplayName("Получить всех пользователей")
    void getAllUsersTest() {
        signInTest();
        authActions.sleep(WAIT_SHORT_SEC);
        actions.clickButtonGetAllUsers();
    }

    @AfterEach
    public void turnOffTest() {
        driver.quit();
    }


}
