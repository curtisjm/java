package sample;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.util.ArrayList;

public class Main extends Application {

    public int numTasks = 1;
    public ArrayList<ItemToDo> tasks = new ArrayList<>();

    Button btnAdd;
    Button btnRemove;
    TextField tfTask;
    TextField tfDate;
    TextField tfRemove;
    Label lblTask;
    Label lblDate;
    Label lblTask0;
    Label lblDate0;

    @Override
    public void start(Stage primaryStage) throws Exception{
        btnAdd = new Button("Add");
        btnRemove = new Button("Remove Task");
        tfTask = new TextField();
        tfDate = new TextField();
        lblTask = new Label("Tasks: ");
        lblDate = new Label("Dates: ");
        lblTask0 = new Label("Task");
        lblDate0 = new Label("Date");


        GridPane root = new GridPane();
        root.setAlignment(Pos.CENTER);
        root.setHgap(10);
        root.setVgap(10);
        root.getBorder();

        root.add(lblTask0, 0,0);
        root.add(lblDate0,0,1);
        root.add(tfTask, 1,0);
        root.add(tfDate,1,1);
        root.add(btnAdd,2,0);
        root.add(lblTask, 3, 0);
        root.add(lblDate, 4, 0);

        attachCode();

        primaryStage.setTitle("To Do List");
        primaryStage.setScene(new Scene(root, 1000, 650));
        primaryStage.show();
    }

    public void attachCode() {
        btnAdd.setOnAction(e-> btncode(e));
    }

    private void btncode(ActionEvent e) {
        tasks.add(new ItemToDo(tfTask.getText(), tfDate.getText()));
        String tasks1 = "Tasks: ";
        String dates1 = "Dates: ";
        StringBuilder textTasks = new StringBuilder();
        StringBuilder textDates = new StringBuilder();
        for(int i=0; i<tasks.size(); i++) {
            textTasks.append(numTasks).append(". ").append(tasks.get(i).getItemName()).append("\n");
            textDates.append(tasks.get(i).getDate()).append("\n");
        }
        lblTask.setText(tasks1 + "\n" + textTasks);
        lblDate.setText(dates1 + "\n" + textDates);


        //lblTask.setText(lblTask.getText() + "\n" + numTasks + ". " + tasks.get(numTasks - 1).getItemName());
        //lblDate.setText(lblDate.getText() + "\n" + tasks.get(numTasks - 1).getDate());

        tfTask.setText("");
        tfDate.setText("");
        numTasks++;
    }


    public static void main(String[] args) {
        launch(args);
    }
}
