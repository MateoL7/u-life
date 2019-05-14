package userInterface;

import java.io.IOException;

import javax.swing.JOptionPane;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;


public class AppController {

	@FXML
	private Label TituloAlarmas;

	@FXML
	private Label alarma1;

	@FXML
	private Label alarma2;

	@FXML
	private Label alarma3;

	@FXML
	private Label alarma4;

	@FXML
	private Label alarma5;

	@FXML
	private Label alarma411;

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

	@FXML
	public void showAlarms(ActionEvent event) {
		TituloAlarmas.setVisible(true);
		alarma1.setText("1.	9:00 a.m."); 
		alarma2.setText("2.	11:00 a.m.");
		alarma3.setText("3.	1:00 p.m.");
		alarma4.setText("4.	3:00 p.m.");
		alarma5.setText("5.	6:00 p.m.");
		alarma411.setText("6.	9:00 p.m.");
	}
	@FXML
	public void showBreaks(ActionEvent event) {
		TituloActividades.setVisible(true);
		JOptionPane.showMessageDialog(null, "No tienes actividades programadas");
	}
	@FXML
	public void showGames(ActionEvent event) {
		JOptionPane.showMessageDialog(null, "Actualiza tu cuenta a premium");
	}
	@FXML
	public void showReport(ActionEvent event) {
		JOptionPane.showMessageDialog(null, "Actualiza tu cuenta a premium");
	}
	@FXML
	public void showTips(ActionEvent event) {
		lbMessage.setText("1. Una dieta rica en frutas y vegetales\n\n2. Armonía y bienestar emocional");

	}
	@FXML
	public void show(ActionEvent event) throws IOException {
		lbMessage.setText("#1 La falta de ejercicio tantas muertes\n como el tabaco en todo el mundo.\n\n#2 Las personas que comen\ndesayunan o cenan regularmente en \nrestaurantes duplican el riesgo de \nconvertirse en obesos.");
	}
	@FXML
	public void addActivity(ActionEvent event) throws IOException {
		TituloActividades.setVisible(true);
		String msg = JOptionPane.showInputDialog("Escribe tu actividad");
		JOptionPane.showMessageDialog(null,"Tu actividad:\n" + "- "+ msg + "\nHa sido guardada");
		descanso1.setText(msg);
	}

}