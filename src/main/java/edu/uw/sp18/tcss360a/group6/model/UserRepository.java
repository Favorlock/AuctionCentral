package edu.uw.sp18.tcss360a.group6.model;

import com.google.gson.*;
import com.google.gson.annotations.Expose;
import edu.uw.sp18.tcss360a.group6.gson.UserDeserializer;
import edu.uw.sp18.tcss360a.group6.util.ResourceUtil;
import net.dongliu.gson.GsonJava8TypeAdapterFactory;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Adam G. Cannon, Josh Atherton, Tam Bui, Evan Lindsay
 * @version 5/1/2018
 */
public class UserRepository implements Repository<User> {

    public static final String DEFAULT_RESOURCE_NAME = "users.json";

    private static final Gson GSON = new GsonBuilder()
            .excludeFieldsWithoutExposeAnnotation()
            .serializeNulls()
            .registerTypeAdapterFactory(new GsonJava8TypeAdapterFactory())
            .registerTypeAdapter(User.class, new UserDeserializer())
            .create();

    @Expose
    private long index = 0;

    @Expose
    private List<User> entries;

    private File file;

    public UserRepository() {
        this.entries = new ArrayList<>();
    }

    @Override
    public List<User> fetchAll() {
        return new ArrayList<>(this.entries);
    }

    public User fetchUser(String name) {
        return fetchAll().stream()
                .filter(user -> user.getUserName().equalsIgnoreCase(name))
                .findFirst().orElse(null);
    }

    @Override
    public void add(User entry) {
        if (entry instanceof AbstractUser) {
            ((AbstractUser) entry).id = this.index++;
        }
        this.entries.add(entry);
    }

    private void __init(File file) {
        this.file = file;
    }

    public static UserRepository load(boolean saveDefaultsIfMissing) {
        File file = new File(".", DEFAULT_RESOURCE_NAME);
        if (saveDefaultsIfMissing) {
            ResourceUtil.saveResource(DEFAULT_RESOURCE_NAME, file, false);
        }

        UserRepository repository = null;

        try {
            if (file.exists()) {
                repository = GSON.fromJson(new FileReader(file), UserRepository.class);
            } else {
                repository = new UserRepository();
            }

            repository.__init(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return repository;
    }
}
