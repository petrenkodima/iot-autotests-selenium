package iot.actions;

import org.openqa.selenium.By;

public class IotAdminSelectors {
    public final static By H1_MAIN_HEADING_TEXT = By.xpath("//b[text()='Доступное для пользователей c ролями ADMIN & USER']");
    public final static By INPUT_USER_ROLE = By.xpath("//input[@id=\"userRole\"]");
    public final static By INPUT_USER_ID = By.xpath("//input[@id=\"userId\"]");
    public final static By INPUT_FILE_USER_ID = By.xpath("//input[@id=\"fileUserId\"]");
    public final static By INPUT_FILE_ID = By.xpath("//input[@id=\"fileId\"]");
    public final static By INPUT_FILE = By.xpath("//input[@id=\"file\"]");
    public final static By INPUT_USER_ID_FOR_FILE = By.xpath("//input[@id=\"userIdForFile\"]");
    public final static By INPUT_NEW_USER_LOGIN = By.xpath("//input[@id=\"newUserLogin\"]");
    public final static By INPUT_NEW_USER_PASSWORD = By.xpath("//input[@id=\"newUserPass\"]");
    public final static By BTN_RECEIVE_THREE = By.xpath("//div[2]//section[2]//form[1]/div[2]//b");
    public final static By BTN_RECEIVE_FOUR = By.xpath("//div[2]//section[2]//form[2]/div[2]//b");
    public final static By BTN_RECEIVE_FIVE = By.xpath("//div[2]//section[2]//form[3]/div[2]//b");
    public final static By BTN_RECEIVE_SIX = By.xpath("//div[2]//section[2]//form[4]/div[2]//b");
    public final static By BTN_RECEIVE_SEVEN = By.xpath("//div[2]//section[2]//form[5]/div[2]//b");
    public final static By BTN_RECEIVE_EIGHT = By.xpath("//div[2]//section[2]//form[6]//div[3]//b");
}
