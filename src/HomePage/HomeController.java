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
    private TableColumn<FridgeData, String> idColumn;
    @FXML
    private TableColumn<FridgeData, String> nameColumn;
    @FXML
    private TableColumn<FridgeData, Integer> quantityColumn;
    @FXML
    private TableColumn<FridgeData, LocalDate> expColumn;
    @FXML
    private TableColumn<FridgeData, String> placementColumn;
    
    

    @FXML
    private Button addEntryBtn;
    @FXML
    private Button clearBtn;

    //instantiate a model
    HomeModel homeModel = null;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        this.homeModel = new HomeModel();
        // this.loadFridgeData();    
        placement.getItems().addAll(locations); 
        quantity.getItems().addAll(quantitys);
    }

    //load data
    @FXML
    public void loadFridgeData(){

        this.idColumn.setCellValueFactory( new PropertyValueFactory<FridgeData, String>("id"));
        this.nameColumn.setCellValueFactory( new PropertyValueFactory<FridgeData, String>("name"));
        this.quantityColumn.setCellValueFactory( new PropertyValueFactory<FridgeData, Integer>("number"));
        this.expColumn.setCellValueFactory( new PropertyValueFactory<FridgeData, LocalDate>("exp"));
        this.placementColumn.setCellValueFactory( new PropertyValueFactory<FridgeData, String>("placement"));
        
        
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