module org.projetos.workshopjavafxjdbc {
    opens org.projetos.workshopjavafxjdbc.model.entities to javafx.base;
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires net.synedra.validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires eu.hansolo.tilesfx;
    requires com.almasb.fxgl.all;
    requires java.sql;

    opens org.projetos.workshopjavafxjdbc to javafx.fxml;
    exports org.projetos.workshopjavafxjdbc;
    exports org.projetos.workshopjavafxjdbc.gui;
    opens org.projetos.workshopjavafxjdbc.gui to javafx.fxml;
}