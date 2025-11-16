package org.projetos.workshopjavafxjdbc.gui;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import org.projetos.workshopjavafxjdbc.Main;
import org.projetos.workshopjavafxjdbc.model.entities.Department;
import org.projetos.workshopjavafxjdbc.model.services.DepartmentService;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class DepartmentListController implements Initializable {
    private DepartmentService service;
    @FXML
    private TableView<Department> tableViewDepartment;
    @FXML
    private TableColumn<Department, Integer> tableColumnId;
    @FXML
    private TableColumn<Department, String> tableColumnName;
    @FXML
    private Button btNew;
    private ObservableList<Department> obsList;
    @FXML
    public void onBtNewAction(){
        System.out.println("New Button clicked");
    }
    public void setDepartmentService(DepartmentService service) {
        this.service = service;
    }

    @FXML













    public void initialize(URL uri, ResourceBundle rb) {
        initializeNodes();
    }
    public void initializeNodes(){
        tableColumnId.setCellValueFactory(new PropertyValueFactory<Department, Integer>("id"));
        tableColumnName.setCellValueFactory(new PropertyValueFactory<Department, String>("name"));
        Stage stage = (Stage) Main.getMainScene().getWindow();
        tableViewDepartment.prefHeightProperty().bind(stage.heightProperty());
    }
    public void updateTableView() {
        if(service==null){
            throw new IllegalStateException("Department Service is null");
        }
        List<Department> list= service.findAll();
        obsList = FXCollections.observableArrayList(list);
        tableViewDepartment.setItems(obsList);
    }
}
