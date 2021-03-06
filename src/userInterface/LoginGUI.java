package userInterface;

import java.io.EOFException;
import java.io.IOException;
import java.util.Optional;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import model.Account;
import model.PremiumAccount;
import model.ULife;
import personalExceptions.MissingInfoException;
import personalExceptions.NoAccountFoundException;
import personalExceptions.NoDataException;
/** 
*@author: Mateo Loaiza
*@author: Juan Pablo Herrera
*@version: 26/05/2019
*Class LoginGUI
*/
public class LoginGUI {

	@FXML
	private TextField username;

	@FXML
	private TextField password;

	@FXML
	private Button loginBt;

	@FXML
	private Button cancelBt;

	private ULife ul;

	private Scene scene;

	private RegisterGUI rc;
	
	private Account ac;
	
	private static LoginGUI lg;

	public void setScene(Scene scene) {
		this.scene = scene;
	}

	@FXML
	public void initialize(){
		ul = new ULife();
		
	}
	
	public void setLg(LoginGUI l){
		lg = l;
	}
	
	public static LoginGUI getLg() {
		return lg;
	}
	
	public void setAccount(Account a) {
		ac = a;
	}
	public Account getAccount() {
		return ac;
	}

	@FXML
	public void cancelLogin(ActionEvent event) {
		Alert alert = new Alert(AlertType.CONFIRMATION);
		alert.setTitle("Confirmation Dialog");
		alert.setHeaderText("You are about to exit the program");
		alert.setContentText("Are you ok with this?");

		Optional<ButtonType> result = alert.showAndWait();
		if (result.get() == ButtonType.OK){
			((Stage) scene.getWindow()).close();
		} else {
		}
			
	}

	@FXML
	public void createAccount(MouseEvent event) {
		try {
			//Close the Login window
			((Stage) scene.getWindow()).close();

			//Open the register window
			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Register.fxml"));
			Parent root = fxmlLoader.load();
			Stage stage = new Stage();
			Scene scene = new Scene(root);
			rc = fxmlLoader.getController();
			rc.setScene(scene);
			stage.setTitle("Register");
			stage.setScene(scene);
			stage.show();

		}
		catch(EOFException t) {
			Alert alert = new Alert(Alert.AlertType.WARNING);
	        alert.initStyle(StageStyle.UTILITY);
	        alert.setTitle("Information");
	        alert.setHeaderText("WARNING!");
	        alert.setContentText("No accounts registered yet");

	       alert.showAndWait();
		}
		catch(IOException e) {
			Alert alert = new Alert(Alert.AlertType.WARNING);
	        alert.initStyle(StageStyle.UTILITY);
	        alert.setTitle("Information");
	        alert.setHeaderText("WARNING!");
	        alert.setContentText("No accounts registered yet");

	       alert.showAndWait();
		}
	}

	@FXML
	public void login(ActionEvent ev) {
		try {
			ul.loadData();
		} 
		catch (ClassNotFoundException c) {
			c.printStackTrace();
		}
		catch(EOFException t) {
			Alert alert = new Alert(Alert.AlertType.WARNING);
	        alert.initStyle(StageStyle.UTILITY);
	        alert.setTitle("Information");
	        alert.setHeaderText("WARNING!");
	        alert.setContentText("No accounts registered yet");

	       alert.showAndWait();
		}
		catch(IOException e) {
			Alert alert = new Alert(Alert.AlertType.WARNING);
	        alert.initStyle(StageStyle.UTILITY);
	        alert.setTitle("Information");
	        alert.setHeaderText("WARNING!");
	        alert.setContentText("No accounts registered yet");

	       alert.showAndWait();
		}
		setLg(this);
		try {
			String usern = username.getText();
			String pass = password.getText();
		
			Account a = ul.searchAccount(usern, pass);
			
				setAccount(a);
				boolean keep = true;
				((Stage) scene.getWindow()).close();
				if(a instanceof PremiumAccount) {
					keep = false;
					FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("ProApp.fxml"));
					Parent root = fxmlLoader.load();

					Stage stage = new Stage();

					Scene scene = new Scene(root);
					stage.setTitle("ULife");
					stage.setScene(scene);
					stage.setMaximized(true);
					stage.show();
				}
				if(keep){
					FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("FreeApp.fxml"));
					Parent root = fxmlLoader.load();

					Stage stage = new Stage();

					Scene scene = new Scene(root);
					stage.setTitle("ULife");
					stage.setScene(scene);
					stage.setMaximized(true);
					stage.show();
				}
			}
		catch(NullPointerException e) {
			e.printStackTrace();
		}
		catch (IOException e1) {
			e1.printStackTrace();
		}
		catch(NoAccountFoundException e2) {
			Alert alert = new Alert(Alert.AlertType.WARNING);
	        alert.initStyle(StageStyle.UTILITY);
	        alert.setTitle("Information");
	        alert.setHeaderText("WARNING!");
	        alert.setContentText(e2.getMessage());

	       alert.showAndWait();
		}
		catch(NoDataException nodata) {
			Alert alert = new Alert(Alert.AlertType.WARNING);
	        alert.initStyle(StageStyle.UTILITY);
	        alert.setTitle("Information");
	        alert.setHeaderText("WARNING!");
	        alert.setContentText(nodata.getMessage());
	        alert.showAndWait();

		} catch (MissingInfoException e) {
			Alert alert = new Alert(Alert.AlertType.WARNING);
	        alert.initStyle(StageStyle.UTILITY);
	        alert.setTitle("Information");
	        alert.setHeaderText("WARNING!");
	        alert.setContentText(e.getMessage());
	        alert.showAndWait();
		}
	}

}
