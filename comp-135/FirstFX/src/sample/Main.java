package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        //Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        Text text = new Text("JavaFX!");
        text.setFill(Color.PURPLE);
        text.setFont(Font.font("Helvetica", 12));
        Pane pane = new StackPane(text);
        primaryStage.setTitle("Hello World");
        Scene scene = new Scene(pane, 500, 300);
        scene.setFill(Color.SILVER);
        primaryStage.setScene(scene);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
