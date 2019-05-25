 package userInterface;

import java.io.FileNotFoundException;
import java.io.IOException;

import javax.swing.JOptionPane;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.ULife;
import personalExceptions.MissingInfoException;

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
	}

	public void setScene(Scene s) {
		scene = s;
	}

	public void doneRegistration(ActionEvent e) {
		String msg;
		try {
			String username = usernameT.getText();
			String password = passwordT.getText();
			int age = Integer.parseInt(ageT.getText());
			double weight = Double.parseDouble(weightT.getText());
			double height =  Double.parseDouble(heightT.getText());
			String gender = genderT.getText();
			String nickName = nicknameT.getText();
			String name = nameT.getText();
			System.out.println(username + "  " + password + "  " +age + "  " +weight+ "  " + height+ "  " + gender+ "  "+ nickName+ "  " +name);
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
				System.out.println(msg);
				messageDialog.setText(msg);
			} catch (IOException e2) {
				msg = ("IOException");
				System.out.println(msg);
				messageDialog.setText(msg);	
			}
	
		catch(MissingInfoException m) {
			msg = m.getMessage();
			System.out.println(msg);
			messageDialog.setText(msg);
		}
		catch(NumberFormatException nf) {
			msg = "WARNING!\nPlease provide\nthe information correclty.";
			System.out.println(msg);
			messageDialog.setText(msg);
		}
	}
}
