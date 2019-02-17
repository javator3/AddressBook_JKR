package pl.sda.addressbook.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import pl.sda.addressbook.model.Person;
import pl.sda.addressbook.view.PersonView;

import java.io.File;
import java.io.IOException;
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

    @FXML
    private Button saveToJason;

    private PersonView personView;

    public void setPersonView(PersonView personView){
        this.personView = personView;
        personTableView.setItems(personView.getPersonList());

    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
//        PersonView personView = new PersonView();
//        personTableView.setItems(personView.getPersonList());
        nameCol.setCellValueFactory(c -> c.getValue().nameProperty());
        lastName.setCellValueFactory(c ->c.getValue().lastnameProperty());

    }


    public void loadNewPerson(ActionEvent actionEvent) {
        personView.loadNewPersonView();
    }

    public void saveToJason(ActionEvent actionEvent){

        ObjectMapper mapper = new ObjectMapper();
        File file = new File("personList");

        try {
            mapper.writeValue(file,personView.getPersonList() );
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

}
