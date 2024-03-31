package playTechTest;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class PlayTechTest extends PageElements {

    public static WebDriver webDriver = new ChromeDriver();
    private Actions actions = new Actions(webDriver);

    public PlayTechTest() {
        super();
    }

    @BeforeClass
    public static void setUp() {
        WebDriverManager.chromedriver().setup();
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        webDriver.get("https://playtech.ee/");
    }

    @AfterClass
    public static void closeUp() {
        webDriver.close();
        webDriver.quit();
    }

    @Test
    public void t1estGlobalPresenceTitleDisplayedOnEnglishPage() {
        whoWeArePageButton.click();
        scrollToGlobalPresenceTitle();
        waitForSeconds(1);

        String actualTitle = globalPresenceTitle.getText();
        String expectedTitle = "Global presence";

        assertTrue(globalPresenceTitle.isDisplayed());
        assertEquals(actualTitle, expectedTitle);
    }

    @Test
    public void t2estGlobalPresenceTitleDisplayedOnEstonianPage() {
        homePageButton.click();
        switchToEstonianLanguage();
        whoWeArePageButton.click();
        scrollToGlobalPresenceTitle();
        waitForSeconds(1);

        String actualTitle = globalPresenceTitle.getText();
        String expectedTitle = "Meie asukohad";

        assertTrue(globalPresenceTitle.isDisplayed());
        assertEquals(actualTitle, expectedTitle);
    }



    private void scrollToGlobalPresenceTitle() {
        ((JavascriptExecutor) webDriver).executeScript("window.scrollBy(0, 1000);");
    }

    private void switchToEstonianLanguage() {
        actions.moveToElement(languageSwitcher).perform();
        etLanguageButton.click();
    }

    private void waitForSeconds(int seconds) {
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}