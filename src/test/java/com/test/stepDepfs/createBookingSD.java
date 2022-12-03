package com.test.stepDepfs;

import com.test.pages.CommonPages.BasePage;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.plugin.event.Node;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

//import static com.test.stepDepfs.SharedContext.scn;
import static io.restassured.RestAssured.*;

public class createBookingSD extends BasePage {
    Response respofcreatebooking;
    JsonPath resonseofcreatebooking;
    String bookingid;
    Scenario scenario;
    //Scenario scenario;
    Scenario sc;
    public createBookingSD(SharedContext context) {
        scenario=context.getScn();
    }


    @Given("I will hit the post request")
    public void iWillHitThePostRequest() throws IOException, ParseException {

        JSONParser parser = new JSONParser();
        JSONObject jsonobj = (JSONObject) parser.parse(new FileReader("src/test/resources/TestData/createbookingbody.json"));
        respofcreatebooking = given()
                .baseUri("https://restful-booker.herokuapp.com/")
                .contentType(ContentType.JSON)
                .body(jsonobj)
                .log().all().
                when()
                .post("booking");

        //scn.log(respofcreatebooking.getBody().asPrettyString());
        setMap("respofcreatebooking",respofcreatebooking);
     //  Scenario sc= (Scenario) getMap("Scenario");
       /* Scenario s=(Scenario)(getMap("Scenario"));
        sc=s;
        sc.log(sc.getName());*/

      // sc.log(respofcreatebooking.getBody().asPrettyString());
        System.out.println(("the value is="+getMap("scName")));
       scenario.log(respofcreatebooking.getBody().asPrettyString());
        System.out.println(Thread.currentThread().getId()+"............."+scenario.getName());
    }

    @Then("I will verify the respose of createbooking")
    public void iWillVerifyTheResposeOfCreatebooking() {
        resonseofcreatebooking = respofcreatebooking.jsonPath();
        bookingid = resonseofcreatebooking.get("bookingid").toString();
        resonseofcreatebooking.get("booking.bookingdates.checkin");
        System.out.println( "the checkinvalie"+resonseofcreatebooking.get("booking.bookingdates.checkin").toString());
    }

    @Given("I will hit the put request")
        public void iWillVerifyput() {
            setMap("first","diwakar");
    }
    @Given("I will hit the head request")
    public void iWillVerifyhead() {
        setMap("first","kumar");
    }
}