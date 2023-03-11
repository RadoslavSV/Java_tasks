module view {
    requires javafx.controls;
    requires javafx.fxml;
    requires model;

    opens fxml to javafx.fxml;
    exports fxml;
}