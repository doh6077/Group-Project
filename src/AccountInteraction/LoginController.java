package AccountInteraction;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class LoginController {

    @FXML
    private Button btnCancel;

    @FXML
    private Button btnSignin;

    @FXML
    private TextField passwordInput;

    @FXML
    private TextField usernameInput;

    @FXML
    void onClickCancel(ActionEvent event) {
        Main.setRoot("Main",400,200);
    }

    @FXML
    void onClickSignin(ActionEvent event) {
        if (loginValidation(usernameInput.getText(), passwordInput.getText(), "UserInfo.txt")){
            Main.setLoggedInUser(usernameInput.getText());
            Main.setRoot("HomePage",600,400);
        }else{
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Alert");
            alert.setHeaderText(null);
            alert.setContentText("Username or password NOT CORRECT!");
            alert.showAndWait();
        }
    }

    public static boolean loginValidation(String username, String password, String userInfoFile){
        boolean match = false;
        try(Scanner input = new Scanner(new File(userInfoFile))){
            while (input.hasNext()) {
            String[] userInfo = input.nextLine().split(",");
            String userName =userInfo[0];
            String passWord = userInfo[1];
            if (userName.equals(username) && passWord.equals(password)) {
                match = true;
                break;
            }
            }
        }catch (IOException e) {
            System.err.println("Error writing data: " + e.getMessage());
           
        }
        return match;

    }
}
