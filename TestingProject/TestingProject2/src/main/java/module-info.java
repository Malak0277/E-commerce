module com.example.testingproject {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.media;
    requires org.jetbrains.annotations;
    requires jdk.compiler;


    opens com.example.testingproject to javafx.fxml;
    exports com.example.testingproject;
}