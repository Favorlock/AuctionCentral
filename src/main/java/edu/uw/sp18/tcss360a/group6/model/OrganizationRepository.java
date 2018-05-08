package edu.uw.sp18.tcss360a.group6.model;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
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
public class OrganizationRepository implements Repository<Organization> {

    public static final String DEFAULT_RESOURCE_NAME = "organizations.json";

    private static final Gson GSON = new GsonBuilder()
            .excludeFieldsWithoutExposeAnnotation()
            .serializeNulls()
            .registerTypeAdapterFactory(new GsonJava8TypeAdapterFactory())
            .registerTypeAdapter(User.class, new UserDeserializer())
            .create();

    @Expose
    private long index = 0;

    @Expose
    private List<Organization> entries;

    private File file;

    public OrganizationRepository() {
        this.entries = new ArrayList<>();
    }

    @Override
    public List<Organization> fetchAll() {
        return new ArrayList<>(this.entries);
    }

    @Override
    public void add(Organization entry) {
        entry.id = this.index++;
        this.entries.add(entry);
    }

    private void __init(File file) {
        this.file = file;
    }

    public static OrganizationRepository load(boolean saveDefaultsIfMissing) {
        File file = new File(".", DEFAULT_RESOURCE_NAME);
        if (saveDefaultsIfMissing) {
            ResourceUtil.saveResource(DEFAULT_RESOURCE_NAME, file, false);
        }

        OrganizationRepository repository = null;

        try {
            if (file.exists()) {
                repository = GSON.fromJson(new FileReader(file), OrganizationRepository.class);
            } else {
                repository = new OrganizationRepository();
            }

            repository.__init(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return repository;
    }
}
