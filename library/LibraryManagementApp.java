package library;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import library.Controllers.MainViewController;

public class LibraryManagementApp extends Application {

    @Override
    // Not Functional
    public void start(Stage primaryStage) throws Exception {
        // Load the FXML file for the main view
        FXMLLoader loader = FXMLLoader.load(getClass().getResource("MainView.fxml"));
        Parent root = loader.load();

        // Set up the controller for the main view
        MainViewController controller = loader.getController();
        controller.setPrimaryStage(primaryStage); // Pass the primary stage reference if needed

        // Set up the primary stage
        primaryStage.setTitle("Library Management System");
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}