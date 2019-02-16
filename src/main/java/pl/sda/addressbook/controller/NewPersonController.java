package pl.sda.addressbook.controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import java.awt.*;
import java.net.URL;
import java.util.ResourceBundle;

public class NewPersonController implements Initializable {

    @FXML
    private TextField showPname;

    @FXML
    private TextField showPlastname;

    @FXML
    private TextField showPstreet;

    @FXML
    private TextField showPcity;

    @FXML
    private TextField showPpostcode;

    @FXML
    private TextField showPtel;

    @FXML
    private Button save;

    @FXML
    private Button cancel;



    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
