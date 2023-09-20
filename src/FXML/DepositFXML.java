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

public class DepositFXML extends Application {

    @Override
    public void start(Stage primaryStage) {
        // Create the root TitledPane
        TitledPane titledPane = new TitledPane("Bank Management", null);
        titledPane.setAnimated(false);
        titledPane.setPrefSize(600, 400);

        // Create the content AnchorPane
        AnchorPane contentPane = new AnchorPane();
        contentPane.setPrefSize(300, 300);

        // Create the Deposit Text
        Text depositText = new Text("Deposit");
        depositText.setFont(Font.font("Elephant", 25));
        HBox depositBox = new HBox(depositText);
        depositBox.setLayoutX(58);
        depositBox.setLayoutY(25);

        // Create the Account Number Text and TextField
        Text accountNumberText = new Text("Account Number:");
        accountNumberText.setFont(Font.font("SansSerif Regular", 20));
        TextField accountNumberField = new TextField();
        HBox accountNumberBox = new HBox(accountNumberText, accountNumberField);
        accountNumberBox.setLayoutX(30);
        accountNumberBox.setLayoutY(94);
        HBox.setMargin(accountNumberText, new Insets(0, 35, 0, 30));

        // Create the Deposit Amount Text and TextField
        Text depositAmountText = new Text("Deposit Amount:");
        depositAmountText.setFont(Font.font("SansSerif Regular", 20));
        TextField depositAmountField = new TextField();
        HBox depositAmountBox = new HBox(depositAmountText, depositAmountField);
        depositAmountBox.setLayoutX(39);
        depositAmountBox.setLayoutY(144);
        HBox.setMargin(depositAmountText, new Insets(0, 35, 0, 15));
        HBox.setMargin(depositAmountField, new Insets(0, 0, 0, 10));

        // Create the Cancel and Confirm Buttons
        Button cancelBtn = new Button("Cancel");
        Button confirmBtn = new Button("Confirm");
        HBox buttonsBox = new HBox(cancelBtn, confirmBtn);
        buttonsBox.setLayoutX(243);
        buttonsBox.setLayoutY(207);
        HBox.setMargin(cancelBtn, new Insets(0, 0, 0, 10));
        HBox.setMargin(confirmBtn, new Insets(0, 0, 0, 10));

        // Set actions for Cancel and Confirm buttons
        cancelBtn.setOnAction(e -> {
            // Information Alert for canceling the transaction
            callAlert("Cancel", "Your transaction has been successfully canceled");

            // Reset text fields
            accountNumberField.setText("");
            depositAmountField.setText("");
        });

        confirmBtn.setOnAction(e -> {
            // Implement the logic for the confirm button action here
            // (e.g., perform the actual deposit)
            String amountText = depositAmountField.getText();
            callAlert("Confirm", "You have successfully deposited $" + amountText);

            // Reset text fields
            accountNumberField.setText("");
            depositAmountField.setText("");
        });

        // Add all the components to the content AnchorPane
        contentPane.getChildren().addAll(depositBox, accountNumberBox, depositAmountBox, buttonsBox);

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
