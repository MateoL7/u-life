package userInterface;

import java.io.FileNotFoundException;
import java.io.IOException;

import javax.swing.JOptionPane;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import model.ULife;

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
    
    private ULife ulife;

    public void initialize() {
    	ulife = new ULife();
    }
    
    public void doneRegistration(ActionEvent e) {
    	String username = nameT.getText();
    	String password = passwordT.getText();
    	int age = Integer.parseInt(ageT.getText());
    	double weight = Double.parseDouble(weightT.getText());
    	double height =  Double.parseDouble(heightT.getText());
    	String gender = genderT.getText();
    	String nickName = nicknameT.getText();
    	JOptionPane.showMessageDialog(null,ulife.CreateNewUser(username, password, age, weight, height, gender, nickName));
    	try {
			ulife.SaveData();
		} catch (FileNotFoundException e1) {
		    JOptionPane.showMessageDialog(null, "no se pudo encontar el archivo");
		
		} catch (IOException e1) {
		JOptionPane.showMessageDialog(null, " hubo un error");
			
		}
    }
}
