package TEST.net.Pages;

import TEST.net.StepLibs.NavigateTo;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import java.io.IOException;
import java.io.InputStream;
import java.util.*;

@DefaultUrl("https://www.wikipedia.org")
public class HomePage extends PageObject {

    @FindBy(id = "searchInput")
    WebElement inputTextBox;
    @FindBy(id = "jsLangLabel")
    WebElement searchLanguage;
    @FindBy(xpath = "//*[@class='pure-button pure-button-primary-progressive']")
    WebElement searchButton;

    public void searchForAWord(String searchWord) {
        inputTextBox.sendKeys(searchWord);
        searchButton.click();
    }

    public String getDefaultLanguage() {
        return searchLanguage.getText();
    }
}
