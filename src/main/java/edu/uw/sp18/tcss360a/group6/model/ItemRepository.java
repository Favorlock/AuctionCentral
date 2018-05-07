package edu.uw.sp18.tcss360a.group6.model;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.annotations.Expose;
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
public class ItemRepository implements Repository<Item> {

    public static final String DEFAULT_RESOURCE_NAME = "items.json";

    private static final Gson GSON = new GsonBuilder()
            .excludeFieldsWithoutExposeAnnotation()
            .serializeNulls()
            .registerTypeAdapterFactory(new GsonJava8TypeAdapterFactory())
            .create();

    @Expose
    private long index = 0;

    @Expose
    private List<Item> entries;

    private File file;

    private void __init(File file) {
        this.file = file;
    }

    @Override
    public List<Item> fetchAll() {
        return new ArrayList<>(this.entries);
    }

    public static ItemRepository load() {
        File file = new File(".", DEFAULT_RESOURCE_NAME);
        ResourceUtil.saveResource(DEFAULT_RESOURCE_NAME, file, false);

        ItemRepository repository = null;

        try {
            repository = GSON.fromJson(new FileReader(file), ItemRepository.class);
            repository.__init(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return repository;
    }
}
