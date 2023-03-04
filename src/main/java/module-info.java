module com.example.demo {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.kordamp.bootstrapfx.core;

    opens com.example.demo to javafx.fxml, javafx.graphics;
    exports com.example.demo;
    opens com.example.demo.openweb to javafx.fxml, javafx.graphics;
    exports com.example.demo.openweb;

    opens com.example.demo.layout to javafx.fxml, javafx.graphics;
    exports com.example.demo.layout;

    opens com.example.demo.menu to javafx.fxml, javafx.graphics;
    exports com.example.demo.menu;
}