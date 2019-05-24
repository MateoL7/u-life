package userInterface;

import java.io.IOException;

import javax.swing.JOptionPane;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import model.Account;
import model.PremiumAccount;
import model.ULife;

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
		int option = JOptionPane.showConfirmDialog(null, "Are you sure you want to exit ULife?");
		if(option == 0) {
			((Stage) scene.getWindow()).close();
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

		}catch(IOException i) {

		}
	}

	@FXML
	public void login(ActionEvent ev) {
		setLg(this);
		try {
			String usern = username.getText();
			String pass = password.getText();
			ul.loadData();
			Account a = ul.searchAccount(usern, pass);
			if(a != null) {
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
			else {
				JOptionPane.showMessageDialog(null, "No account found with that information");
				JOptionPane.showMessageDialog(null, "Register if you do not have an account");
			}
		}
		catch(ClassNotFoundException c) {
			c.printStackTrace();
		}
		catch(NullPointerException e) {
			e.printStackTrace();
		}
		catch (IOException e1) {
			e1.printStackTrace();
		}
	}

}