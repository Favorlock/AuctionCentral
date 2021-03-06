package edu.uw.sp18.tcss360a.group6;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Adam G. Cannon, Josh Atherton, Tam Bui, Evan Lindsay
 * @version 5/1/2018
 */
public class Context {

    private Map<String, Object> data;

    public Context() {
        this.data = new HashMap<>();
    }

    public Context(Context context, String... keysToCopy) {
        this();
        for (String key : keysToCopy) {
            if (context.has(key)) {
                set(key, context.get(key));
            }
        }
    }

    public boolean has(String key) {
        return this.data.containsKey(key.toLowerCase());
    }

    public Object set(String key, Object value) {
        return this.data.put(key.toLowerCase(), value);
    }

    public Object unset(String key) {
        return this.data.remove(key.toLowerCase());
    }

    public Object get (String key) {
        return this.data.get(key.toLowerCase());
    }

    public <T> T get(String key, Class<T> type) {
        Object value = this.data.get(key.toLowerCase());
        T out = null;
        if (value != null && type.isAssignableFrom(value.getClass()))
            out = type.cast(value);
        return out;
    }

}
