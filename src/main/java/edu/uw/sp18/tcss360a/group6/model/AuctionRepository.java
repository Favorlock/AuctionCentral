package edu.uw.sp18.tcss360a.group6.model;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.annotations.Expose;
import edu.uw.sp18.tcss360a.group6.util.ResourceUtil;
import net.dongliu.gson.GsonJava8TypeAdapterFactory;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Store the Auctions in this application.
 *
 * @author Adam G. Cannon, Josh Atherton, Tam Bui, Evan Lindsay
 * @version 5/1/2018
 */
public class AuctionRepository implements Repository<Auction> {

    public static final String DEFAULT_RESOURCE_NAME = "auctions.json";

    private static final Gson GSON = new GsonBuilder()
            .excludeFieldsWithoutExposeAnnotation()
            .serializeNulls()
            .registerTypeAdapterFactory(new GsonJava8TypeAdapterFactory())
            .create();

    @Expose
    private long index = 0;

    @Expose
    private List<Auction> entries;

    private File file;

    private AuctionRepository() {
        this.entries = new ArrayList<>();
    }

    @Override
    public List<Auction> fetchAll() {
        return new ArrayList<>(this.entries);
    }

    public List<Auction> fetchFutureAuctions() {
        return fetchAll().stream()
                .filter(auction -> auction.getStartDate().isAfter(LocalDate.now()))
                .collect(Collectors.toList());
    }

    @Override
    public void add(Auction entry) {
        entry.id = this.index++;
        this.entries.add(entry);
    }

    private void __init(File file) {
        this.file = file;
    }

    public static AuctionRepository load(boolean saveDefaultsIfMissing) {
        File file = new File(".", DEFAULT_RESOURCE_NAME);
        if (saveDefaultsIfMissing) {
            ResourceUtil.saveResource(DEFAULT_RESOURCE_NAME, file, false);
        }

        AuctionRepository repository = null;

        try {
            if (file.exists()) {
                repository = GSON.fromJson(new FileReader(file), AuctionRepository.class);
            } else {
                repository = new AuctionRepository();
            }

            repository.__init(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return repository;
    }
}
