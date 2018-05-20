package edu.uw.sp18.tcss360a.group6.util;

import javafx.scene.control.ListCell;

public class ListViewCell extends ListCell<String>
{
    @Override
    public void updateItem(String string, boolean empty)
    {
        super.updateItem(string,empty);
        if(string != null)
        {
            Data data = new Data();
            data.setInfo(string);
            setGraphic(data.getBox());
        }
    }
}
