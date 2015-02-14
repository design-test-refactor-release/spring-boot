package com.codeexamples.utils;

import com.jayway.restassured.response.Response;

import java.util.HashMap;
import java.util.Map;

public class StoryContext {
  private static Response response;
  private static Map<String, Object> context = new HashMap<>();

  public static void put(Response response) {
    StoryContext.response = response;
  }

  public static Response get() {
    return response;
  }

  public static <T> T get(String key, Class<T> clazz) {
    return (T) context.get(key);
  }

  public static void put(String key, Object object) {
    context.put(key, object);
  }

  public static String getString(String key) {
    return (String) context.get(key);
  }
}
