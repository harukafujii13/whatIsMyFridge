package HomePage;


import java.net.URL;

import java.time.LocalDate;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class HomeController implements Initializable{
    
    @FXML
    private TextField name;
    @FXML
    private TextField number;
    @FXML
    private DatePicker EXP;
    @FXML
    private ChoiceBox location;

    
    @FXML
    private TableView<FridgeData> FridgeDataTableView;
    @FXML
    private TableColumn<FridgeData, String> idColumn;
    @FXML
    private TableColumn<FridgeData, String> nameColumn;
    @FXML
    private TableColumn<FridgeData, Integer> numberColumn;
    @FXML
    private TableColumn<FridgeData, LocalDate> EXPColumn;
    @FXML
    private TableColumn<FridgeData, String> locationColumn;

    @FXML
    private Button addEntryBtn;
    @FXML
    private Button clearBtn;

    //instantiate a model
    HomeModel homeModel = null;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        this.homeModel = new HomeModel();
        this.loadFridgeData();        
    }

    //load data
    @FXML
    public void loadFridgeData(){

        this.idColumn.setCellValueFactory( new PropertyValueFactory<FridgeData, String>("id"));
        this.nameColumn.setCellValueFactory( new PropertyValueFactory<FridgeData, String>("name"));
        this.numberColumn.setCellValueFactory( new PropertyValueFactory<FridgeData, Integer>("number"));
        this.EXPColumn.setCellValueFactory( new PropertyValueFactory<FridgeData, LocalDate>("EXP"));
        this.locationColumn.setCellValueFactory( new PropertyValueFactory<FridgeData, String>("location"));
        
        this.FridgeDataTableView.setItems(homeModel.getfridgeData());
    }

    //add employee
    @FXML
    private void additem(ActionEvent event){
        homeModel.addItem(this.name.getText(), this.number.getText(), this.EXP.getValue(),this.location.getValue());
        this.loadFridgeData();
        this.clearFields(null);
    }

    //update employee
    
    //delete employee

    //clear fields
    @FXML
    private void clearFields(ActionEvent event){
        this.name.setText("");
        this.number.setText("");
        this.EXP.setValue(null);
        this.location.setValue(event);
    }

}