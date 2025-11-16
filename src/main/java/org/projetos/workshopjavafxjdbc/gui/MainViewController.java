package org.projetos.workshopjavafxjdbc.gui;


import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import org.projetos.workshopjavafxjdbc.Main;
import org.projetos.workshopjavafxjdbc.gui.util.Alerts;


import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class MainViewController implements Initializable {
    @FXML
    private MenuItem menuItemSeller;
    @FXML
    private MenuItem menuItemDepartment;
    @FXML
    private MenuItem menuItemAbout;
    @FXML
    private void onMenuItemSellerAction() {
        System.out.println("onMenuItemSellerAction");
    }
    @FXML
    private void onMenuItemDepartmentAction() {
        loadView("/org/projetos/workshopjavafxjdbc/gui/DepartmentList.fxml");
    }
    @FXML
    private void onMenuItemAboutAction() {
        loadView("/org/projetos/workshopjavafxjdbc/gui/About.fxml");

    }
    @Override
    public void initialize(URL uri, ResourceBundle rb) {}
    private synchronized void loadView(String absoluteName) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(absoluteName));
            VBox newVbox = loader.load();

            ScrollPane scrollPane = (ScrollPane) Main.getMainScene().getRoot();
            VBox mainVbox = (VBox) scrollPane.getContent();  // <-- direto do ScrollPane

            Node mainMenu = mainVbox.getChildren().get(0);  // MenuBar

            mainVbox.getChildren().clear();
            mainVbox.getChildren().add(mainMenu);
            mainVbox.getChildren().addAll(newVbox.getChildren());

        } catch (IOException e) {
            Alerts.showAlert("IO Exception", "Erro Loading View", e.getMessage(), Alert.AlertType.ERROR);
            e.printStackTrace();
        }
    }

}
