package pl.sda.addressbook.controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import pl.sda.addressbook.model.Person;
import pl.sda.addressbook.view.PersonView;

import java.awt.*;
import java.net.URL;
import java.util.ResourceBundle;

public class RootViewController implements Initializable {

    @FXML
    private Label showName;

    @FXML
    private Label showLastname;

    @FXML
    private Label showStreet;

    @FXML
    private Label showCity;

    @FXML
    private Label showPostcode;

    @FXML
    private Label showTel;

    @FXML
    private TableView<Person> personTableView;

    @FXML
    private TableColumn<Person, String> nameCol;

    @FXML
    private TableColumn<Person, String> lastName;

    private PersonView personView;

    public void setPersonView(PersonView personView){
        this.personView = personView;
        personTableView.setItems(personView.getPersonList());

    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        PersonView personView = new PersonView();
        personTableView.setItems(personView.getPersonList());

    }




}
