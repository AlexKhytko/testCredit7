package api3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

public class api3EnterAdmin {
    public static void main(String[] args) throws InterruptedException {
        String browserName = System.getenv("browser");
        System.out.println(browserName);

        String userValue = "powar";
        String passwordValue = "showmethemoney";

        RemoteWebDriver browser = getDriver(args[0]);
        browser.get("https://api3.uashort.agis.work/admin/");


        browser.manage().window().maximize();
        System.out.println(browser.getTitle());

        WebElement userName = browser.findElement(By.id("username"));
        userName.click();
        userName.sendKeys(userValue);

        WebElement userPass = browser.findElement(By.id("password"));
        userPass.click();
        userPass.sendKeys(passwordValue);

        WebElement userEnter = browser.findElement(By.id("submit"));
        userEnter.click();
    }

        static RemoteWebDriver getDriver (String driverName){
            switch (driverName) {
                case "chrome":
                    return new ChromeDriver();
                default:
                    throw new IllegalArgumentException("I don't have such driver");
            }
        }
    }


