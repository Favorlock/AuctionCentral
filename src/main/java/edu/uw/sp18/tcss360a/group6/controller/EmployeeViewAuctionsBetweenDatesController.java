package edu.uw.sp18.tcss360a.group6.controller;

import edu.uw.sp18.tcss360a.group6.FXApplication;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.text.Text;

import java.time.LocalDate;

/**
 * GUI for employees to view all auctions between dates that they specify inclusive.
 *
 * @author Adam G. Cannon, Josh Atherton, Tam Bui, Evan Lyndsay
 * @version 5/18/2018
 */
public class EmployeeViewAuctionsBetweenDatesController {

    private static String INVALID_ENTRY_PROMPT = "Invalid entry. Ensure starting date is before ending date" +
            " and written in the correct format";

    @FXML
    private TextField startDate;

    @FXML
    private TextField endDate;

    @FXML
    private Label viewAuctionsErrorText;

    private LocalDate start;

    private LocalDate end;

    private FXApplication application = FXApplication.getInstance();

    /**
     * Get two dates from the GUI then either display auctions between those
     * dates or a prompt to try again
     * @param event activate when user hits enter
     */
    @FXML
    public void onEnter(KeyEvent event) {
        try {
            if (event.getCode().equals(KeyCode.ENTER)) {

                start = LocalDate.parse(startDate.getText());
                end = LocalDate.parse(endDate.getText());
                if (start.isBefore(end)) {
                    EmployeeViewRangeSuccessController.setDates(start, end);
                    application.getSceneController()
                            .activate("employeeViewRangeSuccess");
                } else {
                    viewAuctionsErrorText.setText(INVALID_ENTRY_PROMPT);
                }
            }
        } catch (Exception ex) {
            viewAuctionsErrorText.setText(INVALID_ENTRY_PROMPT);
        }
    }

    @FXML
    public void back() {
        application.getSceneController().activate("employeeMain");
    }

}
