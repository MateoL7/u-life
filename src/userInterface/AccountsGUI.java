package userInterface;

import java.io.IOException;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import javafx.stage.StageStyle;
import model.Account;
import model.ULife;

public class AccountsGUI {

	@FXML
	private Pane screen;

	@FXML
	private TableView<Account> accountsTable;

	@FXML
	private TableColumn<Account, String> nameCol;

	@FXML
	private TableColumn<Account, String> usernameCol;

	@FXML
	private TableColumn<Account, String> nicknameCol;

	@FXML
	private TableColumn<Account, Integer> ageCol;

	@FXML
	private TableColumn<Account, Integer> heightCol;

	@FXML
	private TableColumn<Account, Integer> weightCol;

	@FXML
	private TextField searchField;

	private ObservableList<Account> oAccounts;

	private ULife ul;

	@FXML
	public void initialize() {
		ul = new ULife();


		try {
			ul.loadData();

		} catch (ClassNotFoundException | IOException e) {
			e.printStackTrace();
		}


		ObservableList<Account> oAccounts = FXCollections.observableArrayList();
		nameCol.setCellValueFactory(new PropertyValueFactory<Account,String>("name"));
		usernameCol.setCellValueFactory(new PropertyValueFactory<Account,String>("username"));
		nicknameCol.setCellValueFactory(new PropertyValueFactory<Account,String>("nickName"));
		ageCol.setCellValueFactory(new PropertyValueFactory<Account,Integer>("age"));
		heightCol.setCellValueFactory(new PropertyValueFactory<>("height"));
		weightCol.setCellValueFactory(new PropertyValueFactory<>("weight"));
		oAccounts = updateList();
		accountsTable.setItems(oAccounts);
	}

	public ObservableList<Account> updateList(){
		oAccounts = FXCollections.observableArrayList();
		for(int c = 0; c < ul.getAccounts().size(); c++) {
			oAccounts.add(ul.getAccounts().get(c));
		}
		return oAccounts;
	}

	@FXML
	public void searchAge(ActionEvent event) {
		try {
			ul.sortByAge();
			int age = Integer.parseInt(searchField.getText());
			Account show = ul.searchAge(age);
			if(show != null) {
				Alert alert = new Alert(Alert.AlertType.INFORMATION);
				alert.initStyle(StageStyle.UTILITY);
				alert.setTitle("Information");
				alert.setHeaderText("Found");
				alert.setContentText("Name: " + show.getName() + "\nAge:" + show.getAge()+ "\nUsername: " + show.getUsername());
				alert.showAndWait();
			}
			else {
				Alert alert = new Alert(Alert.AlertType.INFORMATION);
				alert.initStyle(StageStyle.UTILITY);
				alert.setTitle("Information");
				alert.setHeaderText("Not found");
				alert.setContentText("There is not an account with that age");
				alert.showAndWait();
			}
		} 
		catch(NumberFormatException n) {
			Alert alert = new Alert(Alert.AlertType.WARNING);
			alert.initStyle(StageStyle.UTILITY);
			alert.setTitle("Information");
			alert.setHeaderText("Incorrect format");
			alert.setContentText("Please only type numbers");
			alert.showAndWait();
		}
	}

	@FXML
	public void searchHeight(ActionEvent event) {
		ul.sortByHeight();
		try {
			double height = Double.parseDouble(searchField.getText());
			Account show = ul.searchHegiht(height);
			if(show != null) {
				Alert alert = new Alert(Alert.AlertType.INFORMATION);
				alert.initStyle(StageStyle.UTILITY);
				alert.setTitle("Information");
				alert.setHeaderText("Found");
				alert.setContentText("Name: " + show.getName() + "\nAge: " + show.getAge() + "\nUsername: " + show.getUsername());
				alert.showAndWait();
			}
			else {
				Alert alert = new Alert(Alert.AlertType.INFORMATION);
				alert.initStyle(StageStyle.UTILITY);
				alert.setTitle("Information");
				alert.setHeaderText("Not found");
				alert.setContentText("There is not an account with that height");
				alert.showAndWait();
			}
		} 
		catch(NumberFormatException n) {
			Alert alert = new Alert(Alert.AlertType.WARNING);
			alert.initStyle(StageStyle.UTILITY);
			alert.setTitle("Information");
			alert.setHeaderText("Incorrect format");
			alert.setContentText("Please only type numbers");
			alert.showAndWait();
		}
	}

	@FXML
	public void sortAge(ActionEvent event) {
		ul.sortByAge();
		accountsTable.setItems(updateList());
	}

	@FXML
	public void sortHeight(ActionEvent event) {
		ul.sortByHeight();
		accountsTable.setItems(updateList());
	}

	@FXML
	public void sortName(ActionEvent event) {
		ul.sortByName();
		accountsTable.setItems(updateList());
	}

	@FXML
	public void sortNickname(ActionEvent event) {
		ul.sortByNickname();
		accountsTable.setItems(updateList());
	}

	@FXML
	public void sortUsername(ActionEvent event) {
		ul.sortByUsername();
		accountsTable.setItems(updateList());
	}

	@FXML
	public void sortWeight(ActionEvent event) {
		ul.sortByWeight();
		accountsTable.setItems(updateList());
	}

}
