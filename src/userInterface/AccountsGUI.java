package userInterface;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
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
			System.out.println(ul.getAccounts().get(0).getName());
		} catch (ClassNotFoundException | IOException e) {
			e.printStackTrace();
		}
		
		
		ObservableList<Account> oAccounts = FXCollections.observableArrayList();
		nameCol.setCellValueFactory(new PropertyValueFactory<Account,String>("name"));
		usernameCol.setCellValueFactory(new PropertyValueFactory<Account,String>("username"));
		nicknameCol.setCellValueFactory(new PropertyValueFactory<Account,String>("nickN ame"));
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

	}

	@FXML
	public void searchHeight(ActionEvent event) {

	}

	@FXML
	public void searchName(ActionEvent event) {

	}

	@FXML
	public void searchNickname(ActionEvent event) {

	}

	@FXML
	public void searchUsername(ActionEvent event) {

	}

	@FXML
	public void searchWeight(ActionEvent event) {

	}

	@FXML
	public void sortAge(ActionEvent event) {

	}

	@FXML
	public void sortHeight(ActionEvent event) {

	}

	@FXML
	public void sortName(ActionEvent event) {
		ul.sortByName();
		accountsTable.setItems(updateList());
	}

	@FXML
	public void sortNickname(ActionEvent event) {

	}

	@FXML
	public void sortUsername(ActionEvent event) {

	}

	@FXML
	public void sortWeight(ActionEvent event) {

	}

}
