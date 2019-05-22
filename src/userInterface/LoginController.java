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
import javafx.stage.Stage;
import model.Account;
import model.ULife;

public class LoginController {

    @FXML
    private TextField username;

    @FXML
    private TextField password;

    @FXML
    private Button loginBt;

    @FXML
    private Button cancelBt;

    @FXML
    private Button registerBt;
    
    private ULife ul;
    
    private Scene scene;
    
    public void setScene(Scene scene) {
    	this.scene = scene;
    }
    
    @FXML
    public void initialize(){
    	ul = new ULife();
    }

    @FXML
    public void cancelLogin(ActionEvent event) {
    	int option = JOptionPane.showConfirmDialog(null, "Are you sure you want to exit ULife?");
    	if(option == 0) {
    		((Stage) scene.getWindow()).close();
    	}
    }

    @FXML
    public void createAccount(ActionEvent event) {
    	try {
    		((Stage) scene.getWindow()).close();
    		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Register.fxml"));
    		Parent root = fxmlLoader.load();
    		
    		Stage stage = new Stage();

    		Scene scene = new Scene(root);
    		stage.setTitle("Register");
    		stage.setScene(scene);
    		stage.show();
    	}catch(IOException i) {
    		
    	}
    }

    @FXML
    public void login(ActionEvent event) {
    	try {
    		String usern = username.getText();
        	String pass = password.getText();
        	ul.LoadData();
        	Account a = ul.searchAccount(usern, pass);
        	if(a != null) {
			((Stage) scene.getWindow()).close();
			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("App.fxml"));
    		Parent root = fxmlLoader.load();
    		
    		Stage stage = new Stage();

    		Scene scene = new Scene(root);
    		stage.setTitle("ULife");
    		stage.setScene(scene);
    		stage.show();
        	}
        	else {
        		JOptionPane.showMessageDialog(null, "No account found with that information");
        		JOptionPane.showMessageDialog(null, "Register if you do not have an account");
        	}
    	} catch(NumberFormatException n) {
    		System.out.println("Number format, esto lo cambio");
    	}catch(NullPointerException e) {
    		e.printStackTrace();
    	}catch (IOException e) {
			e.printStackTrace();
		}catch(ClassNotFoundException c) {
			c.printStackTrace();;
		}
    }

}
