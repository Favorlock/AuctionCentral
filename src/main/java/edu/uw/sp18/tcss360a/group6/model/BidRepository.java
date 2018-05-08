package edu.uw.sp18.tcss360a.group6.model;

import com.google.gson.*;
import com.google.gson.annotations.Expose;
import edu.uw.sp18.tcss360a.group6.util.ResourceUtil;
import net.dongliu.gson.GsonJava8TypeAdapterFactory;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Adam G. Cannon, Josh Atherton, Tam Bui, Evan Lindsay
 * @version 5/1/2018
 */
public class BidRepository implements Repository<Bid> {

    public static final String DEFAULT_RESOURCE_NAME = "bids.json";

    private static final Gson GSON = new GsonBuilder()
            .excludeFieldsWithoutExposeAnnotation()
            .serializeNulls()
            .registerTypeAdapterFactory(new GsonJava8TypeAdapterFactory())
            .create();

    @Expose
    private long index = 0;

    @Expose
    private List<Bid> entries;

    private File file;

    private void __init(File file) {
        this.file = file;
    }

    @Override
    public List<Bid> fetchAll() {
        return new ArrayList<>(this.entries);
    }

    @Override
    public void add(Bid entry) {
        entry.id = this.index++;
        this.entries.add(entry);
    }

    public static BidRepository load() {
        File file = new File(".", DEFAULT_RESOURCE_NAME);
        ResourceUtil.saveResource(DEFAULT_RESOURCE_NAME, file, false);

        BidRepository repository = null;

        try {
            repository = GSON.fromJson(new FileReader(file), BidRepository.class);
            repository.__init(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return repository;
    }
}
