package edu.uw.sp18.tcss360a.group6.gson;

import com.google.gson.*;
import edu.uw.sp18.tcss360a.group6.model.AbstractUser;
import edu.uw.sp18.tcss360a.group6.model.User;
import edu.uw.sp18.tcss360a.group6.model.UserType;

import java.lang.reflect.Type;

public class UserDeserializer implements JsonDeserializer<User> {

    private static final String TYPE_FIELD = "type";

    private final Gson gson = new GsonBuilder()
            .create();

    @Override
    public User deserialize(JsonElement json, Type type, JsonDeserializationContext context) throws JsonParseException {
        User user = null;
        if (json.isJsonObject()) {
            JsonObject root = json.getAsJsonObject();
            if (root.has(TYPE_FIELD)) {
                UserType t = gson.fromJson(root.get(TYPE_FIELD).getAsString(), UserType.class);
                if (t == null || t == UserType.UNKNOWN) {
                    user = AbstractUser.INVALID_USER;
                } else {
                    user = gson.fromJson(root, t.getType());
                }
            }
        }
        return user;
    }

}
