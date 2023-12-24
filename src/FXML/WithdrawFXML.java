package FXML;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.TitledPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class WithdrawFXML extends Application {

    @Override
    public void start(Stage primaryStage) {
        // Create the main TitledPane
        TitledPane titledPane = new TitledPane("Bank Management", null);
        titledPane.setAnimated(false);
        titledPane.setPrefSize(600, 400);

        // Create the content AnchorPane
        AnchorPane contentPane = new AnchorPane();
        contentPane.setPrefSize(300, 300);

        // Create the "Withdraw" Text
        Text withdrawText = new Text("Withdraw");
        withdrawText.setFont(Font.font("Elephant", 25));
        HBox withdrawBox = new HBox(withdrawText);
        withdrawBox.setLayoutX(58);
        withdrawBox.setLayoutY(25);

        // Create the "Account Number" Text and TextField
        Text accountNumberText = new Text("Account Number:");
        accountNumberText.setFont(Font.font("SansSerif Regular", 20));
        TextField accountNumberField = new TextField();
        HBox accountNumberBox = new HBox(accountNumberText, accountNumberField);
        accountNumberBox.setLayoutX(30);
        accountNumberBox.setLayoutY(94);
        HBox.setMargin(accountNumberText, new Insets(0, 35, 0, 30));

        // Create the "Withdraw Amount" Text and TextField
        Text withdrawAmountText = new Text("Withdraw Amount:");
        withdrawAmountText.setFont(Font.font("SansSerif Regular", 20));
        TextField withdrawAmountField = new TextField();
        HBox withdrawAmountBox = new HBox(withdrawAmountText, withdrawAmountField);
        withdrawAmountBox.setLayoutX(25);
        withdrawAmountBox.setLayoutY(144);
        HBox.setMargin(withdrawAmountText, new Insets(0, 35, 0, 15));
        HBox.setMargin(withdrawAmountField, new Insets(0, 0, 0, 10));

        // Create the "Cancel" and "Confirm" Buttons
        Button cancelBtn = new Button("Cancel");
        Button confirmBtn = new Button("Confirm");
        HBox buttonsBox = new HBox(cancelBtn, confirmBtn);
        buttonsBox.setLayoutX(243);
        buttonsBox.setLayoutY(207);
        HBox.setMargin(cancelBtn, new Insets(0, 0, 0, 10));
        HBox.setMargin(confirmBtn, new Insets(0, 0, 0, 10));

        // Set actions for "Cancel" and "Confirm" buttons
        cancelBtn.setOnAction(e -> {
            // Display an information alert for canceling the transaction
            callAlert("Cancel", "Your transaction has been successfully canceled");

            // Reset text fields
            accountNumberField.setText("");
            withdrawAmountField.setText("");
        });

        confirmBtn.setOnAction(e -> {
            String amountText = withdrawAmountField.getText();
            callAlert("Confirm", "You have successfully withdrawn $" + amountText);

            // Reset text fields
            accountNumberField.setText("");
            withdrawAmountField.setText("");
        });

        // Add all components to the content AnchorPane
        contentPane.getChildren().addAll(withdrawBox, accountNumberBox, withdrawAmountBox, buttonsBox);

        // Set the content of the main TitledPane
        titledPane.setContent(contentPane);

        // Create the Scene and set it to the primary stage
        Scene scene = new Scene(new StackPane(titledPane), 600, 400);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Bank Management App");
        primaryStage.show();
    }

    // Method to display an information alert
    public void callAlert(String title, String text) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(text);
        alert.showAndWait();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
