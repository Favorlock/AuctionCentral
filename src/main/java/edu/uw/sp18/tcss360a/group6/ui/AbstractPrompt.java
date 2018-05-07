package edu.uw.sp18.tcss360a.group6.ui;

import edu.uw.sp18.tcss360a.group6.Context;

/**
 * @author Adam G. Cannon, Josh Atherton, Tam Bui, Evan Lindsay
 * @version 5/1/2018
 */
public abstract class AbstractPrompt implements Prompt {

    private boolean completed = false;

    private Context context;

    public AbstractPrompt(Context context) {
        this.context = context;
    }

    @Override
    public void start() {
        if (!this.completed) {
            this.completed = execute(this.context);
        }
    }

    @Override
    public Context getContext() {
        return this.context;
    }

    public boolean isCompleted() {
        return this.completed;
    }
}
