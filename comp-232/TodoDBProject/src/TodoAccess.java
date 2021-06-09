import java.sql.*;

public class TodoAccess {

    private Connection connect = null;
    private Statement statement = null;
    private ResultSet resultSet = null;
    private PreparedStatement preparedStatement = null;

    public void readDB() throws Exception {
        try {
            // loads the MySQL driver into out program
            Class.forName("com.mysql.cj.jdbc.Driver");
            connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/todoDB","root","Nelsondog7");
            statement = connect.createStatement();
            resultSet = statement.executeQuery("select * from todoDB.tasks");
            writeResultSet(resultSet);

            // add tasks to list
            System.out.println("\n------- INSERT STATEMENT -------");
            preparedStatement = connect.prepareStatement("insert into todoDB.tasks values(default, ?)");
            preparedStatement.setString(1, "Automate Boring Tasks");
            preparedStatement.executeUpdate();

            preparedStatement = connect.prepareStatement("select * from todoDB.tasks");
            resultSet = preparedStatement.executeQuery();
            writeResultSet(resultSet);

            preparedStatement = connect.prepareStatement("delete from todoDB.tasks where id = ?;");
            preparedStatement.setString(1, "9");
            preparedStatement.executeUpdate();
            writeResultSet(resultSet);

        } catch (Exception e) {
            throw e;
        } finally {
            close();
        }
    }

    private void writeResultSet(ResultSet resultSet) throws SQLException {
        while(resultSet.next()) {
            String task = resultSet.getString("task");
            String id = resultSet.getString("id");
            System.out.print("ID: " + id);
            System.out.print("\t-->\t");
            System.out.println("Task: " + task);
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
        TodoAccess toA = new TodoAccess();
        toA.readDB();
    }
}
