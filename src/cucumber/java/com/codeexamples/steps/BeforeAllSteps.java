package com.codeexamples.steps;

import com.codeexamples.Application;
import com.codeexamples.utils.PortScanner;
import cucumber.api.java.Before;

public class BeforeAllSteps {

  private static boolean serverStarted = false;

  @Before
  public void setup() throws Exception {
    if (!serverStarted) {
      Application.main(new String[]{"--server.port=" + PortScanner.getPort()});
      serverStarted = true;
    }
  }
}
