package application;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.prefs.Preferences;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TextField;

public class MainController implements Initializable{
	String id1 = "name", id2 = "phone", id3 = "email", id4 = "address";
	
	@FXML TextField txtName, txtPhone, txtEmail, txtAddress;
	
	Alert a = new Alert(AlertType.NONE);
	
	Preferences prefs = Preferences.userRoot().node(this.getClass().getName());

	@FXML
	public void onSave() {

		
		
		
		String name = txtName.getText();
		String email = txtEmail.getText();
		String address = txtAddress.getText();
		int phone =0;
		try{
			phone = Integer.parseInt(txtPhone.getText());
		}catch(NumberFormatException e) {
			a.setAlertType(AlertType.ERROR);
			a.setContentText("invalid input on phone text field");
			a.show();
			return;
		}
		
		prefs.put(id1, name);
		prefs.putInt(id2, phone);
		prefs.put(id3, email);
		prefs.put(id4, address);
		a.setAlertType(AlertType.INFORMATION);
		a.setContentText("Details Saved");
		a.show();
	}
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
			txtName.setText(prefs.get(id1, null));
			txtPhone.setText(Integer.toString(prefs.getInt(id2, 0000000)));
			txtEmail.setText(prefs.get(id3, null));
			txtAddress.setText(prefs.get(id4, null));
	}
}
