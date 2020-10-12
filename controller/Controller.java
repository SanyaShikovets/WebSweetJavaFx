package controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import model.present.Present;
import model.sweets.Sweet;

import java.util.ArrayList;
import java.util.List;

public class Controller {

    /**
     * selected name text field
     */
    @FXML
    public TextField selectNameTextField;

    /**
     * selected min weight text field
     */
    @FXML
    public TextField selectMinWeightTextField;
    /**
     * selected max weight text field
     */
    @FXML
    public TextField selectMaxWeightTextField;

    /**
     * table view of
     */
    @FXML
    private TableView<Sweet> tableView;

    /**
     * column of medicine name
     */
    @FXML
    private TableColumn<Sweet, String> nameColumn;

    /**
     * column of medicine weight
     */
    @FXML
    private TableColumn<Sweet, Double> weightColumn;

    /**
     * text area to show some info
     */
    @FXML
    private TextArea sweetDescriptionTextArea;

    /**
     * some present
     */
    private ObservableList<Sweet> present = FXCollections.observableArrayList();

    /**
     * initialize some UI method
     */
    @FXML
    private void initialize() {
        addTestData();
        nameColumn.setCellValueFactory(new PropertyValueFactory<Sweet, String>("name"));
        weightColumn.setCellValueFactory(new PropertyValueFactory<Sweet, Double>("weight"));
        tableView.setItems(present);
    }

    private Present pr = new Present();

    /**
     * test sweet data to present
     */
    private void addTestData() {
        present.add(new Sweet("Snikers", 500));
        present.add(new Sweet("Snikers", 520));
        present.add(new Sweet("Kit-kat", 300));
        present.add(new Sweet("Baunti", 550));
        pr.addSweet(new Sweet("Snikers", 500));
        pr.addSweet(new Sweet("Snikers", 520));
        pr.addSweet(new Sweet("Kit-kat", 300));
        pr.addSweet(new Sweet("Baunti", 550));
    }

    /**
     * handling tap select by name button
     *
     */
    public void onSelectByNameTapped() {
        String name = selectNameTextField.getText();
        if (name.isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR, "Enter name", ButtonType.OK);
            alert.showAndWait();
            if (alert.getResult() == ButtonType.OK) {
                alert.hide();
            }
        } else {
            List<Sweet> result;
            result = pr.selectSweetByName(name);
            String buffer = "";
            for(Sweet sw : result) {
                buffer += sw.toString();
                buffer += "\n";
            }
            sweetDescriptionTextArea.setText(buffer);
        }
    }

    /**
     * handling tap drlrvt by weight button
     *
     */
    public void onSelectByWeightTapped() {
        String minWeight = selectMinWeightTextField.getText();
        String maxWeight = selectMaxWeightTextField.getText();
        if (maxWeight.isEmpty() || minWeight.isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR, "Enter weight range", ButtonType.OK);
            alert.showAndWait();
            if (alert.getResult() == ButtonType.OK) {
                alert.hide();
            }
        } else {
            List<Sweet> result;
            result = pr.selectSweetByWeightRange(Double.parseDouble(minWeight),Double.parseDouble(maxWeight));
            String buffer = "";
            for(Sweet sw : result) {
                buffer += sw.toString();
                buffer += "\n";
            }
            sweetDescriptionTextArea.setText(buffer);
        }
    }

    /**
     * handling tap reset button
     *
     */
    public void onResetButtonTapped() {
        selectNameTextField.setText(null);
        selectMinWeightTextField.setText(null);
        selectMaxWeightTextField.setText(null);
    }
}
