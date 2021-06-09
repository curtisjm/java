package sample;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Main extends Application {

    TextField tfNumIn;
    Button btnCheck;
    Label lblAnswer;

    @Override
    public void start(Stage primaryStage) throws Exception{
        tfNumIn = new TextField();
        btnCheck = new Button("Check");
        lblAnswer = new Label("");

        GridPane root = new GridPane();
        root.setAlignment(Pos.CENTER);
        root.setHgap(10);
        root.setVgap(10);

        root.add(tfNumIn, 0, 0);
        root.add(btnCheck, 0, 1);
        root.add(lblAnswer, 2, 0);

        attachCode();

        primaryStage.setTitle("Even or Odd?");
        primaryStage.setScene(new Scene(root, 650, 500));
        primaryStage.show();
    }

    public void attachCode() {
        btnCheck.setOnAction(e-> btncode(e));
    }

    private void btncode(ActionEvent e) {
        try {
            Integer.parseInt(tfNumIn.getText());
        } catch (Exception e1) {
            lblAnswer.setText("Not a number");
            return;
        }
        int num = Integer.parseInt(tfNumIn.getText());
        if(num % 2 == 0) {
            lblAnswer.setText("Number is even");
        } else {
            lblAnswer.setText("Number is odd");
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
