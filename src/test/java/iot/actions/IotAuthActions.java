package iot.actions;

import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import iot.IotAbstractActions;

/**
 * Класс для выполнения действий аутентификации.
 */
@Slf4j
public class IotAuthActions extends IotAbstractActions {

    /**
     * Конструктор класса.
     *
     * @param driver объект WebDriver для управления браузером.
     */
    public IotAuthActions(WebDriver driver) {
        super(driver);
    }

    /**
     * Метод для выполнения входа с корректными данными.
     *
     * @param userName     имя пользователя.
     * @param userPassword пароль пользователя.
     */
    public void loginWithValidCred(String userName, String userPassword) {
        log.info("Логин: ", userName, " Пароль: ", userPassword);
        driver.findElement(IotAuthSelectors.INPUT_LOGIN).sendKeys(userName);
        driver.findElement(IotAuthSelectors.INPUT_PASSWORD).sendKeys(userPassword);
        driver.findElement(IotAuthSelectors.BTN_SIGN_IN).click();
    }

    /**
     * Метод для выполнения выхода из системы.
     */
    public void logoutWithValidCred() {
        driver.findElement(IotAuthSelectors.BTN_SIGN_OUT).click();
    }

    /**
     * Метод для получения текста заголовка главной страницы после входа.
     *
     * @return текст заголовка страницы приветствия.
     */
    public String getWelcomeHeadingText() {
        log.info("Get the page title Welcome");
        WebElement welcomeHeadingTextEl = driver.findElement(IotAuthSelectors.H1_WELCOME_HEADING_TEXT);
        String headingText = welcomeHeadingTextEl.getText();
        System.out.println("Заголовок страницы авторизации: " + headingText);
        return headingText;
    }
}
