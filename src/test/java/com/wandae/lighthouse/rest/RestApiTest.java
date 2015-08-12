package com.wandae.lighthouse.rest;

import static org.hamcrest.core.StringEndsWith.endsWith;
import static org.junit.Assert.assertThat;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response.Status;

import org.junit.Test;

import com.jayway.restassured.RestAssured;
import com.wandae.lighthouse.ArquillianClientTest;

public class RestApiTest extends ArquillianClientTest {

    @Test
    public void registerRelay() {
        // register relay endpoint
        String endpointSuffix = "/registerClient";
        String result = RestAssured.given().contentType(MediaType.TEXT_PLAIN).body(endpointSuffix).then()
                                   .statusCode(Status.CREATED.getStatusCode()).when().post(base).header("Location");
        // get relay endpoint
        String relayUrl =  RestAssured.given().then().contentType(MediaType.TEXT_PLAIN).statusCode(Status.OK.getStatusCode()).when()
                   .get(result).body().asString();
        
        assertThat(relayUrl, endsWith(endpointSuffix));
        
    }

}
