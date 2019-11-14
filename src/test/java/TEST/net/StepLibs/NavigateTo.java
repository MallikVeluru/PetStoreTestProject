package TEST.net.StepLibs;

import TEST.net.Pages.HomePage;
import net.thucydides.core.annotations.Screenshots;
import net.thucydides.core.annotations.Step;

import static org.junit.Assert.assertTrue;

public class NavigateTo {
HomePage homePage;

    @Step("the user browsed Wikipedia.org page")
    @Screenshots(afterEachStep=true)
    public void wikipediaHomePage() {
        homePage.open();
    }
    @Step("the user search for a given word = {0} ")
    @Screenshots(afterEachStep=true)
    public void searchForWord(String searchWord) {
        homePage.searchForAWord(searchWord);
    }
    @Step("the user validated default language as EN} ")
    @Screenshots(afterEachStep=true)
    public void verifyDefaultLanguage() {
       String actualDefaultLanguage=  homePage.getDefaultLanguage();
       assertTrue("EN".equals(actualDefaultLanguage));
    }
}
