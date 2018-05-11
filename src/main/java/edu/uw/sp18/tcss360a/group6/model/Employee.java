package edu.uw.sp18.tcss360a.group6.model;

/**
 * Class used to represent an Employee of Auction Central.
 *
 * @author Adam G. Cannon, Josh Atherton, Tam Bui, Evan Lindsay
 * @version 5/11/2018
 */
public class Employee extends AbstractUser {

    private long userID;
    private String userName;

    /**
     * Construct a new employee.
     *
     * @param id employees user identification number
     * @param userName String representation of the employee name
     */
    public Employee (long id, String userName) {
        super(UserType.EMPLOYEE, id, userName);
    }





}
