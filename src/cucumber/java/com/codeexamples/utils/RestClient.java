package com.codeexamples.utils;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.specification.RequestSpecification;

public class RestClient {
  private static String protocol = "http";
  private static String host = "localhost";

  public static RequestSpecification newClient() {
    return RestAssured.given()
      .baseUri(protocol + "://" + host + ":" + PortScanner.getPort())
      .contentType(ContentType.JSON);
  }
}
