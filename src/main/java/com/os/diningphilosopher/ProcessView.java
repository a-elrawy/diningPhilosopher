package com.os.diningphilosopher;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ArrayList;
import java.util.EventListener;
import java.util.ResourceBundle;
public class ProcessView implements Initializable {
    @FXML
    private TableColumn<ProcessData, String> name;
    @FXML
    private TableColumn<ProcessData, Integer> cpu1;
    @FXML
    private TableColumn<ProcessData, Integer> cpu2;
    @FXML
    private TableView<ProcessData> table;

    @FXML
    private TextField input_name;
    @FXML private ChoiceBox<Integer> input_cpu1;
    @FXML private ChoiceBox<Integer> input_cpu2;



    @FXML public void assign(ActionEvent event){
        Integer cpu1 = input_cpu1.getValue();
        Integer cpu2 = input_cpu2.getValue();
        ProcessData processData = new ProcessData(input_name.getText(),cpu1,cpu2);
        list.add(processData);
        input_cpu1.setValue(null);
        input_cpu2.setValue(null);
        cpus.removeAll(cpu1,cpu2);
        input_name.setText("");
    }

    ObservableList<ProcessData> list = FXCollections.observableArrayList();
    ObservableList<Integer> cpus = FXCollections.observableArrayList(0,1,2,3,4,5);

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        input_cpu1.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (oldValue != null) cpus.add(oldValue);
            cpus.remove(newValue);
        });
        input_cpu2.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (oldValue != null) cpus.add(oldValue);
            cpus.remove(newValue);
        });

        list.add(new ProcessData("p1",1,5));
        list.add(new ProcessData("p2",3,4));
        list.add(new ProcessData("p3",6,2));

        try {input_cpu1.setItems(cpus);
            input_cpu2.setItems(cpus);
        name.setCellValueFactory(new PropertyValueFactory<>("name"));
        cpu1.setCellValueFactory(new PropertyValueFactory<>("cpu1"));
        cpu2.setCellValueFactory(new PropertyValueFactory<>("cpu2"));
        table.setItems(list);
    }
    catch (Exception e) {
        e.printStackTrace();
    }

    }
}
