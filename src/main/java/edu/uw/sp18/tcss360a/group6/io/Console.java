package edu.uw.sp18.tcss360a.group6.io;

import java.io.*;
import java.util.Scanner;

/**
 * A console abstraction for system input and output.
 */
public class Console implements Flushable {

    private Scanner scanner;

    /**
     * Creates a new console.
     */
    public Console() {
        this.scanner = new Scanner(System.in);
    }

    /**
     * Prints formatted text to system output.
     *
     * @param format the format
     * @param args the args to format
     */
    public void printf(String format, Object... args) {
        System.out.printf(format, args);
    }

    /**
     * Prints a line of text to system output.
     *
     * @param line the line to print
     */
    public void println(String line) {
        System.out.println(line);
    }

    /**
     * Prints a line of formatted text to system output.
     *
     * @param format the format
     * @param args the args to format
     */
    public void printfln(String format, Object... args) {
        System.out.println(String.format(format, args));
    }

    /**
     * Reads a line of text or returns null if no line was read.
     *
     * @return a line of text or null if no line found
     */
    public String readLine() {
        return this.scanner.hasNextLine() ? this.scanner.nextLine() : null;
    }

    /**
     * Prints a line of formatted text to system output and
     * returns a line of text or returns null if no line was read.
     *
     * @param format the format
     * @param args the args to format
     *
     * @return a line of text or null if no line found
     */
    public String readLine(String format, Object... args) {
        printfln(format, args);
        return readLine();
    }

    @Override
    public void flush() {
        System.out.flush();
    }

    /**
     * Returns a new reader for system input.
     *
     * @return a reader
     */
    public Reader reader() {
        return new BufferedReader(new InputStreamReader(System.in));
    }

    /**
     * Returns a new writer for system output.
     *
     * @return a writer
     */
    public Writer writer() {
        return new BufferedWriter(new OutputStreamWriter(System.out));
    }
}
