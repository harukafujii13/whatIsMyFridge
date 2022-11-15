package HomePage;



import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import dbUtil.dbConnection;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class HomeModel {
    
    Connection conn = null;
    private ObservableList<EmployeeData> employeeData;

    public HomeModel(){
        this.conn = dbConnection.getConnection();

        if(this.conn == null){
            System.exit(0);
        }
    }

    public ObservableList<EmployeeData> getEmployees(){
        String query = "SELECT * FROM employees_tbl";

        try {
            this.employeeData = FXCollections.observableArrayList();

            ResultSet resultSet = conn.createStatement().executeQuery(query);

            // id | createAt | name | department

            while(resultSet.next()){
                this.employeeData.add( new EmployeeData(
                    resultSet.getString(1),
                    resultSet.getString(3),
                    resultSet.getString(4)
                ));
            }

            return employeeData;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
        
    }

    public void addEmployee(String name, String department){
        String query = "INSERT INTO employees_tbl (name, department) VALUES (?, ?)";
        PreparedStatement statement = null;

        try {
            statement = conn.prepareStatement(query);

            statement.setString(1, name);
            statement.setString(2, department);

            statement.executeQuery();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}