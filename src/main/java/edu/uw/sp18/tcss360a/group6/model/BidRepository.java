package edu.uw.sp18.tcss360a.group6.model;

import com.google.gson.*;
import com.google.gson.reflect.TypeToken;
import edu.uw.sp18.tcss360a.group6.Bid;

import java.io.*;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class BidRepository implements Repository<Bid> {

    private static final Gson GSON = new GsonBuilder()
            .excludeFieldsWithoutExposeAnnotation()
            .serializeNulls()
            .create();

    private static final String INDEX_KEY = "index";

    private static final String ENTRIES_KEY = "entries";

    private static final Type ENTRIES_TYPE = new TypeToken<List<Bid>>(){}.getType();

    private long index = 0;

    private List<Bid> entries;

    private File file;

    public BidRepository(File file) {
        this.file = file;
        __init(file);
    }

    private void __init(File file) {
        try (FileReader reader = new FileReader(file)) {
            JsonParser parser = new JsonParser();
            JsonElement element = parser.parse(reader);

            if (element.isJsonObject()) {
                JsonObject root = element.getAsJsonObject();
                if (root.has(INDEX_KEY)) {
                    this.index = root.get(INDEX_KEY).getAsLong();
                }

                if (root.has(ENTRIES_KEY)) {
                    JsonElement entries = root.get(ENTRIES_KEY);
                    this.entries = GSON.fromJson(entries, ENTRIES_TYPE);
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Bid> fetchAll() {
        return new ArrayList<>(this.entries);
    }
}
