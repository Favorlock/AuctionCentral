package edu.uw.sp18.tcss360a.group6.model;

import com.google.gson.annotations.Expose;

/**
 * @author Adam G. Cannon, Josh Atherton, Tam Bui, Evan Lindsay
 * @version 5/1/2018
 */
public class AbstractUser implements User {

    public static final User INVALID_USER = new AbstractUser(
            UserType.UNKNOWN,
            -1,
            UserType.UNKNOWN.name());

    @Expose
    private UserType type;

    @Expose
    protected long id;

    @Expose
    protected String userName;

    protected AbstractUser(UserType type, long id, String username) {
        this.type = type;
        this.id = id;
        this.userName = username;
    }

    @Override
    public UserType getType() {
        return type;
    }

    @Override
    public long getId() {
        return id;
    }

    @Override
    public String getUserName() {
        return userName;
    }
}
