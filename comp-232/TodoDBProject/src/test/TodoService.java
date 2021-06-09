package test;

import java.io.OutputStream;
import java.sql.*;

public class TodoService {

    private Connection connect = null;
    private Statement statement = null;
    private ResultSet resultSet = null;
    private PreparedStatement preparedStatement = null;

    //private ArrayList<String> tasks = new ArrayList<>();
    private String result;

    public void readDB() throws Exception {
        try {
            // loads the MySQL driver into out program
            Class.forName("com.mysql.cj.jdbc.Driver");
            connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/todoDB","root","Nelsondog7");
            statement = connect.createStatement();
            resultSet = statement.executeQuery("select * from todoDB.tasks");
            resultSet = preparedStatement.executeQuery();

            int x = 1;
            while(resultSet.next()) {
                //tasks.add(resultSet.getString("task"));
                result += "(" + x + ") " + resultSet.getString("task") + "/n";
                x++;
                System.out.println(resultSet.getString("task"));
            }

        } catch (Exception e) {
            throw e;
        } finally {
            close();
        }
    }

    private void close() {
        try {
            if(resultSet != null) {
                resultSet.close();
            }
            if(statement != null) {
                statement.close();
            }
            if(connect != null) {
                connect.close();
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void main(String[] args) throws Exception {
        TodoService tdS = new TodoService();
        tdS.readDB();
        System.out.println(tdS.result);
    }
}
