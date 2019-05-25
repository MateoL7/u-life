package userInterface;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javafx.application.Platform;
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
    private Label LbClock;


	@FXML
	public void initialize() {
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