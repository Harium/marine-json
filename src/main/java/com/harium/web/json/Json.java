package com.harium.web.json;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;

public class Json {

    private static Map<Type, Object> adapters = new HashMap<>();

    public static Gson build() {
        GsonBuilder builder = getBuilder();
        return builder.create();
    }

    private static GsonBuilder getBuilder() {
        GsonBuilder builder = new GsonBuilder();
        for (Map.Entry<Type, Object> entry : adapters.entrySet()) {
            builder.registerTypeAdapter(entry.getKey(), entry.getValue());
        }
        return builder;
    }

    public static void registerTypeAdapter(Type type, Object object) {
        adapters.put(type, object);
    }

    public static void clearAdapters() {
        adapters.clear();
    }

    public static String toJson(Object object) {
        Gson gson = build();
        return gson.toJson(object);
    }

    public static Object fromJson(String json, Type typeOf) {
        Gson gson = build();
        return gson.fromJson(json, typeOf);
    }
}
