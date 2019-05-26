package userInterface;

import java.io.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Optional;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputDialog;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import model.Information;
import model.PremiumAccount;
import model.SportType;
import threads.AlarmShineThread;
import threads.MoveLightsThread;
import threads.ShiningThread;
/** 
*@author: Mateo Loaiza
*@author: Juan Pablo Herrera
*@version: 26/05/2019
*Class ProAppGUI
*/
public class ProAppGUI {

	@FXML
	private Label TituloAlarmas;

	@FXML
	private Label alarmsLb;

	@FXML
	private Arc star5;

	@FXML
	private Arc star4;

	@FXML
	private Arc star3;

	@FXML
	private Arc star2;

	@FXML
	private Arc star1;

	@FXML
	private Circle centerStar1;

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
	private Rectangle line2;

	@FXML
	private Rectangle line1;

	@FXML
	private Rectangle line3;

	@FXML
	private Rectangle line4;

	@FXML
	private Rectangle line5;

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
	private Label activationAlarm;

	@FXML
	private Label LbClock;


	@FXML
	private Circle light2;

	@FXML
	private Circle light4;

	@FXML
	private Circle light7;

	@FXML
	private Circle light5;

	@FXML
	private Circle light1;

	@FXML
	private Circle light19;

	@FXML
	private Circle light18;

	@FXML
	private Circle light17;

	@FXML
	private Circle light16;

	@FXML
	private Circle light15;

	@FXML
	private Circle light14;

	@FXML
	private Circle light13;

	@FXML
	private Circle light12;

	@FXML
	private Circle light9;

	@FXML
	private Circle light11;

	private boolean shinning;

	@FXML
	private Circle light6;

	@FXML
	private Arc star51;

	@FXML
	private Arc star41;

	@FXML
	private Arc star31;

	@FXML
	private Arc star21;

	@FXML
	private Arc star11;

	@FXML
	private Circle centerStar11;

	@FXML
	private Circle digitalClock;


	private ShiningThread sh;
	private MoveLightsThread ml;
	private AlarmShineThread as;
	

