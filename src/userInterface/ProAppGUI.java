package userInterface;

import java.io.*;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
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
	public void initialize(){
		lg = LoginGUI.getLg();
		pa = (PremiumAccount) lg.getAccount();
		bt.setVisible(false);
		addNoteBt.setVisible(false);
		addActBt.setVisible(false);
		addAlarmBt.setVisible(false);

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
			// TODO Auto-generated catch block
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
		labelMessage.setText(pa.showAlarms());
	}
}
