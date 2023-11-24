module com.dino.app {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires org.kordamp.bootstrapfx.core;
    requires com.almasb.fxgl.all;

    opens com.dino.app to javafx.fxml;
    exports com.dino.app;
    exports com.dino.app.controllers;
    opens com.dino.app.controllers to javafx.fxml;
}