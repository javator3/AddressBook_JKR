package pl.sda.addressbook.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
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
    private Button close;



    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    private PersonView personView;

    public int getIndex() {
        return index;
    }

    private int index;


    public void savePerson(ActionEvent actionEvent) {

//        Person person = personView.getPersonList().get(getIndex());
//        person.setName(showPname.getText());
//        person.setLastname(showPlastname.getText());
//        person.setStreet(showPstreet.getText());
//        person.setCity(showPcity.getText());
//        person.setPostcode(showPpostcode.getText());
//        person.setTelephone(showPtel.getText());


        personView.getPersonList().add(new Person(showPname.getText(), showPlastname.getText(), showPstreet.getText(),
        showPcity.getText(), showPpostcode.getText(), showPtel.getText()));

        Stage stage = (Stage) save.getScene().getWindow();
        stage.close();
    }

    public void setPersonView(PersonView personView) {
        this.personView = personView;


    }

    public void closeButton (javafx.event.ActionEvent actionEvent){
        personView.getNewPersonStage().close();

//        Stage stage = (Stage) closeButton.getScene().getWindow();
//        stage.close();

    }

    public void setPerson(Person person){
        showPname.setText(person.getName());
        showPlastname.setText(person.getLastname());
        showPstreet.setText(person.getStreet());
        showPcity.setText(person.getCity());
        showPpostcode.setText(person.getPostcode());
        showPtel.setText(person.getTelephone());
    }

    public void setIndex(int index){
        this.index=index;
    }
}
