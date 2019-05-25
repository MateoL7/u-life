package userInterface;

import java.io.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Optional;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputDialog;
import javafx.scene.layout.Pane;
import model.LoadInfo;
import model.Note;
import model.PremiumAccount;

public class ProAppGUI {

	@FXML
	private Label TituloAlarmas;

	@FXML
	private Label alarmsLb;

	@FXML
	private Label TituloActividades;

	@FXML
	private Label activitiesLb;

	@FXML
	private Pane pickPane;

	@FXML
	private Button bt;

	private TextField tfTh;
	private TextField tfId;

	@FXML
	private Button addAlarmBt;

	@FXML
	private Button addActBt;

	@FXML
	private Label labelMessage;

	@FXML
	private Button addNoteBt;

	private PremiumAccount pa;

	private LoginGUI lg;

	@FXML
	private Label LbClock;

	@FXML
	public void initialize(){
		lg = LoginGUI.getLg();
		pa = (PremiumAccount) lg.getAccount();
		bt.setVisible(false);
		addNoteBt.setVisible(false);
		addActBt.setVisible(false);
		addAlarmBt.setVisible(false);
		new Thread(new Runnable() {
			@Override
			public void run() {
				while(true) {
					// se crea un hilo de javafx para cambiar el reloj
					Platform.runLater(new Runnable() {
						@Override
						public void run() {
							DateFormat date = new SimpleDateFormat("hh:mm:ss:a");
							Calendar cal = Calendar.getInstance();
							String t = date.format(cal.getTime());
							int hour = cal.get(Calendar.HOUR);
							int minute = cal.get(Calendar.MINUTE);
							String contain = pa.CheckAlarm(hour, minute);
							if(contain.isEmpty()) {
								LbClock.setText(t);
							}else {
								LbClock.setText(contain);
							}
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

	@FXML
	public void loadFacts(ActionEvent event) {
		addNoteBt.setVisible(false);
		addActBt.setVisible(false);
		addAlarmBt.setVisible(false);
		String msg = "";
		try {
			String info = pa.loadRandomInfo(LoadInfo.PATHFACTS);
			String[] fact = info.split(",");
			for(int i = 0; i < fact.length;i++) {
				String[] splitFact = fact[i].split(";");
				msg += splitFact[0] + ". " + splitFact[1]+ "\n\n";
				pa.addFunFact(splitFact[0], splitFact[1]);
			}
			labelMessage.setText(msg);

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@FXML
	public void loadNotes(ActionEvent event) {
		addNoteBt.setVisible(true);
		addActBt.setVisible(false);
		addAlarmBt.setVisible(false);
		try {
			BufferedReader br = new BufferedReader(new FileReader(new File("data\\notes.txt")));
			String line = br.readLine();
			String msg = "";
			while(line != null) {

				msg += line + "\n";

				line = br.readLine();
			}
			labelMessage.setText(msg);
			br.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@FXML
	public void loadTips(ActionEvent event) {
		addNoteBt.setVisible(false);
		addActBt.setVisible(false);
		addAlarmBt.setVisible(false);
		String msg = "";
		try {
			String info = pa.loadRandomInfo(LoadInfo.PATHTIPS);
			String[] tip = info.split(",");
			for(int i = 0; i < tip.length;i++) {
				String[] splitTip = tip[i].split(";");
				msg += splitTip[0] + ". " + splitTip[1]+ "\n\n";
				pa.addTip(splitTip[0], splitTip[1]);
			}
			labelMessage.setText(msg);

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@FXML
	public void addNote(ActionEvent event) {
		addActBt.setVisible(false);
		addAlarmBt.setVisible(false);
		labelMessage.setText("");
		bt.setVisible(true);
		tfId = new TextField();
		tfId.setPromptText("Type an id number for your thoughts here");
		tfTh = new TextField();
		tfTh.setPromptText("Type your thoughts");

		tfId.setLayoutX(300);
		tfId.setLayoutY(300);
		tfId.setMinSize(300, 10);

		tfTh.setLayoutX(150);
		tfTh.setLayoutY(400);
		tfTh.setMinSize(600, 100);

		pickPane.getChildren().add(tfId);
		pickPane.getChildren().add(tfTh);

	}

	@FXML
	public void doneAdding(ActionEvent ev) {
		tfId.setVisible(false);
		tfTh.setVisible(false);
		try {
			String id = tfId.getText();
			String th = tfTh.getText();
			int i1 = Integer.parseInt(id);
			if(pa.addNote(i1, th)) {
				BufferedWriter bw = new BufferedWriter(new FileWriter(new File("data\\notes.txt").getAbsoluteFile(), true));
				int i = 0;
				while(i < pa.getNotes().length-1) {
					Note n = pa.getNotes()[i];
					if(n != null) {
						bw.write(n.getNum() + ". " + n.getNote());
						bw.newLine();
					}
					i++;
				}
				bw.close();
			}
		} 
		catch(NumberFormatException nm) {
			nm.printStackTrace();
		}
		catch(IOException e) {
			e.printStackTrace();
		}
		bt.setVisible(false);
	}

	@FXML
	public void addActivity(ActionEvent event) {

	}

	@FXML
	public void addAlarm(ActionEvent event) {
		try {
		int hour = 0;
		int min = 0;
		String time = "";
		boolean vibrate = false;
		String timeDay = "";
//		boolean[] days = new boolean[7];

		//Get the hour
		TextInputDialog hourD = new TextInputDialog("");
		hourD.setTitle("New Alarm");
		hourD.setHeaderText("Setting you alarm");
		hourD.setContentText("Please type just an hour:");

		Optional<String> resultHour = hourD.showAndWait();
		if (resultHour.isPresent()){
			 hour = Integer.parseInt(resultHour.get());
		}
		//Get the minutes
		TextInputDialog minD = new TextInputDialog("");
		minD.setTitle("New Alarm");
		minD.setHeaderText("Setting you alarm");
		minD.setContentText("Please type just the minutes:");

		Optional<String> rMin = minD.showAndWait();
		if (rMin.isPresent()){
			 min = Integer.parseInt(rMin.get());
		}
		//Am or Pm
		Alert alertT = new Alert(AlertType.CONFIRMATION);
		alertT.setTitle("New Alarm");
		alertT.setHeaderText("Setting your alarm");
		alertT.setContentText("Time of day");

		ButtonType buttonTypeOne = new ButtonType("AM");
		ButtonType buttonTypeTwo = new ButtonType("PM");
		
		alertT.getButtonTypes().setAll(buttonTypeOne, buttonTypeTwo);
		
		Optional<ButtonType> result = alertT.showAndWait();
		if (result.get() == buttonTypeOne){
		    timeDay = "AM";
		}
		if (result.get() == buttonTypeTwo){
		    timeDay = "PM";
		}
		
		//Vibration On or Off
		Alert alertV = new Alert(AlertType.CONFIRMATION);
		alertV.setTitle("New Alarm");
		alertV.setHeaderText("Setting your alarm");
		alertV.setContentText("Vibration");

		 buttonTypeOne = new ButtonType("On");
		 buttonTypeTwo = new ButtonType("Off");
		
		alertV.getButtonTypes().setAll(buttonTypeOne, buttonTypeTwo);
		
		Optional<ButtonType> resultV = alertV.showAndWait();
		if (resultV.get() == buttonTypeOne){
		    vibrate = true;
		}
//		//Monday On or Off
//		Alert alertMonday = new Alert(AlertType.CONFIRMATION);
//		alertMonday.setTitle("New Alarm");
//		alertMonday.setHeaderText("Setting your alarm");
//		alertMonday.setContentText("Monday");
//
//		buttonTypeOne = new ButtonType("On");
//		buttonTypeTwo = new ButtonType("Off");
//		
//		alertV.getButtonTypes().setAll(buttonTypeOne, buttonTypeTwo);
//		
//		Optional<ButtonType> resultMonday = alertMonday.showAndWait();
//		if (resultMonday.get() == buttonTypeOne){
//		    days[0] = true;
//		}
//		if(resultMonday.get() == buttonTypeTwo) {
//			days[0] = false;
//		}
//		//Tuesday On or Off
//		Alert alertTuesday = new Alert(AlertType.CONFIRMATION);
//		alertTuesday.setTitle("New Alarm");
//		alertTuesday.setHeaderText("Setting your alarm");
//		alertTuesday.setContentText("Tuesday");
//
//		buttonTypeOne = new ButtonType("On");
//		buttonTypeTwo = new ButtonType("Off");
//		
//		alertTuesday.getButtonTypes().setAll(buttonTypeOne, buttonTypeTwo);
//		
//		Optional<ButtonType> resultTuesday = alertMonday.showAndWait();
//		if (resultTuesday.get() == buttonTypeOne){
//		    days[1] = true;
//		}
//		if(resultTuesday.get() == buttonTypeTwo) {
//			days[1] = false;
//		}
		
		time = timeDay + " " + hour + ":" + min;
		
		pa.addAlarm(hour, min, time, vibrate);
		System.out.println(time);
		
		} catch(NumberFormatException nm) {
			Alert alert = new Alert(AlertType.WARNING);
			alert.setTitle("Problem");
			alert.setHeaderText("WARNING!");
			alert.setContentText("Please only type numbers");
			alert.showAndWait();
		}
		
	}

	@FXML
	public void loadActivities(ActionEvent event) {
		addNoteBt.setVisible(false);
		addActBt.setVisible(true);
		addAlarmBt.setVisible(false);
		labelMessage.setText(pa.showActivities());
	}

	@FXML
	public void loadAlarms(ActionEvent event) {
		addNoteBt.setVisible(false);
		addActBt.setVisible(false);
		addAlarmBt.setVisible(true);
		Alert a = new Alert(AlertType.INFORMATION);
		a.setTitle("Alarms");
		a.setContentText(pa.showAlarms());
		a.showAndWait();
		labelMessage.setText(pa.showAlarms());
	}


}
