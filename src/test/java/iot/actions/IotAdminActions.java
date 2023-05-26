package iot.actions;

import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import iot.IotAbstractActions;

import static iot.actions.IotAdminSelectors.*;

/**
 * Класс для выполнения административных действий.
 */
@Slf4j
public class IotAdminActions extends IotAbstractActions {

    /**
     * Конструктор класса.
     *
     * @param driver объект WebDriver для управления браузером.
     */
    public IotAdminActions(WebDriver driver) {
        super(driver);
    }

    /**
     * Метод для получения текста главного заголовка.
     *
     * @return текст главного заголовка.
     */
    public String getMainHeadingText() {
        log.info("Get the page title Main");
        WebElement mainHeadingTextEl = driver.findElement(H1_MAIN_HEADING_TEXT);
        String headingText = mainHeadingTextEl.getText();
        System.out.println("Заголовок главной страницы: " + headingText);
        return headingText;
    }

    /**
     * Метод для получения всех пользователей по роли.
     *
     * @param userRole роль пользователя.
     */
    public void allUsersByRole(String userRole) {
        log.info("Get user information");
        driver.findElement(INPUT_USER_ROLE).sendKeys(userRole);

        WebElement userRoleEl = driver.findElement(INPUT_USER_ROLE);
        String userRoleText = userRoleEl.getText();
        System.out.println("Роль: " + userRoleText);

        driver.findElement(BTN_RECEIVE_THREE).click();
    }

    /**
     * Метод для получения пользователя по его идентификатору.
     *
     * @param userId идентификатор пользователя.
     */
    public void userById(Integer userId) {
        log.info("Get a user by Id");
        driver.findElement(INPUT_USER_ID).sendKeys(String.valueOf(userId));

        WebElement userIdEl = driver.findElement(INPUT_USER_ID);
        String userIdText = userIdEl.getText();
        System.out.println("Ид: " + userIdText);

        driver.findElement(BTN_RECEIVE_FOUR).click();
    }

    /**
     * Метод для создания нового пользователя.
     *
     * @param userLogin    логин нового пользователя.
     * @param userPassword пароль нового пользователя.
     */
    public void createUser(String userLogin, String userPassword) {
        log.info("Create a userLogin: ", userLogin, " Create a userPassword: ", userPassword);
        driver.findElement(INPUT_NEW_USER_LOGIN).sendKeys(userLogin);
        driver.findElement(INPUT_NEW_USER_PASSWORD).sendKeys(userPassword);
        WebElement userLoginEl = driver.findElement(INPUT_NEW_USER_LOGIN);
        WebElement userPasswordEl = driver.findElement(INPUT_NEW_USER_PASSWORD);
        String userLoginText = userLoginEl.getText();
        String userPasswordText = userPasswordEl.getText();
        System.out.println("Логин: " + userLoginText + " Пароль: " + userPasswordText);

        driver.findElement(BTN_RECEIVE_FIVE).click();
    }

    /**
     * Метод для получения файла по его идентификатору.
     *
     * @param fileId идентификатор файла.
     */
    public void fileById(Integer fileId) {
        log.info("Get a file by Id");
        driver.findElement(INPUT_FILE_ID).sendKeys(String.valueOf(fileId));

        WebElement fileIdEl = driver.findElement(INPUT_FILE_ID);
        String fileIdText = fileIdEl.getText();
        System.out.println("Ид: " + fileIdText);

        driver.findElement(BTN_RECEIVE_SIX).click();
    }

    /**
     * Метод для получения всех файлов пользователя.
     *
     * @param userId идентификатор пользователя.
     */
    public void allUserFiles(Integer userId) {
        log.info("Get all users files");
        driver.findElement(INPUT_FILE_USER_ID).sendKeys(String.valueOf(userId));

        WebElement userIdEl = driver.findElement(INPUT_FILE_USER_ID);
        String userIdText = userIdEl.getText();
        System.out.println("Ид: " + userIdText);

        driver.findElement(BTN_RECEIVE_SEVEN).click();
    }

    /**
     * Метод для загрузки документа на сервер от имени пользователя.
     *
     * @param fileName имя файла.
     * @param userId   идентификатор пользователя.
     */
    public void uploadDocument(String fileName, Integer userId) {
        log.info("Upload the file", fileName, " to the user with the specified id", userId);
        driver.findElement(INPUT_FILE).sendKeys(fileName);
        driver.findElement(INPUT_USER_ID_FOR_FILE).sendKeys(String.valueOf(userId));

        WebElement userIdForFileEl = driver.findElement(INPUT_USER_ID_FOR_FILE);
        String userIdForFileText = userIdForFileEl.getText();
        System.out.println("Ид: " + userIdForFileText);

        driver.findElement(BTN_RECEIVE_EIGHT).click();
    }
}
