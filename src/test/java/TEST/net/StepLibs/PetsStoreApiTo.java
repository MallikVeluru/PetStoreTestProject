package TEST.net.StepLibs;

import TEST.net.Pages.PetsStoreApi;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import net.serenitybdd.core.Serenity;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.annotations.Step;

import java.util.List;

@DefaultUrl("https://petstore.swagger.io.v2")
public class PetsStoreApiTo {
    PetsStoreApi petsStoreApi;
   // String baseURL = DefaultUrl;
    @Step("the user checking service is running")
    public boolean currentStatus() {
        int statusCode = RestAssured.get("https://petstore.swagger.io").statusCode();
        return (statusCode == 200) ? true : false;
    }
    @Step("the User request for pet status = {0}")
    public Response requestForPetsResponse(String petStatus) {
        Response response = petsStoreApi.getPetsByStatus(petStatus);
        return response;
    }
    @Step("the User get {1} count from response")
    public int getGivenPetNameCount(Response petStatusResponse, String petName) {
        int count = 0;
        List<Object> jsonPetNamesList = petStatusResponse.jsonPath().getList( "name" );
        //List<Object> jsonPetsList = response.jsonPath().getList("$");

        for (int i = 0; i < jsonPetNamesList.size(); i++) {
            if (jsonPetNamesList.get( i ) != null) {
                if (jsonPetNamesList.get( i ).equals( petName )) {
                    count++;
                }
            }
        }
        return count;
    }
    @Step("the user validate pet number as {0}")
    public void verifyGivenPetNameCountInResponse(int givenPetCount, String number) {
            if( String.valueOf(givenPetCount)== number){
                Serenity.recordReportData().withTitle( "Number of Pets Name doggie matching " ).andContents( String.valueOf( givenPetCount ) );
            }
    else{
                Serenity.recordReportData().withTitle( "Number of Pets Name doggie not matching" ).andContents( String.valueOf( givenPetCount ) );

            }
     }
}
