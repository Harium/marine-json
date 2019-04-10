package com.harium.marine.json;

import org.junit.Assert;
import org.junit.Test;

public class JsonTest {

    @Test
    public void testSimple() {
        int a = 1;
        String json = Json.toJson(a);

        Assert.assertEquals("1", json);
    }

    @Test
    public void testPojo() {
        Pojo pojo = new Pojo();
        String json = Json.toJson(pojo);

        Assert.assertEquals("{\"a\":1,\"c\":\"?\",\"text\":\"abc\"}", json);
    }

    class Pojo {
        int a = 1;
        char c = '?';
        String text = "abc";
    }

}
