package pl.sda.addressbook.view;

import com.fasterxml.jackson.databind.ObjectMapper;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import pl.sda.addressbook.controller.NewPersonController;
import pl.sda.addressbook.controller.RootViewController;
import pl.sda.addressbook.model.Person;
import pl.sda.addressbook.model.PersonString;

import java.io.File;
import java.io.IOException;

public class PersonView {

    public PersonView() {
    }

    private ObservableList<Person> personList =
            FXCollections.observableArrayList();

    private Stage primaryStage;


    public PersonView(Stage primaryStage) {
        this.primaryStage = primaryStage;
//        personList.add(new Person("Jan", "Kowalski", "Kwiatowa", "Warszawa",
//                "12-12", "78 697"));
//        personList.add(new Person("Anna", "Nowak", "Długa", "kraków",
//                "34-34", "67 890"));
//        personList.add(new Person("Maria", "Wiśniewska", "Bajkowa", "Poznań",
//                "56-34", "876 098"));


        ObjectMapper mapper = new ObjectMapper();
        File file = new File("personList");

        PersonString[] person = null;

        try {
            person = mapper.readValue(file, PersonString[].class);

            for (PersonString personString : person) {
                personList.add(new Person(personString.getName(), personString.getLastname(), personString.getStreet(),
                        personString.getCity(), personString.getPostcode(), personString.getTelephone()));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    public ObservableList<Person> getPersonList() {
        return personList;
    }

    public Stage getPrimaryStage() {
        return primaryStage;
    }

    public void loadView() {

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/RootView.fxml"));

        try {
            loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Parent parent = loader.getRoot();

        primaryStage.setScene(new Scene(parent, 600, 400));
        RootViewController rootViewController = loader.getController();
        rootViewController.setPersonView(this);
        primaryStage.show();

//        try {
//            Parent root = FXMLLoader.
//                    load(getClass().
//                            getResource("/RootView.fxml"));
//            primaryStage.setScene(new Scene(root, 600, 300));
//            primaryStage.show();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
    }


    public void loadNewPersonView() {

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/NewPerson.fxml"));

        try {
            loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Parent parent = loader.getRoot();

        Stage personStage = new Stage();

        personStage.setScene(new Scene(parent, 700, 400));
        personStage.show();

        NewPersonController newPersonController = loader.getController();
        newPersonController.setPersonView(this);


    }


}

