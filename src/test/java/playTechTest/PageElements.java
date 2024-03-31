package playTechTest;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PageElements {

    @FindBy(xpath = "/html/body/header/div/a")
    protected WebElement homePageButton;

    @FindBy(xpath = "/html/body/header/div/nav/a[1]")
    protected WebElement whoWeArePageButton;

    @FindBy(xpath = "/html/body/main/section[4]/div/h2")
    protected WebElement globalPresenceTitle;

    @FindBy(xpath = "/html/body/header/div/div/div")
    protected WebElement languageSwitcher;

    @FindBy(xpath = "/html/body/header/div/div/div/div[2]/a")
    protected WebElement etLanguageButton;

    protected PageElements() {
        PageFactory.initElements(PlayTechTest.webDriver, this);
    }
}

