package TEST.net.Pages;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.parsing.Parser;
import io.restassured.response.Response;
import net.thucydides.core.pages.PageObject;

import static io.restassured.RestAssured.given;

public class PetsStoreApi extends PageObject {

    Response response;

Response str;
Response str2;

    //public String baseUrl = "https://petstore.swagger.io/v2/";
    public String endpoint="https://petstore.swagger.io/v2/pet/findByStatus?status=";


   public Response getPetsByStatus(String peStatus){
        endpoint+=peStatus;
        int statusCode = RestAssured.get(endpoint).statusCode();

        if (statusCode != 200)
            throw new RuntimeException();
        else
        {
            RestAssured.defaultParser = Parser.JSON;
                  response =  given().queryParam("name","doggie" ).headers("Content-Type", ContentType.JSON, "Accept", ContentType.JSON).
                            when().get(endpoint)
                                .then().contentType(ContentType.JSON).extract().response();
        }
        return response;

    }

}
