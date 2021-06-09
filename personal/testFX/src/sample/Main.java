package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.awt.event.ActionEvent;

public class Main extends Application {

    private Button button;
    private Text text;

    @Override
    public void start(Stage primaryStage) throws Exception{

        Pane pane = new FlowPane();

        button = new Button("Click");
        button.setOnAction(this::handleButton);
        text = new Text("Welcome to FX!");

        primaryStage.setScene(new Scene(pane, 300, 275));
        primaryStage.show();
    }

    private void handleButton(javafx.event.ActionEvent actionEvent) {
        text.setText("You clicked!");
        text.setFont(Font.font("Helvetica", 14));

    }


    public static void main(String[] args) {
        launch(args);
    }
}
