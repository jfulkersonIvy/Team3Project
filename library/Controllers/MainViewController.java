package library.Controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.stage.Stage;

public class MainViewController {

    private Stage primaryStage;

    // Setter for the primary stage if needed
    public void setPrimaryStage(Stage primaryStage) {
        this.primaryStage = primaryStage;
    }

    @FXML
    private void viewAvailableBooks() {
        // Implement logic for viewing available books
        showAlert("View Available Books", "Logic for viewing available books goes here");
    }

    @FXML
    private void checkoutBook() {
        // Implement logic for checking out a book
        showAlert("Checkout a Book", "Logic for checking out a book goes here");
    }

    @FXML
    private void returnBook() {
        // Implement logic for returning a book
        showAlert("Return a Book", "Logic for returning a book goes here");
    }

    @FXML
    private void exitApp() {
        // Implement logic for exiting the application
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Are you sure you want to exit?", ButtonType.YES, ButtonType.NO);
        alert.showAndWait();

        if (alert.getResult() == ButtonType.YES) {
            primaryStage.close();
        }
    }

    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
