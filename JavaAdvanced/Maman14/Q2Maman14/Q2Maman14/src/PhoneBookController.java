/**
 *   Controller for PhoneBook application.
 */

import java.util.Optional;
import java.io.File;
import java.io.IOException;
import java.util.Map;
import javafx.fxml.FXML;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import javafx.beans.value.ObservableValue;
import javafx.beans.binding.Bindings;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableBooleanValue;

public class PhoneBookController {
	private PhoneBook phoneBook;
	private FileChooser fileChooser;
	private File phoneBookFile; // the file that the phone book was loaded from
	
	// instance variables for interacting with GUI components
	@FXML private Button addContactButton;
	@FXML private TextField addContactNameField;
         @FXML private TextField addContactPhoneField;
	@FXML private Button deleteContactButton;
	@FXML private Button editContactButton;
	@FXML private TableView<String> contactsTable;
	@FXML private TableColumn<String,String> nameCol;
	@FXML private TableColumn<String,String> phoneNumberCol;
	@FXML private TextField searchContactTextField;
	@FXML private MenuItem saveMenuItem;
	
	// initialize controller
	@FXML
	public void initialize() { 
		fileChooser = new FileChooser();
		fileChooser.getExtensionFilters().add(new ExtensionFilter("TXT files (*.txt)", "*.txt"));
		phoneBook = new PhoneBook();
		
		// if the contacts table is empty it will show the message "No contacts"
		contactsTable.setPlaceholder(new Label("No contacts"));
		
		// the delete and the edit buttons are disabled as long as there isn't a selected contact
		ObservableBooleanValue  nonSelection = 
			contactsTable.getSelectionModel().selectedItemProperty().isNull();
		deleteContactButton.disableProperty().bind(nonSelection);
		editContactButton.disableProperty().bind(nonSelection);
		
		// the add button is disabled as long as the name/phone number field isn't entered
		addContactButton.disableProperty().bind(
			Bindings.isEmpty(addContactNameField.textProperty())
			.or(Bindings.isEmpty(addContactPhoneField.textProperty())));
		
		// displays the relevant search results on the contacts table for the current name/prefix within the 
		// search text field
		searchContactTextField.textProperty().addListener(
			(ObservableValue<? extends String> observable, String oldValue, String newValue) -> {
				updateContactsTable(phoneBook.searchContact(newValue));
			});
		
		// the save menu item is disabled before the user selects a phone book file
		saveMenuItem.setDisable(true);
	}
	
	// adds the relevant contact to the phone book as a reaction to "add contact" button press
	@FXML
         void addContactButtonPressed(ActionEvent event) {
		// adds the new contact if it isn't in the phone book
		boolean contactAdded = phoneBook.addContact(addContactNameField.getText(), 
			                                                          addContactPhoneField.getText());
		if(!(contactAdded)){
			Alert alert = new Alert(AlertType.ERROR);
			alert.setHeaderText("Addition error!");
			alert.setContentText("The contact is already in the phone book.");
			alert.setTitle("Addition Error");
			alert.show();
			return;
		} // informs the user that the contact wasn't added since it had been in the phone book already
		
		// clears the addition fields and displays the phone book 
		addContactNameField.clear();
		addContactPhoneField.clear();
		updateContactsTable(phoneBook.getContacts());
         }
	
	// deletes the selected contact from the phone book as a reaction to "delete contact" button press		 
	@FXML
	void deleteContactButtonPressed(ActionEvent event) {
		String contactToDelete = contactsTable.getSelectionModel().getSelectedItem();
		phoneBook.deleteContant(contactToDelete);
		contactsTable.getItems().remove(contactToDelete);
	}
	
	// opens an input text dialog as a react to a "edit contact" button press	that allows the user to edit 
	// the phone number of the selected contact in the contacts table
	@FXML
	void editContactButtonPressed(ActionEvent event) {
		// creats and displays a dialog box that allows the user to provide the updated phone number
		TextInputDialog contactEditorDialog = new TextInputDialog();
		contactEditorDialog.setTitle("Contact Editor");
		contactEditorDialog.setHeaderText("What is the updated phone number?");
		Optional<String>result = contactEditorDialog.showAndWait();
		
		if (result.isPresent() && result.get().length() != 0) {
			phoneBook.editContact(contactsTable.getSelectionModel().getSelectedItem(), result.get());
			updateContactsTable(phoneBook.getContacts());
		} // if the user provided the updated phone number 
         }
	
	// allows the user to load a phone book via text file
	@FXML
	void openFileMenuItemClicked(ActionEvent event) {
		File openFile = fileChooser.showOpenDialog(null); // displays the relevant dialog box
		
		if(openFile != null){
			phoneBookFile = openFile;
			phoneBook.clearPhoneBook();
			phoneBook.addAllContacts(phoneBookFile);
			updateContactsTable(phoneBook.getContacts());
			saveMenuItem.setDisable(false);
		} // if the user selected a file to open
         }
	
	// allows the user to save the phone book
	@FXML
	void saveFileMenuItemClicked(ActionEvent event) {
		try{
			phoneBook.phoneBookFile(phoneBookFile.getPath());
		} catch(IOException e){
			System.out.println("IOException occured");
		}
	}
	
	// allows the user to save the phone book to selected folder and to select the file name
	@FXML
	void saveAsFileMenuItemClicked(ActionEvent event) throws IOException {
		File saveAs = fileChooser.showSaveDialog(null); // displays the relevant dialog box

		if(saveAs != null){
			saveMenuItem.setDisable(false);
			
			if(phoneBookFile != null){
				phoneBookFile.delete();
			} // if there is a file that the phone book was loaded from
			
			phoneBookFile = saveAs;
			saveMenuItem.fire();
		} // if the user provided the relevant deta to save the file
	}	
	
	// displays the contacts on the contacts table
	private void updateContactsTable(Map<String,String> contacts){
		contactsTable.getItems().clear();
		contactsTable.getItems().addAll(contacts.keySet());
		nameCol.setCellValueFactory(name -> new SimpleStringProperty(name.getValue()));
		phoneNumberCol.setCellValueFactory(phone ->
			new SimpleStringProperty(contacts.get(phone.getValue())));	
	}
}

