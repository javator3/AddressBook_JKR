package pl.sda.addressbook.view;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import pl.sda.addressbook.controller.RootViewController;
import pl.sda.addressbook.model.Person;

import java.io.IOException;

public class PersonView {

    public PersonView(){}

    private ObservableList<Person> personList=
            FXCollections.observableArrayList();

    private Stage primaryStage;


    public PersonView(Stage primaryStage) {
        this.primaryStage = primaryStage;
        personList.add(new Person("Jan", "Kowalski", "Kwiatowa", "Warszawa",
                "12-12", "78 697"));
        personList.add(new Person("Anna", "Nowak", "Długa", "kraków",
        "34-34","67 890"));
        personList.add(new Person("Maria", "Wiśniewska", "Bajkowa", "Poznań",
                "56-34", "876 098"));

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



//    public void loadNewPersonView(){
//
//        try {
//            Parent root = FXMLLoader.
//                    load(getClass().
//                            getResource("/NewPerson.fxml"));
//            primaryStage.setScene(new Scene(root, 700, 400));
//            primaryStage.show();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }


}

