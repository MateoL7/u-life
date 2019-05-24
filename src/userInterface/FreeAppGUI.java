package userInterface;

import java.io.IOException;
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
						
							Calendar cal = Calendar.getInstance();

			                 int second = cal.get(Calendar.SECOND);
			                int minute = cal.get(Calendar.MINUTE);
			                int hour = cal.get(Calendar.HOUR);
			                LbClock.setText(hour + ":" + (minute) + ":" + second);
			                System.out.println(hour + ":" + (minute) + ":" + second);
			                System.out.println(LbClock.getText());
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