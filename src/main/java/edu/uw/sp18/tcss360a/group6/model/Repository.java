package edu.uw.sp18.tcss360a.group6.model;


import java.util.List;

/**
 * @author Adam G. Cannon, Josh Atherton, Tam Bui, Evan Lindsay
 * @version 5/1/2018
 * @param <T>
 */
public interface Repository<T> {

    List<T> fetchAll();

    void add(T entry);

}
