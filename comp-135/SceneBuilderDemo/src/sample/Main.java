package sample;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {

    private Scene createScene(Pane mainPane) {
        return new Scene(mainPane);
    }

    private Pane loadMainPane(String path) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        return (Pane)loader.load(getClass().getResourceAsStream(path));
    }

    @Override
    public void start(Stage primaryStage) throws Exception{
        primaryStage.setTitle("FXML UX from Scene Builder");
        primaryStage.setScene(createScene(loadMainPane("/Resources/test.fxml")));
        primaryStage.show();

    }

    public static void main(String[] args) {
        launch(args);
    }
}
