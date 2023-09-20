package AccountInteraction;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class MainController {

    @FXML
    void onClickNo(ActionEvent event) {
        Main.setRoot("Signup",400,400);
    }

    @FXML
    void onClickYes(ActionEvent event) {
        Main.setRoot("Login",400,250);
    }

}