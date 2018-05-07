package edu.uw.sp18.tcss360a.group6.ui;

import edu.uw.sp18.tcss360a.group6.Context;

public interface Prompt {

    void start();

    boolean execute(Context context);

    Context getContext();

}
