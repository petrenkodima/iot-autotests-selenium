package iot.actions;

import org.openqa.selenium.By;

public class IotUserAndAdminSelectors {
    public final static By H1_MAIN_HEADING_TEXT = By.xpath("//b[text()='Доступное для пользователей c ролями ADMIN & USER']");
    public final static By INPUT_USER_LOGIN = By.xpath("//input[@id='userLogin']");
    public final static By BTN_RECEIVE_ONE = By.xpath("//section[1]//form[1]/div[2]//b");
    public final static By BTN_RECEIVE_TWO = By.xpath("//section[1]//form[2]/div[2]//b");

}
