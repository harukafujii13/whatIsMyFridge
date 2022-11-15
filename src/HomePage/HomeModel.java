package HomePage;



import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import dbUtil.dbConnection;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class HomeModel {
    
    Connection conn = null;
    private ObservableList<FridgeData> fridgeData;

    public HomeModel(){
        this.conn = dbConnection.getConnection();

        if(this.conn == null){
            System.exit(0);
        }
    }

    public ObservableList<FridgeData> getfridgeData(){
        String query = "SELECT * FROM fridge_tbl";

        try {
            this.fridgeData = FXCollections.observableArrayList();

            ResultSet resultSet = conn.createStatement().executeQuery(query);

            // id | createAt | name | department

            while(resultSet.next()){
                this.fridgeData.add( new FridgeData(
                    resultSet.getString(1),
                    resultSet.getString(2),
                    resultSet.getInt(3),
                    resultSet.getDate(4),
                    resultSet.getString(5)

                ));
            }

            return fridgeData;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
        
    }

    public void addItem(String name, Integer number,Date EXP, String location ){
        String query = "INSERT INTO fridge_tbl (name, department) VALUES (?, ?, ?, ?)";
        PreparedStatement statement = null;

        try {
            statement = conn.prepareStatement(query);

            statement.setString(1, name);
            statement.setInt(2, number);
            ((Object) statement).setEXP(3, EXP);
            statement.setString(4, location);
           

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