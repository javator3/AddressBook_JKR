package pl.sda.addressbook.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import pl.sda.addressbook.model.Person;
import pl.sda.addressbook.view.PersonView;

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

    private PersonView personView;


    public void savePerson(ActionEvent actionEvent) {

        personView.getPersonList().add(new Person(showPname.getText(), showPlastname.getText(), showPstreet.getText(),
        showPcity.getText(), showPpostcode.getText(), showPtel.getText()));
    }

    public void setPersonView(PersonView personView) {
        this.personView = personView;


    }
}
