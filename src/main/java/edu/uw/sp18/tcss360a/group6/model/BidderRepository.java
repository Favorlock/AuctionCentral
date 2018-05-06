package edu.uw.sp18.tcss360a.group6.model;

import com.google.gson.*;
import com.google.gson.annotations.Expose;
import edu.uw.sp18.tcss360a.group6.Bidder;
import edu.uw.sp18.tcss360a.group6.util.ResourceUtil;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class BidderRepository implements Repository<Bidder> {

    public static final String DEFAULT_RESOURCE_NAME = "bidders.json";

    private static final Gson GSON = new GsonBuilder()
            .excludeFieldsWithoutExposeAnnotation()
            .serializeNulls()
            .create();

    @Expose
    private long index = 0;

    @Expose
    private List<Bidder> entries;

    private File file;

    private void __init(File file) {
        this.file = file;
    }

    @Override
    public List<Bidder> fetchAll() {
        return new ArrayList<>(this.entries);
    }

    public static BidderRepository load() {
        File file = new File(".", DEFAULT_RESOURCE_NAME);
        ResourceUtil.saveResource(DEFAULT_RESOURCE_NAME, file, false);

        BidderRepository repository = null;

        try {
            repository = GSON.fromJson(new FileReader(file), BidderRepository.class);
            repository.__init(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return repository;
    }
}
