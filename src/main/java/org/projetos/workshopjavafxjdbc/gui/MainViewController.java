package org.projetos.workshopjavafxjdbc.gui;


import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.VBox;
import org.projetos.workshopjavafxjdbc.Main;
import org.projetos.workshopjavafxjdbc.gui.util.Alerts;
import org.projetos.workshopjavafxjdbc.model.services.DepartmentService;


import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.function.Consumer;

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
        loadView("/org/projetos/workshopjavafxjdbc/gui/DepartmentList.fxml",
                (DepartmentListController controller)->  {controller.setDepartmentService(new DepartmentService());
        controller.updateTableView();
        });
    }
    @FXML
    private void onMenuItemAboutAction() {
        loadView("/org/projetos/workshopjavafxjdbc/gui/About.fxml",x -> {});

    }
    @Override
    public void initialize(URL uri, ResourceBundle rb) {}
   private synchronized <T> void loadView(String absoluteName, Consumer<T> initializingAction) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(absoluteName));
            VBox newVbox = loader.load();

            ScrollPane scrollPane = (ScrollPane) Main.getMainScene().getRoot();
            VBox mainVbox = (VBox) scrollPane.getContent();  // <-- direto do ScrollPane

            Node mainMenu = mainVbox.getChildren().get(0);  // MenuBar

            mainVbox.getChildren().clear();
            mainVbox.getChildren().add(mainMenu);
            mainVbox.getChildren().addAll(newVbox.getChildren());

            T controller = loader.getController();
            initializingAction.accept(controller);

        } catch (IOException e) {
            Alerts.showAlert("IO Exception", "Erro Loading View", e.getMessage(), Alert.AlertType.ERROR);
            e.printStackTrace();
        }
    }

}
