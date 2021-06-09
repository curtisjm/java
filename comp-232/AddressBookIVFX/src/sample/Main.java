package sample;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.ArrayList;

public class Main extends Application {

    Stage stage;
    Scene menuScene, listScene, addScene, deleteScene, editScene;
    Label mainLabel;
    Button listButton, addButton, deleteButton, editButton;

    @Override
    public void start(Stage primaryStage) throws Exception {
        stage = primaryStage;
        mainMenu();
    }

    private void mainMenu() {
        mainLabel = new Label("-- Main Menu --");
        listButton = new Button("List Contacts");
        addButton = new Button("Add Contacts");
        deleteButton = new Button("Delete Contacts");
        editButton = new Button("Edit Contacts");

        VBox menuLayout = new VBox(20);
        menuLayout.setAlignment(Pos.CENTER);
        menuLayout.getChildren().addAll(mainLabel, listButton, addButton, deleteButton, editButton);
        menuScene = new Scene(menuLayout, 600, 450);

        listButton.setOnAction(e -> listMenu());
        addButton.setOnAction(e -> addMenu());
        deleteButton.setOnAction(e -> deleteMenu());
        editButton.setOnAction(e -> editMenu());

        stage.setScene(menuScene);
        stage.setTitle("Address Book IV");
        stage.show();
    }

    private void listMenu() {
        stage.setScene(listScene);
        Button backButton = new Button("Back");
        Label listLabel = new Label("-- Contacts --");
        ArrayList<Contact> contacts = HTTPService.getContactsList();
        ArrayList<String> contactStrings = new ArrayList<>();
        for(Contact c : contacts) {
            contactStrings.add(c.toString());
        }

        ListView<String> listView = new ListView<>();
        ObservableList<String> items = FXCollections.observableArrayList(contactStrings);
        listView.setItems(items);

        VBox listLayout = new VBox(20);
        listLayout.setAlignment(Pos.CENTER);
        listLayout.getChildren().addAll(listLabel, listView, backButton);
        listScene = new Scene(listLayout, 600, 450);
        stage.setScene(listScene);
        stage.setTitle("Address Book IV - List");
        stage.show();
        backButton.setOnAction(e -> mainMenu());
    }

    private void addMenu() {
        stage.setScene(addScene);
        Button backButton = new Button("Back");
        Button addContact = new Button("Add Contact");
        Label addLabel = new Label("-- Add Contacts --");
        Label firstNameLabel = new Label("First name:");
        Label lastNameLabel = new Label("Last name:");
        Label addressLabel = new Label("Address:");
        Label phoneNumLabel = new Label("Phone #:");
        TextField firstNameTf = new TextField();
        TextField lastNameTf = new TextField();
        TextField addressTf = new TextField();
        TextField phoneNumTf = new TextField();

        GridPane gridPane = new GridPane();
        gridPane.setAlignment(Pos.CENTER);
        gridPane.setHgap(10);
        gridPane.setVgap(10);
        gridPane.add(addLabel, 0, 0, 2, 1);
        gridPane.add(firstNameLabel, 0, 1);
        gridPane.add(firstNameTf, 1, 1);
        gridPane.add(lastNameLabel, 0, 2);
        gridPane.add(lastNameTf, 1, 2);
        gridPane.add(addressLabel, 0, 3);
        gridPane.add(addressTf, 1, 3);
        gridPane.add(phoneNumLabel, 0, 4);
        gridPane.add(phoneNumTf, 1, 4);
        gridPane.add(addContact, 0, 5, 2, 1);
        gridPane.add(backButton, 0, 6, 2, 1);

        addScene = new Scene(gridPane, 600, 450);
        stage.setScene(addScene);
        stage.setTitle("Address Book IV - Add");
        stage.show();

        addContact.setOnAction(e -> {
            if(firstNameTf.getText().equals("") || lastNameTf.getText().equals("") || addressTf.getText().equals("") || phoneNumTf.getText().equals("")) {
                Toast.makeText(stage, "Enter all fields before adding a contact!", 4200, 500, 500);
            } else {
                HTTPService.addContact(new Contact(firstNameTf.getText(), lastNameTf.getText(), addressTf.getText(), phoneNumTf.getText()));
                firstNameTf.setText("");
                lastNameTf.setText("");
                addressTf.setText("");
                phoneNumTf.setText("");
            }
        });
        backButton.setOnAction(e -> mainMenu());
    }


