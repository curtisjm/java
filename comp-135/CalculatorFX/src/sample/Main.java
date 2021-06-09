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

    // basic declaration for calculator
    TextField tfNum1;
    TextField tfMum2;
    Button btnAddition;
    Button btnSubtraction;
    Button btnMultiply;
    Button btnDivide;
    Button btnPower;
    Button btnModulo;
    Button btnClear;
    Label lblAnswer;

    @Override
    public void start(Stage primaryStage) throws Exception{
        //Initialize
        tfNum1 = new TextField();
        tfMum2 = new TextField();
        btnAddition = new Button("+");
        btnSubtraction = new Button("-");
        btnMultiply = new Button("*");
        btnDivide = new Button("/");
        btnPower = new Button("^");
        btnModulo = new Button("%");
        btnClear = new Button("Clear");
        lblAnswer = new Label("?");

        GridPane root = new GridPane();
        root.setAlignment(Pos.CENTER);
        root.setHgap(10);
        root.setVgap(10);

        // column , row
        root.add(btnDivide, 0, 0);
        root.add(btnMultiply, 1, 0);
        root.add(btnAddition, 0, 1);
        root.add(btnSubtraction, 1, 1);
        root.add(btnPower,0,2);
        root.add(btnModulo,1,2);
        root.add(btnClear, 0, 5, 2, 1);

        root.add(tfNum1, 0,3);
        root.add(tfMum2, 1, 3);
        root.add(lblAnswer, 0,4,2,1);

        setWidths();
        attachCode();

        //Parent root2 = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Calculator FX 1.0");
        primaryStage.setScene(new Scene(root, 300, 300));
        primaryStage.show();
    }

    private void setWidths() {
        tfNum1.setPrefWidth(70);
        tfMum2.setPrefWidth(70);
        btnDivide.setPrefWidth(70);
        btnMultiply.setPrefWidth(70);
        btnAddition.setPrefWidth(70);
        btnSubtraction.setPrefWidth(70);
        btnPower.setPrefWidth(70);
        btnModulo.setPrefWidth(70);
        btnClear.setPrefWidth(150);
        lblAnswer.setPrefWidth(150);
        lblAnswer.setAlignment(Pos.CENTER);
        lblAnswer.setStyle("-fx-border-color: #0000; -fx-padding: 5px");
    }

    public void attachCode() {
        btnAddition.setOnAction(e-> btncode(e));
        btnSubtraction.setOnAction(e-> btncode(e));
        btnMultiply.setOnAction(e-> btncode(e));
        btnDivide.setOnAction(e-> btncode(e));
        btnPower.setOnAction(e-> btncode(e));
        btnModulo.setOnAction(e-> btncode(e));
        btnClear.setOnAction(e-> btncode(e));
    }

    // do specific operation for each button
    private void btncode(ActionEvent e) {
        int num1, num2, answer = 0;
        char symbol = ' ';
        num1 = Integer.parseInt(tfNum1.getText());
        num2 = Integer.parseInt(tfMum2.getText());

        if (e.getSource() == btnAddition) {
            symbol = '+';
            answer = num1 + num2;
        } else if (e.getSource() == btnSubtraction) {
            symbol = '-';
            answer = num1 - num2;
        } else if (e.getSource() == btnMultiply) {
            symbol = '*';
            answer = num1 * num2;
        } else if (e.getSource() == btnDivide) {
            symbol = '/';
            answer = num1 / num2;
        } else if (e.getSource() == btnPower) {
            symbol = '^';
            answer = (int) Math.pow(num1, num2);
        } else if (e.getSource() == btnModulo) {
            symbol = '%';
            answer = num1 % num2;
        } else {
            // clear was pressed
            tfNum1.setText("");
            tfMum2.setText("");
            lblAnswer.setText("");
            return;
        }
        lblAnswer.setText("" + num1 + symbol + num2 + "=" + answer);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
