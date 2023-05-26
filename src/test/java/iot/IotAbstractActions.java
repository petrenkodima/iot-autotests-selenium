package iot;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class IotAbstractActions {
    protected WebDriver driver;

    public IotAbstractActions(WebDriver driver) {
        this.driver = driver;
    }

    public void sleep(long ms){
        try {
            Thread.sleep(ms);
        } catch (InterruptedException var4) {
            throw new RuntimeException("Interrupted", var4);
        }
    }

    public void scrollIntoView(String scroll) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript(scroll, "");
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
