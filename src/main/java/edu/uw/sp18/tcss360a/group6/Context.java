package edu.uw.sp18.tcss360a.group6;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Adam G. Cannon, Josh Atherton, Tam Bui, Evan Lindsay
 * @version 5/1/2018
 */
public class Context {

    private Map<String, Object> data = new HashMap<>();

    public boolean has(String key) {
        return this.data.containsKey(key.toLowerCase());
    }

    public Object set(String key, Object value) {
        return this.data.put(key, value);
    }

    public Object unset(String key) {
        return this.data.remove(key);
    }

    public Object get (String key) {
        return this.data.get(key);
    }

    public <T> T get(String key, Class<T> type) {
        Object value = this.data.get(key);
        T out = null;
        if (type.isAssignableFrom(value.getClass()))
            out = type.cast(value);
        return out;
    }

}
