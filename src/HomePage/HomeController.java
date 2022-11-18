package HomePage;


import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class HomeController implements Initializable{
    
    @FXML
    private TextField name;
    @FXML
    private TextField department;
    
    @FXML
    private TableView<FridgeData> employeeDataTableView;
    @FXML
    private TableColumn<FridgeData, String> idColumn;
    @FXML
    private TableColumn<FridgeData, String> nameColumn;
    @FXML
    private TableColumn<FridgeData, String> departmentColumn;

    @FXML
    private Button addEntryBtn;
    @FXML
    private Button clearBtn;

    //instantiate a model
    HomeModel homeModel = null;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        this.homeModel = new HomeModel();
        this.loadEmployeeData();        
    }

    //load data
    @FXML
    public void loadEmployeeData(){

        this.idColumn.setCellValueFactory( new PropertyValueFactory<FridgeData, String>("id"));
        this.nameColumn.setCellValueFactory( new PropertyValueFactory<FridgeData, String>("name"));
        this.departmentColumn.setCellValueFactory( new PropertyValueFactory<FridgeData, String>("department"));

        this.employeeDataTableView.setItems(homeModel.getEmployees());
    }

    //add employee
    @FXML
    private void addEmployee(ActionEvent event){
        homeModel.addEmployee(this.name.getText(), this.department.getText());
        this.loadEmployeeData();
        this.clearFields(null);
    }

    //update employee
    
    //delete employee

    //clear fields
    @FXML
    private void clearFields(ActionEvent event){
        this.name.setText("");
        this.department.setText("");
    }

}