package com.mapbox.api.directions.v5.utils;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;

import java.util.Map;

public class MutateJsonUtil {

  public static void mutateJson(JsonElement element) {
    if (element.isJsonPrimitive() || element.isJsonNull()) {
    } else if (element.isJsonArray()) {
      JsonArray array = (JsonArray) element;
      for (JsonElement item : array) {
        mutateJson(item);
      }
    } else if (element.isJsonObject()) {
      JsonObject object = (JsonObject) element;
      for (Map.Entry<String, JsonElement> field : object.entrySet()) {
        mutateJson(field.getValue());
      }
      addPrimitiveValues(object);
      JsonObject testJsonObject = new JsonObject();
      addPrimitiveValues(testJsonObject);
      object.add("testingObject", testJsonObject);
    }
  }

  private static void addPrimitiveValues(JsonObject object) {
    object.add("testingStringValue", new JsonPrimitive("test"));
    object.add("testingBooleanValue", new JsonPrimitive(true));
    object.add("testingNumberValue", new JsonPrimitive(5));
  }
}
