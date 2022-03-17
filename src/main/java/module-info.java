module com.example.uhr_decker_jhuber_nschickm {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.example.uhr_decker_jhuber_nschickm to javafx.fxml;
    exports com.example.uhr_decker_jhuber_nschickm;
    exports Model;
    opens Model to javafx.fxml;
    exports View;
    opens View to javafx.fxml;
}