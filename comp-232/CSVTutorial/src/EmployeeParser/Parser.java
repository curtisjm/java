package EmployeeParser;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Parser {

    private static final String COMMA_DELIMITER = ",";

    public static void main(String[] args) {
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader("C:\\Users\\curti\\Desktop\\employee.csv"));
            List<Employee> empList = new ArrayList<>();

            String line = "";
            br.readLine();

            while((line = br.readLine()) != null) {
                String [] employeeDetails = line.split(COMMA_DELIMITER);
                if(employeeDetails.length > 0) {
                    Employee emp = new Employee(Integer.parseInt(employeeDetails[0]), employeeDetails[1], employeeDetails[2], Integer.parseInt(employeeDetails[3]));
                    empList.add(emp);
                }
            }
            for(Employee e : empList) {
                System.out.println(e);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                br.close();
            } catch (IOException ioE) {
                System.out.println("Error occurred while closing the Buffered Reader");
                ioE.printStackTrace();
            }
        }
    }
}