	@FXML
	public void initialize(){
		lg = LoginGUI.getLg();
		pa = (PremiumAccount) lg.getAccount();
		bt.setVisible(false);
		addNoteBt.setVisible(false);
		addActBt.setVisible(false);
		addAlarmBt.setVisible(false);

		ProAppGUI ptemp = this;
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
							String contain = pa.checkAlarm(hour, minute);
							LbClock.setText(t);
							boolean active = false;
							if(!contain.isEmpty()) {
								active = true;
								activationAlarm.setText(LbClock.getText());

							}else {
								active = false;
							}
							as = new AlarmShineThread(ptemp,active);
							as.start();
						}	
					});
					//Sleep adentro del while
					try {
						Thread.sleep(500);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}

				}
			}

		}).start();
	}


	public void shine() {
		//Down
		light2.setFill(Color.GOLDENROD);
		light4.setFill(Color.GOLDENROD);
		light7.setFill(Color.GOLDENROD);
		light5.setFill(Color.GOLDENROD);
		light1.setFill(Color.GOLDENROD);
		light19.setFill(Color.GOLDENROD);
		light18.setFill(Color.GOLDENROD);
		light17.setFill(Color.GOLDENROD);

		//Up
		light16.setFill(Color.GOLDENROD);
		light15.setFill(Color.GOLDENROD);
		light14.setFill(Color.GOLDENROD);
		light13.setFill(Color.GOLDENROD);
		light12.setFill(Color.GOLDENROD);
		light9.setFill(Color.GOLDENROD);
		light11.setFill(Color.GOLDENROD);
		light6.setFill(Color.GOLDENROD);

		//Star
		centerStar1.setFill(Color.GOLDENROD);
		star1.setFill(Color.GOLDENROD);
		star2.setFill(Color.GOLDENROD);
		star3.setFill(Color.GOLDENROD);
		star4.setFill(Color.GOLDENROD);
		star5.setFill(Color.GOLDENROD);

		//Star2
		centerStar11.setFill(Color.GOLDENROD);
		star11.setFill(Color.GOLDENROD);
		star21.setFill(Color.GOLDENROD);
		star31.setFill(Color.GOLDENROD);
		star41.setFill(Color.GOLDENROD);
		star51.setFill(Color.GOLDENROD);

	}

	public boolean getShinning() {
		return shinning;
	}

	public void setShinning(boolean s) {
		shinning = s;
	}

	@FXML
	public void makeItShine(ActionEvent event) {
		setShinning(true);
		sh = new ShiningThread(this);
		ml = new MoveLightsThread(this);
		sh.setDaemon(true);
		ml.setDaemon(true);
		sh.start();
		ml.start();


	}

	public void shutDownLights() {
		//Down
		light2.setFill(Color.BLACK);
		light4.setFill(Color.BLACK);
		light7.setFill(Color.BLACK);
		light5.setFill(Color.BLACK);
		light1.setFill(Color.BLACK);
		light19.setFill(Color.BLACK);
		light18.setFill(Color.BLACK);
		light17.setFill(Color.BLACK);

		//Up
		light16.setFill(Color.BLACK);
		light15.setFill(Color.BLACK);
		light14.setFill(Color.BLACK);
		light13.setFill(Color.BLACK);
		light12.setFill(Color.BLACK);
		light9.setFill(Color.BLACK);
		light11.setFill(Color.BLACK);
		light6.setFill(Color.BLACK);

		//Star
		centerStar1.setFill(Color.BLACK);
		star1.setFill(Color.BLACK);
		star2.setFill(Color.BLACK);
		star3.setFill(Color.BLACK);
		star4.setFill(Color.BLACK);
		star5.setFill(Color.BLACK);

		//Star2
		centerStar11.setFill(Color.BLACK);
		star11.setFill(Color.BLACK);
		star21.setFill(Color.BLACK);
		star31.setFill(Color.BLACK);
		star41.setFill(Color.BLACK);
		star51.setFill(Color.BLACK);
	}
	public void move1() {
		double mov = 5;
		//Down ---> right
		light2.setLayoutX(light2.getLayoutX()+mov);
		light4.setLayoutX(light4.getLayoutX()+mov);
		light7.setLayoutX(light7.getLayoutX()+mov);
		light5.setLayoutX(light5.getLayoutX()+mov);
		light1.setLayoutX(light1.getLayoutX()+mov);
		light19.setLayoutX(light19.getLayoutX()+mov);
		light18.setLayoutX(light18.getLayoutX()+mov);
		light17.setLayoutX(light17.getLayoutX()+mov);

		//Up ---> left
		light16.setLayoutX(light16.getLayoutX()-mov);
		light15.setLayoutX(light15.getLayoutX()-mov);
		light14.setLayoutX(light14.getLayoutX()-mov);
		light13.setLayoutX(light13.getLayoutX()-mov);
		light12.setLayoutX(light12.getLayoutX()-mov);
		light9.setLayoutX(light9.getLayoutX()-mov);
		light11.setLayoutX(light11.getLayoutX()-mov);
		light6.setLayoutX(light6.getLayoutX()-mov);

		//Star
		centerStar1.setLayoutY(centerStar1.getLayoutY() + mov);
		star1.setLayoutY(star1.getLayoutY()+mov);
		star2.setLayoutY(star2.getLayoutY()+mov);
		star3.setLayoutY(star3.getLayoutY()+mov);
		star4.setLayoutY(star4.getLayoutY()+mov);
		star5.setLayoutY(star5.getLayoutY()+mov);

		//Star2
		centerStar11.setLayoutY(centerStar11.getLayoutY() - mov);
		star11.setLayoutY(star11.getLayoutY()-mov);
		star21.setLayoutY(star21.getLayoutY()-mov);
		star31.setLayoutY(star31.getLayoutY()-mov);
		star41.setLayoutY(star41.getLayoutY()-mov);
		star51.setLayoutY(star51.getLayoutY()-mov);
	}
	public void move2() {
		double mov = 5;
		//Down ---> left
		light2.setLayoutX(light2.getLayoutX()-mov);
		light4.setLayoutX(light4.getLayoutX()-mov);
		light7.setLayoutX(light7.getLayoutX()-mov);
		light5.setLayoutX(light5.getLayoutX()-mov);
		light1.setLayoutX(light1.getLayoutX()-mov);
		light19.setLayoutX(light19.getLayoutX()-mov);
		light18.setLayoutX(light18.getLayoutX()-mov);
		light17.setLayoutX(light17.getLayoutX()-mov);

		//Up ---> right
		light16.setLayoutX(light16.getLayoutX()+mov);
		light15.setLayoutX(light15.getLayoutX()+mov);
		light14.setLayoutX(light14.getLayoutX()+mov);
		light13.setLayoutX(light13.getLayoutX()+mov);
		light12.setLayoutX(light12.getLayoutX()+mov);
		light9.setLayoutX(light9.getLayoutX()+mov);
		light11.setLayoutX(light11.getLayoutX()+mov);
		light6.setLayoutX(light6.getLayoutX()+mov);

		//Star
		centerStar1.setLayoutY(centerStar1.getLayoutY() - mov);
		star1.setLayoutY(star1.getLayoutY()-mov);
		star2.setLayoutY(star2.getLayoutY()-mov);
		star3.setLayoutY(star3.getLayoutY()-mov);
		star4.setLayoutY(star4.getLayoutY()-mov);
		star5.setLayoutY(star5.getLayoutY()-mov);

		//Star2
		centerStar11.setLayoutY(centerStar11.getLayoutY() + mov);
		star11.setLayoutY(star11.getLayoutY()+mov);
		star21.setLayoutY(star21.getLayoutY()+mov);
		star31.setLayoutY(star31.getLayoutY()+mov);
		star41.setLayoutY(star41.getLayoutY()+mov);
		star51.setLayoutY(star51.getLayoutY()+mov);
	}

	public void alarmShine() {
		line1.setFill(Color.GOLDENROD);
		line2.setFill(Color.GOLDENROD);
		line3.setFill(Color.GOLDENROD);
		line4.setFill(Color.GOLDENROD);
		line5.setFill(Color.GOLDENROD);
		digitalClock.setStroke(Color.DARKRED);


	}
	public void alarmDown() {
		line1.setFill(Color.BLACK);
		line2.setFill(Color.BLACK);
		line3.setFill(Color.BLACK);
		line4.setFill(Color.BLACK);
		line5.setFill(Color.BLACK);
		digitalClock.setStroke(Color.GOLDENROD);
	}

	@FXML
	public void loadFacts(ActionEvent event) {
		addNoteBt.setVisible(false);
		addActBt.setVisible(false);
		addAlarmBt.setVisible(false);
		String msg = "";
		try {
			String info = pa.loadInfo(Information.PATHFACTS);
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
		} 	catch(EOFException t) {
			Alert alert = new Alert(Alert.AlertType.INFORMATION);
	        alert.initStyle(StageStyle.UTILITY);
	        alert.setTitle("Information");
	        alert.setHeaderText("WARNING!");
	        alert.setContentText("You do not have any notes yet");

	       alert.showAndWait();
		}
		catch(IOException e) {
			Alert alert = new Alert(Alert.AlertType.INFORMATION);
	        alert.initStyle(StageStyle.UTILITY);
	        alert.setTitle("Information");
	        alert.setHeaderText("WARNING!");
	        alert.setContentText("You do not have any notes yet");

	       alert.showAndWait();
		}
	}

	@FXML
	public void loadTips(ActionEvent event) {
		addNoteBt.setVisible(false);
		addActBt.setVisible(false);
		addAlarmBt.setVisible(false);
		String msg = "";
		try {
			String info = pa.loadInfo(Information.PATHTIPS);
			String[] tip = info.split(",");
			for(int i = 0; i < tip.length;i++) {
				String[] splitTip = tip[i].split(";");
				msg += splitTip[0] + ". " + splitTip[1]+ "\n\n";
				pa.addTip(splitTip[0], splitTip[1]);
			}
			labelMessage.setText(msg);

		} catch (FileNotFoundException f) {
			f.printStackTrace();
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
			pa.addNote(i1, th);
			File f = new File("data\\notes.txt");
			BufferedWriter bw = new BufferedWriter(new FileWriter(f.getAbsoluteFile(), true));

			bw.write(i1 + ". " + th);

			bw.close();
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
		try {
			String name = "";
			int minutes = 0;
			int hours = 0;
			TextInputDialog nameT = new TextInputDialog();
			nameT.setHeaderText("Name of the activity");
			Optional<String> m1 = nameT.showAndWait();
			if(m1.isPresent()) {
				name = m1.get();	
			}
			TextInputDialog hoursT = new TextInputDialog();
			hoursT.setHeaderText("Hours");
			hoursT.setContentText("Please only type numbers.\nCan be 0.");
			Optional<String> m = hoursT.showAndWait();
			if(m.isPresent()) {
				hours = Integer.parseInt(m.get());
			}
			TextInputDialog minT = new TextInputDialog();
			minT.setHeaderText("Minutes");
			minT.setContentText("Please only type numbers.\nCan be 0.");
			Optional<String> m2 = minT.showAndWait();
			if(m2.isPresent()) {
				minutes = Integer.parseInt(m2.get());
			}

			Alert alert = new Alert(AlertType.CONFIRMATION);
			alert.setTitle("New Activity");
			alert.setHeaderText("Create you activity");
			alert.setContentText("Type of activity");

			ButtonType buttonTypeOne = new ButtonType("Activity");
			ButtonType buttonTypeTwo = new ButtonType("Sport");
			alert.getButtonTypes().setAll(buttonTypeOne, buttonTypeTwo);
			Optional<ButtonType> resulType = alert.showAndWait();
			if(resulType.get() == buttonTypeOne) {
				pa.addActivity(name, minutes, hours);
			}
			if(resulType.get() == buttonTypeTwo) {
				double cal = 0.0;
				SportType st = null;
				TextInputDialog calT = new TextInputDialog();
				calT.setHeaderText("Expected calories to burn");
				calT.setContentText("Please only type numbers.\nCan be 0.");
				Optional<String> m3 = calT.showAndWait();
				if(m3.isPresent()) {
					cal = Double.parseDouble(m2.get());
				}
				Alert alertSt = new Alert(AlertType.CONFIRMATION);
				alertSt.setTitle("New Activity");
				alertSt.setHeaderText("Sports");
				alertSt.setContentText("Type of sport");

				ButtonType basket = new ButtonType("BasketBall");
				ButtonType parkour = new ButtonType("Parkour");
				ButtonType run = new ButtonType("Run");
				alertSt.getButtonTypes().setAll(basket, parkour, run);
				Optional<ButtonType> option = alertSt.showAndWait();
				if(option.get() == basket) {
					st = SportType.BASKETBALL;
				}
				if(option.get() == parkour) {
					st = SportType.PARKOUR;
				}
				if(option.get() == run) {
					st = SportType.RUN;
				}

				pa.addSport(name, minutes, hours, cal, st);
			}

		} catch(NumberFormatException nm) {
			Alert alert = new Alert(AlertType.WARNING);
			alert.setTitle("Problem");
			alert.setHeaderText("WARNING!");
			alert.setContentText("Please only type numbers");
			alert.showAndWait();
		}
	}

	@FXML
	public void addAlarm(ActionEvent event) {
		try {
			int hour = 0;
			int min = 0;
			String time = "";
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

			time = timeDay + " " + hour + ":" + min;

			pa.addAlarm(hour, min, time);
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

	@FXML
	public void seeAccountsInfo(ActionEvent event) {
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Accounts.fxml"));
		Parent root;
		try {
			root = fxmlLoader.load();
			Stage stage = new Stage();

			Scene scene = new Scene(root);
			stage.setTitle("Accounts Information");
			stage.setScene(scene);
			stage.setMaximized(true);
			stage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}


}
