package com.test.stepDepfs;

import com.test.pages.CommonPages.BasePage;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

//import static com.test.stepDepfs.SharedContext.scn;
import static io.restassured.RestAssured.*;
import io.restassured.http.ContentType;
import io.restassured.http.Cookies;
import io.restassured.http.Header;
import io.restassured.response.Response;
import org.json.simple.JSONObject;

public class getBookinSD extends BasePage {
    Scenario scenario;

    public getBookinSD(SharedContext context) {
        scenario=context.getScn();
    }

    @Given("I will hit the get request")
    public void iWillHitTheGetRequest() {
        Response response=(Response) (getMap("respofcreatebooking"));
       String bookingid= response.jsonPath().get("bookingid").toString();
       Response respOfgetbooking= given()
                .baseUri("https://restful-booker.herokuapp.com/")
                .contentType(ContentType.JSON)
                .pathParams("bookingid",bookingid)
                .log().all().
                when()
                .get("booking/{bookingid}");
        //scn.log((respOfgetbooking.getBody().asPrettyString()));
       // Scenario sc= (Scenario) getMap("Scenario");

        scenario.log(respOfgetbooking.getBody().asPrettyString());
        System.out.println(Thread.currentThread().getId()+"............."+scenario.getName());
    }
    @Then("I will verify the respose")
    public void iWillVerifyTheRespose() {

        System.out.println(getMap("scName"));
        System.out.println(Thread.currentThread().getId()+".........."+getMap("first"));
    }


}
