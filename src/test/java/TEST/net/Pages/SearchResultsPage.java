package TEST.net.Pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.WebElement;

public class SearchResultsPage extends PageObject {

    @FindBy(id="firstHeading")
    WebElement firstHeading;

    @FindBy(id ="p-lang-label")
    WebElement languageSection;

    @FindBy(xpath = "//*[@hreflang ='cy' and contains(text(),'Cymraeg') ]")
    WebElement languageWelsh;

    @FindBy(xpath = "//*[@hreflang ='en' and contains(text(),'English') ]")
    WebElement languageEnglish;

    public String validateFirstHeading() {
            String header = firstHeading.getText();
            return header.toString();
    }

    public void changeLanguage(String otherLanguage) {
        languageWelsh.click();
    }
}
