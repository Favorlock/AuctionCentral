package edu.uw.sp18.tcss360a.group6.model;

import edu.uw.sp18.tcss360a.group6.Bidder;
import edu.uw.sp18.tcss360a.group6.ContactPerson;

public enum UserType {
    UNKNOWN(-1, User.class),
    BIDDER(0, Bidder.class),
    CONTACT_PERSON(1, ContactPerson.class);

    private int id;
    private Class<? extends User> type;

    UserType(int id, Class<? extends User> type) {
        this.id = id;
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public Class<? extends User> getType() {
        return type;
    }

    public static UserType getEnumType(int id) {
        UserType type = UNKNOWN;
        for (UserType t : values()) {
            if (t.id == id) {
                type = t;
                break;
            }
        }
        return type;
    }
}