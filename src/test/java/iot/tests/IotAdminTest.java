package iot.tests;

import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import iot.actions.IotAdminActions;
import iot.actions.IotAuthActions;

import java.time.Duration;
import java.util.logging.Logger;


class IotAdminTest {
    private WebDriver driver;
    private IotAdminActions actions;
    private IotAuthActions authActions;
    private final Logger log = Logger.getLogger(String.valueOf(this.getClass()));
    private static final String MESSAGE = "The resulting value does not match the expected value";
    private static final Integer WAIT_SHORT_SEC = 2000;

    @BeforeEach
    void setupTest() {
        log.info("Открыть приложение перейти по ссылке");
        System.setProperty("webdriver.gecko.driver", "C:\\Users\\dimap\\Downloads\\driver\\geckodriver.exe");
        System.setProperty("webdriver.firefox.bin", "C:\\Program Files\\Mozilla Firefox\\firefox.exe");
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().window().maximize();
        driver.get("http://localhost:8088");
        actions = new IotAdminActions(driver);
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
    @DisplayName("Получить всех пользователей по определенной роли")
    void getAllUsersByRoleTest() {
        String expectedRoleUser = "ROLE_USER";
        signInTest();
        authActions.sleep(WAIT_SHORT_SEC);
        actions.scrollIntoView("window.scrollBy(0, 650)");
        actions.allUsersByRole(expectedRoleUser);
    }

    @Test
    @DisplayName("Получить пользователя по Id")
    void getUserByIdTest() {
        Integer expectedIdUser = 1;
        signInTest();
        authActions.sleep(WAIT_SHORT_SEC);
        actions.scrollIntoView("window.scrollBy(0, 1300)");
        actions.userById(expectedIdUser);
    }

    @Test
    @DisplayName("Получить все файлы пользователя")
    void getAllUserFilesTest() {
        Integer expectedIdUser = 1;
        signInTest();
        authActions.sleep(WAIT_SHORT_SEC);
        actions.scrollIntoView("window.scrollBy(0, 2600)");
        actions.allUserFiles(expectedIdUser);
    }

    @Test
    @DisplayName("Получить файл по Id")
    void getFileByIdTest() {
        Integer expectedIdFile = 1;
        signInTest();
        authActions.sleep(WAIT_SHORT_SEC);
        actions.scrollIntoView("window.scrollBy(0, 1950)");
        actions.fileById(expectedIdFile);
    }

    @Test
    @DisplayName("Загрузить документ к пользователю с указанным id")
    void uploadDocumentToTheUserWithTheSpecifiedId() {
        signInTest();
        Integer expectedIdUsers = 1;
        String fileName = "C:\\Users\\dimap\\IdeaProjects\\iot-autotests-selenium\\src\\test\\resources\\files\\sketch.bin";
        authActions.sleep(WAIT_SHORT_SEC);
        actions.scrollIntoView("window.scrollBy(0, 3250)");
        actions.uploadDocument(fileName, expectedIdUsers);
    }

    @Test
    @DisplayName("Создать пользователя")
    void createUserTest() {
        String expectedUserLogin = "test";
        String expectedUserPassword = "test";
        signInTest();
        authActions.sleep(WAIT_SHORT_SEC);
        actions.scrollIntoView("window.scrollBy(0, 1950)");
        actions.createUser(expectedUserLogin, expectedUserPassword);
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

    @AfterEach
    public void turnOffTest() {
        driver.quit();
    }

}
