package userInterface;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;


public class FreeAppGUI {

	@FXML
	private Label TituloAlarmas;

	@FXML
	private Label alarmas;

	@FXML
	private Label lbMessage;
	
	@FXML
    private Label descanso1;

	@FXML
	private Label TituloActividades;

	@FXML
	public void initialize() {
		TituloAlarmas.setVisible(false);
		TituloActividades.setVisible(false);
	}


}