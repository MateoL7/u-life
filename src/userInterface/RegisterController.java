package userInterface;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class RegisterController {

    @FXML
    private TextField nameT;

    @FXML
    private TextField usernameT;

    @FXML
    private TextField passwordT;

    @FXML
    private TextField ageT;

    @FXML
    private TextField heightT;

    @FXML
    private TextField weightT;

    @FXML
    private TextField genderT;

    @FXML
    private TextField nicknameT;

    @FXML
    private Button registration;

    
    public void doneRegistration(ActionEvent e) {
    	System.out.println("Works");
    }
}
