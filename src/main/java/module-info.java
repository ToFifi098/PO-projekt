module com.example.poprojekt {
    requires javafx.controls;
    requires javafx.fxml;
            
                            
    opens com.example.poprojekt to javafx.fxml;
    exports com.example.poprojekt;
}