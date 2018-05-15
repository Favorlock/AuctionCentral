package edu.uw.sp18.tcss360a.group6.model;

public interface SingletonRepository<T> extends Repository<T> {

    T fetch();

}
