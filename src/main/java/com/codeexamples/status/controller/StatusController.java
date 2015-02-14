package com.codeexamples.status.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StatusController {

  @RequestMapping("/status")
  @ResponseStatus(HttpStatus.OK)
  String status() {
    return "Server is running";
  }
}
