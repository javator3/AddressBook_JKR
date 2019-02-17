package pl.sda.addressbook.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.input.MouseEvent;
import pl.sda.addressbook.model.Person;
import pl.sda.addressbook.model.PersonString;
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

//        personTableView.getSelectionModel().selectedItemProperty().addListener(observable, oldField, newField)
//        ->viewPersonInfoOnLabel(newField);



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


    public void selectPerson(MouseEvent mouseEvent) {
        Person person = personTableView.getSelectionModel().getSelectedItem();

        int index = personTableView.getSelectionModel().getFocusedIndex();
        showName.setText(person.getName());
        showLastname.setText(person.getLastname());
        showStreet.setText(person.getStreet());
        showCity.setText(person.getCity());
        showPostcode.setText(person.getPostcode());
        showTel.setText(person.getTelephone());

    }

//    public void editPerson(ActionEvent actionEvent) {
//        int index = personTableView.getSelectionModel().getFocusedIndex();
//        Person person = personTableView.getSelectionModel().getSelectedItem();
//        personView.loadPersonEdit(person, index);
//    }

    public void DeletePerson(javafx.event.ActionEvent actionEvent) {
        int index = personTableView.getSelectionModel().getFocusedIndex();
        personView.getPersonList().remove(index);

    }
}
