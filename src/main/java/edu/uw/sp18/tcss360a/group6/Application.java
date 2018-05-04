package edu.uw.sp18.tcss360a.group6;

import java.util.Scanner;

public class Application {

    private static Application instance;

    private boolean running = true;

    public void start() {
        while (this.running) {
            Scanner input = new Scanner(System.in);
            System.out.println("Choose an option");
            System.out.println("1. Exit");

            String response = input.nextLine();
            switch (response.toLowerCase()) {
                case "1":
                    stop();
                    break;
                default:
                    System.out.println("Invalid selection...");
            }
        }
    }

    public void stop() {
        this.running = false;
    }

    public static void main(String... args) {
        instance = new Application();
        instance.start();
    }

    public static Application getInstance() {
        return instance;
    }
}
