package TEST.net;

import TEST.net.StepLibs.NavigateTo;
import TEST.net.StepLibs.PetsStoreApiTo;
import TEST.net.StepLibs.SearchTo;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.response.Response;
import net.thucydides.core.annotations.Steps;

import static org.junit.Assert.assertTrue;

public class TestSteps {

    @Steps
    NavigateTo navigateTo;
    @Steps
    SearchTo searchTo;
    @Steps
    PetsStoreApiTo petsStoreApiTo;
    Response petStatusResponse;
    @Given("the user navigated to wikipedia")
    public void the_user_navigated_to_wikipedia() {
        navigateTo.wikipediaHomePage();
    }

    @When("the user search for a {string} in english")
    public void the_user_search_for_a_given_word_in_english(String searchWord) {
        navigateTo.verifyDefaultLanguage();
        navigateTo.searchForWord(searchWord);
    }

    @Then("the user validate {string} in search result")
    public void the_user_validate_given_word_in_search_result(String firstHeading) {
        searchTo.validateHeading(firstHeading);
    }
    @And("the user change to {string} and validate {string}")
    public void the_User_Change_To_Other_language_And_Validate(String otherLanguage, String givenWordInOtherLanguage) {
        searchTo.changeToOtherLanguage(otherLanguage);
        searchTo.validateHeading( givenWordInOtherLanguage );
    }
//API Steps
    @Given("the user checks for pet store")
    public void the_User_Checks_For_Pet_store() {
        boolean currentStatus = (petsStoreApiTo.currentStatus());
        assertTrue(currentStatus);
    }

    @When("the user request to find the {string}")
    public void the_User_Request_To_Find_The_Pets_Status(String petStatus) {
        petStatusResponse = petsStoreApiTo.requestForPetsResponse(petStatus);
    }

    @Then("the user validate {string} of {string} and {string}")
    public void the_User_Validate_Number_Of_Pets_status_And_Pet_name(String number, String petStatus, String petName) {
        int givenPetcount = petsStoreApiTo.getGivenPetNameCount(petStatusResponse,petName );
        petsStoreApiTo.verifyGivenPetNameCountInResponse(givenPetcount, number);
    }

    }