    private void deleteMenu() {
        stage.setScene(deleteScene);
        Button backButton = new Button("Back");
        Label deleteLabel = new Label("-- Delete Contacts --");
        Button deleteContact = new Button("Delete Contact");
        Label oldPhoneNumLabel = new Label("Phone # of contact you want to delete:");
        TextField oldPhoneNumTf = new TextField();
        oldPhoneNumTf.setPrefWidth(150);

        VBox vBox = new VBox(20);
        vBox.setAlignment(Pos.CENTER);
        vBox.getChildren().addAll(deleteLabel, oldPhoneNumLabel, oldPhoneNumTf, deleteContact, backButton);
        vBox.setFillWidth(false);

        deleteScene = new Scene(vBox, 600, 450);
        stage.setScene(deleteScene);
        stage.setTitle("Address Book IV - Delete");
        stage.show();

        deleteContact.setOnAction(e -> {
            if(oldPhoneNumTf.getText().equals("")) {
                Toast.makeText(stage, "Enter a phone number before deleting a contact!", 4200, 500, 500);
            } else {
                Contact oldContact = new Contact();
                oldContact.setPhoneNumber(oldPhoneNumTf.getText());
                HTTPService.deleteContact(oldContact);
                oldPhoneNumTf.setText("");
            }
        });
        backButton.setOnAction(e -> mainMenu());
    }

    private void editMenu() {
        stage.setScene(editScene);
        Button backButton = new Button("Back");
        Button editContact = new Button("Update Contact");
        Label editLabel = new Label("-- Edit Contacts --");
        Label oldPhoneNumLabel = new Label("Phone # of contact you want to edit:");
        Label newValuesLabel = new Label("Enter new values (fill all fields):");
        Label firstNameLabel = new Label("First name:");
        Label lastNameLabel = new Label("Last name:");
        Label addressLabel = new Label("Address:");
        Label phoneNumLabel = new Label("Phone #:");
        TextField oldPhoneNumTf = new TextField();
        TextField firstNameTf = new TextField();
        TextField lastNameTf = new TextField();
        TextField addressTf = new TextField();
        TextField phoneNumTf = new TextField();

        GridPane gridPane = new GridPane();
        gridPane.setAlignment(Pos.CENTER);
        gridPane.setHgap(10);
        gridPane.setVgap(10);
        gridPane.add(editLabel, 0, 0, 2, 1);
        gridPane.add(oldPhoneNumLabel, 0, 1, 2, 1);
        gridPane.add(oldPhoneNumTf, 0, 2, 2, 1);
        gridPane.add(newValuesLabel, 0, 3, 2, 1);
        gridPane.add(firstNameLabel, 0, 4);
        gridPane.add(firstNameTf, 1, 4);
        gridPane.add(lastNameLabel, 0, 5);
        gridPane.add(lastNameTf, 1, 5);
        gridPane.add(addressLabel, 0, 6);
        gridPane.add(addressTf, 1, 6);
        gridPane.add(phoneNumLabel, 0, 7);
        gridPane.add(phoneNumTf, 1, 7);
        gridPane.add(editContact, 0, 8, 2, 1);
        gridPane.add(backButton, 0, 9, 2, 1);

        deleteScene = new Scene(gridPane, 600, 450);
        stage.setScene(deleteScene);
        stage.setTitle("Address Book IV - Edit");
        stage.show();

        editContact.setOnAction(e -> {
            if(firstNameTf.getText().equals("") || lastNameTf.getText().equals("") || addressTf.getText().equals("") || phoneNumTf.getText().equals("") || oldPhoneNumTf.getText().equals("")) {
                Toast.makeText(stage, "Enter all fields before editing a contact!", 4200, 500, 500);
            } else {
                Contact oldContact = new Contact();
                oldContact.setPhoneNumber(oldPhoneNumTf.getText());
                Contact newContact = new Contact(firstNameTf.getText(), lastNameTf.getText(), addressTf.getText(), phoneNumTf.getText());
                HTTPService.updateContact(oldContact, newContact);
                oldPhoneNumTf.setText("");
                firstNameTf.setText("");
                lastNameTf.setText("");
                addressTf.setText("");
                phoneNumTf.setText("");
            }
        });
        backButton.setOnAction(e -> mainMenu());
    }

    public static void main(String[] args) {
        launch(args);
    }
}
