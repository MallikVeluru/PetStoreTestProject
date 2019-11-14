package TEST.net.StepLibs;

import TEST.net.Pages.SearchResultsPage;
import net.thucydides.core.annotations.Screenshots;
import net.thucydides.core.annotations.Step;
import static junit.framework.TestCase.assertTrue;



public class SearchTo {
    SearchResultsPage searchResultsPage;

    @Step("the user validated first heading has {0} ")
    @Screenshots(afterEachStep=true)
    public void validateHeading(String expectedFirstHeading) {
       String actualFirstHeading = searchResultsPage.validateFirstHeading();
        assertTrue(expectedFirstHeading.equalsIgnoreCase(actualFirstHeading));
    }
    @Step("the user change the language to {0} ")
    @Screenshots(afterEachStep=true)
    public void changeToOtherLanguage(String otherLanguage) {
        searchResultsPage.changeLanguage(otherLanguage);
    }
}
