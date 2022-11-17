package HomePage;


import java.net.URL;

import java.time.LocalDate;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;

public class HomeController implements Initializable{
    
    private String editIdString;
    TextField editName = new TextField();
    ChoiceBox<Integer> editQuantity = new ChoiceBox<Integer>();
    DatePicker editExp =new DatePicker();
    ChoiceBox<String> editPlacement=new ChoiceBox<String>();
    
    @FXML
    private TextField name;
    @FXML
    private ChoiceBox<Integer> quantity;
    @FXML
    private DatePicker exp;
    @FXML
    private ChoiceBox<String> placement;

    private String[] locations={"Fridge","Freezer","Crisper","Door Pocket", "Inner Shelf","Pantry"};

    private Integer[] quantities={1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20};
    @FXML
    private TableView<FridgeData> FridgeDataTableView;
   
    @FXML
    private TableColumn<FridgeData, String> idColumn;
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
    @FXML
    private Button Button;
    @FXML
    private Button editButton;

    Dialog<ButtonType> dialog = null;
    Alert alert = new Alert(AlertType.NONE);
    //instantiate a model
    HomeModel HomeModel = null;

    private String editNameString;
    private Integer editQuantityInteger;
    private LocalDate editExpLocalDate;
    private String editPlacementString;

    //instantiate a model
    HomeModel homeModel = null;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        this.homeModel = new HomeModel();
        this.loadFridgeData();    
        placement.getItems().addAll(locations); 
        quantity.getItems().addAll(quantities);
        editPlacement.getItems().addAll(locations);
        editQuantity.getItems().addAll(quantities);

          //disable  and edit buttons
          editButton.setDisable(true);
          Button.setDisable(true);
  
          FridgeDataTableView.setOnMouseClicked(e -> {
              FridgeData selected = FridgeDataTableView.getSelectionModel().getSelectedItem();
  
              if(selected != null){
                  Button.setDisable(false);
                  editButton.setDisable(false);
  
                  
                  editIdString=selected.idProperty().getValue();
                  editNameString = selected.nameProperty().getValue();
                  editQuantityInteger = selected.getQuantity().getValue();
                  editExpLocalDate=selected.getEXP().getValue();
                  editPlacementString=selected.getPlacement().getValue();
                }
            });
        }
    //load data
    @FXML
    public void loadFridgeData(){

        
        this.idColumn.setCellValueFactory(cellData -> cellData.getValue().idProperty());
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
    @FXML
    private void editItem(ActionEvent event){

        //create modal
        createModal();

        //call the modal
        dialog.showAndWait().ifPresent(response -> {
            if(response.getButtonData().equals(ButtonData.OK_DONE)){
                homeModel.editItem(editIdString,editName.getText(), editQuantity.getValue(), editExp.getValue(), editPlacement.getValue());
                this.loadFridgeData();
            }
        });
    }


    
    //delete
    @FXML
    private void deleteitem(ActionEvent event){
       FridgeData selectedItem = FridgeDataTableView.getSelectionModel().getSelectedItem();
       //locally remove
       FridgeDataTableView.getItems().remove(selectedItem);
       //delete from DB
       homeModel.deleteitem(selectedItem.idProperty().getValue());

    }

    //clear fields
    @FXML
    private void clearFields(ActionEvent event){
        this.name.setText("");
        this.quantity.setValue(null);
        this.exp.setValue(null);
        this.placement.setValue(null);
    }



    //create a modal
    private void createModal(){

        dialog = new Dialog<ButtonType>();

        dialog.setTitle("Edit an Item");
        ButtonType editModalBtn = new ButtonType("Edit", ButtonData.OK_DONE);
        ButtonType cancelModalBtn = new ButtonType("Cancel", ButtonData.CANCEL_CLOSE);

        //set the content
        GridPane gridPane = new GridPane();
        gridPane.setHgap(10);   
        gridPane.setVgap(10);   
        gridPane.setPadding(new Insets(20, 10, 10, 10));

        editName.setText(editNameString);
        editQuantity.setValue(editQuantityInteger);
        editExp.setValue(editExpLocalDate);
        editPlacement.setValue(editPlacementString);

        gridPane.add(new Label("Name"), 0, 0);
        gridPane.add(editName, 1, 0);
        gridPane.add(new Label("Quantity"), 0, 1);
        gridPane.add(editQuantity, 1, 1);
        
        gridPane.add(new Label("EXP"), 0, 2);
        gridPane.add(editExp, 1, 2);

        gridPane.add(new Label("Location"), 0, 3);
        gridPane.add(editPlacement, 1, 3);


        dialog.getDialogPane().setContent(gridPane);

        dialog.getDialogPane().getButtonTypes().add(editModalBtn);
        dialog.getDialogPane().getButtonTypes().add(cancelModalBtn);
    }
}