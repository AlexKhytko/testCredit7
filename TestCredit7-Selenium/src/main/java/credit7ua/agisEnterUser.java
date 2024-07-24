package credit7ua;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class agisEnterUser {

    public static void main(String[] args) throws InterruptedException {
        String browserName = System.getenv("browser");
        System.out.println(browserName);

//        String numberValue = "0672790993";
//        String numberValue = "0500578168";
        String numberValue = "0974853967";

        String userValue = "a.khitko";
        String passwordValue = "Tmfhy,_64nsR";

        RemoteWebDriver browser = getDriver(args[0]);
        browser.get("https://api.credit7.ua/admin/login");

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

        WebElement treeAll = browser.findElement(By.linkText("Меню користувач"));
        treeAll.click();

        WebElement treeUserAll = browser.findElement(By.linkText("Всі користувачі"));
        treeUserAll.click();

        WebElement findNumber = browser.findElement(By.cssSelector("#filter_universal_value_field > label:nth-child(2) > div"));
        findNumber.click();
        Thread.sleep(1000);

        WebElement writeNumber = browser.findElement(By.id("filter_universal_value_value"));
        writeNumber.click();
        writeNumber.sendKeys(numberValue);

        WebElement putFilter = browser.findElement(By.cssSelector("button.btn.btn-primary"));
        putFilter.click();
        Thread.sleep(5000);

        WebElement enterCabinet = browser.findElement(By.cssSelector("body > div.wrapper > div.content-wrapper > section.content > div:nth-child(2) > div > form > div > div.box-body.table-responsive.no-padding > table > tbody > tr:nth-child(1) > td.sonata-ba-list-field.sonata-ba-list-field-actions > div > a.btn.btn-sm.btn-default.view_link > i"));
        enterCabinet.click();


        WebElement enterWeb = browser.findElement(By.cssSelector("body > div > div.content-wrapper > section.content > div.row > div:nth-child(1) > div > div > a:nth-child(1)"));
        enterWeb.click();

        WebElement enterPersonal = browser.findElement(By.cssSelector(".navbar-header__nav-list > li:nth-child(4) > a:nth-child(1)"));
        enterPersonal.click();
            }

    static RemoteWebDriver getDriver(String driverName) {
        switch (driverName) {
            case "chrome":
                return new ChromeDriver();
            case "firefox":
                return new FirefoxDriver();
            default:
                throw new IllegalArgumentException("I don't have such driver");
        }
    }
}
