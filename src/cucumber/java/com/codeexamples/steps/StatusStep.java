package com.codeexamples.steps;

import com.codeexamples.utils.RestClient;
import com.codeexamples.utils.StoryContext;
import com.jayway.restassured.response.Response;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class StatusStep {

  @Given("^server is started$")
  public void server_is_started() {
    // the server is started
  }

  @When("^user checks the status of the server$")
  public void user_checks_the_status_of_the_server() {
    Response response = RestClient.newClient().get("status");
    StoryContext.put(response);
  }

  @Then("^(\\d+) is returned$")
  public void response_is_returned(int statusCode) {
    assertThat(statusCode, is(StoryContext.get().statusCode()));
  }
}
