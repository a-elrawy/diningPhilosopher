module com.os.diningphilosopher {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.kordamp.bootstrapfx.core;

    opens com.os.diningphilosopher to javafx.fxml;
    exports com.os.diningphilosopher;
}