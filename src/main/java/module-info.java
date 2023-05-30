module com.example.poprojekt {
    requires javafx.controls;
    requires javafx.fxml;
            
                            
    opens com.example.poprojekt to javafx.fxml;
    opens com.example.poprojekt.FXController to javafx.fxml;
    exports com.example.poprojekt;
    exports com.example.poprojekt.FXController;
}