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
    private IntegerProperty number;
    private ObjectProperty<LocalDate> EXP;
    private StringProperty location;

    public FridgeData(String id, String name, Integer number, int i, String location) {
        this.id = new SimpleStringProperty(id);
        this.name = new SimpleStringProperty(name);
        this.number = new SimpleIntegerProperty(number);
        this.EXP=new SimpleObjectProperty<LocalDate>(i);
        this.location=new SimpleStringProperty(location);
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
        return number;
    }

    public void setNumber(IntegerProperty number) {
        this.number = number;
    }

    public ObjectProperty<LocalDate> getEXP() {
        return EXP;
    }

    public void setEXP(ObjectProperty<LocalDate> eXP) {
        EXP = eXP;
    }

    public StringProperty getLocation() {
        return location;
    }

    public void setLocation(StringProperty location) {
        this.location = location;
    }
    
}