package userInterface;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import model.LoadInfo;
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
	private Label labelMessage;

	private PremiumAccount pa;

	private LoginGUI lg;

	@FXML
	public void initialize(){
		lg = LoginGUI.getLg();
		pa = (PremiumAccount) lg.getAccount();
	}

	@FXML
	public void loadFacts(ActionEvent event) {
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
		
	}

	@FXML
	public void loadTips(ActionEvent event) {

	}

}
