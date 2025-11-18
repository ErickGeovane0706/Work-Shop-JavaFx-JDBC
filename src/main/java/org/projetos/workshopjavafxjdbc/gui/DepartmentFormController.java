package org.projetos.workshopjavafxjdbc.gui;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import org.projetos.workshopjavafxjdbc.gui.util.Constraints;

import java.net.URL;
import java.util.ResourceBundle;

public class DepartmentFormController implements Initializable {

    @FXML
    private TextField txtId;
    @FXML
    private TextField txtName;
    @FXML
    private Label labelErrorName;
    @FXML
    private Button btnSave;
    @FXML
    private Button btnDelete;

    @FXML
    public void onBtSaveAction() {
        System.out.println("onBtSaveAction");
    }
    @FXML
    public void onBtDeleteAction() {
        System.out.println("onBtDeleteAction");
    }

















    @Override
    public void initialize(URL url, ResourceBundle rb) {
        initializeNodes();
    }
    private void initializeNodes(){
        Constraints.setTextFieldInteger(txtId);
        Constraints.setTextFieldMaxLength(txtName,30);
    }
}
