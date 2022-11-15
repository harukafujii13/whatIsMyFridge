package HomePage;

import java.sql.Date;

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
    private ObjectProperty<Date> EXP;
    private StringProperty location;

    public FridgeData(String id, String name, Integer number, Date EXP, String location) {
        this.id = new SimpleStringProperty(id);
        this.name = new SimpleStringProperty(name);
        this.number = new SimpleIntegerProperty(number);
        this.EXP=new SimpleObjectProperty<Date>(EXP);
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

    public ObjectProperty<Date> getEXP() {
        return EXP;
    }

    public void setEXP(ObjectProperty<Date> eXP) {
        EXP = eXP;
    }

    public StringProperty getLocation() {
        return location;
    }

    public void setLocation(StringProperty location) {
        this.location = location;
    }
    
}