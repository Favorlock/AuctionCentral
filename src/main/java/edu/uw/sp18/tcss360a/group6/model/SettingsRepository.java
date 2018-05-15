package edu.uw.sp18.tcss360a.group6.model;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.annotations.Expose;
import edu.uw.sp18.tcss360a.group6.util.FileUtil;
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
public class SettingsRepository implements SingletonRepository<Settings> {

    public static final String DEFAULT_RESOURCE_NAME = "settings.json";

    private static final Gson GSON = new GsonBuilder()
            .excludeFieldsWithoutExposeAnnotation()
            .serializeNulls()
            .registerTypeAdapterFactory(new GsonJava8TypeAdapterFactory())
            .create();

    private Settings instance;

    private File file;

    @Override
    public Settings fetch() {
        return this.instance;
    }

    @Override
    public void save() {
        String json = GSON.toJson(this.instance);
        FileUtil.saveJson(this.file, json);
    }

    private void __init(File file) {
        this.file = file;
    }

    public static SettingsRepository load(boolean saveDefaultsIfMissing) {
        File file = new File(".", DEFAULT_RESOURCE_NAME);
        if (saveDefaultsIfMissing) {
            ResourceUtil.saveResource(DEFAULT_RESOURCE_NAME, file, false);
        }

        SettingsRepository repository = new SettingsRepository();

        try {
            if (file.exists()) {
                repository.instance = GSON.fromJson(new FileReader(file), Settings.class);
            } else {
                repository.instance = new Settings();
            }

            repository.__init(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return repository;
    }
}
