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
    private ChoiceBox<Integer> quantity;
    @FXML
    private DatePicker exp;
    @FXML
    private ChoiceBox<String> placement;

    private String[] locations={"Fridge","Freezer","Vegetable compartment", "Pantry"};

    private Integer[] quantitys={1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20};
    @FXML
    private TableView<FridgeData> FridgeDataTableView;
   
    @FXML
    private TableColumn<FridgeData, String> NameColumn;
    @FXML
    private TableColumn<FridgeData, Number> QuantityColumn;
    @FXML
    private TableColumn<FridgeData, LocalDate> EXPColumn;
    @FXML
    private TableColumn<FridgeData, String> LocationColumn;
    
    

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
        placement.getItems().addAll(locations); 
        quantity.getItems().addAll(quantitys);
    }

    //load data
    @FXML
    public void loadFridgeData(){

        
        this.NameColumn.setCellValueFactory(cellData->cellData.getValue().nameProperty());
        this.QuantityColumn.setCellValueFactory(cellData -> cellData.getValue().getQuantity());
        this.EXPColumn.setCellValueFactory(cellData -> cellData.getValue().getEXP());
        this.LocationColumn.setCellValueFactory(cellData -> cellData.getValue().getPlacement());
        
        
        this.FridgeDataTableView.setItems(homeModel.getfridgeData());
    }

    //add employee
    @FXML
    private void additem(ActionEvent event){
        homeModel.addItem(this.name.getText(), this.quantity.getValue(), this.exp.getValue(),this.placement.getValue());
        this.loadFridgeData();
        this.clearFields(null);
    }

    //update 
    
    //delete

    //clear fields
    @FXML
    private void clearFields(ActionEvent event){
        this.name.setText("");
        this.quantity.setValue(null);
        this.exp.setValue(null);
        this.placement.setValue(null);
    }

}