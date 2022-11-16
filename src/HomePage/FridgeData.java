package HomePage;


import java.time.LocalDate;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class FridgeData {
    
    private StringProperty id;
    private StringProperty name;
    private IntegerProperty quantity;
    private ObjectProperty<LocalDate> exp;
    private StringProperty placement;

    public FridgeData(String id, String name, Integer quantity, LocalDate exp, String placement) {
        this.id = new SimpleStringProperty(id);
        this.name = new SimpleStringProperty(name);
        this.quantity = new SimpleIntegerProperty(quantity);
        this.exp=new SimpleObjectProperty<LocalDate>(exp);
        this.placement=new SimpleStringProperty(placement);
    }

    public StringProperty idProperty() {
        return id;
    }

    public void setId(StringProperty id) {
        this.id = id;
    }

    public StringProperty nameProperty() {
        return name;
    }

    public void setName(StringProperty name) {
        this.name = name;
    }

    
    public IntegerProperty getNumber() {
        return quantity;
    }

    public void setNumber(IntegerProperty quantity) {
        this.quantity = quantity;
    }

    public ObjectProperty<LocalDate> getEXP() {
        return exp;
    }

    public void setEXP(ObjectProperty<LocalDate> exp) {
        this.exp = exp;
    }

    public StringProperty getPlacement() {
        return placement;
    }

    public void setPlacement(StringProperty placement) {
        this.placement = placement;
    }
    
}