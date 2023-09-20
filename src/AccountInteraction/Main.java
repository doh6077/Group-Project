package AccountInteraction;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {

    private static Stage primaryStage;
    private static String loggedInUser;

    public static void setLoggedInUser(String username) {
        loggedInUser = username;
    }

    public static String getLoggedInUser() {
        return loggedInUser;
    }

    @Override
    public void start(Stage primaryStage) {
        Main.primaryStage = primaryStage;
        showScreen();
        
    }

    public static void main(String[] args) {
        launch(args);
    }

    public static void showScreen() {
        try {
            Parent root = FXMLLoader.load(Main.class.getResource("Main.fxml"));
            primaryStage.setTitle("Log in / Sign up");
            primaryStage.setScene(new Scene(root, 400, 200));
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void setRoot(String fxmlFile, int width, int height) {
        try {
            Parent root = FXMLLoader.load(Main.class.getResource(fxmlFile + ".fxml"));
            primaryStage.setScene(new Scene(root, width, height));
            primaryStage.setTitle(fxmlFile);
           
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
   

}
