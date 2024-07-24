package credit7ua;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.WebDriver;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

public class agisInputCard{
    public static void main(String[] args) throws InterruptedException {
        String browserName = System.getenv("browser");
        System.out.println(browserName);

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

//       browser.get("https://api.credit7.ua/admin/user-blocked/list");
//       browser.get("https://api.credit7.ua/admin/user/91/show");
       browser.get("https://api.credit7.ua/admin/user/2430797/show");

       WebElement userEnterCabninet = browser.findElement(By.xpath("/html/body/div/div[1]/section[2]/div[1]/div[1]/div/div/a[1]/i"));
       userEnterCabninet.click();

        browser.get("https://credit7.ua/client/personal-cabinet/cards");

        WebElement userCards = browser.findElement(By.xpath("/html/body/main/div[1]/div/ul/li[3]/a"));
        userCards.click();

        WebElement userAddCards = browser.findElement(By.linkText("Додати нову картку"));
        userAddCards.click();
        List<String> tabs = new ArrayList<>(browser.getWindowHandles());
        browser.switchTo().window(tabs.get(0));
        WebElement checkNumberCards = browser.findElement(By.xpath("//*[@id=\"add-card-form\"]/div[1]/input"));
        checkNumberCards.click();
        checkNumberCards.sendKeys(fakeNumberCards.generateNumber());
        WebElement cardEnter = browser.findElement(By.xpath("//*[@id=\"add-card-form\"]/div[2]/input"));
        cardEnter.click();
        checkNumberCards.clear();
        checkNumberCards.sendKeys("3333333333333333");
        cardEnter.click();
        checkNumberCards.clear();
        checkNumberCards.sendKeys("4444444444444444");
        cardEnter.click();
        checkNumberCards.clear();
        checkNumberCards.sendKeys("5555555555555555");
        cardEnter.click();
        checkNumberCards.clear();
        checkNumberCards.sendKeys("6666666666666666");
        cardEnter.click();
        checkNumberCards.clear();
        checkNumberCards.sendKeys("7777777777777777");
        cardEnter.click();
        checkNumberCards.clear();
        checkNumberCards.sendKeys("8888888888888888");
        cardEnter.click();
        checkNumberCards.clear();
        checkNumberCards.sendKeys("9999999999999999");
        cardEnter.click();
        checkNumberCards.clear();


    }

    static RemoteWebDriver getDriver(String driverName) {
        switch (driverName) {
            case "chrome":
                return new ChromeDriver();
            default:
                throw new IllegalArgumentException("I don't have such driver");
        }
    }
}
