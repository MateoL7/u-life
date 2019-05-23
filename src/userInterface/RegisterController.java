package userInterface;

import java.io.FileNotFoundException;
import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import model.ULife;

public class RegisterController {

	@FXML
	private Label messageDialog;

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
		String msg;
		try {
			String username = nameT.getText();
			String password = passwordT.getText();
			int age = Integer.parseInt(ageT.getText());
			double weight = Double.parseDouble(weightT.getText());
			double height =  Double.parseDouble(heightT.getText());
			String gender = genderT.getText();
			String nickName = nicknameT.getText();
			String name = nameT.getText();
			msg = ulife.createNewUser(username, password, age, weight, height, gender, nickName, name);	
			try {
				ulife.saveData();
				messageDialog.setText(msg);
			} catch (FileNotFoundException e1) {
				msg = ("No file found");
				messageDialog.setText(msg);
			} catch (IOException e2) {
				msg = ("IOException");
				messageDialog.setText(msg);	
			} 
		} catch(NumberFormatException nf) {
			msg = "WARNING!\nPlease provide all \nof the information.";
			messageDialog.setText(msg);
		}
	}
}
