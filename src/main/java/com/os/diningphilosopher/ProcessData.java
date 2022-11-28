package com.os.diningphilosopher;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class ProcessData {
    private Integer cpu1;
    private Integer cpu2;
    private final StringProperty name = new SimpleStringProperty();

    public ProcessData(String name,Integer cpu1, Integer cpu2) {
        this.name.set(name);
        this.cpu1 = cpu1;
        this.cpu2 = cpu2;
    }

    public final StringProperty getNameProperty() {
        return this.name;
    }

    public final String getName() {
        return this.name.get();
    }

    public final void setName(String value) {
        name.set(value);
    }

    public Integer getCpu1() {
        return cpu1;
    }

    public void setCpu1(Integer cpu1) {
        this.cpu1 = cpu1;
    }

    public Integer getCpu2() {
        return cpu2;
    }

    public void setCpu2(Integer cpu2) {
        this.cpu2 = cpu2;
    }
}
