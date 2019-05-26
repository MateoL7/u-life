package userInterface;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
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
    private Label LbClock;


	@FXML
	public void initialize() {
		
		Alert x = new Alert(AlertType.INFORMATION);
		x.setTitle("Important information");
		x.setHeaderText("We are working for your confort");
		x.setContentText("This is a beta version of the free app.\nWe are still working on this version.\nIt will start working with the upcoming updates\nIf you would like to see the real app, create a premium account.");
		x.resizableProperty().set(true);
		x.showAndWait();
		
		
		TituloAlarmas.setVisible(false);
		TituloActividades.setVisible(false);
		new Thread(new Runnable() {
			@Override
			public void run() {
				while(true) {
					// se crea un hilo de javafx para cambiar el reloj
					Platform.runLater(new Runnable() {
						@Override
						public void run() {
						DateFormat date = new SimpleDateFormat("hh:mm:a");
							Calendar cal = Calendar.getInstance();
						     String t = date.format(cal.getTime());
			                LbClock.setText(t);

						}	
					});
					//Sleep adentro del while
				 try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				 
				}
			}
			
		}).start();
		
	}
	
	public void showAlarms(ActionEvent e) {
		
	}


}