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
public class BidRepository implements CollectionRepository<Bid> {

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

    public BidRepository() {
        this.entries = new ArrayList<>();
    }

    @Override
    public List<Bid> fetchAll() {
        return new ArrayList<>(this.entries);
    }

    @Override
    public void add(Bid entry) {
        entry.id = this.index++;
        this.entries.add(entry);
        this.save();
    }

    @Override
    public void delete(Bid entry) {
        this.entries.removeIf(bid -> bid.getId() == entry.getId());
        entry.id = this.index--;
        save();
    }

    @Override
    public void save() {
        String json = GSON.toJson(this);
        FileUtil.saveJson(this.file, json);
    }


    private void __init(File file) {
        this.file = file;
    }

    public static BidRepository load(boolean saveDefaultsIfMissing) {
        File file = new File(".", DEFAULT_RESOURCE_NAME);
        if (saveDefaultsIfMissing) {
            ResourceUtil.saveResource(DEFAULT_RESOURCE_NAME, file, false);
        }

        BidRepository repository = null;

        try {
            if (file.exists()) {
                repository = GSON.fromJson(new FileReader(file), BidRepository.class);
            } else {
                repository = new BidRepository();
            }

            repository.__init(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return repository;
    }
}
