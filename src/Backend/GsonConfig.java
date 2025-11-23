/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Backend;

import com.google.gson.*;
import java.lang.reflect.Type;


/**
 *
 * @author Khaled
 */
public class GsonConfig {
    public static Gson createGson() {
        GsonBuilder builder = new GsonBuilder().setPrettyPrinting();
        builder.registerTypeAdapter(User.class, new JsonDeserializer<User>() {
            @Override
            public User deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
                JsonObject obj = json.getAsJsonObject();
                JsonElement roleEl = obj.get("role");

                String role = roleEl != null && !roleEl.isJsonNull() ? roleEl.getAsString() : null;

                if ("student".equalsIgnoreCase(role)) {
                    return context.deserialize(json, Student.class);
                } else if ("instructor".equalsIgnoreCase(role)) {
                    return context.deserialize(json, Instructor.class);
                } else {
                    return context.deserialize(json, User.class);
                }
            }
        });

        return builder.create();
    }
}
