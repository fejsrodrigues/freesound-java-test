package com.github.fejsrodrigues.core;

import com.github.fejsrodrigues.config.Configuration;
import com.github.fejsrodrigues.config.ConfigurationManager;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class ClientToken {

    public static String getToken() {
        Configuration configuration = ConfigurationManager.getConfiguration();
        if (!configuration.apiTokenEnable()) {
            Response response = RestAssured.given().
                    spec(specToken()).
                    when().
                    log().all().
                    formParam("client_id", configuration.clientId()).
                    formParam("client_secret").
                    formParam("grant_type", configuration.grantTyope()).
                    formParam("code", configuration.code()).
                    post("/apiv2/oauth2/access_token");
            JsonPath body = response.jsonPath();

            return body.getString("access_token");

        }else{
            return configuration.apiToken();
        }


    }

    private static RequestSpecification specToken() {
        Configuration configuration = ConfigurationManager.getConfiguration();
        return new RequestSpecBuilder().
                setBaseUri(configuration.baseURI()).
                setContentType(ContentType.URLENC).
                build();
    }

}
