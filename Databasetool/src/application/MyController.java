package application;

import javafx.scene.control.*;

import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;
import javafx.event.*;
import javafx.fxml.*;

public class MyController implements Initializable {
	@FXML
	private TextField nameField;
	@FXML
	private PasswordField pwdField;
	@FXML
	private Button loginButton;
	
	@Override
	public void initialize(final URL location, final ResourceBundle resources) {
		loginButton.setOnAction(this::handleSubmitButtonAction);
	}
	
	@FXML
	protected void handleSubmitButtonAction(final ActionEvent event) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test?user="+nameField.getText()+"&password="+pwdField.getText());
			if (con == null) {
				System.out.println("Fehler bei der Verbindung.");
			}
			else {
				System.out.println("Verbindung hergestellt.");
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}	
}
