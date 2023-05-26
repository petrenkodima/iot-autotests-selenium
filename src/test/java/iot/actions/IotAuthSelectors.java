package iot.actions;

import org.openqa.selenium.By;

public class IotAuthSelectors {
    public final static By INPUT_LOGIN = By.xpath("//input[@id='floatingInput']");
    public final static By INPUT_PASSWORD = By.xpath("//input[@id='floatingPassword']");
    public final static By BTN_SIGN_IN = By.xpath("//div[@class=\"container-login100-form-btn\"]");
    public final static By BTN_SIGN_OUT = By.xpath("/html/body/div[2]/img");
    public final static By H1_WELCOME_HEADING_TEXT = By.xpath("//b[text()='Добро пожаловать!']");

}
