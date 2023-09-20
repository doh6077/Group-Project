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

public class TransferFXML extends Application {

    @Override
    public void start(Stage primaryStage) {
        // Create the root TitledPane
        TitledPane titledPane = new TitledPane("Bank Management", null);
        titledPane.setAnimated(false);
        titledPane.setPrefSize(600, 400);

        // Create the content AnchorPane
        AnchorPane contentPane = new AnchorPane();
        contentPane.setPrefSize(600, 400);

        // Create the Transfer Money Text
        Text transferText = new Text("Transfer Money");
        transferText.setFont(Font.font("Elephant", 25));
        HBox transferBox = new HBox(transferText);
        transferBox.setLayoutX(58);
        transferBox.setLayoutY(25);

        // Create the from Account Number Text and TextField
        Text accountFromText = new Text("From Account:");
        accountFromText.setFont(Font.font("SansSerif Regular", 20));
        TextField accountNumberFromField = new TextField();
        HBox accountNumberFromBox = new HBox(accountFromText, accountNumberFromField);
        accountNumberFromBox.setLayoutX(50);
        accountNumberFromBox.setLayoutY(94);
        HBox.setMargin(accountFromText, new Insets(0, 35, 0, 30));

        // Create the to Account Number Text and TextField
        Text accountToText = new Text("To Account:");
        accountToText.setFont(Font.font("SansSerif Regular", 20));
        TextField accountNumberToField = new TextField();
        HBox accountNumberToBox = new HBox(accountToText, accountNumberToField);
        accountNumberToBox.setLayoutX(70);
        accountNumberToBox.setLayoutY(144);
        HBox.setMargin(accountToText, new Insets(0, 35, 0, 30));

        // Create the transfer Amount Text and TextField
        Text transferAmountText = new Text("Transfer Amount:");
        transferAmountText.setFont(Font.font("SansSerif Regular", 20));
        TextField transferAmountField = new TextField();
        HBox transferAmountBox = new HBox(transferAmountText, transferAmountField);
        transferAmountBox.setLayoutX(30);
        transferAmountBox.setLayoutY(194);
        HBox.setMargin(transferAmountText, new Insets(0, 35, 0, 15));
        HBox.setMargin(transferAmountField, new Insets(0, 0, 0, 10));

        // Create the Cancel and Confirm Buttons
        Button cancelBtn = new Button("Cancel");
        Button confirmBtn = new Button("Confirm");
        HBox buttonsBox = new HBox(cancelBtn, confirmBtn);
        buttonsBox.setLayoutX(243);
        buttonsBox.setLayoutY(257);
        HBox.setMargin(cancelBtn, new Insets(0, 0, 0, 10));
        HBox.setMargin(confirmBtn, new Insets(0, 0, 0, 10));

        // Set actions for Cancel and Confirm buttons
        cancelBtn.setOnAction(e -> {
            // Information Alert for canceling the transaction
            callAlert("Cancel", "Your transaction has been successfully canceled");

            // Reset text fields
            accountNumberFromField.setText("");
            accountNumberToField.setText("");
            transferAmountField.setText("");
        });

        confirmBtn.setOnAction(e -> {
            // Implement the logic for the confirm button action here
            // (e.g., perform the actual withdrawal)
            String amountText = transferAmountField.getText();
            callAlert("Confirm", "You have successfully transferred $" + amountText);

            // Reset text fields
            accountNumberFromField.setText("");
            accountNumberToField.setText("");
            transferAmountField.setText("");
        });

        // Add all the components to the content AnchorPane
        contentPane.getChildren().addAll(transferBox, accountNumberFromBox, accountNumberToBox, transferAmountBox,
                buttonsBox);

        // Set the content of the TitledPane
        titledPane.setContent(contentPane);

        // Create the Scene and set it to the primary stage
        Scene scene = new Scene(new StackPane(titledPane), 600, 400);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Bank Management App");
        primaryStage.show();
    }

    // Method to show information alert
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