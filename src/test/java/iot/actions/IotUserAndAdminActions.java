package iot.actions;

import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import iot.IotAbstractActions;

import static iot.actions.IotUserAndAdminSelectors.*;

/**
 * Класс для выполнения действий администратора и пользователя.
 */
@Slf4j
public class IotUserAndAdminActions extends IotAbstractActions {

    /**
     * Конструктор класса.
     *
     * @param driver объект WebDriver для управления браузером.
     */
    public IotUserAndAdminActions(WebDriver driver) {
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
     * Метод для получения информации о пользователе.
     *
     * @param userLogin логин пользователя.
     */
    public void getUserInformation(String userLogin) {
        log.info("Get user information");
        driver.findElement(INPUT_USER_LOGIN).sendKeys(userLogin);

        WebElement userLoginEl = driver.findElement(INPUT_USER_LOGIN);
        String userLoginText = userLoginEl.getText();
        System.out.println("Логин: " + userLoginText);

        driver.findElement(BTN_RECEIVE_ONE).click();
    }

    /**
     * Метод для клика на кнопку "Получить всех пользователей".
     */
    public void clickButtonGetAllUsers() {
        driver.findElement(BTN_RECEIVE_TWO).click();
    }

    /**
     * Метод для вызова контекстного меню при наведении на элемент.
     *
     * @param findAttr селектор элемента, на который надо навести.
     */
    public void callContextMenu(By findAttr) {
        log.info("Действие", findAttr);
        Actions actions = new Actions(driver);
        WebElement tdEl = driver.findElements(findAttr).stream().findAny().orElse(null);
        actions.moveToElement(tdEl).build().perform();
    }
}
