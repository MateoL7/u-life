package userInterface;

import java.io.EOFException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Optional;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import model.ULife;
import personalExceptions.MissingInfoException;
/** 
*@author: Mateo Loaiza
*@author: Juan Pablo Herrera
*@version: 26/05/2019
*Class RegisterGUI
*/
public class RegisterGUI {

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
	private RadioButton premiumR;

	@FXML
	private Button registration;

	private ULife ulife;

	private Scene scene;

	public void initialize() {
		ulife = new ULife();
		try {
			ulife.loadData();
		} 
		catch(EOFException t) {
			Alert alert = new Alert(Alert.AlertType.WARNING);
	        alert.initStyle(StageStyle.UTILITY);
	        alert.setTitle("Information");
	        alert.setHeaderText("Welcome!");
	        alert.setContentText("You will be our first user :D");

	       alert.showAndWait();
		}
		catch(IOException e) {
			Alert alert = new Alert(Alert.AlertType.WARNING);
	        alert.initStyle(StageStyle.UTILITY);
	        alert.setTitle("Information");
	        alert.setHeaderText("Welcome!");
	        alert.setContentText("You will be our first user");

	       alert.showAndWait();
		} catch (ClassNotFoundException e) {

			e.printStackTrace();
		}
	}

	public void setScene(Scene s) {
		scene = s;
	}

	public void doneRegistration(ActionEvent e) {
		String msg;
		Alert alertR = new Alert(AlertType.CONFIRMATION);
		alertR.setTitle("Confirmation Dialog");
		alertR.setHeaderText("Registration Information");
		alertR.setContentText("Are you done with the registration?");

		Optional<ButtonType> result = alertR.showAndWait();
		if (result.get() == ButtonType.OK){
			try {
				String username = usernameT.getText();
				String password = passwordT.getText();
				int age = Integer.parseInt(ageT.getText());
				double weight = Double.parseDouble(weightT.getText());
				double height =  Double.parseDouble(heightT.getText());
				String gender = genderT.getText();
				String nickName = nicknameT.getText();
				String name = nameT.getText();
				if(premiumR.isSelected()){
					ulife.createNewPremiumUser(username, password, age, weight, height, gender, nickName, name);
				}
				else{
					ulife.createNewUser(username, password, age, weight, height, gender, nickName, name);	
				}
				ulife.saveData();

				//Closing the register window
				if(scene != null) {
					((Stage) scene.getWindow()).close();
				}

				//Loading the Login window again
				FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Login.fxml"));
				Parent root = fxmlLoader.load();
				Stage stage = new Stage();
				Scene scene = new Scene(root);
				stage.setTitle("Login");
				LoginGUI lc = fxmlLoader.getController();
				lc.setScene(scene);
				stage.setScene(scene);
				stage.show();




			} catch (FileNotFoundException e1) {
				msg = ("No file found");
				messageDialog.setText(msg);
			} catch (IOException e2) {
				msg = ("IOException");
				messageDialog.setText(msg);	
			}

			catch(MissingInfoException m) {
				Alert alert = new Alert(Alert.AlertType.WARNING);
				alert.initStyle(StageStyle.UTILITY);
				alert.setTitle("Information");
				alert.setHeaderText("WARNING!");
				alert.setContentText(m.getMessage());

				alert.showAndWait();
			}
			catch(NumberFormatException nf) {
				Alert alert = new Alert(Alert.AlertType.WARNING );
				alert.initStyle(StageStyle.UTILITY);
				alert.setTitle("Information");
				alert.setHeaderText("WARNING!");
				alert.setContentText("Please provide the information correclty.");

				alert.showAndWait();
			}
		}
	}
}
