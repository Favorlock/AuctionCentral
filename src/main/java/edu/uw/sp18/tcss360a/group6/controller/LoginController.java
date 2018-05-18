package edu.uw.sp18.tcss360a.group6.controller;

import edu.uw.sp18.tcss360a.group6.Bootstrap;
import edu.uw.sp18.tcss360a.group6.FXApplication;
import edu.uw.sp18.tcss360a.group6.model.User;
import edu.uw.sp18.tcss360a.group6.model.UserType;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
/**
 * GUI for users to login to the application.
 *
 * @author Adam G. Cannon, Josh Atherton, Tam Bui, Evan Lyndsay
 * @version 5/18/2018
 */
public class LoginController {

    @FXML
    private TextField userNameTextField;

    @FXML
    public void onEnter(KeyEvent event) {
        if (event.getCode().equals(KeyCode.ENTER)) {
            Bootstrap bootstrap = Bootstrap.getInstance();
            FXApplication application = FXApplication.getInstance();
            User user = bootstrap.getUserRepository().fetchUser(this.userNameTextField.getText());

            if (user != null) {
                if (user.getType() == UserType.BIDDER) {
                    application.getSceneController().activate("bidderMain");
                } else if (user.getType() == UserType.CONTACT_PERSON) {
                    application.getSceneController().activate("contactMain");
                } else if (user.getType() == UserType.EMPLOYEE) {
                    application.getSceneController().activate("employeeMain");
                }
            } else {
                userNameTextField.setText("Invalid user, try again....");
            }
        }
    }

}
