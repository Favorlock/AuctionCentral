package edu.uw.sp18.tcss360a.group6.model;


import java.util.List;

public interface Repository<T> {

    List<T> fetchAll();

}
