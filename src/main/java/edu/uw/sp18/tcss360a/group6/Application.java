package edu.uw.sp18.tcss360a.group6;

import edu.uw.sp18.tcss360a.group6.io.Console;
import edu.uw.sp18.tcss360a.group6.model.BidRepository;

import java.io.*;
import java.util.List;
import java.util.ArrayList;
import java.util.stream.Collectors;

public class Application {

    private static Application instance;

    private BidRepository bidRepository;

    /**  All registered users of this application. */
    private List<Bidder> listOfUsers = new ArrayList<>();

    private boolean running = true;

    public void start() {
        loadBids();
        System.out.println(this.bidRepository.fetchAll().stream()
                .map(bid -> bid.getId()).collect(Collectors.toList())
                .toString());

        Console console = new Console();

        while (this.running) {
            //login the user
            InterfaceLogin login = new InterfaceLogin();
            String userName = "";
            while ( !(login.isValidUser(userName, listOfUsers)) ) {
                console.printf(login.displayLogin());
                userName = console.readLine();
            }
            //display valid user options based on user

            console.printf("Choose an option\n");
            console.printf("1. Exit\n");
            console.printf("2. option 2\n");

            String line = null;
            while (line == null)
                line = console.readLine();
            switch (line.toLowerCase()) {
                case "1":
                    stop();
                    break;
                case "2":
                    console.printf("you chose option 2...\n");
                    break;
                default:
                    console.printf("Invalid selection...\n");
            }
        }
    }

    public void stop() {
        this.running = false;
    }

    public BidRepository getBidRepository() {
        return bidRepository;
    }

    private void loadBids() {
        String fileName = "bids.json";
        File file = new File(".", fileName);
        if (!file.exists()) {
            try (InputStream in = this.getClass().getClassLoader()
                    .getResourceAsStream(fileName)) {
                try (OutputStream out = new FileOutputStream(file)) {
                    byte[] buffer = new byte[in.available()];
                    in.read(buffer);
                    out.write(buffer);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        this.bidRepository = new BidRepository(file);
    }

    public static void main(String... args) {
        instance = new Application();
        instance.start();
    }

    public static Application getInstance() {
        return instance;
    }
}
